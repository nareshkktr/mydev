package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.LocationDao;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dao.UserInfoDao;
import com.kasisripriyawebapps.myindia.dto.LocationImportRequest;
import com.kasisripriyawebapps.myindia.entity.Location;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.UserInfo;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.LocationImportExportService;
import com.kasisripriyawebapps.myindia.util.AmazonS3Util;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class LocationImportExportServiceImpl implements LocationImportExportService {

	@Autowired
	LocationMasterDao locationMasterDao;

	@Autowired
	LocationDao locationDao;

	@Autowired
	UserInfoDao userInfoDao;

	@Autowired
	private Environment env;

	static WebDriver driver;
	static Wait<WebDriver> wait;
	private static final String SUFFIX = "/";

	static {
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}

	@Override
	@Transactional
	public boolean importCountries(LocationImportRequest locationImportRequest) throws InternalServerException {
		String fileName = env.getProperty("project.countries-locations-file-name");

		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		uploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName;

		String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName + SUFFIX + fileName;

		Long indiaLocationParentGuid = Long.parseLong(env.getProperty("location.country.india.parent-guid"));

		saveUpdateDeleteMasterLocations(inputFilePath, ServiceConstants.LOCATION_COUNTRY_TYPE, locationImportRequest,
				indiaLocationParentGuid);
		return true;
	}

	@Override
	@Transactional
	public boolean importStates(LocationImportRequest locationImportRequest) throws InternalServerException {
		String fileName = env.getProperty("project.state-locations-file-name");

		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");

		uploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX + countryFolderName;
		String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName + SUFFIX + fileName;

		List<LocationMaster> countryLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_COUNTRY_TYPE);

		if (countryLocations != null && !countryLocations.isEmpty()) {
			for (LocationMaster eachCountryLocation : countryLocations) {
				if (eachCountryLocation != null) {
					saveUpdateDeleteMasterLocations(inputFilePath, ServiceConstants.LOCATION_STATE_TYPE,
							locationImportRequest, eachCountryLocation.getGuid());
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importDistricts(LocationImportRequest locationImportRequest) throws InternalServerException {
		String fileName = env.getProperty("project.district-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");
					String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

					String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
					String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

					uploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX + countryFolderName
							+ SUFFIX + eachLocation.getLocationName() + SUFFIX + ruralFolderName;
					String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName + SUFFIX + fileName;

					saveUpdateDeleteMasterLocations(inputFilePath, ServiceConstants.LOCATION_DISTRICT_TYPE,
							locationImportRequest, eachLocation.getGuid());
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importSubDistricts(LocationImportRequest locationImportRequest) throws InternalServerException {
		String fileName = env.getProperty("project.sub_dsitrict-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
					String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

					List<LocationMaster> districtLocations = locationMasterDao
							.getAllMasterLocationsByTypeAndParentLocation(ServiceConstants.LOCATION_DISTRICT_TYPE,
									eachLocation.getGuid());

					if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
						for (LocationMaster eachDistrictLocation : districtLocations) {
							if (eachDistrictLocation != null) {

								String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name")
										+ SUFFIX + globalFolderName + SUFFIX + countryFolderName + SUFFIX
										+ eachLocation.getLocationName() + SUFFIX + ruralFolderName + SUFFIX
										+ eachDistrictLocation.getLocationName();

								String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName + SUFFIX
										+ fileName;

								saveUpdateDeleteMasterLocations(inputFilePath,
										ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, locationImportRequest,
										eachDistrictLocation.getGuid());
							}
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importMuncipalCorporations(LocationImportRequest locationImportRequest)
			throws InternalServerException {

		String fileName = env.getProperty("project.municipality.corporations-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
					String urbanFolderName = env.getProperty("amazon.s3.locations.urban.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name") + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName + SUFFIX
							+ urbanFolderName + SUFFIX + fileName;

					saveUpdateDeleteMasterLocations(inputFilePath, ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE,
							locationImportRequest, eachLocation.getGuid());
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importMuncipalities(LocationImportRequest locationImportRequest) throws InternalServerException {

		String fileName = env.getProperty("project.municipalities-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
					String urbanFolderName = env.getProperty("amazon.s3.locations.urban.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name") + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName + SUFFIX
							+ urbanFolderName + SUFFIX + fileName;

					saveUpdateDeleteMasterLocations(inputFilePath, ServiceConstants.LOCATION_MUNCIPALITY_TYPE,
							locationImportRequest, eachLocation.getGuid());
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importTownPanchayathies(LocationImportRequest locationImportRequest) throws InternalServerException {
		String fileName = env.getProperty("project.town.panchayathies-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
					String urbanFolderName = env.getProperty("amazon.s3.locations.urban.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name") + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName + SUFFIX
							+ urbanFolderName + SUFFIX + fileName;

					saveUpdateDeleteMasterLocations(inputFilePath, ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE,
							locationImportRequest, eachLocation.getGuid());
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importVillagePanchayathies(LocationImportRequest locationImportRequest)
			throws InternalServerException {

		String fileName = env.getProperty("project.village.panchayathies-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
					String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

					List<LocationMaster> districtLocations = locationMasterDao
							.getAllMasterLocationsByTypeAndParentLocation(ServiceConstants.LOCATION_DISTRICT_TYPE,
									eachLocation.getGuid());

					if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
						for (LocationMaster eachDistrictLocation : districtLocations) {
							if (eachDistrictLocation != null) {

								List<LocationMaster> subDistrictLocations = locationMasterDao
										.getAllMasterLocationsByTypeAndParentLocation(
												ServiceConstants.LOCATION_SUB_DISTRICT_TYPE,
												eachDistrictLocation.getGuid());

								if (CommonUtil.isListNotNullAndNotEmpty(subDistrictLocations)) {
									for (LocationMaster eachSubDistrictLocation : subDistrictLocations) {
										if (eachSubDistrictLocation != null) {

											String uploadedFolderName = env
													.getProperty("amazon.s3.locations.uploaded.folder.name") + SUFFIX
													+ globalFolderName + SUFFIX + countryFolderName + SUFFIX
													+ eachLocation.getLocationName() + SUFFIX + ruralFolderName + SUFFIX
													+ eachDistrictLocation.getLocationName() + SUFFIX
													+ eachSubDistrictLocation.getLocationName();

											String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName
													+ SUFFIX + fileName;

											saveUpdateDeleteMasterLocations(inputFilePath,
													ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE,
													locationImportRequest, eachDistrictLocation.getGuid());
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importVillages(LocationImportRequest locationImportRequest) throws InternalServerException {

		String fileName = env.getProperty("project.villages-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
					String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

					List<LocationMaster> districtLocations = locationMasterDao
							.getAllMasterLocationsByTypeAndParentLocation(ServiceConstants.LOCATION_DISTRICT_TYPE,
									eachLocation.getGuid());

					if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
						for (LocationMaster eachDistrictLocation : districtLocations) {
							if (eachDistrictLocation != null) {

								List<LocationMaster> subDistrictLocations = locationMasterDao
										.getAllMasterLocationsByTypeAndParentLocation(
												ServiceConstants.LOCATION_SUB_DISTRICT_TYPE,
												eachDistrictLocation.getGuid());

								if (CommonUtil.isListNotNullAndNotEmpty(subDistrictLocations)) {
									for (LocationMaster eachSubDistrictLocation : subDistrictLocations) {
										if (eachSubDistrictLocation != null) {

											String uploadedFolderName = env
													.getProperty("amazon.s3.locations.uploaded.folder.name") + SUFFIX
													+ globalFolderName + SUFFIX + countryFolderName + SUFFIX
													+ eachLocation.getLocationName() + SUFFIX + ruralFolderName + SUFFIX
													+ eachDistrictLocation.getLocationName() + SUFFIX
													+ eachSubDistrictLocation.getLocationName();

											String inputFilePath = hostName + bucketName + SUFFIX + uploadedFolderName
													+ SUFFIX + fileName;

											saveUpdateDeleteMasterLocations(inputFilePath,
													ServiceConstants.LOCATION_VILLAGE_TYPE, locationImportRequest,
													eachDistrictLocation.getGuid());
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	private List<LocationMaster> prepareMasterLocations(String filePath, List<LocationMaster> existingMasterLocations,
			List<LocationMaster> excelMasterLocations, LocationImportRequest locationImportRequest)
			throws InternalServerException {
		List<LocationMaster> masterLocations = new ArrayList<LocationMaster>();
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(filePath);

		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {
			if (i < 1) {
				i++;
				continue;
			}
			double locationCode = eachRow.getCell(0).getNumericCellValue();
			long locationCodeLong = Long.valueOf(0);
			locationCodeLong = (long) locationCode;
			String locationName = "";
			if (eachRow.getCell(1).getStringCellValue() != null) {
				locationName = eachRow.getCell(1).getStringCellValue().trim();
			}
			String locationType = eachRow.getCell(2).getStringCellValue().trim();

			double parentLocationCode = eachRow.getCell(3).getNumericCellValue();
			long parentLocationGuid = Long.valueOf(0);
			parentLocationGuid = (long) parentLocationCode;

			if (locationName != null) {
				LocationMaster locationMaster = new LocationMaster();
				locationMaster.setLocationCode(locationCodeLong);
				locationMaster.setLocationName(locationName);
				locationMaster.setLocationType(locationType);
				locationMaster.setParentLocationGuid(parentLocationGuid);
				if (!masterLocations.contains(locationMaster) && !existingMasterLocations.contains(locationMaster)) {
					masterLocations.add(locationMaster);
				}
				if (!excelMasterLocations.contains(locationMaster)) {
					excelMasterLocations.add(locationMaster);
				}
			}

		}
		return masterLocations;
	}

	private List<LocationMaster> findUpdatedMasterLocations(List<LocationMaster> existingMasterLocations,
			List<LocationMaster> excelMasterLocations) {
		List<LocationMaster> updatedMasterLocations = new ArrayList<LocationMaster>();
		Map<String, List<LocationMaster>> existingLocationCodeMap = existingMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationCode().toString() + "|"
						+ locationObject.getLocationType()));
		if (excelMasterLocations != null && !excelMasterLocations.isEmpty() && existingMasterLocations != null
				&& !existingMasterLocations.isEmpty()) {
			for (LocationMaster eachExcelLocation : excelMasterLocations) {
				if (existingMasterLocations.contains(eachExcelLocation)
						&& !updatedMasterLocations.contains(eachExcelLocation)) {
					eachExcelLocation.setGuid(existingLocationCodeMap.get(
							eachExcelLocation.getLocationCode().toString() + "|" + eachExcelLocation.getLocationType())
							.get(0).getGuid());
					updatedMasterLocations.add(eachExcelLocation);
				}
			}
		}
		return updatedMasterLocations;
	}

	private void saveUpdateDeleteMasterLocations(String filePath, String locationType,
			LocationImportRequest locationImportRequest, Long parentLocationGuid) throws InternalServerException {
		List<LocationMaster> existingMasterLocations = new ArrayList<LocationMaster>();
		if (locationType.equalsIgnoreCase(ServiceConstants.LOCATION_STATE_TYPE)) {
			List<String> locationTypes = new ArrayList<String>();
			locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
			locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
			existingMasterLocations = locationMasterDao.getAllMasterLocationsByTypesAndParentLocation(locationTypes,
					parentLocationGuid);
		} else {
			existingMasterLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocation(locationType,
					parentLocationGuid);
		}

		List<LocationMaster> excelMasterLocations = new ArrayList<LocationMaster>();
		List<LocationMaster> newMasterLocations = prepareMasterLocations(filePath, existingMasterLocations,
				excelMasterLocations, locationImportRequest);

		processSaveUpdateDeleteLocations(newMasterLocations, excelMasterLocations, existingMasterLocations);

	}

	private void processSaveUpdateDeleteLocations(List<LocationMaster> newMasterLocations,
			List<LocationMaster> excelMasterLocations, List<LocationMaster> existingMasterLocations)
			throws InternalServerException {
		locationMasterDao.saveAllMasterLocations(newMasterLocations);
		List<LocationMaster> updatedMasterLocations = findUpdatedMasterLocations(existingMasterLocations,
				excelMasterLocations);
		if (updatedMasterLocations != null && !updatedMasterLocations.isEmpty()) {
			locationMasterDao.updateAllMasterLocations(updatedMasterLocations);
		}
		if (existingMasterLocations != null && !existingMasterLocations.isEmpty()) {
			existingMasterLocations.removeAll(excelMasterLocations);
			locationMasterDao.deleteMasterLocations(existingMasterLocations);
		}

	}

	@Override
	public boolean exportCountries() throws InternalServerException {

		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String fileName = env.getProperty("project.countries-locations-file-name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");
		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");

		uploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName;

		String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX + globalFolderName
				+ SUFFIX + fileName;

		Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);

		Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

		Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);

		if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
			exportWorkBook.removeSheetAt(0);
		}
		Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.LOCATION_EXCEL_COUNTRY_SHEET_NAME);
		addHeaderRow(exportWorkBookSheet);
		int j = 0;
		int i = 0;
		Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
		for (Row eachRow : importWorkBookSheet) {
			if (i < 3) {
				i++;
				continue;
			}
			String locationName = eachRow.getCell(2).getStringCellValue().trim();
			String locationType = ServiceConstants.LOCATION_COUNTRY_TYPE;

			if (locationName != null && !locationName.isEmpty()) {
				Long locationCode = (long) eachRow.getCell(1).getNumericCellValue();
				Long parentLocationGuid = (long) eachRow.getCell(3).getNumericCellValue();
				j++;
				sheetData.put(j, new Object[] { locationCode, locationName, locationType, parentLocationGuid });
			} else {
				break;
			}
		}
		writeDataIntoSheet(sheetData, exportWorkBookSheet);
		writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName, uploadedFolderName);

		return true;
	}

	@Override
	@Transactional
	public boolean exportStates() throws InternalServerException {

		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String fileName = env.getProperty("project.state-locations-file-name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		uploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX + countryFolderName;

		String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX + globalFolderName
				+ SUFFIX + countryFolderName + SUFFIX + fileName;

		List<LocationMaster> countryLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_COUNTRY_TYPE);

		if (countryLocations != null && !countryLocations.isEmpty()) {
			for (LocationMaster eachCountryLocation : countryLocations) {
				if (eachCountryLocation != null) {
					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook
							.createSheet(ServiceConstants.LOCATION_EXCEL_STATE_SHEET_NAME);
					addHeaderRow(exportWorkBookSheet);
					int j = 0;
					int i = 0;
					Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
					for (Row eachRow : importWorkBookSheet) {
						if (i < 3) {
							i++;
							continue;
						}

						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String locationType = "";
						String stateOrUnionTerritory = eachRow.getCell(7).getStringCellValue().trim();
						locationType = stateOrUnionTerritory.equalsIgnoreCase("S")
								? ServiceConstants.LOCATION_STATE_TYPE : ServiceConstants.LOCATION_UNION_TERRITORY_TYPE;

						if (locationName != null && !locationName.isEmpty()) {
							Long locationCode = (long) eachRow.getCell(1).getNumericCellValue();
							Long parentLocationGuid = eachCountryLocation.getGuid();
							j++;
							sheetData.put(j,
									new Object[] { locationCode, locationName, locationType, parentLocationGuid });

						} else {
							break;
						}
					}
					writeDataIntoSheet(sheetData, exportWorkBookSheet);
					writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName, uploadedFolderName);

				}
			}
		}
		return true;
	}

	private void addHeaderRow(Sheet exportWorkBookSheet) {
		Row headerRow = exportWorkBookSheet.createRow(0);

		Cell locationCodeHeaderCell = headerRow.createCell(0);
		Cell locationNameHeaderCell = headerRow.createCell(1);
		Cell locationTypeHeaderCell = headerRow.createCell(2);
		Cell parentLocationGuidHeaderCell = headerRow.createCell(3);

		locationCodeHeaderCell.setCellValue(ServiceConstants.LOCATION_CODE);
		locationNameHeaderCell.setCellValue(ServiceConstants.LOCATION_NAME);
		locationTypeHeaderCell.setCellValue(ServiceConstants.LOCATION_TYPE);
		parentLocationGuidHeaderCell.setCellValue(ServiceConstants.PARENT_LOCATION_GUID);

	}

	private void writeDataIntoSheet(Map<Integer, Object[]> sheetData, Sheet exportWorkBookSheet) {

		Set<Integer> newRows = sheetData.keySet();
		int rownum = exportWorkBookSheet.getLastRowNum() + 1;
		for (Integer key : newRows) {
			Row row = exportWorkBookSheet.createRow(rownum++);
			Object[] objArr = sheetData.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Long) {
					cell.setCellValue((Long) obj);
				} else if (obj == null) {
					cell.setCellType(Cell.CELL_TYPE_BLANK);
				}
			}
		}
	}

	private void writeExcelDataIntoAmazonS3File(String fileName, Workbook exportWorkBook, String bucketName,
			String uploadedFolderName) throws InternalServerException {
		FileOutputStream os = null;
		try {
			File exportedFile = new File(fileName);
			os = new FileOutputStream(exportedFile);
			try {
				exportWorkBook.write(os);
				os.close();
				exportWorkBook.close();

				AmazonS3Util.createFile(bucketName, null, exportedFile, uploadedFolderName + SUFFIX + fileName);

			} catch (IOException e) {
				throw new InternalServerException(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean exportDistricts() throws InternalServerException {

		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String fileName = env.getProperty("project.district-locations-file-name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<Long, List<LocationMaster>> stateMasterLocationsCodeMap = stateLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationCode()));

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName()
							+ SUFFIX + ruralFolderName + SUFFIX + fileName;

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					if (importWorkBook != null) {
						Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

						Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);
						if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
							exportWorkBook.removeSheetAt(0);
						}
						Sheet exportWorkBookSheet = exportWorkBook
								.createSheet(ServiceConstants.LOCATION_EXCEL_DISTRICT_SHEET_NAME);
						addHeaderRow(exportWorkBookSheet);
						int j = 0;
						int i = 0;
						Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
						for (Row eachRow : importWorkBookSheet) {
							if (i < 4) {
								i++;
								continue;
							}
							String locationName = eachRow.getCell(3).getStringCellValue().trim();
							String locationType = ServiceConstants.LOCATION_DISTRICT_TYPE;
							if (locationName != null && !locationName.isEmpty()) {
								Long locationCode = Long.parseLong(eachRow.getCell(1).getStringCellValue().trim());
								Long parentLocationCode = Long
										.parseLong(eachRow.getCell(5).getStringCellValue().trim());
								Long parentLocationGuid = stateMasterLocationsCodeMap.get(parentLocationCode).get(0)
										.getGuid();
								j++;
								sheetData.put(j,
										new Object[] { locationCode, locationName, locationType, parentLocationGuid });
							} else {
								break;
							}
						}

						String eachUploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX
								+ countryFolderName + SUFFIX;

						writeDataIntoSheet(sheetData, exportWorkBookSheet);
						writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName,
								eachUploadedFolderName + eachLocation.getLocationName() + SUFFIX + ruralFolderName);
					}
				}
			}
		}
		return true;
	}

	@Override
	@Transactional
	public boolean exportSubDistricts() throws InternalServerException {

		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String fileName = env.getProperty("project.sub_dsitrict-locations-file-name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

		if (CommonUtil.isListNotNullAndNotEmpty(stateLocations)) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName()
							+ SUFFIX + ruralFolderName + SUFFIX + fileName;

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					List<LocationMaster> districtLocations = locationMasterDao
							.getAllMasterLocationsByTypeAndParentLocation(ServiceConstants.LOCATION_DISTRICT_TYPE,
									eachLocation.getGuid());

					final Map<Long, List<LocationMaster>> districtLocationsMap = districtLocations.stream()
							.collect(Collectors.groupingBy(districtLocation -> districtLocation.getLocationCode()));

					if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
						for (LocationMaster eachDistrictLocation : districtLocations) {
							if (eachDistrictLocation != null) {

								Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);
								if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
									exportWorkBook.removeSheetAt(0);
								}
								Sheet exportWorkBookSheet = exportWorkBook
										.createSheet(ServiceConstants.LOCATION_EXCEL_SUB_DISTRICT_SHEET_NAME);
								addHeaderRow(exportWorkBookSheet);
								int j = 0;
								int i = 0;
								Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
								for (Row eachRow : importWorkBookSheet) {
									if (i < 4) {
										i++;
										continue;
									}

									String locationName = eachRow.getCell(3).getStringCellValue().trim();
									String locationType = ServiceConstants.LOCATION_SUB_DISTRICT_TYPE;

									if (locationName != null && !locationName.isEmpty()) {
										Long locationCode = (long) eachRow.getCell(1).getNumericCellValue();
										Long parentLocationCode = (long) eachRow.getCell(5).getNumericCellValue();
										Long parentLocationGuid = districtLocationsMap.get(parentLocationCode).get(0)
												.getGuid();

										if (eachDistrictLocation.getLocationCode().equals(parentLocationCode)
												|| eachDistrictLocation.getLocationCode().toString()
														.equalsIgnoreCase(parentLocationCode.toString())) {
											j++;
											sheetData.put(j, new Object[] { locationCode, locationName, locationType,
													parentLocationGuid });
										}
									} else {
										break;
									}
								}

								String eachUploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX
										+ countryFolderName + SUFFIX + eachLocation.getLocationName() + SUFFIX
										+ ruralFolderName + SUFFIX + eachDistrictLocation.getLocationName();

								writeDataIntoSheet(sheetData, exportWorkBookSheet);
								writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName,
										eachUploadedFolderName);
							}
						}
					}
				}
			}
		}

		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportMuncipalCorporations() throws InternalServerException {
		String fileName = env.getProperty("project.urban.bodies-locations-file-name");

		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String urbanFolderName = env.getProperty("amazon.s3.locations.urban.folder.name");

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName()
							+ SUFFIX + urbanFolderName + SUFFIX + fileName;

					String localBodyFileName = env.getProperty("project.municipality.corporations-locations-file-name");

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					Workbook exportWorkBook = CommonUtil.createWorkBook(localBodyFileName);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook
							.createSheet(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE);
					addHeaderRow(exportWorkBookSheet);

					int j = 0;
					int i = 0;
					Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
					for (Row eachRow : importWorkBookSheet) {
						if (i < 4) {
							i++;
							continue;
						}
						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String excelLocationType = eachRow.getCell(6).getStringCellValue().trim();
						String locationType = "";
						if (excelLocationType != null && excelLocationType
								.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPAL_CORPORATIONS_TYPE)) {
							locationType = ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE;
						}

						if (locationName != null && !locationName.isEmpty()) {
							Long locationCode = (long) eachRow.getCell(1).getNumericCellValue();
							if (locationType != null && locationType
									.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE)) {
								j++;
								locationName = CommonUtil.removeEndsWith(locationName,
										ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE_LOWER);
								sheetData.put(j, new Object[] { locationCode, locationName, locationType,
										eachLocation.getGuid() });
							}
						} else {
							break;
						}
					}
					String eachUploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX
							+ countryFolderName + SUFFIX;

					writeDataIntoSheet(sheetData, exportWorkBookSheet);
					writeExcelDataIntoAmazonS3File(localBodyFileName, exportWorkBook, bucketName,
							eachUploadedFolderName + eachLocation.getLocationName() + SUFFIX + urbanFolderName);
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportMuncipalities() throws InternalServerException {
		String fileName = env.getProperty("project.urban.bodies-locations-file-name");
		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String urbanFolderName = env.getProperty("amazon.s3.locations.urban.folder.name");

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName()
							+ SUFFIX + urbanFolderName + SUFFIX + fileName;

					String localBodyFileName = env.getProperty("project.municipalities-locations-file-name");

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					Workbook exportWorkBook = CommonUtil.createWorkBook(localBodyFileName);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.LOCATION_MUNCIPALITY_TYPE);
					addHeaderRow(exportWorkBookSheet);
					int j = 0;
					int i = 0;
					Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
					for (Row eachRow : importWorkBookSheet) {
						if (i < 4) {
							i++;
							continue;
						}
						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String locationType = eachRow.getCell(6).getStringCellValue().trim();

						if (locationName != null && !locationName.isEmpty()) {
							Long locationCode = (long) eachRow.getCell(1).getNumericCellValue();
							if (locationType != null
									&& locationType.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPALITY_TYPE)) {
								j++;
								locationName = CommonUtil.removeEndsWith(locationName,
										ServiceConstants.LOCATION_MUNCIPAL_COUNCIL_TYPE);
								sheetData.put(j, new Object[] { locationCode, locationName, locationType,
										eachLocation.getGuid() });
							}
						} else {
							break;
						}
					}
					String eachUploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX
							+ countryFolderName + SUFFIX;

					writeDataIntoSheet(sheetData, exportWorkBookSheet);
					writeExcelDataIntoAmazonS3File(localBodyFileName, exportWorkBook, bucketName,
							eachUploadedFolderName + eachLocation.getLocationName() + SUFFIX + urbanFolderName);
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportTownPanchayathies() throws InternalServerException {

		String fileName = env.getProperty("project.urban.bodies-locations-file-name");
		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String urbanFolderName = env.getProperty("amazon.s3.locations.urban.folder.name");

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName()
							+ SUFFIX + urbanFolderName + SUFFIX + fileName;

					String localBodyFileName = env.getProperty("project.town.panchayathies-locations-file-name");

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					Workbook exportWorkBook = CommonUtil.createWorkBook(localBodyFileName);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook
							.createSheet(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE);
					addHeaderRow(exportWorkBookSheet);

					int j = 0;
					int i = 0;
					Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
					for (Row eachRow : importWorkBookSheet) {
						if (i < 4) {
							i++;
							continue;
						}
						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String locationType = eachRow.getCell(6).getStringCellValue().trim();

						if (locationName != null && !locationName.isEmpty()) {
							Long locationCode = (long) eachRow.getCell(1).getNumericCellValue();
							if (locationType != null
									&& (locationType.equalsIgnoreCase(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE)
											|| locationType.equalsIgnoreCase(
													ServiceConstants.LOCATION_NOTIFIED_AREA_COUNCIL_TYPE))) {
								j++;
								locationName = CommonUtil.removeEndsWith(locationName,
										ServiceConstants.LOCATION_NAGAR_PANCHAYAT_TYPE);
								locationType = ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE;
								sheetData.put(j, new Object[] { locationCode, locationName, locationType,
										eachLocation.getGuid() });
							}
						} else {
							break;
						}
					}
					String eachUploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX
							+ countryFolderName + SUFFIX;

					writeDataIntoSheet(sheetData, exportWorkBookSheet);
					writeExcelDataIntoAmazonS3File(localBodyFileName, exportWorkBook, bucketName,
							eachUploadedFolderName + eachLocation.getLocationName() + SUFFIX + urbanFolderName);
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportVillagePanchayathies() throws InternalServerException {
		String fileName = env.getProperty("project.village.panchayathies-locations-file-name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName()
							+ SUFFIX + ruralFolderName + SUFFIX + fileName;

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					List<LocationMaster> districtLocations = locationMasterDao
							.getAllMasterLocationsByTypeAndParentLocation(ServiceConstants.LOCATION_DISTRICT_TYPE,
									eachLocation.getGuid());

					if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
						for (LocationMaster eachDistrictLocation : districtLocations) {
							if (eachDistrictLocation != null) {

								List<LocationMaster> subDistrictLocations = new ArrayList<LocationMaster>();
								subDistrictLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocation(
										ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, eachDistrictLocation.getGuid());

								final Map<Long, List<LocationMaster>> subDistrictLocationsMap = subDistrictLocations
										.stream().collect(Collectors.groupingBy(
												subDistrictLocation -> subDistrictLocation.getLocationCode()));

								if (CommonUtil.isListNotNullAndNotEmpty(subDistrictLocations)) {
									for (LocationMaster eachSubDistrictLocation : subDistrictLocations) {
										if (eachSubDistrictLocation != null) {

											Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);

											if (exportWorkBook.getNumberOfSheets() == 1
													&& exportWorkBook.getSheetAt(0) != null) {
												exportWorkBook.removeSheetAt(0);
											}
											Sheet exportWorkBookSheet = exportWorkBook
													.createSheet(ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE);
											addHeaderRow(exportWorkBookSheet);

											int j = 0;
											int i = 0;
											Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
											for (Row eachRow : importWorkBookSheet) {
												if (i < 4) {
													i++;
													continue;
												}
												String locationName = eachRow.getCell(13).getStringCellValue().trim();
												String districtName = eachRow.getCell(1).getStringCellValue().trim();
												String locationType = ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE;
												if (locationName != null && !locationName.isEmpty()) {
													Long locationCode = (long) eachRow.getCell(12)
															.getNumericCellValue();
													Long parentLocationCode = (long) eachRow.getCell(4)
															.getNumericCellValue();

													if (eachSubDistrictLocation.getLocationCode()
															.equals(parentLocationCode)
															|| eachSubDistrictLocation.getLocationCode().toString()
																	.equalsIgnoreCase(parentLocationCode.toString())) {
														Long parentLocationGuid = subDistrictLocationsMap
																.get(parentLocationCode).get(0).getGuid();
														j++;
														sheetData.put(j, new Object[] { locationCode, locationName,
																locationType, parentLocationGuid });
													}
												}
												if (districtName == null || districtName.isEmpty()) {
													break;
												}
											}
											writeDataIntoSheet(sheetData, exportWorkBookSheet);

											String eachUploadedFolderName = uploadedFolderName + SUFFIX
													+ globalFolderName + SUFFIX + countryFolderName + SUFFIX
													+ eachLocation.getLocationName() + SUFFIX + ruralFolderName + SUFFIX
													+ eachDistrictLocation.getLocationName() + SUFFIX
													+ eachSubDistrictLocation.getLocationName();

											writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName,
													eachUploadedFolderName);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportVillages() throws InternalServerException {
		String fileName = env.getProperty("project.villages-locations-file-name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
							+ globalFolderName + SUFFIX + countryFolderName + SUFFIX + eachLocation.getLocationName()
							+ SUFFIX + ruralFolderName + SUFFIX + fileName;

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					List<LocationMaster> districtLocations = locationMasterDao
							.getAllMasterLocationsByTypeAndParentLocation(ServiceConstants.LOCATION_DISTRICT_TYPE,
									eachLocation.getGuid());

					if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
						for (LocationMaster eachDistrictLocation : districtLocations) {
							if (eachDistrictLocation != null) {

								List<LocationMaster> subDistrictLocations = new ArrayList<LocationMaster>();
								subDistrictLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocation(
										ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, eachDistrictLocation.getGuid());

								final Map<Long, List<LocationMaster>> subDistrictLocationsMap = subDistrictLocations
										.stream().collect(Collectors.groupingBy(
												subDistrictLocation -> subDistrictLocation.getLocationCode()));

								if (CommonUtil.isListNotNullAndNotEmpty(subDistrictLocations)) {
									for (LocationMaster eachSubDistrictLocation : subDistrictLocations) {
										if (eachSubDistrictLocation != null) {

											Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);

											if (exportWorkBook.getNumberOfSheets() == 1
													&& exportWorkBook.getSheetAt(0) != null) {
												exportWorkBook.removeSheetAt(0);
											}
											Sheet exportWorkBookSheet = exportWorkBook
													.createSheet(ServiceConstants.LOCATION_VILLAGE_TYPE);
											addHeaderRow(exportWorkBookSheet);

											int j = 0;
											int i = 0;
											Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
											for (Row eachRow : importWorkBookSheet) {
												if (i < 4) {
													i++;
													continue;
												}
												String locationName = eachRow.getCell(3).getStringCellValue().trim();
												String locationType = ServiceConstants.LOCATION_VILLAGE_TYPE;
												if (locationName != null && !locationName.isEmpty()) {
													Long locationCode = (long) eachRow.getCell(1).getNumericCellValue();
													Long parentLocationCode = (long) eachRow.getCell(5)
															.getNumericCellValue();

													if (eachSubDistrictLocation.getLocationCode()
															.equals(parentLocationCode)
															|| eachSubDistrictLocation.getLocationCode().toString()
																	.equalsIgnoreCase(parentLocationCode.toString())) {
														Long parentLocationGuid = subDistrictLocationsMap
																.get(parentLocationCode).get(0).getGuid();
														j++;
														sheetData.put(j, new Object[] { locationCode, locationName,
																locationType, parentLocationGuid });
													}
												} else {
													break;
												}
											}
											writeDataIntoSheet(sheetData, exportWorkBookSheet);

											String eachUploadedFolderName = uploadedFolderName + SUFFIX
													+ globalFolderName + SUFFIX + countryFolderName + SUFFIX
													+ eachLocation.getLocationName() + SUFFIX + ruralFolderName + SUFFIX
													+ eachDistrictLocation.getLocationName() + SUFFIX
													+ eachSubDistrictLocation.getLocationName();

											writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName,
													eachUploadedFolderName);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return true;

	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportVillageReferenceLocations() throws InternalServerException {

		String fileName = env.getProperty("project.village.panchayathies-locations-file-name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String ruralFolderName = env.getProperty("amazon.s3.locations.rural.folder.name");

		List<LocationMaster> countryLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_COUNTRY_TYPE);

		if (countryLocations != null && !countryLocations.isEmpty()) {
			for (LocationMaster eachCountryLocation : countryLocations) {
				if (eachCountryLocation != null) {

					List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
					List<String> locationTypes = new ArrayList<String>();
					locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
					locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
					stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

					if (stateLocations != null && !stateLocations.isEmpty()) {
						for (LocationMaster eachLocation : stateLocations) {
							if (eachLocation != null) {

								List<LocationMaster> districtLocations = locationMasterDao
										.getAllMasterLocationsByTypeAndParentLocation(
												ServiceConstants.LOCATION_DISTRICT_TYPE, eachLocation.getGuid());

								if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
									for (LocationMaster eachDistrictLocation : districtLocations) {
										if (eachDistrictLocation != null) {

											List<LocationMaster> subDistrictLocations = new ArrayList<LocationMaster>();
											subDistrictLocations = locationMasterDao
													.getAllMasterLocationsByTypeAndParentLocation(
															ServiceConstants.LOCATION_SUB_DISTRICT_TYPE,
															eachDistrictLocation.getGuid());

											if (CommonUtil.isListNotNullAndNotEmpty(subDistrictLocations)) {
												for (LocationMaster eachSubDistrictLocation : subDistrictLocations) {
													if (eachSubDistrictLocation != null) {

														List<LocationMaster> villagePanchayathLocations = locationMasterDao
																.getAllMasterLocationsByTypeAndParentLocation(
																		ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE,
																		eachSubDistrictLocation.getGuid());

														final Map<Long, List<LocationMaster>> villagePanchayathLocationsMap = villagePanchayathLocations
																.stream()
																.collect(Collectors.groupingBy(
																		villagePanchayathLocation -> villagePanchayathLocation
																				.getLocationCode()));

														List<LocationMaster> villageLocations = locationMasterDao
																.getAllMasterLocationsByTypeAndParentLocation(
																		ServiceConstants.LOCATION_VILLAGE_TYPE,
																		eachSubDistrictLocation.getGuid());

														final Map<Long, List<LocationMaster>> villageLocationsMap = villageLocations
																.stream()
																.collect(Collectors
																		.groupingBy(villageLocation -> villageLocation
																				.getLocationCode()));

														String inputFilePath = hostName + bucketName + SUFFIX
																+ downloadedFolderName + SUFFIX + globalFolderName
																+ SUFFIX + countryFolderName + SUFFIX
																+ eachLocation.getLocationName() + SUFFIX
																+ ruralFolderName + SUFFIX + fileName;

														Workbook importWorkBook = CommonUtil
																.getWorkBookFromFile(inputFilePath);
														Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

														Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);
														if (exportWorkBook.getNumberOfSheets() == 1
																&& exportWorkBook.getSheetAt(0) != null) {
															exportWorkBook.removeSheetAt(0);
														}
														Sheet exportWorkBookSheet = exportWorkBook.createSheet(
																ServiceConstants.LOCATION_VILLAGE_REFERENCE_TYPE);
														addReferenceHeaderRow(exportWorkBookSheet);
														int j = 0;
														int i = 0;
														Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
														for (Row eachRow : importWorkBookSheet) {
															if (i < 4) {
																i++;
																continue;
															}
															String villageLocationName = eachRow.getCell(9)
																	.getStringCellValue().trim();
															if (villageLocationName != null
																	&& !villageLocationName.isEmpty()) {
																Long villageLocationCode = (long) eachRow.getCell(8)
																		.getNumericCellValue();
																Long villagePanchathLocationCode = null;
																if ((Double) eachRow.getCell(12)
																		.getNumericCellValue() != null) {
																	villagePanchathLocationCode = (long) eachRow
																			.getCell(12).getNumericCellValue();
																}

																Long subDistrictLocationCode = (long) eachRow.getCell(4)
																		.getNumericCellValue();

																Long villageLocationGuid = null;
																Long villageLocationPanchayathGuid = null;

																if (eachSubDistrictLocation.getLocationCode()
																		.equals(subDistrictLocationCode)
																		|| eachSubDistrictLocation.getLocationCode()
																				.toString().equalsIgnoreCase(
																						subDistrictLocationCode
																								.toString())) {

																	if (villageLocationCode != null
																			&& !villageLocationCode
																					.equals(Long.valueOf(0))) {
																		villageLocationGuid = villageLocationsMap
																				.get(villageLocationCode).get(0)
																				.getGuid();
																	}

																	if (villagePanchathLocationCode != null
																			&& !villagePanchathLocationCode
																					.equals(Long.valueOf(0))) {
																		villageLocationPanchayathGuid = villagePanchayathLocationsMap
																				.get(villagePanchathLocationCode).get(0)
																				.getGuid();
																	}

																	j++;
																	sheetData.put(j, new Object[] { villageLocationGuid,
																			villageLocationPanchayathGuid, null, null,
																			null, eachSubDistrictLocation.getGuid(),
																			eachDistrictLocation.getGuid(),
																			eachLocation.getGuid(),
																			eachCountryLocation.getGuid() });
																}
															} else {
																break;
															}
														}
														writeDataIntoSheet(sheetData, exportWorkBookSheet);

														String eachUploadedFolderName = uploadedFolderName + SUFFIX
																+ globalFolderName + SUFFIX + countryFolderName + SUFFIX
																+ eachLocation.getLocationName() + SUFFIX
																+ ruralFolderName + SUFFIX
																+ eachDistrictLocation.getLocationName() + SUFFIX
																+ eachSubDistrictLocation.getLocationName();

														String referenceFileName = env.getProperty(
																"project.village.references-locations-file-name");
														writeExcelDataIntoAmazonS3File(referenceFileName,
																exportWorkBook, bucketName, eachUploadedFolderName);
													}
												}
											}
										}
									}
								}

							}
						}
					}
				}
			}
		}

		return true;

	}

	private void addReferenceHeaderRow(Sheet exportWorkBookSheet) {
		Row headerRow = exportWorkBookSheet.createRow(0);

		Cell locationVillageHeaderCell = headerRow.createCell(0);
		Cell locationVillagePanchayatHeaderCell = headerRow.createCell(1);
		Cell locationTownPanchayathHeaderCell = headerRow.createCell(2);
		Cell locationMunicipalityHeaderCell = headerRow.createCell(3);
		Cell locationMunicipalCorporationHeaderCell = headerRow.createCell(4);
		Cell locationSubDistrictHeaderCell = headerRow.createCell(5);
		Cell locationDistrictHeaderCell = headerRow.createCell(6);
		Cell locationStateHeaderCell = headerRow.createCell(7);
		Cell locationCountryHeaderCell = headerRow.createCell(8);

		locationVillageHeaderCell.setCellValue(ServiceConstants.LOCATION_VILLAGE_TYPE);
		locationVillagePanchayatHeaderCell.setCellValue(ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE);
		locationTownPanchayathHeaderCell.setCellValue(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE);
		locationMunicipalityHeaderCell.setCellValue(ServiceConstants.LOCATION_MUNCIPALITY_TYPE);
		locationMunicipalCorporationHeaderCell.setCellValue(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE);
		locationSubDistrictHeaderCell.setCellValue(ServiceConstants.LOCATION_SUB_DISTRICT_TYPE);
		locationDistrictHeaderCell.setCellValue(ServiceConstants.LOCATION_DISTRICT_TYPE);
		locationStateHeaderCell.setCellValue(ServiceConstants.LOCATION_STATE_TYPE);
		locationCountryHeaderCell.setCellValue(ServiceConstants.LOCATION_COUNTRY_TYPE);

	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportUrbanReferenceLocations() throws InternalServerException {

		String fileName = env.getProperty("project.urban.local.bodies-locations-file-name");
		String hostName = env.getProperty("amazon.s3.host.name");
		String bucketName = env.getProperty("amazon.s3.locations.bucket.name");
		String downloadedFolderName = env.getProperty("amazon.s3.locations.downloaded.folder.name");
		String uploadedFolderName = env.getProperty("amazon.s3.locations.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.locations.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.locations.india.folder.name");
		String urbanFolderName = env.getProperty("amazon.s3.locations.urban.folder.name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		List<LocationMaster> countryLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_COUNTRY_TYPE);
		if (countryLocations != null && !countryLocations.isEmpty()) {
			for (LocationMaster eachCountryLocation : countryLocations) {
				if (eachCountryLocation != null) {
					if (stateLocations != null && !stateLocations.isEmpty()) {
						for (LocationMaster eachLocation : stateLocations) {
							if (eachLocation != null) {

								List<String> urbanLocationTypes = new ArrayList<String>();
								urbanLocationTypes.add(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE);
								urbanLocationTypes.add(ServiceConstants.LOCATION_MUNCIPALITY_TYPE);
								urbanLocationTypes.add(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE);

								List<LocationMaster> urbanLocationsList = locationMasterDao
										.getAllMasterLocationsByTypesAndParentLocation(urbanLocationTypes,
												eachLocation.getGuid());

								final Map<Long, List<LocationMaster>> urbanLocationsMap = urbanLocationsList.stream()
										.collect(Collectors
												.groupingBy(urbanLocation -> urbanLocation.getLocationCode()));

								List<LocationMaster> districtLocations = locationMasterDao
										.getAllMasterLocationsByTypeAndParentLocation(
												ServiceConstants.LOCATION_DISTRICT_TYPE, eachLocation.getGuid());

								final Map<Long, List<LocationMaster>> districtLocationsMap = districtLocations.stream()
										.collect(Collectors
												.groupingBy(districtLocation -> districtLocation.getLocationCode()));

								List<Long> districtLocationGuids = districtLocations.stream()
										.map(LocationMaster::getGuid).collect(Collectors.toList());

								List<LocationMaster> subDistrictLocations = locationMasterDao
										.getAllMasterLocationsByTypeAndParentLocations(
												ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, districtLocationGuids);

								final Map<Long, List<LocationMaster>> subDistrictLocationsMap = subDistrictLocations
										.stream().collect(Collectors.groupingBy(
												subDistrictLocation -> subDistrictLocation.getLocationCode()));

								String inputFilePath = hostName + bucketName + SUFFIX + downloadedFolderName + SUFFIX
										+ globalFolderName + SUFFIX + countryFolderName + SUFFIX
										+ eachLocation.getLocationName() + SUFFIX + urbanFolderName + SUFFIX + fileName;

								Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
								Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

								Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);

								if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
									exportWorkBook.removeSheetAt(0);
								}
								Sheet exportWorkBookSheet = exportWorkBook
										.createSheet(ServiceConstants.LOCATION_URBAN_BODY_TYPE);
								addReferenceHeaderRow(exportWorkBookSheet);
								int j = 0;
								int i = 0;
								Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
								for (Row eachRow : importWorkBookSheet) {
									if (i < 4) {
										i++;
										continue;
									}
									Long locationCode = (long) eachRow.getCell(0).getNumericCellValue();
									String locationName = eachRow.getCell(1).getStringCellValue().trim();
									if (locationName != null && !locationName.isEmpty()) {

										Long districtLocationCode = (long) eachRow.getCell(5).getNumericCellValue();
										Long subDistrictLocationCode = (long) eachRow.getCell(7).getNumericCellValue();

										Long urbanLocationGuid = null;
										String urbanLocationType = "";
										LocationMaster locationMaster = null;
										if (urbanLocationsMap.get(locationCode) != null) {
											locationMaster = urbanLocationsMap.get(locationCode).get(0);
										}
										if (locationMaster != null) {
											urbanLocationType = locationMaster.getLocationType();
											urbanLocationGuid = locationMaster.getGuid();
										}

										Long districtLocationGuid = null;
										Long subDistrictLocationGuid = null;

										if (districtLocationCode != null
												&& !districtLocationCode.equals(Long.valueOf(0))) {
											districtLocationGuid = districtLocationsMap.get(districtLocationCode).get(0)
													.getGuid();

										}

										if (subDistrictLocationCode != null
												&& !subDistrictLocationCode.equals(Long.valueOf(0))) {
											subDistrictLocationGuid = subDistrictLocationsMap
													.get(subDistrictLocationCode).get(0).getGuid();
										}

										Location loc = new Location();
										if (urbanLocationType != null) {
											if (urbanLocationType.equalsIgnoreCase(
													ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE)) {
												loc.setLocationMunicipalCorporation(urbanLocationGuid);
											} else if (urbanLocationType
													.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPALITY_TYPE)) {
												loc.setLocationMunicipality(urbanLocationGuid);
											} else if (urbanLocationType
													.equalsIgnoreCase(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE)) {
												loc.setLocationTownPanchayat(urbanLocationGuid);
											}
										}
										j++;
										sheetData.put(j, new Object[] { null, null, loc.getLocationTownPanchayat(),
												loc.getLocationMunicipality(), loc.getLocationMunicipalCorporation(),
												subDistrictLocationGuid, districtLocationGuid, eachLocation.getGuid(),
												eachCountryLocation.getGuid() });

									} else {
										break;
									}
								}
								writeDataIntoSheet(sheetData, exportWorkBookSheet);

								String eachUploadedFolderName = uploadedFolderName + SUFFIX + globalFolderName + SUFFIX
										+ countryFolderName + SUFFIX + eachLocation.getLocationName() + SUFFIX
										+ urbanFolderName;

								writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName,
										eachUploadedFolderName);
							}
						}
					}
				}
			}
		}

		return true;

	}

	@Override
	@Transactional
	public boolean importVillageReferenceLocations() throws InternalServerException {

		String filePath = env.getProperty("project.village-upload-locations-reference-file-name");
		processReferenceLocationsData(filePath);
		return true;

	}

	@Override
	@Transactional
	public boolean importUrbanReferenceLocations() throws InternalServerException {
		// TODO Auto-generated method stub

		String filePath = env.getProperty("project.urban-upload-locations-reference-file-name");
		processReferenceLocationsData(filePath);
		return true;

	}

	private void processReferenceLocationsData(String filePath) throws InternalServerException {

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		List<Location> referenceLocations = new ArrayList<Location>();
		userInfoDao.updateAllUsersLocationReferenceToDefault();

		if (stateMasterLocations != null && !stateMasterLocations.isEmpty()) {
			for (LocationMaster eachStateLocation : stateMasterLocations) {
				if (eachStateLocation != null) {

					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path") + filePath;
					String fileName = eachStateLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;
					outPutFilePath = directoryPath + fileName;

					List<Location> eachSheetNewReferenceLocations = prepareReferenceLocations(outPutFilePath);
					referenceLocations.addAll(eachSheetNewReferenceLocations);
				}
			}
			locationDao.saveAllLocations(referenceLocations);

		}
		updateAllUsersLocationReferenceToBaseLocation();

	}

	private void updateAllUsersLocationReferenceToBaseLocation() throws InternalServerException {
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();
		userInfoList = userInfoDao.getAllUsers();
		if (userInfoList != null && !userInfoList.isEmpty()) {
			for (UserInfo userInfo : userInfoList) {

				String masterLocationType = userInfo.getMasterLocation().getLocationType();
				Long masterLocationGuid = userInfo.getMasterLocation().getGuid();

				Location updatedLocation = locationDao.getLocationByTypeAndGuid(masterLocationType, masterLocationGuid);
				userInfo.setNativeLocation(updatedLocation);
			}
			userInfoDao.updateUsers(userInfoList);
		}
	}

	private List<Location> prepareReferenceLocations(String outPutFilePath) throws InternalServerException {

		List<Location> referenceLocations = new ArrayList<Location>();
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);

		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {
			if (i < 1) {
				i++;
				continue;
			}
			Location location = prepareLocationReferenceData(eachRow);
			if (!referenceLocations.contains(location)) {
				referenceLocations.add(location);
			}
		}
		return referenceLocations;
	}

	private Location prepareLocationReferenceData(Row eachRow) {
		Cell villageCell = eachRow.getCell(0);
		Cell villagePanchayathCell = eachRow.getCell(1);
		Cell townPanchathCell = eachRow.getCell(2);
		Cell municipalityCell = eachRow.getCell(3);
		Cell municipalityCorporationCell = eachRow.getCell(4);
		Cell subDistrictCell = eachRow.getCell(5);
		Cell districtCell = eachRow.getCell(6);
		Cell stateCell = eachRow.getCell(7);
		Cell countryCell = eachRow.getCell(8);

		Location location = null;

		if (villageCell.getCellType() != Cell.CELL_TYPE_BLANK
				|| villagePanchayathCell.getCellType() != Cell.CELL_TYPE_BLANK
				|| townPanchathCell.getCellType() != Cell.CELL_TYPE_BLANK
				|| municipalityCell.getCellType() != Cell.CELL_TYPE_BLANK
				|| municipalityCorporationCell.getCellType() != Cell.CELL_TYPE_BLANK
				|| subDistrictCell.getCellType() != Cell.CELL_TYPE_BLANK
				|| districtCell.getCellType() != Cell.CELL_TYPE_BLANK || stateCell.getCellType() != Cell.CELL_TYPE_BLANK
				|| countryCell.getCellType() != Cell.CELL_TYPE_BLANK) {
			location = new Location();

			Long locationVillage = null;
			Long locationVillagePanchayat = null;
			Long locationTownPanchayat = null;
			Long locationMunicipality = null;
			Long locationMunicipalCorporation = null;
			Long locationSubDistrict = null;
			Long locationDistrict = null;
			Long locationState = null;
			Long locationCountry = null;

			if (villageCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double villageLocationCode = villageCell.getNumericCellValue();
				locationVillage = (long) villageLocationCode;
			}
			if (villagePanchayathCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double villagePanchayatLocationCode = villagePanchayathCell.getNumericCellValue();
				locationVillagePanchayat = (long) villagePanchayatLocationCode;
			}
			if (townPanchathCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double townPanchaytLocationCode = townPanchathCell.getNumericCellValue();
				locationTownPanchayat = (long) townPanchaytLocationCode;
			}
			if (municipalityCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double municipalityLocationCode = municipalityCell.getNumericCellValue();
				locationMunicipality = (long) municipalityLocationCode;
			}
			if (municipalityCorporationCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double municipalCorporationLocationCode = municipalityCorporationCell.getNumericCellValue();
				locationMunicipalCorporation = (long) municipalCorporationLocationCode;
			}
			if (subDistrictCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double subDistrictLocationCode = subDistrictCell.getNumericCellValue();
				locationSubDistrict = (long) subDistrictLocationCode;
			}
			if (districtCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double districtLocationCode = districtCell.getNumericCellValue();
				locationDistrict = (long) districtLocationCode;
			}
			if (stateCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double stateLocationCode = stateCell.getNumericCellValue();
				locationState = (long) stateLocationCode;
			}
			if (countryCell.getCellType() != Cell.CELL_TYPE_BLANK) {
				double countryLocationCode = countryCell.getNumericCellValue();
				locationCountry = (long) countryLocationCode;
			}

			location.setLocationVillage(locationVillage);
			location.setLocationVillagePanchayat(locationVillagePanchayat);
			location.setLocationTownPanchayat(locationTownPanchayat);
			location.setLocationMunicipality(locationMunicipality);
			location.setLocationMunicipalCorporation(locationMunicipalCorporation);
			location.setLocationSubDistrict(locationSubDistrict);
			location.setLocationDistrict(locationDistrict);
			location.setLocationState(locationState);
			location.setLocationCountry(locationCountry);

		}
		return location;
	}

	@Override
	@Transactional
	public boolean importMPConstituencyLocations() throws InternalServerException {

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<String, List<LocationMaster>> stateMasterLocationsCodeMap = stateMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationName().toUpperCase()));

		List<LocationMaster> exportMasterLocations = new ArrayList<LocationMaster>();
		List<LocationMaster> existingMasterLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_MP_CONSTITUENCT_TYPE);

		List<LocationMaster> newMasterLocations = new ArrayList<LocationMaster>();
		processMPConstituencyLocations(stateMasterLocationsCodeMap, existingMasterLocations, exportMasterLocations,
				newMasterLocations);
		processSaveUpdateDeleteLocations(newMasterLocations, exportMasterLocations, existingMasterLocations);

		return true;
	}

	private void processMPConstituencyLocations(Map<String, List<LocationMaster>> stateMasterLocationsCodeMap,
			List<LocationMaster> existingMasterLocations, List<LocationMaster> exportMasterLocations,
			List<LocationMaster> newMasterLocations) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(env.getProperty("india-loksabha-constituency.url"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			new InternalServerException(e.getMessage());
		}

		List<WebElement> stateNameHeaderElements = driver.findElements(By.tagName("h3"));
		List<WebElement> mpConstiencyTables = driver.findElements(By.cssSelector("table.wikitable"));
		if (mpConstiencyTables != null && !mpConstiencyTables.isEmpty()) {

			int tableIndex = 0;
			for (WebElement eachMpConstiencyTable : mpConstiencyTables) {
				if (tableIndex == 0) {
					tableIndex++;
					continue;
				}
				if (eachMpConstiencyTable != null) {
					WebElement stateNameHeaderElement = stateNameHeaderElements.get(tableIndex - 1);
					WebElement stateNameHeaderSpanElement = stateNameHeaderElement.findElement(By.xpath("span"));
					WebElement stateNameHeaderSpanAchorElement = stateNameHeaderSpanElement.findElement(By.xpath("a"));
					String stateName = stateNameHeaderSpanAchorElement.getText();
					WebElement eachMpConstiencyTableTbody = eachMpConstiencyTable.findElements(By.xpath("tbody"))
							.get(0);
					List<WebElement> eachMpConstiencyTableTbodyTrList = eachMpConstiencyTableTbody
							.findElements(By.xpath("tr"));
					if (eachMpConstiencyTableTbodyTrList != null && !eachMpConstiencyTableTbodyTrList.isEmpty()) {
						for (WebElement row : eachMpConstiencyTableTbodyTrList) {

							List<WebElement> cells = row.findElements(By.xpath("td"));

							WebElement mpConstituencyNoCell = cells.get(0);
							WebElement mpConstituencyNameCell = cells.get(1);

							if (mpConstituencyNoCell != null && mpConstituencyNoCell.getText() != null
									&& !mpConstituencyNoCell.getText().isEmpty()) {

								Long mpConstituencyNo = Long.parseLong(mpConstituencyNoCell.getText());
								String mpConstituencyName = mpConstituencyNameCell.getText();

								LocationMaster locationMaster = new LocationMaster();
								locationMaster.setLocationName(mpConstituencyName);
								locationMaster.setLocationCode(mpConstituencyNo);
								locationMaster.setLocationType(ServiceConstants.LOCATION_MP_CONSTITUENCT_TYPE);
								stateName = CommonUtil.getResolvedConflictedLocationName(stateName);
								stateName = stateName.toUpperCase();
								Long parentLocationGuid = stateMasterLocationsCodeMap.get(stateName).get(0).getGuid();
								locationMaster.setParentLocationGuid(parentLocationGuid);

								if (!newMasterLocations.contains(locationMaster)
										&& !existingMasterLocations.contains(locationMaster)) {
									newMasterLocations.add(locationMaster);
								}

								if (!exportMasterLocations.contains(locationMaster)) {
									exportMasterLocations.add(locationMaster);
								}
							}
						}
					}
				}
				tableIndex++;
			}
		}
		driver.close();
		driver.quit();

	}

	@Override
	@Transactional
	public boolean importExportAllMasterLocations() throws InternalServerException {
		System.out.println("Export Countries Start");
		exportCountries();
		System.out.println("Export Countries End");
		System.out.println("Import Countries Started");
		importCountries(null);
		System.out.println("Import Countries End");
		System.out.println("Export States Started");
		exportStates();
		System.out.println("Export States Ended");
		System.out.println("Import States Started");
		importStates(null);
		System.out.println("Import Stated End");
		System.out.println("Export Districts Started");
		exportDistricts();
		System.out.println("Export Districts Ended");
		System.out.println("Import Districts Started");
		importDistricts(null);
		System.out.println("Import Districts Ended");
		System.out.println("Export Sub Districts Started");
		exportSubDistricts();
		System.out.println("Export Sub Districts Ended");
		System.out.println("Import Sub Districts Started");
		importSubDistricts(null);
		System.out.println("Import Sub Districts Ended");
		System.out.println("Export Muncipal Corporations Started");
		exportMuncipalCorporations();
		System.out.println("Export Muncipal Corporations Ended");
		System.out.println("Import MC Started");
		importMuncipalCorporations(null);
		System.out.println("Import MC Ended");
		System.out.println("Export M Started");
		exportMuncipalities();
		System.out.println("Export M Ended");
		System.out.println("Import M Started");
		importMuncipalities(null);
		System.out.println("Import M Ended");
		System.out.println("Export TP Started");
		exportTownPanchayathies();
		System.out.println("Export TP Ended");
		System.out.println("Import TP Started");
		importTownPanchayathies(null);
		System.out.println("Import TP End");
		System.out.println("Export VP Started");
		exportVillagePanchayathies();
		System.out.println("Export VP End");
		System.out.println("Import VP Started");
		importVillagePanchayathies(null);
		System.out.println("Import VP End");
		System.out.println("Export V Started");
		exportVillages();
		System.out.println("Export V Ended");
		System.out.println("Import V Started");
		importVillages(null);
		System.out.println("Import V End");
		return true;
	}

	@Override
	@Transactional
	public boolean importExportAllReferenceLocations() throws InternalServerException {
		System.out.println("Export V Ref Start");
		exportVillageReferenceLocations();
		System.out.println("Export V Ref End");
		System.out.println("Import V Ref Start");
		importVillageReferenceLocations();
		System.out.println("Import V Ref End");
		System.out.println("Export U Ref Start");
		exportUrbanReferenceLocations();
		System.out.println("Export U Ref End");
		System.out.println("Import U Ref Start");
		importUrbanReferenceLocations();
		System.out.println("Import U Ref End");
		return true;
	}

	@Override
	@Transactional
	public boolean importMLAConstituencyLocations() throws InternalServerException {

		List<LocationMaster> mPMasterLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_MP_CONSTITUENCT_TYPE);

		Map<String, List<LocationMaster>> mPMasterLocationsCodeMap = mPMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationName()));

		List<LocationMaster> exportMasterLocations = new ArrayList<LocationMaster>();
		List<LocationMaster> existingMasterLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE);

		List<LocationMaster> newMasterLocations = new ArrayList<LocationMaster>();
		processMLAConstituencyLocations(mPMasterLocationsCodeMap, existingMasterLocations, exportMasterLocations,
				newMasterLocations);
		processSaveUpdateDeleteLocations(newMasterLocations, exportMasterLocations, existingMasterLocations);

		return true;
	}

	private void processMLAConstituencyLocations(Map<String, List<LocationMaster>> mPMasterLocationsCodeMap,
			List<LocationMaster> existingMasterLocations, List<LocationMaster> exportMasterLocations,
			List<LocationMaster> newMasterLocations) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(env.getProperty("india-mla-constituency.url"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			new InternalServerException(e.getMessage());
		}

		List<WebElement> mpConstiencyTables = driver.findElements(By.cssSelector("table.wikitable"));
		if (mpConstiencyTables != null && !mpConstiencyTables.isEmpty()) {

			int tableIndex = 0;
			for (WebElement eachMpConstiencyTable : mpConstiencyTables) {
				if (tableIndex == 0) {
					tableIndex++;
					continue;
				}
				Long validStateMLAConstituencyId = (long) 0;
				if (eachMpConstiencyTable != null) {
					WebElement eachMpConstiencyTableTbody = eachMpConstiencyTable.findElements(By.xpath("tbody"))
							.get(0);
					List<WebElement> eachMpConstiencyTableTbodyTrList = eachMpConstiencyTableTbody
							.findElements(By.xpath("tr"));
					if (eachMpConstiencyTableTbodyTrList != null && !eachMpConstiencyTableTbodyTrList.isEmpty()) {
						for (WebElement row : eachMpConstiencyTableTbodyTrList) {

							List<WebElement> cells = row.findElements(By.xpath("td"));
							WebElement mpConstituencyNameCell = cells.get(1);
							String mpConstituencyName = mpConstituencyNameCell.getText();
							WebElement mlaConstituencyNamesCell = cells.get(3);
							System.out.println(mlaConstituencyNamesCell.getText());
							System.out.println(">>>>>>>>>>>>>>");

							if (mpConstituencyNameCell != null && mpConstituencyNameCell.getText() != null
									&& !mpConstituencyNameCell.getText().isEmpty() && mlaConstituencyNamesCell != null
									&& mlaConstituencyNamesCell.getText() != null
									&& !mlaConstituencyNamesCell.getText().isEmpty()) {

								Long parentLocationGuid = mPMasterLocationsCodeMap.get(mpConstituencyName).get(0)
										.getGuid();

								String[] mlaConstituencyNamesArray = mlaConstituencyNamesCell.getText().trim()
										.split("(?<=\\D)(?=\\d)");

								boolean isHavingHyphon = false;
								boolean isHavingDot = false;

								if (mlaConstituencyNamesCell.getText().trim().charAt(1) == '-') {
									isHavingHyphon = true;
								}

								if (mlaConstituencyNamesCell.getText().trim().charAt(1) == '.') {
									isHavingDot = true;
								}

								for (int i = 0; i < mlaConstituencyNamesArray.length; i++) {
									String eachStr = mlaConstituencyNamesArray[i].trim();
									Long locationCode = null;
									String locationName = "";

									if (eachStr.matches(".*\\d+.*") && isHavingDot) {
										locationCode = Long.parseLong(eachStr.split("\\.")[0]);
										locationName = eachStr.split("\\.")[1].trim();
										validStateMLAConstituencyId = prepareLocationMasterData(locationCode,
												locationName, parentLocationGuid, existingMasterLocations,
												exportMasterLocations, newMasterLocations, validStateMLAConstituencyId);
									} else if (eachStr.matches(".*\\d+.*") && isHavingHyphon) {
										locationCode = Long.parseLong(eachStr.split("-")[0]);
										locationName = eachStr.split("-")[1].trim();
										validStateMLAConstituencyId = prepareLocationMasterData(locationCode,
												locationName, parentLocationGuid, existingMasterLocations,
												exportMasterLocations, newMasterLocations, validStateMLAConstituencyId);
									} else {
										String[] locationNamesArray = eachStr.split("\\,");
										for (int j = 0; j < locationNamesArray.length; j++) {
											locationName = locationNamesArray[j];
											validStateMLAConstituencyId = prepareLocationMasterData(locationCode,
													locationName, parentLocationGuid, existingMasterLocations,
													exportMasterLocations, newMasterLocations,
													validStateMLAConstituencyId);
										}
									}

								}
							}
						}
					}
				}

				tableIndex++;
			}
		}
		driver.close();
		driver.quit();
	}

	private Long prepareLocationMasterData(Long locationCode, String locationName, Long parentLocationGuid,
			List<LocationMaster> existingMasterLocations, List<LocationMaster> exportMasterLocations,
			List<LocationMaster> newMasterLocations, Long validStateMLAConstituencyId) {
		if (locationName.contains("(")) {
			String[] subDistrictCodeArray = locationName.split("\\(");
			if (subDistrictCodeArray.length > 2) {
				locationName = subDistrictCodeArray[0] + "(" + subDistrictCodeArray[1];
			} else {
				locationName = subDistrictCodeArray[subDistrictCodeArray.length - 2];
			}
		}
		if (locationName.endsWith(".") || locationName.endsWith(",")) {
			locationName = locationName.substring(0, locationName.length() - 1);
		}
		locationName = locationName.trim();

		if (locationCode != null) {
			validStateMLAConstituencyId = locationCode;
		} else {
			locationCode = validStateMLAConstituencyId + 1;
			validStateMLAConstituencyId++;
		}
		LocationMaster locationMaster = new LocationMaster();
		locationMaster.setLocationCode(locationCode);
		locationMaster.setLocationName(locationName);
		locationMaster.setLocationType(ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE);
		locationMaster.setParentLocationGuid(parentLocationGuid);

		if (!newMasterLocations.contains(locationMaster) && !existingMasterLocations.contains(locationMaster)) {
			newMasterLocations.add(locationMaster);
		}

		if (!exportMasterLocations.contains(locationMaster)) {
			exportMasterLocations.add(locationMaster);
		}

		return validStateMLAConstituencyId;
	}
}
