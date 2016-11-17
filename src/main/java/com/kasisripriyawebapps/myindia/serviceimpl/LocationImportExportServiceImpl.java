package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.DaoConstants;
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

	static {
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}

	@Override
	@Transactional
	public boolean importCountries(LocationImportRequest locationImportRequest) throws InternalServerException {
		String filePath = env.getProperty("project.locations-files.upload-path")
				+ env.getProperty("project.countries-locations-file-name");
		saveUpdateDeleteMasterLocations(filePath, ServiceConstants.LOCATION_COUNTRY_TYPE, locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importStates(LocationImportRequest locationImportRequest) throws InternalServerException {
		String filePath = env.getProperty("project.locations-files.upload-path")
				+ env.getProperty("project.state-locations-file-name");
		saveUpdateDeleteMasterLocations(filePath, ServiceConstants.LOCATION_STATE_TYPE, locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importDistricts(LocationImportRequest locationImportRequest) throws InternalServerException {
		String filePath = env.getProperty("project.locations-files.upload-path")
				+ env.getProperty("project.district-locations-file-name");
		saveUpdateDeleteMasterLocations(filePath, ServiceConstants.LOCATION_DISTRICT_TYPE, locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importSubDistricts(LocationImportRequest locationImportRequest) throws InternalServerException {
		String filePath = env.getProperty("project.locations-files.upload-path")
				+ env.getProperty("project.sub_dsitrict-locations-file-name");
		saveUpdateDeleteMasterLocations(filePath, ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importMuncipalCorporations(LocationImportRequest locationImportRequest)
			throws InternalServerException {

		processMasterLocationsChildData(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE,
				env.getProperty("project.muncipal_corporation-upload-locations-file-name"), locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importMuncipalities(LocationImportRequest locationImportRequest) throws InternalServerException {
		processMasterLocationsChildData(ServiceConstants.LOCATION_MUNCIPALITY_TYPE,
				env.getProperty("project.muncipaity-upload-locations-file-name"), locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importTownPanchayathies(LocationImportRequest locationImportRequest) throws InternalServerException {
		processMasterLocationsChildData(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE,
				env.getProperty("project.town_panchayath-upload-locations-file-name"), locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importVillagePanchayathies(LocationImportRequest locationImportRequest)
			throws InternalServerException {

		processMasterLocationsChildData(ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE,
				env.getProperty("project.village_panchayath-upload-locations-file-name"), locationImportRequest);
		return true;
	}

	@Override
	@Transactional
	public boolean importVillages(LocationImportRequest locationImportRequest) throws InternalServerException {
		processMasterLocationsChildData(ServiceConstants.LOCATION_VILLAGE_TYPE,
				env.getProperty("project.village-upload-locations-file-name"), locationImportRequest);
		return true;
	}

	private List<LocationMaster> prepareMasterLocations(String filePath, List<LocationMaster> existingMasterLocations,
			List<LocationMaster> excelMasterLocations, LocationImportRequest locationImportRequest,
			String locationType2) throws InternalServerException {
		List<LocationMaster> masterLocations = new ArrayList<LocationMaster>();
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(filePath);

		Sheet sheet = myWorkBook.getSheetAt(0);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (i < 1) {
				continue;
			}
			Row eachRow = sheet.getRow(i);
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
				excelMasterLocations.add(locationMaster);
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

	private void processMasterLocationsChildData(String locationType, String subDirectoryPath,
			LocationImportRequest locationImportRequest) throws InternalServerException {
		List<LocationMaster> existingStateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		existingStateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		List<LocationMaster> existingMasterVillageLocations = locationMasterDao
				.getAllMasterLocationsByType(locationType);

		List<LocationMaster> newMasterLocations = new ArrayList<LocationMaster>();
		List<LocationMaster> excelMasterLocations = new ArrayList<LocationMaster>();

		if (existingStateMasterLocations != null && !existingStateMasterLocations.isEmpty()) {
			for (LocationMaster eachLocation : existingStateMasterLocations) {
				if (eachLocation != null) {
					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path") + subDirectoryPath;
					String fileName = eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;
					outPutFilePath = directoryPath + fileName;

					List<LocationMaster> eachSheetNewMasterLocations = prepareMasterLocations(outPutFilePath,
							existingMasterVillageLocations, excelMasterLocations, locationImportRequest, locationType);
					newMasterLocations.addAll(eachSheetNewMasterLocations);

				}
			}
			locationMasterDao.saveAllMasterLocations(newMasterLocations);
			newMasterLocations.clear();
			List<LocationMaster> updatedMasterLocations = findUpdatedMasterLocations(existingMasterVillageLocations,
					excelMasterLocations);
			locationMasterDao.updateAllMasterLocations(updatedMasterLocations);
			existingMasterVillageLocations.removeAll(excelMasterLocations);
			locationMasterDao.deleteMasterLocations(existingMasterVillageLocations);
		}
	}

	private void saveUpdateDeleteMasterLocations(String filePath, String locationType,
			LocationImportRequest locationImportRequest) throws InternalServerException {
		List<LocationMaster> existingMasterLocations = new ArrayList<LocationMaster>();
		if (locationType.equalsIgnoreCase(ServiceConstants.LOCATION_STATE_TYPE)) {
			List<String> locationTypes = new ArrayList<String>();
			locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
			locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
			existingMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		} else {
			existingMasterLocations = locationMasterDao.getAllMasterLocationsByType(locationType);
		}

		List<LocationMaster> excelMasterLocations = new ArrayList<LocationMaster>();
		List<LocationMaster> newMasterLocations = prepareMasterLocations(filePath, existingMasterLocations,
				excelMasterLocations, locationImportRequest, locationType);
		locationMasterDao.saveAllMasterLocations(newMasterLocations);
		newMasterLocations.clear();
		List<LocationMaster> updatedMasterLocations = findUpdatedMasterLocations(existingMasterLocations,
				excelMasterLocations);
		locationMasterDao.updateAllMasterLocations(updatedMasterLocations);
		existingMasterLocations.removeAll(excelMasterLocations);
		locationMasterDao.deleteMasterLocations(existingMasterLocations);
	}

	@Override
	public boolean exportCountries(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.countries-locations-file-name");
		}

		Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
		Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

		String outPutFilePath = "";
		String directoryPath = env.getProperty("project.locations-files.upload-path");
		String fileName = env.getProperty("project.countries-locations-file-name");

		outPutFilePath = directoryPath + fileName;
		CommonUtil.createExcelFile(directoryPath, fileName);

		Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
		if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
			exportWorkBook.removeSheetAt(0);
		}
		Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.LOCATION_EXCEL_COUNTRY_SHEET_NAME);
		addHeaderRow(exportWorkBookSheet);
		int j = 0;
		for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
			if (i < 3) {
				continue;
			}
			Row eachRow = importWorkBookSheet.getRow(i);
			double locationCode = eachRow.getCell(1).getNumericCellValue();
			long locationCodeLong = Long.valueOf(0);
			locationCodeLong = (long) locationCode;
			String locationName = eachRow.getCell(2).getStringCellValue().trim();
			String locationType = ServiceConstants.LOCATION_COUNTRY_TYPE;

			double parentLocationCode = eachRow.getCell(3).getNumericCellValue();
			long parentLocationGuid = Long.valueOf(0);
			parentLocationGuid = (long) parentLocationCode;

			if (locationName != null && !locationName.isEmpty()) {
				j++;
				writeDataIntoSheet(locationCodeLong, locationName, locationType, parentLocationGuid,
						exportWorkBookSheet, j);
			} else {
				break;
			}

		}
		writeExcelDataIntoFile(outPutFilePath, exportWorkBook);
		return true;
	}

	@Override
	public boolean exportStates(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.state-locations-file-name");
		}
		List<LocationMaster> countryLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_COUNTRY_TYPE);

		if (countryLocations != null && !countryLocations.isEmpty()) {
			for (LocationMaster eachCountryLocation : countryLocations) {
				if (eachCountryLocation != null) {
					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path");
					String fileName = env.getProperty("project.state-locations-file-name");

					outPutFilePath = directoryPath + fileName;
					CommonUtil.createExcelFile(directoryPath, fileName);

					Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook
							.createSheet(ServiceConstants.LOCATION_EXCEL_STATE_SHEET_NAME);
					addHeaderRow(exportWorkBookSheet);
					int j = 0;
					for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
						if (i < 3) {
							continue;
						}
						Row eachRow = importWorkBookSheet.getRow(i);
						double locationCode = eachRow.getCell(1).getNumericCellValue();
						long locationCodeLong = Long.valueOf(0);
						locationCodeLong = (long) locationCode;
						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String locationType = "";
						String stateOrUnionTerritory = eachRow.getCell(7).getStringCellValue().trim();
						locationType = stateOrUnionTerritory.equalsIgnoreCase("S")
								? ServiceConstants.LOCATION_STATE_TYPE : ServiceConstants.LOCATION_UNION_TERRITORY_TYPE;
						Long parentLocationGuid = eachCountryLocation.getGuid();
						if (locationName != null && !locationName.isEmpty()) {
							j++;
							writeDataIntoSheet(locationCodeLong, locationName, locationType, parentLocationGuid,
									exportWorkBookSheet, j);
						} else {
							break;
						}

					}
					writeExcelDataIntoFile(outPutFilePath, exportWorkBook);
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

	private void writeDataIntoSheet(Long locationCode, String locationName, String locationType,
			long parentLocationGuid, Sheet exportWorkBookSheet, int rowNo) {

		Row row = exportWorkBookSheet.createRow(rowNo);
		Cell locationCodeCell = row.createCell(0);
		Cell locationNameCell = row.createCell(1);
		Cell locationTypeCell = row.createCell(2);
		Cell parentLocationGuidCell = row.createCell(3);

		locationCodeCell.setCellValue(locationCode);
		locationNameCell.setCellValue(locationName);
		locationTypeCell.setCellValue(locationType);
		parentLocationGuidCell.setCellValue(parentLocationGuid);

	}

	private void writeExcelDataIntoFile(String outPutFilePath, Workbook exportWorkBook) throws InternalServerException {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(outPutFilePath);
			try {
				exportWorkBook.write(os);
				os.close();
				exportWorkBook.close();
			} catch (IOException e) {
				throw new InternalServerException(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public boolean exportDistricts(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.district-locations-file-name");
		}

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<Long, List<LocationMaster>> stateMasterLocationsCodeMap = stateMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationCode()));

		Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
		Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

		String outPutFilePath = "";
		String directoryPath = env.getProperty("project.locations-files.upload-path");
		String fileName = env.getProperty("project.district-locations-file-name");

		outPutFilePath = directoryPath + fileName;
		CommonUtil.createExcelFile(directoryPath, fileName);

		Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
		if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
			exportWorkBook.removeSheetAt(0);
		}
		Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.LOCATION_EXCEL_DISTRICT_SHEET_NAME);
		addHeaderRow(exportWorkBookSheet);
		int j = 0;
		for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
			if (i < 3) {
				continue;
			}
			Row eachRow = importWorkBookSheet.getRow(i);
			double locationCode = eachRow.getCell(0).getNumericCellValue();
			long locationCodeLong = Long.valueOf(0);
			locationCodeLong = (long) locationCode;
			String locationName = eachRow.getCell(1).getStringCellValue().trim();
			String locationType = ServiceConstants.LOCATION_DISTRICT_TYPE;

			double parentLocationCode = eachRow.getCell(2).getNumericCellValue();
			long parentLocationCodeLong = Long.valueOf(0);
			parentLocationCodeLong = (long) parentLocationCode;

			Long parentLocationGuid = null;
			List<LocationMaster> stateLocations = stateMasterLocationsCodeMap.get(parentLocationCodeLong);
			if (stateLocations != null && !stateLocations.isEmpty()) {
				LocationMaster locationMaster = stateLocations.get(0);
				parentLocationGuid = locationMaster.getGuid();
			}
			if (locationName != null && !locationName.isEmpty()) {
				j++;
				writeDataIntoSheet(locationCodeLong, locationName, locationType, parentLocationGuid,
						exportWorkBookSheet, j);
			} else {
				break;
			}
		}
		writeExcelDataIntoFile(outPutFilePath, exportWorkBook);

		return true;
	}

	@Override
	public boolean exportSubDistricts(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.sub_dsitrict-locations-file-name");
		}

		List<LocationMaster> districtLocations = new ArrayList<LocationMaster>();
		districtLocations = locationMasterDao.getAllMasterLocationsByType(ServiceConstants.LOCATION_DISTRICT_TYPE);

		final Map<Long, List<LocationMaster>> districtLocationsMap = districtLocations.stream()
				.collect(Collectors.groupingBy(districtLocation -> districtLocation.getLocationCode()));

		Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath);
		Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

		String outPutFilePath = "";
		String directoryPath = env.getProperty("project.locations-files.upload-path");
		String fileName = env.getProperty("project.sub_dsitrict-locations-file-name");

		outPutFilePath = directoryPath + fileName;
		CommonUtil.createExcelFile(directoryPath, fileName);

		Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
		if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
			exportWorkBook.removeSheetAt(0);
		}
		Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.LOCATION_EXCEL_SUB_DISTRICT_SHEET_NAME);
		addHeaderRow(exportWorkBookSheet);
		int j = 0;
		for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
			if (i < 3) {
				continue;
			}
			Row eachRow = importWorkBookSheet.getRow(i);
			double locationCode = eachRow.getCell(0).getNumericCellValue();
			long locationCodeLong = Long.valueOf(0);
			locationCodeLong = (long) locationCode;
			String locationName = eachRow.getCell(2).getStringCellValue().trim();
			String locationType = ServiceConstants.LOCATION_SUB_DISTRICT_TYPE;

			double parentLocationCode = eachRow.getCell(3).getNumericCellValue();
			long parentLocationCodeLong = Long.valueOf(0);
			parentLocationCodeLong = (long) parentLocationCode;

			Long parentLocationGuid = null;
			List<LocationMaster> districtLocationsList = districtLocationsMap.get(parentLocationCodeLong);
			if (districtLocationsList != null && !districtLocationsList.isEmpty()) {
				LocationMaster locationMaster = districtLocationsList.get(0);
				parentLocationGuid = locationMaster.getGuid();
			}

			if (locationName != null && !locationName.isEmpty()) {
				j++;
				writeDataIntoSheet(locationCodeLong, locationName, locationType, parentLocationGuid,
						exportWorkBookSheet, j);
			} else {
				break;
			}
		}
		writeExcelDataIntoFile(outPutFilePath, exportWorkBook);
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportMuncipalCorporations(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.muncipal_corporation-download-locations-file-name");
		}
		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {
					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(
							inputFilePath + eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path")
							+ env.getProperty("project.muncipal_corporation-upload-locations-file-name");
					String fileName = eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;

					outPutFilePath = directoryPath + fileName;
					CommonUtil.createExcelFile(directoryPath, fileName);

					Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook
							.createSheet(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE);
					addHeaderRow(exportWorkBookSheet);

					int j = 0;

					for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
						if (i < 4) {
							continue;
						}
						Row eachRow = importWorkBookSheet.getRow(i);
						double locationCode = eachRow.getCell(1).getNumericCellValue();
						long locationCodeLong = Long.valueOf(0);
						locationCodeLong = (long) locationCode;
						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String excelLocationType = eachRow.getCell(6).getStringCellValue().trim();
						String locationType = "";
						if (excelLocationType != null && excelLocationType
								.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPAL_CORPORATIONS_TYPE)) {
							locationType = ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE;
						}

						if (locationName != null && !locationName.isEmpty()) {
							if (locationType != null && locationType
									.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE)) {
								j++;
								locationName = CommonUtil.removeEndsWith(locationName,
										ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE_LOWER);
								writeDataIntoSheet(locationCodeLong, locationName, locationType, eachLocation.getGuid(),
										exportWorkBookSheet, j);
							}
						} else {
							break;
						}
					}
					writeExcelDataIntoFile(outPutFilePath, exportWorkBook);
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportMuncipalities(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.muncipaity-download-locations-file-name");
		}
		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {
					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(
							inputFilePath + eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path")
							+ env.getProperty("project.muncipaity-upload-locations-file-name");
					String fileName = eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;

					outPutFilePath = directoryPath + fileName;
					CommonUtil.createExcelFile(directoryPath, fileName);

					Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.LOCATION_MUNCIPALITY_TYPE);
					addHeaderRow(exportWorkBookSheet);

					int j = 0;

					for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
						if (i < 4) {
							continue;
						}
						Row eachRow = importWorkBookSheet.getRow(i);
						double locationCode = eachRow.getCell(1).getNumericCellValue();
						long locationCodeLong = Long.valueOf(0);
						locationCodeLong = (long) locationCode;
						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String locationType = eachRow.getCell(6).getStringCellValue().trim();

						if (locationName != null && !locationName.isEmpty()) {
							if (locationType != null
									&& locationType.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPALITY_TYPE)) {
								j++;
								locationName = CommonUtil.removeEndsWith(locationName,
										ServiceConstants.LOCATION_MUNCIPAL_COUNCIL_TYPE);
								writeDataIntoSheet(locationCodeLong, locationName, locationType, eachLocation.getGuid(),
										exportWorkBookSheet, j);
							}
						} else {
							break;
						}
					}
					writeExcelDataIntoFile(outPutFilePath, exportWorkBook);
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportTownPanchayathies(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.town_panchayath-download-locations-file-name");
		}

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {
					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(
							inputFilePath + eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path")
							+ env.getProperty("project.town_panchayath-upload-locations-file-name");
					String fileName = eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;

					outPutFilePath = directoryPath + fileName;
					CommonUtil.createExcelFile(directoryPath, fileName);

					Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook
							.createSheet(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE);
					addHeaderRow(exportWorkBookSheet);

					int j = 0;

					for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
						if (i < 4) {
							continue;
						}
						Row eachRow = importWorkBookSheet.getRow(i);
						double locationCode = eachRow.getCell(1).getNumericCellValue();
						long locationCodeLong = Long.valueOf(0);
						locationCodeLong = (long) locationCode;
						String locationName = eachRow.getCell(3).getStringCellValue().trim();
						String locationType = eachRow.getCell(6).getStringCellValue().trim();

						if (locationName != null && !locationName.isEmpty()) {
							if (locationType != null
									&& (locationType.equalsIgnoreCase(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE)
											|| locationType.equalsIgnoreCase(
													ServiceConstants.LOCATION_NOTIFIED_AREA_COUNCIL_TYPE))) {
								j++;
								locationName = CommonUtil.removeEndsWith(locationName,
										ServiceConstants.LOCATION_NAGAR_PANCHAYAT_TYPE);
								locationType = ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE;
								writeDataIntoSheet(locationCodeLong, locationName, locationType, eachLocation.getGuid(),
										exportWorkBookSheet, j);
							}
						} else {
							break;
						}
					}
					writeExcelDataIntoFile(outPutFilePath, exportWorkBook);
				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportVillagePanchayathies(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.village_panchayath-download-locations-file-name");
		}
		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					List<LocationMaster> districtLocations = new ArrayList<LocationMaster>();
					districtLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocation(
							ServiceConstants.LOCATION_DISTRICT_TYPE, eachLocation.getGuid());

					List<Long> distirctGuids = districtLocations.stream().map(LocationMaster::getGuid)
							.collect(Collectors.toList());

					List<LocationMaster> subDistrictLocations = new ArrayList<LocationMaster>();
					subDistrictLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocations(
							ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, distirctGuids);

					final Map<Long, List<LocationMaster>> subDistrictLocationsMap = subDistrictLocations.stream()
							.collect(Collectors
									.groupingBy(subDistrictLocation -> subDistrictLocation.getLocationCode()));

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(
							inputFilePath + eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path")
							+ env.getProperty("project.village_panchayath-upload-locations-file-name");
					String fileName = eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;

					outPutFilePath = directoryPath + fileName;
					CommonUtil.createExcelFile(directoryPath, fileName);

					Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook
							.createSheet(ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE);
					addHeaderRow(exportWorkBookSheet);
					int j = 0;
					for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
						if (i < 4) {
							continue;
						}
						Row eachRow = importWorkBookSheet.getRow(i);
						double locationCode = eachRow.getCell(12).getNumericCellValue();
						long locationCodeLong = Long.valueOf(0);
						locationCodeLong = (long) locationCode;
						String locationName = eachRow.getCell(13).getStringCellValue().trim();
						String locationType = ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE;

						String villageName = eachRow.getCell(9).getStringCellValue().trim();

						double parentLocationCode = eachRow.getCell(4).getNumericCellValue();
						long parentLocationCodeLong = Long.valueOf(0);
						parentLocationCodeLong = (long) parentLocationCode;

						Long parentLocationGuid = null;
						List<LocationMaster> subDistrictLocationsList = subDistrictLocationsMap
								.get(parentLocationCodeLong);
						if (subDistrictLocationsList != null && !subDistrictLocationsList.isEmpty()) {
							LocationMaster locationMaster = subDistrictLocationsList.get(0);
							parentLocationGuid = locationMaster.getGuid();
						}

						if (villageName != null && !villageName.isEmpty()) {
							if (locationName != null && !locationName.isEmpty()) {
								j++;
								writeDataIntoSheet(locationCodeLong, locationName, locationType, parentLocationGuid,
										exportWorkBookSheet, j);
							}
						} else {
							break;
						}

					}
					writeExcelDataIntoFile(outPutFilePath, exportWorkBook);

				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportVillages(String inputFilePath) throws InternalServerException {
		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.village-download-locations-file-name");
		}

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					List<LocationMaster> districtLocations = new ArrayList<LocationMaster>();
					districtLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocation(
							ServiceConstants.LOCATION_DISTRICT_TYPE, eachLocation.getGuid());

					List<Long> distirctGuids = districtLocations.stream().map(LocationMaster::getGuid)
							.collect(Collectors.toList());

					List<LocationMaster> subDistrictLocations = new ArrayList<LocationMaster>();
					subDistrictLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocations(
							ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, distirctGuids);

					final Map<Long, List<LocationMaster>> subDistrictLocationsMap = subDistrictLocations.stream()
							.collect(Collectors
									.groupingBy(subDistrictLocation -> subDistrictLocation.getLocationCode()));

					List<Long> subDistirctGuids = subDistrictLocations.stream().map(LocationMaster::getGuid)
							.collect(Collectors.toList());

					List<LocationMaster> villagePanchayathLocations = new ArrayList<LocationMaster>();
					villagePanchayathLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocations(
							ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE, subDistirctGuids);

					final Map<Long, List<LocationMaster>> villagePanchayathLocationsMap = villagePanchayathLocations
							.stream().collect(Collectors.groupingBy(
									villagePanchayathLocation -> villagePanchayathLocation.getLocationCode()));

					Workbook importWorkBook = CommonUtil.getWorkBookFromFile(
							inputFilePath + eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS);
					Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path")
							+ env.getProperty("project.village-upload-locations-file-name");
					String fileName = eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;

					outPutFilePath = directoryPath + fileName;
					CommonUtil.createExcelFile(directoryPath, fileName);

					Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
					if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
						exportWorkBook.removeSheetAt(0);
					}
					Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.LOCATION_VILLAGE_TYPE);
					addHeaderRow(exportWorkBookSheet);

					int j = 0;
					for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
						if (i < 4) {
							continue;
						}
						Row eachRow = importWorkBookSheet.getRow(i);
						double locationCode = eachRow.getCell(8).getNumericCellValue();
						long locationCodeLong = Long.valueOf(0);
						locationCodeLong = (long) locationCode;
						String locationName = eachRow.getCell(9).getStringCellValue().trim();
						String locationType = ServiceConstants.LOCATION_VILLAGE_TYPE;

						double parentLocationCode = 0;
						long parentLocationCodeLong = Long.valueOf(0);
						Long parentLocationGuid = null;
						if (eachRow.getCell(12).getCellType() != Cell.CELL_TYPE_BLANK) {

							parentLocationCode = eachRow.getCell(12).getNumericCellValue();
							parentLocationCodeLong = (long) parentLocationCode;

							List<LocationMaster> villagePanchayathLocationsList = villagePanchayathLocationsMap
									.get(parentLocationCodeLong);
							if (villagePanchayathLocationsList != null && !villagePanchayathLocationsList.isEmpty()) {
								LocationMaster locationMaster = villagePanchayathLocationsList.get(0);
								parentLocationGuid = locationMaster.getGuid();
							}
						} else {
							parentLocationCode = eachRow.getCell(4).getNumericCellValue();
							parentLocationCodeLong = (long) parentLocationCode;

							List<LocationMaster> subDistrictLocationsList = subDistrictLocationsMap
									.get(parentLocationCodeLong);
							if (subDistrictLocationsList != null && !subDistrictLocationsList.isEmpty()) {
								LocationMaster locationMaster = subDistrictLocationsList.get(0);
								parentLocationGuid = locationMaster.getGuid();
							}

						}

						if (locationName != null && !locationName.isEmpty()) {
							j++;
							writeDataIntoSheet(locationCodeLong, locationName, locationType, parentLocationGuid,
									exportWorkBookSheet, j);

						} else {
							break;
						}
					}
					writeExcelDataIntoFile(outPutFilePath, exportWorkBook);

				}
			}
		}
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportVillageReferenceLocations(String inputFilePath) throws InternalServerException {

		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.village_panchayath-download-locations-file-name");
		}

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

								List<LocationMaster> districtLocations = new ArrayList<LocationMaster>();
								districtLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocation(
										ServiceConstants.LOCATION_DISTRICT_TYPE, eachLocation.getGuid());

								final Map<Long, List<LocationMaster>> districtLocationsMap = districtLocations.stream()
										.collect(Collectors
												.groupingBy(districtLocation -> districtLocation.getLocationCode()));

								List<Long> distirctGuids = districtLocations.stream().map(LocationMaster::getGuid)
										.collect(Collectors.toList());

								List<LocationMaster> subDistrictLocations = new ArrayList<LocationMaster>();
								subDistrictLocations = locationMasterDao.getAllMasterLocationsByTypeAndParentLocations(
										ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, distirctGuids);

								final Map<Long, List<LocationMaster>> subDistrictLocationsMap = subDistrictLocations
										.stream().collect(Collectors.groupingBy(
												subDistrictLocation -> subDistrictLocation.getLocationCode()));

								List<Long> subDistirctGuids = subDistrictLocations.stream().map(LocationMaster::getGuid)
										.collect(Collectors.toList());

								List<LocationMaster> villagePanchayathLocations = new ArrayList<LocationMaster>();
								villagePanchayathLocations = locationMasterDao
										.getAllMasterLocationsByTypeAndParentLocations(
												ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE, subDistirctGuids);

								final Map<Long, List<LocationMaster>> villagePanchayathLocationsMap = villagePanchayathLocations
										.stream()
										.collect(Collectors
												.groupingBy(villagePanchayathLocation -> villagePanchayathLocation
														.getLocationCode()));

								Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath
										+ eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS);
								Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

								String outPutFilePath = "";
								String directoryPath = env.getProperty("project.locations-files.upload-path")
										+ env.getProperty("project.village-upload-locations-reference-file-name");
								String fileName = eachLocation.getLocationName()
										+ ServiceConstants.EXCEL_SHEET_TYPE_XLS;

								outPutFilePath = directoryPath + fileName;
								CommonUtil.createExcelFile(directoryPath, fileName);

								Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
								if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
									exportWorkBook.removeSheetAt(0);
								}
								Sheet exportWorkBookSheet = exportWorkBook
										.createSheet(ServiceConstants.LOCATION_VILLAGE_TYPE);
								addReferenceHeaderRow(exportWorkBookSheet);
								int j = 0;
								for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
									if (i < 4) {
										continue;
									}
									Row eachRow = importWorkBookSheet.getRow(i);
									double locationCode = eachRow.getCell(8).getNumericCellValue();
									Long locationCodeLong = null;
									locationCodeLong = (long) locationCode;
									String locationName = eachRow.getCell(9).getStringCellValue().trim();

									Long villagePanchathLocationCodeLong = null;
									if ((Double) eachRow.getCell(12).getNumericCellValue() != null) {
										villagePanchathLocationCodeLong = (long) eachRow.getCell(12)
												.getNumericCellValue();
									}

									double subDistrictLocation = eachRow.getCell(4).getNumericCellValue();
									Long subDistrictLocationLong = null;
									subDistrictLocationLong = (long) subDistrictLocation;

									double districtLocation = eachRow.getCell(0).getNumericCellValue();
									Long districtLocationLong = null;
									districtLocationLong = (long) districtLocation;

									Long villageLocationGuid = null;
									Long villageLocationPanchayathGuid = null;
									Long subDistrictLocationGuid = null;
									Long districtLocationGuid = null;

									/*
									 * if (locationCodeLong != null) { if
									 * (locationCodesMap != null) { if
									 * (locationCodesMap.get(locationCodeLong)
									 * != null &&
									 * locationCodesMap.get(locationCodeLong).
									 * get(0) != null) { villageLocationGuid =
									 * getLocationTypeGuid(
									 * locationCodesMap.get(locationCodeLong),
									 * ServiceConstants.LOCATION_VILLAGE_TYPE);
									 * 
									 * } } }
									 */

									if (villagePanchathLocationCodeLong != null) {
										List<LocationMaster> villagePanchayathLocationsList = subDistrictLocationsMap
												.get(villagePanchathLocationCodeLong);
										if (villagePanchayathLocationsList != null
												&& !villagePanchayathLocationsList.isEmpty()) {
											LocationMaster locationMaster = villagePanchayathLocationsList.get(0);
											villageLocationPanchayathGuid = locationMaster.getGuid();
										}
									}

									if (subDistrictLocationLong != null) {
										List<LocationMaster> subDistrictLocationsList = subDistrictLocationsMap
												.get(subDistrictLocationLong);
										if (subDistrictLocationsList != null && !subDistrictLocationsList.isEmpty()) {
											LocationMaster locationMaster = subDistrictLocationsList.get(0);
											subDistrictLocationGuid = locationMaster.getGuid();
										}
									}

									if (districtLocationLong != null) {
										List<LocationMaster> districtLocationsList = districtLocationsMap
												.get(districtLocationLong);
										if (districtLocationsList != null && !districtLocationsList.isEmpty()) {
											LocationMaster locationMaster = districtLocationsList.get(0);
											districtLocationGuid = locationMaster.getGuid();
										}
									}

									Location loc = new Location();
									loc.setLocationCountry(eachCountryLocation.getGuid());
									loc.setLocationState(eachLocation.getGuid());
									loc.setLocationDistrict(districtLocationGuid);
									loc.setLocationSubDistrict(subDistrictLocationGuid);
									loc.setLocationVillagePanchayat(villageLocationPanchayathGuid);
									loc.setLocationVillage(villageLocationGuid);

									if (locationName != null && !locationName.isEmpty()) {
										j++;
										writeReferenceDataIntoSheet(loc, exportWorkBookSheet, j);
									} else {
										break;
									}
								}
								writeExcelDataIntoFile(outPutFilePath, exportWorkBook);

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

	private void writeReferenceDataIntoSheet(Location loc, Sheet exportWorkBookSheet, int rowNo) {

		Row row = exportWorkBookSheet.createRow(rowNo);
		Cell locationVillageCell = row.createCell(0);
		Cell locationVillagePanchayatCell = row.createCell(1);
		Cell locationTownPanchayathCell = row.createCell(2);
		Cell locationMunicipalityCell = row.createCell(3);
		Cell locationMunicipalCorporationCell = row.createCell(4);
		Cell locationSubDistrictCell = row.createCell(5);
		Cell locationDistrictCell = row.createCell(6);
		Cell locationStateCell = row.createCell(7);
		Cell locationCountryCell = row.createCell(8);

		if (loc.getLocationVillage() == null) {
			locationVillageCell.setCellType(Cell.CELL_TYPE_BLANK);
		} else {
			locationVillageCell.setCellValue(loc.getLocationVillage());
		}
		if (loc.getLocationVillagePanchayat() == null) {
			locationVillagePanchayatCell.setCellType(Cell.CELL_TYPE_BLANK);
		} else {
			locationVillagePanchayatCell.setCellValue(loc.getLocationVillagePanchayat());
		}
		if (loc.getLocationTownPanchayat() == null) {
			locationTownPanchayathCell.setCellType(Cell.CELL_TYPE_BLANK);
		} else {
			locationTownPanchayathCell.setCellValue(loc.getLocationTownPanchayat());
		}
		if (loc.getLocationMunicipality() == null) {
			locationMunicipalityCell.setCellType(Cell.CELL_TYPE_BLANK);
		} else {
			locationMunicipalityCell.setCellValue(loc.getLocationMunicipality());
		}
		if (loc.getLocationMunicipalCorporation() == null) {
			locationMunicipalCorporationCell.setCellType(Cell.CELL_TYPE_BLANK);
		} else {
			locationMunicipalCorporationCell.setCellValue(loc.getLocationMunicipalCorporation());
		}
		if (loc.getLocationSubDistrict() == null) {
			locationSubDistrictCell.setCellType(Cell.CELL_TYPE_BLANK);
		} else {
			locationSubDistrictCell.setCellValue(loc.getLocationSubDistrict());
		}
		if (loc.getLocationDistrict() == null) {
			locationDistrictCell.setCellType(Cell.CELL_TYPE_BLANK);
		} else {
			locationDistrictCell.setCellValue(loc.getLocationDistrict());
		}
		locationStateCell.setCellValue(loc.getLocationState());
		locationCountryCell.setCellValue(loc.getLocationCountry());

	}

	@Override
	@Transactional(readOnly = true)
	public boolean exportUrbanReferenceLocations(String inputFilePath) throws InternalServerException {

		if (inputFilePath == null || inputFilePath.isEmpty()) {
			inputFilePath = env.getProperty("project.locations-files.download-path")
					+ env.getProperty("project.urban-download-locations-reference-file-name");
		}

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		List<String> urbanLocationTypes = new ArrayList<String>();
		urbanLocationTypes.add(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE);
		urbanLocationTypes.add(ServiceConstants.LOCATION_MUNCIPALITY_TYPE);
		urbanLocationTypes.add(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE);

		List<LocationMaster> urbanLocations = new ArrayList<LocationMaster>();
		urbanLocations = locationMasterDao.getAllMasterLocationsByTypes(urbanLocationTypes);

		final Map<Long, List<LocationMaster>> urbanLocationsMap = urbanLocations.stream()
				.collect(Collectors.groupingBy(urbanLocation -> urbanLocation.getLocationCode()));

		List<String> districtSubDistrictLocationTypes = new ArrayList<String>();
		districtSubDistrictLocationTypes.add(ServiceConstants.LOCATION_DISTRICT_TYPE);
		districtSubDistrictLocationTypes.add(ServiceConstants.LOCATION_SUB_DISTRICT_TYPE);

		List<LocationMaster> districtSubDistrictLocations = new ArrayList<LocationMaster>();
		districtSubDistrictLocations = locationMasterDao.getAllMasterLocationsByTypes(districtSubDistrictLocationTypes);

		final Map<Long, List<LocationMaster>> districtSubDistrictLocationMap = districtSubDistrictLocations.stream()
				.collect(Collectors
						.groupingBy(districtSubDistrictLocation -> districtSubDistrictLocation.getLocationCode()));

		List<LocationMaster> countryLocations = locationMasterDao
				.getAllMasterLocationsByType(ServiceConstants.LOCATION_COUNTRY_TYPE);
		if (countryLocations != null && !countryLocations.isEmpty()) {
			for (LocationMaster eachCountryLocation : countryLocations) {
				if (eachCountryLocation != null) {
					if (stateLocations != null && !stateLocations.isEmpty()) {
						for (LocationMaster eachLocation : stateLocations) {
							if (eachLocation != null) {

								Workbook importWorkBook = CommonUtil.getWorkBookFromFile(inputFilePath
										+ eachLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS);
								Sheet importWorkBookSheet = importWorkBook.getSheetAt(0);

								String outPutFilePath = "";
								String directoryPath = env.getProperty("project.locations-files.upload-path")
										+ env.getProperty("project.urban-upload-locations-reference-file-name");
								String fileName = eachLocation.getLocationName()
										+ ServiceConstants.EXCEL_SHEET_TYPE_XLS;

								outPutFilePath = directoryPath + fileName;
								CommonUtil.createExcelFile(directoryPath, fileName);

								Workbook exportWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);
								if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
									exportWorkBook.removeSheetAt(0);
								}
								Sheet exportWorkBookSheet = exportWorkBook
										.createSheet(ServiceConstants.LOCATION_URBAN_BODY_TYPE);
								addReferenceHeaderRow(exportWorkBookSheet);
								int j = 0;
								for (int i = 0; i <= importWorkBookSheet.getLastRowNum(); i++) {
									if (i < 4) {
										continue;
									}
									Row eachRow = importWorkBookSheet.getRow(i);
									String locationCode = eachRow.getCell(0).getStringCellValue();
									Long locationCodeLong = null;
									String[] locationCodeArray = locationCode.split(",");
									String locationCodeFinal = "0";
									if (locationCodeArray != null) {
										for (int k = 0; k < locationCodeArray.length; k++) {
											locationCodeFinal += locationCodeArray[k];
										}
									}
									locationCodeLong = Long.parseLong(locationCodeFinal);
									String locationName = eachRow.getCell(1).getStringCellValue().trim();

									String districtSubDistrictCode = eachRow.getCell(5).getStringCellValue().trim();
									Long subDistrictLocationLong = null;
									Long districtLocationLong = null;

									if (districtSubDistrictCode != null && !districtSubDistrictCode.isEmpty()) {
										String[] districtSubDistrictCodeArray = districtSubDistrictCode.split("/");
										if (districtSubDistrictCodeArray != null) {
											int subDistrictCodeIndex = 0;
											String subDistrictCode = "";
											String districtCode = "";
											if (districtSubDistrictCodeArray.length == 1) {
												subDistrictCode = "";
												districtCode = districtSubDistrictCodeArray[0];
											} else {
												subDistrictCodeIndex = districtSubDistrictCodeArray.length - 1;
												subDistrictCode = districtSubDistrictCodeArray[subDistrictCodeIndex
														- 1];
												districtCode = districtSubDistrictCodeArray[subDistrictCodeIndex];
											}
											if (subDistrictCode != null && !subDistrictCode.isEmpty()) {
												String[] subDistrictCodeArray = subDistrictCode.split("\\(");
												String subDistrictCodeArraySecondIndex = subDistrictCodeArray[subDistrictCodeArray.length
														- 1];
												subDistrictLocationLong = Long.parseLong(subDistrictCodeArraySecondIndex
														.substring(0, subDistrictCodeArraySecondIndex.length() - 1));
											}
											if (districtCode != null && !districtCode.isEmpty()) {
												String[] districtCodeArray = districtCode.split("\\(");
												String districtCodeArraySecondIndex = districtCodeArray[districtCodeArray.length
														- 1];
												districtLocationLong = Long.parseLong(districtCodeArraySecondIndex
														.substring(0, districtCodeArraySecondIndex.length() - 1));
											}
										}
									}
									Long urbanLocationGuid = null;
									String urbanLocationType = "";
									LocationMaster locationMaster = null;
									if (urbanLocationsMap.get(locationCodeLong) != null) {
										locationMaster = urbanLocationsMap.get(locationCodeLong).get(0);
									}
									if (locationMaster != null) {
										urbanLocationType = locationMaster.getLocationType();
										urbanLocationGuid = locationMaster.getGuid();
									}

									Long districtLocationGuid = null;
									Long subDistrictLocationGuid = null;

									if (subDistrictLocationLong != null) {
										if (districtSubDistrictLocationMap != null) {
											if (districtSubDistrictLocationMap.get(subDistrictLocationLong) != null
													&& districtSubDistrictLocationMap.get(subDistrictLocationLong)
															.get(0) != null) {
												subDistrictLocationGuid = districtSubDistrictLocationMap
														.get(subDistrictLocationLong).get(0).getGuid();
											}
										}
									}

									if (districtLocationLong != null) {
										if (districtSubDistrictLocationMap != null) {
											if (districtSubDistrictLocationMap.get(districtLocationLong) != null
													&& districtSubDistrictLocationMap.get(districtLocationLong)
															.get(0) != null) {
												districtLocationGuid = districtSubDistrictLocationMap
														.get(districtLocationLong).get(0).getGuid();
											}
										}
									}
									Location loc = new Location();
									loc.setLocationCountry(eachCountryLocation.getGuid());
									loc.setLocationState(eachLocation.getGuid());
									loc.setLocationDistrict(districtLocationGuid);
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
									loc.setLocationSubDistrict(subDistrictLocationGuid);
									if (locationName != null && !locationName.isEmpty()) {
										j++;
										writeReferenceDataIntoSheet(loc, exportWorkBookSheet, j);
									} else {
										break;
									}
								}
								writeExcelDataIntoFile(outPutFilePath, exportWorkBook);
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
	public boolean importVillageReferenceLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		// TODO Auto-generated method stub

		String filePath = env.getProperty("project.village-upload-locations-reference-file-name");
		processReferenceLocationsData(filePath, locationImportRequest);
		return true;

	}

	@Override
	@Transactional
	public boolean importUrbanReferenceLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		// TODO Auto-generated method stub

		String filePath = env.getProperty("project.urban-upload-locations-reference-file-name");
		processReferenceLocationsData(filePath, locationImportRequest);
		return true;

	}

	private void processReferenceLocationsData(String filePath, LocationImportRequest locationImportRequest)
			throws InternalServerException {

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		List<Location> referenceLocations = new ArrayList<Location>();
		userInfoDao.updateAllUsersLocationReferenceToDefault();
		locationDao.deleteAllLocations();

		if (stateMasterLocations != null && !stateMasterLocations.isEmpty()) {
			for (LocationMaster eachStateLocation : stateMasterLocations) {
				if (eachStateLocation != null) {
					String outPutFilePath = "";
					String directoryPath = env.getProperty("project.locations-files.upload-path") + filePath;
					String fileName = eachStateLocation.getLocationName() + ServiceConstants.EXCEL_SHEET_TYPE_XLS;
					outPutFilePath = directoryPath + fileName;

					List<Location> eachSheetNewReferenceLocations = prepareReferenceLocations(outPutFilePath,
							locationImportRequest);
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

	private List<Location> prepareReferenceLocations(String outPutFilePath, LocationImportRequest locationImportRequest)
			throws InternalServerException {

		List<Location> referenceLocations = new ArrayList<Location>();
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(outPutFilePath);

		Sheet sheet = myWorkBook.getSheetAt(0);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (i < 1) {
				continue;
			}
			Row eachRow = sheet.getRow(i);

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

		List<LocationMaster> mpConstituencyLocations = new ArrayList<LocationMaster>();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(env.getProperty("india-loksabha-constituency.url"));
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
				if (eachMpConstiencyTable != null) {
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
								mpConstituencyLocations.add(locationMaster);
							}
						}
					}
				}
				tableIndex++;
			}
		}
		driver.close();
		driver.quit();

		if (mpConstituencyLocations != null && !mpConstituencyLocations.isEmpty()) {
			locationMasterDao.saveAllMasterLocations(mpConstituencyLocations);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean importExportAllMasterLocations() throws InternalServerException {
		exportCountries(null);
		importCountries(null);
		exportStates(null);
		importStates(null);
		exportDistricts(null);
		importDistricts(null);
		exportSubDistricts(null);
		importSubDistricts(null);
		exportMuncipalCorporations(null);
		importMuncipalCorporations(null);
		exportMuncipalities(null);
		importMuncipalities(null);
		exportTownPanchayathies(null);
		importTownPanchayathies(null);
		exportVillagePanchayathies(null);
		importVillagePanchayathies(null);
		exportVillages(null);
		importVillages(null);
		return true;
	}

	@Override
	@Transactional
	public boolean importExportAllReferenceLocations() throws InternalServerException {
		exportVillageReferenceLocations(null);
		importVillageReferenceLocations(null);
		exportUrbanReferenceLocations(null);
		importUrbanReferenceLocations(null);
		return true;
	}

	@Override
	public boolean importMLAConstituencyLocations() throws InternalServerException {
		List<LocationMaster> mlaConstituencyLocations = new ArrayList<LocationMaster>();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(env.getProperty("india-mla-constituency.url"));

		List<WebElement> pageMainTables = driver.findElements(By.className("tableizer-table"));
		WebElement pageMainTable = pageMainTables.get(5);
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> statesTableRowsWithHeader = pageMainTableBody.findElements(By.xpath("tr"));
		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<String, List<LocationMaster>> stateMasterLocationsCodeMap = stateMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationType()));

		processEachStateMLAConstituencyURL(1, statesTableRowsWithHeader.size(), mlaConstituencyLocations,
				stateMasterLocationsCodeMap);
		if (mlaConstituencyLocations != null && !mlaConstituencyLocations.isEmpty()) {

		}
		return true;
	}

	private void processEachStateMLAConstituencyURL(int rowNo, int rowsSize,
			List<LocationMaster> mlaConstituencyLocations,
			Map<String, List<LocationMaster>> stateMasterLocationsCodeMap) {
		if (rowNo > rowsSize) {
			driver.close();
			driver.quit();
		} else {
			driver.get(env.getProperty("india-mla-constituency.url"));
			List<WebElement> pageMainTables = driver.findElements(By.className("tableizer-table"));
			WebElement pageMainTable = pageMainTables.get(5);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", pageMainTable);
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> statesTableRowsWithHeader = pageMainTableBody.findElements(By.xpath("tr"));
			WebElement stateNameTrWebElement = statesTableRowsWithHeader.get(rowNo);
			WebElement stateNameTdWebElement = stateNameTrWebElement.findElements(By.xpath("td")).get(0);
			WebElement eachRowStateCellLink = stateNameTdWebElement.findElement(By.xpath("a"));
			String stateName = eachRowStateCellLink.getText();
			String stateUrl = eachRowStateCellLink.getAttribute("href");
			processEachStateMLAConstituencyLocationData(mlaConstituencyLocations, stateName, stateUrl,
					stateMasterLocationsCodeMap);
			processEachStateMLAConstituencyURL(rowNo + 1, rowsSize, mlaConstituencyLocations,
					stateMasterLocationsCodeMap);
		}
	}

	private void processEachStateMLAConstituencyLocationData(List<LocationMaster> mlaConstituencyLocations,
			String stateName, String stateUrl, Map<String, List<LocationMaster>> stateMasterLocationsCodeMap) {
		driver.get(stateUrl);
		WebElement scrollTabDiv = driver.findElement(By.className("scroll-tab"));
		WebElement mCSB2Div = scrollTabDiv.findElement(By.id("mCSB_2"));
		WebElement mCSB2DivContainerDiv = mCSB2Div.findElement(By.id("mCSB_2_container"));
		List<WebElement> mlaConstituencyTables = mCSB2DivContainerDiv.findElements(By.className("tableizer-table"));
		WebElement mlaConstituencyTable = mlaConstituencyTables.get(0);
		if (mlaConstituencyTables.size() > 1) {
			mlaConstituencyTable = mlaConstituencyTables.get(1);
		}
		WebElement mlaConstituencyTableBody = mlaConstituencyTable.findElement(By.xpath("tbody"));
		List<WebElement> mlaConstituencyTableBodyTrs = mlaConstituencyTableBody.findElements(By.xpath("tr"));

		Long parentLocationGuid = null;
		List<LocationMaster> stateLocations = stateMasterLocationsCodeMap.get(stateName);
		if (stateLocations != null && !stateLocations.isEmpty()) {
			LocationMaster locationMaster = stateLocations.get(0);
			parentLocationGuid = locationMaster.getGuid();
		}

		for (WebElement row : mlaConstituencyTableBodyTrs) {

			List<WebElement> cells = row.findElements(By.xpath("td"));
			WebElement assemblyConstituencyNo1 = cells.get(0);
			WebElement assemblyConstituencyName1 = cells.get(1);
			WebElement assemblyConstituencyNo2 = cells.get(2);
			WebElement assemblyConstituencyName2 = cells.get(3);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", assemblyConstituencyNo1);

			if (assemblyConstituencyName1.getText() != null && !assemblyConstituencyName1.getText().isEmpty()) {
				LocationMaster loc1 = new LocationMaster();
				loc1.setLocationCode(Long.parseLong(assemblyConstituencyNo1.getText()));
				loc1.setLocationName(assemblyConstituencyName1.getText());
				loc1.setLocationType(ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE);
				loc1.setParentLocationGuid(parentLocationGuid);
				mlaConstituencyLocations.add(loc1);
			}
			if (assemblyConstituencyName2.getText() != null && !assemblyConstituencyName2.getText().isEmpty()) {
				LocationMaster loc2 = new LocationMaster();
				loc2.setLocationCode(Long.parseLong(assemblyConstituencyNo2.getText()));
				loc2.setLocationName(assemblyConstituencyName2.getText());
				loc2.setLocationType(ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE);
				loc2.setParentLocationGuid(parentLocationGuid);
				mlaConstituencyLocations.add(loc2);
			}
		}
	}
}
