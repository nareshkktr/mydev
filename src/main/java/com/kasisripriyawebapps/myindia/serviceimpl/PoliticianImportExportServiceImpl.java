package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dao.PartyDao;
import com.kasisripriyawebapps.myindia.dao.PoliticianAuthorityDao;
import com.kasisripriyawebapps.myindia.dao.PoliticianDao;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.Party;
import com.kasisripriyawebapps.myindia.entity.Politician;
import com.kasisripriyawebapps.myindia.entity.PoliticianAuthority;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianExportModel;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianImportExportRequest;
import com.kasisripriyawebapps.myindia.service.PoliticianImportExportService;
import com.kasisripriyawebapps.myindia.util.AmazonS3Util;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class PoliticianImportExportServiceImpl implements PoliticianImportExportService {

	@Autowired
	PartyDao partyDao;

	@Autowired
	LocationMasterDao locationMasterDao;

	@Autowired
	PoliticianDao politicianDao;

	@Autowired
	PoliticianAuthorityDao politicianAuthorityDao;

	@Autowired
	private Environment env;

	static WebDriver driver;

	static // Map for data inconsistencies in locations
	Map<String, String> dataInconsistencyPartyMap = new HashMap<String, String>();

	static {

		dataInconsistencyPartyMap.put("YSRC", "YSRCP");
		dataInconsistencyPartyMap.put("KEC(M)", "KC(M)");
		dataInconsistencyPartyMap.put("SHS", "SS");
		dataInconsistencyPartyMap.put("MAG", "MGP");
		dataInconsistencyPartyMap.put("UKDP", "UKD");
		dataInconsistencyPartyMap.put("Yuvajana Sramika Rythu Congress Party", "YSR Congress Party");
		dataInconsistencyPartyMap.put("All India Majlis-E-Ittehadul Muslimeen",
				"All India Majlis-e-Ittehadul Muslimeen");
		dataInconsistencyPartyMap.put("CPM", "CPI-M");

	}

	@Override
	@Transactional
	public void importLoksabhaMPs() throws InternalServerException {

		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		String fileName = env.getProperty("india-politicians-mp-loksabha-export-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name")
							+ ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX
							+ countryFolderName + ApplicationConstants.SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + ApplicationConstants.SUFFIX + uploadedFolderName
							+ ApplicationConstants.SUFFIX + fileName;

					preparePoliticanDataFromExcel(inputFilePath, politicianData);

				}
			}
		}

		List<String> politicianLocationTypes = new ArrayList<String>();
		politicianLocationTypes.add(ServiceConstants.LOCATION_MP_CONSTITUENCT_TYPE);
		processPoliticians(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION, politicianLocationTypes, politicianData);
	}

	private void preparePoliticanDataFromExcel(String filePath, List<PoliticianExportModel> politicianData)
			throws InternalServerException {

		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(filePath);

		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {
			if (i < 1) {
				i++;
				continue;
			}
			String politicianName = eachRow.getCell(0).getStringCellValue();
			String designation = eachRow.getCell(1).getStringCellValue();
			String type = eachRow.getCell(2).getStringCellValue();
			String partyName = eachRow.getCell(3).getStringCellValue();
			String locationName = eachRow.getCell(4).getStringCellValue();

			if (politicianName != null && !politicianName.isEmpty()) {
				PoliticianExportModel politicianObj = new PoliticianExportModel();
				politicianObj.setPoliticianName(politicianName);
				politicianObj.setLocationName(locationName);
				politicianObj.setPartyName(partyName);
				politicianObj.setDesignation(designation);
				politicianObj.setPoliticianType(type);
				politicianData.add(politicianObj);
			}
		}

	}

	@Override
	@Transactional
	public void importRajyasabhaMPs() throws InternalServerException {

		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		String fileName = env.getProperty("india-politicians-mp-rajyasabha-export-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name")
							+ ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX
							+ countryFolderName + ApplicationConstants.SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + ApplicationConstants.SUFFIX + uploadedFolderName
							+ ApplicationConstants.SUFFIX + fileName;

					preparePoliticanDataFromExcel(inputFilePath, politicianData);

				}
			}
		}

		processPoliticians(ServiceConstants.SITTING_RAJYASABHA_MP_DESIGNATION, locationTypes, politicianData);

	}

	@Override
	@Transactional
	public void importMLAs() throws InternalServerException {

		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		String fileName = env.getProperty("india-politicians-mla-export-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name")
							+ ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX
							+ countryFolderName + ApplicationConstants.SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + ApplicationConstants.SUFFIX + uploadedFolderName
							+ ApplicationConstants.SUFFIX + fileName;

					preparePoliticanDataFromExcel(inputFilePath, politicianData);

				}
			}
		}

		List<String> politicianLocationTypes = new ArrayList<String>();
		politicianLocationTypes.add(ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE);
		processPoliticians(ServiceConstants.SITTING_MLA_DESIGNATION, politicianLocationTypes, politicianData);

	}

	@Override
	@Transactional
	public void importChiefMinisters() throws InternalServerException {

		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		String fileName = env.getProperty("project.cheif.mistier-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name")
							+ ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX
							+ countryFolderName + ApplicationConstants.SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + ApplicationConstants.SUFFIX + uploadedFolderName
							+ ApplicationConstants.SUFFIX + fileName;

					preparePoliticanDataFromExcel(inputFilePath, politicianData);

				}
			}
		}

		processPoliticians(ServiceConstants.CHIEF_MINISTER, locationTypes, politicianData);

	}

	@Override
	@Transactional
	public void importGovernors() throws InternalServerException {

		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		String fileName = env.getProperty("project.governor-locations-file-name");

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {

					String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
					String hostName = env.getProperty("amazon.s3.host.name");

					String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
					String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

					String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name")
							+ ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX
							+ countryFolderName + ApplicationConstants.SUFFIX + eachLocation.getLocationName();
					String inputFilePath = hostName + bucketName + ApplicationConstants.SUFFIX + uploadedFolderName
							+ ApplicationConstants.SUFFIX + fileName;

					preparePoliticanDataFromExcel(inputFilePath, politicianData);

				}
			}
		}

		processPoliticians(ServiceConstants.GOVERNORS, locationTypes, politicianData);

	}

	@Override
	@Transactional
	public void importMinistries() throws InternalServerException {

	}

	@Transactional
	private void processPoliticians(String politicianType, List<String> locationTypes,
			List<PoliticianExportModel> politicianData) throws InternalServerException {

		Politician politicianMember = null;

		PoliticianAuthority politicianAuthority = null;

		List<PoliticianAuthority> politicianAuthorities = null;

		List<Politician> newPoliticians = new ArrayList<Politician>();

		List<PoliticianAuthority> newUpdatedPoliticians = new ArrayList<PoliticianAuthority>();

		/**** Commenting out validating for existing politicians
		// Load all existing list of politicians
		List<Politician> allPoliticians = new ArrayList<Politician>();

		allPoliticians = politicianDao.getAllPoliticians();
		

		// Create a map of politicians for easy retreival
		Map<String, List<Politician>> mapAllPoliticians = new HashMap<String, List<Politician>>();

		mapAllPoliticians = allPoliticians.stream()
				.collect(Collectors.groupingBy(politicianObject -> politicianObject.getFullName()));
		

		// Load existing current active Members from Politician Authority based
		// on politicianType
		List<PoliticianAuthority> activePoliticianAuthorities = new ArrayList<PoliticianAuthority>();

		if(applicableLocationGuids != null && !applicableLocationGuids.isEmpty())
			activePoliticianAuthorities = politicianAuthorityDao
				.getActivePoliticianAuthhoritiesByDesignationAndLocations(politicianType,applicableLocationGuids);
		else
			activePoliticianAuthorities = politicianAuthorityDao.getActivePoliticianAuthhoritiesByDesignation(politicianType);
		 
		 ***/
		
		// Load all party information
		List<Party> allParties = partyDao.getAllParties();

		Map<String, List<Party>> mapAllPartiesByName = allParties.stream()
				.collect(Collectors.groupingBy(partyObject -> partyObject.getPartyName().trim()));

		Map<String, List<Party>> mapAllPartiesByAbbreviation = allParties.stream()
				.collect(Collectors.groupingBy(partyObject -> partyObject.getPartyAbbrevation().trim()));

		// Load all location information by location type
		List<LocationMaster> allMpLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		Map<String, List<LocationMaster>> mapAllMpLocations = allMpLocations.stream()
				.collect(Collectors.groupingBy(locationMasterObject -> locationMasterObject.getLocationName().trim().replaceAll(" ","").replaceAll("\\.", "").replaceAll("/","").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "")));

		for (PoliticianExportModel row : politicianData) {

			politicianMember = new Politician();
			politicianAuthority = new PoliticianAuthority();

			String eachMemberName = row.getPoliticianName();
			String eachMemberPartyName = row.getPartyName();
			String eachMemberLocation = row.getLocationName();

			if (eachMemberPartyName != null) {

				String partyName = eachMemberPartyName.trim();

				if (dataInconsistencyPartyMap.containsKey(partyName)) {
					partyName = dataInconsistencyPartyMap.get(partyName);
				}

				if (partyName != null && mapAllPartiesByName.get(partyName) != null
						&& mapAllPartiesByName.get(partyName).size() > 0) {
					Party memberParty = mapAllPartiesByName.get(partyName).get(0);
					politicianAuthority.setParty(memberParty);
				} else if (partyName != null && mapAllPartiesByAbbreviation.get(partyName) != null
						&& mapAllPartiesByAbbreviation.get(partyName).size() > 0) {
					Party memberParty = mapAllPartiesByAbbreviation.get(partyName).get(0);
					politicianAuthority.setParty(memberParty);
				}
			}
			
			//Clean location information
			eachMemberLocation = eachMemberLocation.toUpperCase().replaceAll(" ", "").replaceAll("\\.", "").replaceAll("/","").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "");

			if (eachMemberLocation != null && mapAllMpLocations.get(eachMemberLocation) != null
					&& mapAllMpLocations.get(eachMemberLocation).size() > 0) {
				LocationMaster electedLocation = mapAllMpLocations.get(eachMemberLocation).get(0);
				politicianAuthority.setElectedLocation(electedLocation);
			}else{
				String location = computeDistance(eachMemberLocation,mapAllMpLocations.keySet());
				if(location == ""){
					System.out.println(eachMemberLocation);
				}else{
					//System.out.println("Matchh found--"+location+"--"+eachMemberLocation);
					LocationMaster electedLocation = mapAllMpLocations.get(location).get(0);
					politicianAuthority.setElectedLocation(electedLocation);
				}
			}

			politicianMember.setFullName(eachMemberName);
			politicianMember.setCurrentDesignation(row.getDesignation());

			politicianAuthority.setDesignation(row.getDesignation());
			politicianAuthority.setPoliticianType(row.getPoliticianType());

			// Need to populate start date and is active fields in politician
			// authhority
			politicianAuthority.setActive(true);
			politicianAuthority.setStartDate(new Date());

			newUpdatedPoliticians.add(politicianAuthority);

			// New members
			//if (!allPoliticians.contains(politicianMember)) {
				politicianAuthorities = new ArrayList<PoliticianAuthority>();
				politicianAuthority.setPolitician(politicianMember);
				politicianAuthorities.add(politicianAuthority);
				politicianMember.setPoliticianAuthorities(politicianAuthorities);
				newPoliticians.add(politicianMember);
				
		/** Commenting validating existing politicians as all are treated as new politicians
		
		} else {
				// get the existing politician and get its authorities and
				// decide on update/add/delete
				Politician currentPolitician = mapAllPoliticians.get(politicianMember.getFullName()).get(0);// Need
																											// to
																											// handle
																											// null.
				if (currentPolitician != null) {
					politicianAuthority.setPolitician(currentPolitician);
					List<PoliticianAuthority> currentPoliticianAuthorities = currentPolitician
							.getPoliticianAuthorities();
					if (currentPoliticianAuthorities != null) {

						Boolean exists = false;

						// Check if the current politician authority exists and
						// is active handled in conatins
						// Iterate all authorities mark them as inactive if it
						// doesnt match
						for (PoliticianAuthority pa : currentPoliticianAuthorities) {

							// If there exists an active matching politician
							// authority
							if (pa.equals(politicianAuthority)) {
								exists = true;
							} else { // if doesnt match check if is active if
										// yes mark it inactive and set end date
								if (pa.isActive()) {
									pa.setEndDate(new Date());
									pa.setActive(false);
								}
							}
						}

						//
						if (!exists) {

							currentPoliticianAuthorities.add(politicianAuthority);
							// Set current designation in the politican object
							currentPolitician.setCurrentDesignation(row.getDesignation());
						}

						currentPolitician.setPoliticianAuthorities(currentPoliticianAuthorities);
						newPoliticians.add(currentPolitician);

					} else { // There are no authorities associated with the
								// user.
						politicianAuthorities = new ArrayList<PoliticianAuthority>();
						politicianAuthorities.add(politicianAuthority);
						currentPolitician.setPoliticianAuthorities(politicianAuthorities);

						// Set current designation in the politican object
						currentPolitician.setCurrentDesignation(row.getDesignation());

						newPoliticians.add(currentPolitician);
					}
				}
			} 
			**/

		} // End of all politicians
		
		/**

		// Now find the difference of current active ones and the ones that came
		// new.. those are to be marked as in active and end date	
		
		if (activePoliticianAuthorities != null) {
			activePoliticianAuthorities.removeAll(newUpdatedPoliticians);

			// Mark the above list as inactive and set end Date
			for (PoliticianAuthority pa : activePoliticianAuthorities) {
				pa.setActive(false);
				pa.setEndDate(new Date());
			}
		}
		
		**/

		// DB OPS

		// Politician to be saved/updated -- newPolitician
		if (newPoliticians != null && newPoliticians.size() > 0)
			politicianDao.saveOrUpdatePolitician(newPoliticians);
		
		/**

		// Politician Authorities to be updated - activePoliticianAuthorities
		if (activePoliticianAuthorities != null && activePoliticianAuthorities.size() > 0)
			politicianAuthorityDao.saveOrUpdatePolitician(activePoliticianAuthorities);
			
		**/

	}

	@Override
	@Transactional
	public void importVillageSarpanchas() throws InternalServerException {

	}

	@Override
	@Transactional
	public void exportLoksabhaMPs() throws InternalServerException {

		ChromeOptions op = new ChromeOptions();
		op.addExtensions(new File("Block-image_v1.0.crx"));
		driver = new ChromeDriver(op);

		driver.get(env.getProperty("india-politicians-mp-loksabha.url"));

		String fileName = env.getProperty("india-politicians-mp-loksabha-export-file-name");

		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

		Select stateDropDown = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
		List<WebElement> stateOptions = stateDropDown.getOptions();

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<String, List<LocationMaster>> stateMasterLocationsCodeMap = stateMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationName().toUpperCase()));

		for (int i = 0; i < stateOptions.size(); i++) {

			Select refreshedStateDropDown = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
			WebElement stateOption = refreshedStateDropDown.getOptions().get(i);

			if (i == 0) {
				continue;
			}

			String stateName = stateOption.getText().split("\\(")[0].trim();

			if (!stateMasterLocationsCodeMap.containsKey(stateName.toUpperCase())) {
				continue;
			}

			LocationMaster stateLocation = stateMasterLocationsCodeMap.get(stateName.toUpperCase()).get(0);

			stateOption.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}

			WebElement pageMainTable = driver.findElement(By.className("member_list_table"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> memberRows = pageMainTableBody.findElements(By.xpath("tr"));

			List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();

			for (WebElement row : memberRows) {

				PoliticianExportModel politicianObj = new PoliticianExportModel();

				List<WebElement> cells = row.findElements(By.xpath("td"));

				WebElement eachMemberName = cells.get(1);
				WebElement eachMemberPartyName = cells.get(2);
				WebElement locationName = cells.get(3);

				politicianObj.setPoliticianName(eachMemberName.getText());

				String[] locationSplit = locationName.getText().split("\\(" + stateName);
				String location = locationSplit[0].trim();

				String[] eachLocationSplit = location.split("\\(");

				String extractedLocation = null;

				if (eachLocationSplit != null && eachLocationSplit.length > 0) {
					extractedLocation = eachLocationSplit[0].trim();

				}

				politicianObj.setLocationName(extractedLocation.toUpperCase());
				politicianObj.setPartyName(eachMemberPartyName.getText());
				politicianObj.setDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);
				politicianObj.setPoliticianType(ServiceConstants.MP);
				politicianData.add(politicianObj);

			} // Politician member by state

			String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
					+ ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
					+ stateLocation.getLocationName();

			exportPoliticians(politicianData, fileName, folderPath);

		} // end of all states

		driver.close();
		driver.quit();

	}

	private void exportPoliticians(List<PoliticianExportModel> politicianData, String fileName, String folderPath)
			throws InternalServerException {

		String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");

		Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);

		if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
			exportWorkBook.removeSheetAt(0);
		}
		Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.POLITICIAN_EXCEL);
		addHeaderRowForPoliticianExport(exportWorkBookSheet);

		// prepare sheet data
		Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();

		int j = 0;

		for (PoliticianExportModel eachPolitician : politicianData) {
			j++;
			sheetData.put(j, new Object[] { eachPolitician.getPoliticianName(), eachPolitician.getPoliticianType(),
					eachPolitician.getDesignation(), eachPolitician.getPartyName(), eachPolitician.getLocationName() });
		}

		CommonUtil.writeDataIntoSheet(sheetData, exportWorkBookSheet);
		AmazonS3Util.writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName, folderPath);

	}

	private void addHeaderRowForPoliticianExport(Sheet exportWorkBookSheet) {
		// TODO Auto-generated method stub
		Row headerRow = exportWorkBookSheet.createRow(0);

		Cell politicianNameHeaderCell = headerRow.createCell(0);
		Cell politicianTypeHeaderCell = headerRow.createCell(1);
		Cell designationHeaderCell = headerRow.createCell(2);
		Cell partyNameHeaderCell = headerRow.createCell(3);
		Cell locationNameHeaderCell = headerRow.createCell(4);

		politicianNameHeaderCell.setCellValue(ServiceConstants.POLITICIAN_NAME);
		politicianTypeHeaderCell.setCellValue(ServiceConstants.POLITICIAN_TYPE);
		designationHeaderCell.setCellValue(ServiceConstants.DESIGNATION);
		partyNameHeaderCell.setCellValue(ServiceConstants.PARTY_NAME);
		locationNameHeaderCell.setCellValue(ServiceConstants.LOCATION_NAME);

	}

	@Override
	@Transactional
	public void exportRajyasabhaMPs() throws InternalServerException {

		ChromeOptions op = new ChromeOptions();
		op.addExtensions(new File("Block-image_v1.0.crx"));
		driver = new ChromeDriver(op);
		driver.get(env.getProperty("india-politicians-mp-rajyasabha.url"));

		String fileName = env.getProperty("india-politicians-mp-rajyasabha-export-file-name");

		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (CommonUtil.isListNotNullAndNotEmpty(stateMasterLocations)) {
			for (LocationMaster eachStateLocationMaster : stateMasterLocations) {
				List<PoliticianExportModel> politicianData = extractEachStateRajyasabhaMPsFromURL(
						eachStateLocationMaster);
				String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
						+ ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
						+ eachStateLocationMaster.getLocationName();

				exportPoliticians(politicianData, fileName, folderPath);
				driver.navigate().back();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					throw new InternalServerException(e.getMessage());
				}
			}
		}

		driver.close();
		driver.quit();

	}

	private List<PoliticianExportModel> extractEachStateRajyasabhaMPsFromURL(LocationMaster eachStateLocationMaster)
			throws InternalServerException {
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		// State wise export
		// ContentPlaceHolder1_GridView1
		WebElement pageMainTable = driver.findElement(By.id("ContentPlaceHolder1_GridView1"));
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> states = pageMainTableBody.findElements(By.xpath("tr"));

		for (WebElement state : states) {
			List<WebElement> stateCells = state.findElements(By.xpath("td"));

			if (stateCells.size() > 0) {

				WebElement eachStateName = stateCells.get(1);

				WebElement stateLink = eachStateName.findElement(By.xpath("a"));

				String stateName = stateLink.getText().split("\\(")[0].trim();

				if (eachStateLocationMaster.getLocationName().equalsIgnoreCase(stateName.toUpperCase())) {

					stateLink.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						throw new InternalServerException(e.getMessage());
					}

					pageMainTable = driver.findElement(By.id("ContentPlaceHolder1_GridView2"));
					pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
					List<WebElement> memberRows = pageMainTableBody.findElements(By.xpath("tr"));

					for (WebElement row : memberRows) {

						List<WebElement> cells = row.findElements(By.xpath("td"));

						if (cells.size() > 0) {

							PoliticianExportModel politicianObj = new PoliticianExportModel();

							WebElement eachMemberName = cells.get(1);

							WebElement eachMemberPartyName = cells.get(2);

							WebElement locationName = cells.get(3);

							politicianObj.setPoliticianName(eachMemberName.getText());
							politicianObj.setLocationName(locationName.getText().toUpperCase());
							politicianObj.setPartyName(eachMemberPartyName.getText());
							politicianObj.setDesignation(ServiceConstants.SITTING_RAJYASABHA_MP_DESIGNATION);
							politicianObj.setPoliticianType(ServiceConstants.MP);
							politicianData.add(politicianObj);

						} // For td rows

					}

					break;
				}
			}
		}
		return politicianData;
	}

	@Override
	public void exportGPSarpanch(PoliticianImportExportRequest politicianImport)
			throws InternalServerException, IOException {

		String hostName = env.getProperty("amazon.s3.host.name");
		String rawFileName = env.getProperty("india-politicians-gp-sarpanch-raw-file-name");
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.downloaded.folder.name");
		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");
		String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");

		uploadedFolderName = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
				+ ApplicationConstants.SUFFIX + countryFolderName;

		List<String> stateDirectories = AmazonS3Util.getListOfObjects(bucketName, uploadedFolderName);

		for (String statePath : stateDirectories) {

			String[] pathSplit = statePath.split("/");
			String stateName = pathSplit[pathSplit.length - 1];

			if (politicianImport.getStates() != null && !politicianImport.getStates().isEmpty()) {
				if (!politicianImport.getStates().contains(stateName)) {
					continue;
				}
			}

			// Process and proceed to districts
			List<String> districtDirectories = AmazonS3Util.getListOfObjects(bucketName, statePath);

			if (districtDirectories != null && districtDirectories.size() > 0) {
				for (String eachStateDistrictDirectory : districtDirectories) {

					pathSplit = eachStateDistrictDirectory.split("/");
					String districtName = pathSplit[pathSplit.length - 1];

					if (politicianImport.getDistricts() != null && !politicianImport.getDistricts().isEmpty()) {
						if (!politicianImport.getDistricts().contains(districtName)) {
							continue;
						}
					}

					// Prepare file name and process sarpanches
					String filePath = hostName + bucketName + ApplicationConstants.SUFFIX + eachStateDistrictDirectory
							+ rawFileName;

					processSarpanchas(filePath, districtName, stateName);

				}
			}

		}

	}

	private void processSarpanchas(String fileName, String districtName, String stateName)
			throws IOException, InternalServerException {

		// switch (districtName.toLowerCase()) {
		// case LocationConstants.DISTRICT_ADILABAD_STATE_AP:
		// parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{
		// env.getProperty("adilabad-cols-index"),
		// env.getProperty("adilabad-row-start-index") });
		// case LocationConstants.DISTRICT_ANANTHAPUR_STATE_AP:
		// parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{
		// env.getProperty("ananthapur-cols-index"),
		// env.getProperty("ananthapur-row-start-index") });
		// case LocationConstants.DISTRICT_CHITTOOR_STATE_AP:
		// parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{
		// env.getProperty("chittoor-cols-index"),
		// env.getProperty("chittoor-row-start-index") });
		// case LocationConstants.DISTRICT_EASTGODAVARI_STATE_AP:
		// parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{
		// env.getProperty("eastGodavari-cols-index"),
		// env.getProperty("eastGodavari-row-start-index") });
		//
		// default:
		// break;
		// }

		String districtPropertyName = districtName.toLowerCase().replaceAll(" ", "-");
		String colIndexProperty = districtPropertyName + "-cols-index";
		String rowStartIndexProperty = districtPropertyName + "-row-start-index";

		parseXLSSarpanchDetails(fileName, districtName, stateName,
				new String[] { env.getProperty(colIndexProperty), env.getProperty(rowStartIndexProperty) });

	}

	private void parseXLSSarpanchDetails(String fileName, String districtName, String stateName, String[] cellInfo)
			throws InternalServerException {

		String exportfileName = env.getProperty("india-politicians-gp-sarpanch-export-file-name");

		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

		List<String> headerList = new ArrayList<String>();
		headerList.add("name of the gram panchayat");
		headerList.add("names of the candidate declared elected");
		headerList.add("name of the candidate declared elected");
		headerList.add("name of the grampanchayat");
		headerList.add("name of the sarpanch");
		headerList.add("4.0");
		headerList.add("5.0");
		headerList.add("3.0");

		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(fileName);

		List<PoliticianExportModel> politicians = new ArrayList<PoliticianExportModel>();

		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {

			PoliticianExportModel politicianObj = new PoliticianExportModel();

			if (i < Integer.parseInt(cellInfo[1])) {
				i++;
				continue;
			}

			String[] columns = cellInfo[0].split(",");

			System.out.println(eachRow.getCell(2));
			System.out.println(eachRow.getCell(3));
			
			Cell col1 = eachRow.getCell(Integer.parseInt(columns[1]));	
			Cell col2 = eachRow.getCell(Integer.parseInt(columns[0]));
			
			if(col1 != null && col2 != null){
				
				String politicianName = col1.toString().trim().replace("\n", " ");
				String locationName = col2.toString().trim();
				
				if(!headerList.contains(politicianName.toLowerCase()) && !(politicianName.isEmpty() || locationName.isEmpty())){
					politicianObj.setPoliticianName(politicianName);
					politicianObj.setLocationName(locationName);
					politicianObj.setDesignation(ServiceConstants.SITTING_SARPANCH_GP_DESIGNATION);
					politicianObj.setPoliticianType(ServiceConstants.SARPANCH);
					politicians.add(politicianObj);
				}
			}
			i++;

		}
		
		//Export for the district
		String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
				+ stateName + ApplicationConstants.SUFFIX + districtName.toUpperCase() ;
		
		exportPoliticians(politicians, exportfileName, folderPath);

	}

	@Override
	@Transactional
	public void exportMLAs() throws InternalServerException {

		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mla.url"));

		String fileName = env.getProperty("india-politicians-mla-export-file-name");

		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();

		List<WebElement> allStates = driver.findElements(By.className("sets"));

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<String, List<LocationMaster>> stateMasterLocationsCodeMap = stateMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationName().toUpperCase()));

		for (WebElement we : allStates) {

			String stateName = we.getText().split("\\(")[0].trim();

			if (!stateMasterLocationsCodeMap.containsKey(stateName.toUpperCase())) {
				continue;
			}

			we.click();

			LocationMaster stateLocation = stateMasterLocationsCodeMap.get(stateName.toUpperCase()).get(0);

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}

			WebElement activeResultDiv = driver.findElement(By.className("active_result"));

			WebElement pageMainTable = activeResultDiv.findElement(By.className("tableizer-table"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> memberRows = pageMainTableBody.findElements(By.xpath("tr"));

			int i = 0;

			for (WebElement row : memberRows) {

				if (i == 0) {
					i++;
					continue;
				}
				List<WebElement> cells = row.findElements(By.xpath("td"));

				if (cells.size() > 0) {

					List<Integer> sequence = new ArrayList<Integer>();
					sequence.add(new Integer(1));
					sequence.add(new Integer(5));

					for (Integer j : sequence) {

						PoliticianExportModel politicianObj = new PoliticianExportModel();

						// One entry
						WebElement locationName = cells.get(j);

						WebElement eachMemberName = cells.get(j + 1);

						WebElement eachMemberPartyName = cells.get(j + 2);

						String locationNameStr = locationName.getText().toString();

						locationNameStr = locationNameStr.split("-")[0].toUpperCase().trim();

						if (!eachMemberName.getText().trim().isEmpty()) {
							politicianObj.setPoliticianName(eachMemberName.getText());
							politicianObj.setLocationName(locationNameStr);
							politicianObj.setPartyName(eachMemberPartyName.getText());
							politicianObj.setDesignation(ServiceConstants.SITTING_MLA_DESIGNATION);
							politicianObj.setPoliticianType(ServiceConstants.MLA);
							politicianData.add(politicianObj);
						}
					}
				}

			} // For each row.

			// Export for the district
			String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
					+ ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
					+ stateLocation.getLocationName();

			exportPoliticians(politicianData, fileName, folderPath);

		} // For all states

		driver.close();
		driver.quit();

	}

	@Override
	@Transactional
	public void exportChiefMinisters() throws InternalServerException {
		ChromeOptions op = new ChromeOptions();
		op.addExtensions(new File("Block-image_v1.0.crx"));
		driver = new ChromeDriver(op);
		driver.get(env.getProperty("india-politicians-cm.url"));

		String fileName = env.getProperty("project.cheif.mistier-locations-file-name");
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");
		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<String, List<LocationMaster>> stateMasterLocationsCodeMap = stateMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationName().toUpperCase()));

		WebElement webElement = driver.findElement(By.cssSelector("table.sortable"));
		List<WebElement> rows = webElement.findElements(By.tagName("tr"));
		for (WebElement webElement_1 : rows) {
			List<WebElement> colums = webElement_1.findElements(By.tagName("td"));
			if (colums.size() > 0) {

				WebElement locationName = colums.get(0);
				WebElement fullName = colums.get(1);
				WebElement partyName = colums.get(4);
				String state = "";
				String[] stateArray = locationName.getText().split("\\n");
				if (stateArray != null && stateArray.length > 0) {
					state = stateArray[0].trim();
				}
				stateArray = state.split("\\[");
				if (stateArray != null && stateArray.length > 0) {
					state = stateArray[0].trim();
				}
				state = state.toUpperCase();

				if (!stateMasterLocationsCodeMap.containsKey(state)) {
					continue;
				}

				LocationMaster stateLocation = stateMasterLocationsCodeMap.get(state).get(0);
				List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();

				PoliticianExportModel politicianObj = new PoliticianExportModel();
				politicianObj.setPoliticianName(fullName.getText());
				politicianObj.setLocationName(state);
				politicianObj.setPartyName(partyName.getText());
				politicianObj.setDesignation(ServiceConstants.CHIEF_MINISTER);
				politicianObj.setPoliticianType(ServiceConstants.CHIEF_MINISTER);
				politicianData.add(politicianObj);

				String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
						+ ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
						+ stateLocation.getLocationName();

				exportPoliticians(politicianData, fileName, folderPath);
			}

		}
		driver.close();
		driver.quit();
	}

	@Override
	@Transactional
	public void exportGovernors() throws InternalServerException {
		ChromeOptions op = new ChromeOptions();
		op.addExtensions(new File("Block-image_v1.0.crx"));
		driver = new ChromeDriver(op);
		driver.get(env.getProperty("india-politicians-gov.url"));

		String fileName = env.getProperty("project.governor-locations-file-name");
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");
		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");

		List<LocationMaster> stateMasterLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateMasterLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<String, List<LocationMaster>> stateMasterLocationsCodeMap = stateMasterLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationName().toUpperCase()));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}
		List<WebElement> partyTables = driver.findElements(By.cssSelector("table.wikitable"));
		if (partyTables != null && !partyTables.isEmpty()) {
			for (WebElement eachPartyTable : partyTables) {
				if (eachPartyTable != null) {
					WebElement eachPartyTableTbody = eachPartyTable.findElements(By.xpath("tbody")).get(0);
					List<WebElement> eachPartyTableTBodyTrList = eachPartyTableTbody.findElements(By.xpath("tr"));
					if (eachPartyTableTBodyTrList != null && !eachPartyTableTBodyTrList.isEmpty()) {
						for (WebElement row : eachPartyTableTBodyTrList) {

							List<WebElement> cells = row.findElements(By.xpath("td"));
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								throw new InternalServerException(e.getMessage());
							}

							WebElement locationName = null;
							WebElement fullName = null;
							String state = "";
							String name = "";
							String[] stateArray = null;
							String[] nameArray = null;

							locationName = cells.get(0);
							fullName = cells.get(1);

							stateArray = locationName.getText().split("\\n");
							nameArray = fullName.getText().split("\\n");

							if (stateArray != null && stateArray.length > 0) {
								for (int i = 0; i < stateArray.length - 1; i++) {
									state = stateArray[i].trim();

								}
							}
							if (nameArray != null && nameArray.length > 0) {
								name = nameArray[0].trim();
							}

							state = state.toUpperCase();

							if (!stateMasterLocationsCodeMap.containsKey(state)) {
								continue;
							}

							LocationMaster stateLocation = stateMasterLocationsCodeMap.get(state).get(0);
							List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();

							PoliticianExportModel politicianObj = new PoliticianExportModel();
							politicianObj.setPoliticianName(name);
							politicianObj.setLocationName(stateLocation.getLocationName());
							politicianObj.setDesignation(ServiceConstants.GOVERNORS);
							politicianObj.setPoliticianType(ServiceConstants.GOVERNORS);
							politicianData.add(politicianObj);

							String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
									+ ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
									+ stateLocation.getLocationName();

							exportPoliticians(politicianData, fileName, folderPath);
						}
					}

				}

			}
		}
		driver.close();
		driver.quit();
	}

@Override
	@Transactional
	public void importGPSarpanch(PoliticianImportExportRequest politicianImport) throws InternalServerException {
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		String fileName = env.getProperty("india-politicians-gp-sarpanch-export-file-name");
		
		String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
		String hostName = env.getProperty("amazon.s3.host.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");
		
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");
		
		List<Long> applicableLocationGuids = new ArrayList<Long>();

		List<LocationMaster> stateLocations = new ArrayList<LocationMaster>();
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);

		if (stateLocations != null && !stateLocations.isEmpty()) {
			for (LocationMaster eachLocation : stateLocations) {
				if (eachLocation != null) {
					
					if(politicianImport.getStates() != null && !politicianImport.getStates().isEmpty()){
						if(!politicianImport.getStates().contains(eachLocation.getLocationName())){
							continue;
						}
					}
					
					locationTypes = new ArrayList<String>();
					locationTypes.add(ServiceConstants.DISTRICT);
					
					List<LocationMaster> districtLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
					
					if(districtLocations !=null && !districtLocations.isEmpty()){	
						
						for(LocationMaster districtLcoation: districtLocations){
							
							if(politicianImport.getDistricts() != null && !politicianImport.getDistricts().isEmpty()){
								if(!politicianImport.getDistricts().contains(districtLcoation.getLocationName())){
									continue;
								}
							}

							uploadedFolderName+= ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX
									+ countryFolderName + ApplicationConstants.SUFFIX + eachLocation.getLocationName() + ApplicationConstants.SUFFIX +
									districtLcoation.getLocationName();
							String inputFilePath = hostName + bucketName + ApplicationConstants.SUFFIX + uploadedFolderName
									+ ApplicationConstants.SUFFIX + fileName;

							preparePoliticanDataFromExcel(inputFilePath, politicianData);
							
						}						
					}
				}
			}
		}

		List<String> politicianLocationTypes = new ArrayList<String>();
		politicianLocationTypes.add(ServiceConstants.LOCATION_VILLAGE_PANCHAYATH_TYPE);
		processPoliticians(ServiceConstants.SARPANCH, politicianLocationTypes, politicianData);
		
		// Load all location information by location type
//				List<LocationMaster> allMpLocations = locationMasterDao.getAllMasterLocationsByTypes(politicianLocationTypes);
//
//				Map<String, List<LocationMaster>> mapAllMpLocations = allMpLocations.stream()
// 						.collect(Collectors.groupingBy(locationMasterObject -> locationMasterObject.getLocationName().trim().replaceAll(" ","").replaceAll("\\.", "").replaceAll("/","").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "")));
//		
//				for(PoliticianExportModel pd:politicianData){
//					String locationName = pd.getLocationName().toUpperCase().replaceAll(" ", "").replaceAll("\\.", "").replaceAll("/","").replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "");
//					if(!mapAllMpLocations.containsKey(locationName)){
//						
//						String location = computeDistance(locationName,mapAllMpLocations.keySet());
//						if(location == ""){
//							System.out.println(locationName);
//						}else{
//							System.out.println("Matchh found--"+location+"--"+locationName);
//						}
//						
//						//System.out.println(locationName);
//						//System.out.println("");
//					}
//				}
		
	}
	
	private String computeDistance(String locationName, Set<String> locations) {

		double min =9999;
		String locationIdentified="";
		for(String lm:locations){
			double minDistance = StringUtils.getLevenshteinDistance(lm, locationName);
			if(minDistance<=3 && minDistance <min ){
				min = minDistance;
				locationIdentified = lm;
			}
		}
		
		return locationIdentified;
		
	}
}
