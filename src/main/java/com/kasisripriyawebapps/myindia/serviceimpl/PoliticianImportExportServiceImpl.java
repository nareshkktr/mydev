package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.LocationConstants;
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
	
	static //Map for data inconsistencies in locations
	Map<String,String> dataInconsistencyPartyMap = new HashMap<String,String>();
	
	static //Map for data inconsistencies in locations
	Map<String,String> dataInconsistencyLocationMap = new HashMap<String,String>();
	
	static{
			
		dataInconsistencyPartyMap.put("YSRC", "YSRCP");
		dataInconsistencyPartyMap.put("KEC(M)", "KC(M)");
		dataInconsistencyPartyMap.put("SHS", "SS");
		dataInconsistencyPartyMap.put("MAG", "MGP");
		dataInconsistencyPartyMap.put("UKDP", "UKD");
		
		dataInconsistencyLocationMap.put("Hisar", "Hissar");
		dataInconsistencyLocationMap.put("Mumbai-North-West", "Mumbai North West");
		dataInconsistencyLocationMap.put("Mumbai South-Central", "Mumbai South Central");
		dataInconsistencyLocationMap.put("Mumbai-South", "Mumbai South");
		dataInconsistencyLocationMap.put("Ratnagiri-Sindhudurg", "Ratnagiri–Sindhudurg");
		dataInconsistencyLocationMap.put("Tiruvallur", "Thiruvallur");
		dataInconsistencyLocationMap.put("Viluppuram", "Villupuram");
		dataInconsistencyLocationMap.put("Mayiladuthurai", "Mayiladuturai");
		dataInconsistencyLocationMap.put("Thoothukkudi", "Thoothukudi");
		dataInconsistencyLocationMap.put("Mahabubnagar", "Mahbubnagar");
	}

	@Override
	@Transactional
	public void importExportLoksabhaMPs() throws InternalServerException {
		
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mp-loksabha.url"));
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		
		Select stateDropDown = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
		List<WebElement> stateOptions = stateDropDown.getOptions();
		
		for (int i = 0; i < stateOptions.size(); i++) {
			Select refreshedStateDropDown = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
			WebElement stateOption = refreshedStateDropDown.getOptions().get(i);
			if (i == 0) {
				continue;
			}
			stateOption.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}

			WebElement pageMainTable = driver.findElement(By.className("member_list_table"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> memberRows = pageMainTableBody.findElements(By.xpath("tr"));

			for (WebElement row : memberRows) {

				PoliticianExportModel politicianObj = new PoliticianExportModel();
				
				List<WebElement> cells = row.findElements(By.xpath("td"));

				WebElement eachMemberName = cells.get(1);
				WebElement eachMemberPartyName = cells.get(2);
				WebElement locationName = cells.get(3);
				
				
				politicianObj.setPoliticianName(eachMemberName.getText());
				politicianObj.setLocationName(locationName.getText());
				politicianObj.setPartyName(eachMemberPartyName.getText());
				politicianObj.setDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);
				politicianObj.setPoliticianType(ServiceConstants.MP);
				politicianData.add(politicianObj);	

			}// Politician member by state

		}// end of all states
		
		driver.close();
		driver.quit();
		
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_MP_CONSTITUENCT_TYPE);
		
		processPoliticians(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION,locationTypes,politicianData);
	}
	
	@Override
	@Transactional
	public void importExportRajyasabhaMPs() throws InternalServerException {
		
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mp-rajyasabha.url"));
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		
		WebElement allMmebersRadioButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdblist_1"));
		
		allMmebersRadioButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}
		
		//ctl00_ContentPlaceHolder1_GridView2
		
		WebElement pageMainTable = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView2"));
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> memberRows = pageMainTableBody
				.findElements(By.xpath("tr"));
		
		for (WebElement row : memberRows) {

			List<WebElement> cells = row.findElements(By.xpath("td"));
			
			if(cells.size() >0){
				
				PoliticianExportModel politicianObj = new PoliticianExportModel();
				
				WebElement eachMemberName = cells.get(1);
				
				WebElement eachMemberPartyName = cells.get(2);
				
				WebElement locationName = cells.get(3);
				
				politicianObj.setPoliticianName(eachMemberName.getText());
				politicianObj.setLocationName(locationName.getText());
				politicianObj.setPartyName(eachMemberPartyName.getText());
				politicianObj.setDesignation(ServiceConstants.SITTING_RAJYASABHA_MP_DESIGNATION);
				politicianObj.setPoliticianType(ServiceConstants.MP);
				politicianData.add(politicianObj);
	
			}//For td rows
			
		}// For each member
		
		driver.close();
		driver.quit();
		
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
		
		processPoliticians(ServiceConstants.SITTING_RAJYASABHA_MP_DESIGNATION,locationTypes,politicianData);
		
	}
	
	@Override
	@Transactional
	public void importExportMLA() throws InternalServerException {	
		
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mla.url"));
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		
		List<WebElement> allStates = driver.findElements(By.className("sets"));
		
		for(WebElement we: allStates){	
			
			we.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}
			
			WebElement activeResultDiv = driver.findElement(By.className("active_result"));
			
			WebElement pageMainTable = activeResultDiv.findElement(By.className("tableizer-table"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> memberRows = pageMainTableBody
					.findElements(By.xpath("tr"));
			
			int i =0;
			
			for (WebElement row : memberRows) {
				
				if(i==0){
					i++;
					continue;
				}
				List<WebElement> cells = row.findElements(By.xpath("td"));
				
				if(cells.size() >0){
					
					List<Integer> sequence = new ArrayList<Integer>();
					sequence.add(new Integer(1));
					sequence.add(new Integer(5));
					
					for(Integer j : sequence){
						
						PoliticianExportModel politicianObj = new PoliticianExportModel();
						
						// One entry
						WebElement locationName = cells.get(j);
						
						WebElement eachMemberName = cells.get(j+1);
						
						WebElement eachMemberPartyName = cells.get(j+2);
						
						if(!eachMemberName.getText().trim().isEmpty()){					
							politicianObj.setPoliticianName(eachMemberName.getText());
							politicianObj.setLocationName(locationName.getText());
							politicianObj.setPartyName(eachMemberPartyName.getText());
							politicianObj.setDesignation(ServiceConstants.SITTING_MLA_DESIGNATION);
							politicianObj.setPoliticianType(ServiceConstants.MLA);
							politicianData.add(politicianObj);
						}
					}
				}
				
					
			}// For each row. 
			
		}// For all states
		
		driver.close();
		driver.quit();
		
		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE);
		
		processPoliticians(ServiceConstants.SITTING_MLA_DESIGNATION,locationTypes,politicianData);
	}
	@Override
	@Transactional
	public void importExportChiefMinistors() throws InternalServerException {
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-cm.url"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}
		WebElement webElement = driver.findElement(By.cssSelector("table.sortable"));
			List<WebElement> rows=webElement.findElements(By.tagName("tr"));
			for(WebElement webElement_1:rows){
				List<WebElement> colums=webElement_1.findElements(By.tagName("td"));
				if(colums.size() >0){
					
					WebElement locationName= colums.get(0);
					WebElement fullName = colums.get(1);
					WebElement partyName = colums.get(4);
					String state="";
					String[] stateArray = locationName.getText().split("\\n");
					 if(stateArray!=null && stateArray.length>0){
			             state = stateArray[0].trim();
			         }
					 stateArray = state.split("\\[");
					 if(stateArray!=null && stateArray.length>0){
			             state = stateArray[0].trim();
			         }
					 state= state.toUpperCase();
					PoliticianExportModel politicianObj = new PoliticianExportModel();
					politicianObj.setPoliticianName(fullName.getText());
					politicianObj.setLocationName(state);
					politicianObj.setPartyName(partyName.getText());
					politicianObj.setDesignation(ServiceConstants.CHIEF_MINISTER);
					politicianObj.setPoliticianType(ServiceConstants.CHIEF_MINISTER);
					politicianData.add(politicianObj);
					System.out.println(state + " *********** " + fullName.getText());
					
				}	
			}
			driver.close();
			driver.quit();
			
			List<String> locationTypes = new ArrayList<String>();
			locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
			locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
			
			processPoliticians(ServiceConstants.CHIEF_MINISTER,locationTypes,politicianData);
	  
	}
	@Override
	@Transactional
	public void importExportGoverners() throws InternalServerException {
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-gov.url"));
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
							 /*else if (tableIndex == 1) {
								locationName = cells.get(0);
								fullName = cells.get(1);
								state = locationName.getText();
								stateArray = locationName.getText().split("\\n");
								
								if (stateArray != null && stateArray.length > 0) {
									for (int i = 0; i <= stateArray.length - 1; i++) {
										state = stateArray[i+1].trim();

									}
								}
								name = fullName.getText().trim();
							}*/
							state= state.toUpperCase();
							PoliticianExportModel politicianObj = new PoliticianExportModel();
							politicianObj.setPoliticianName(name);
							politicianObj.setLocationName(state);
							politicianObj.setDesignation(ServiceConstants.GOVERNORS);
							politicianObj.setPoliticianType(ServiceConstants.GOVERNORS);
							politicianData.add(politicianObj);
							System.out.println(state + " *********** " + name);
						}
					}
				}

			}
		}
			driver.close();
			driver.quit();
			
			List<String> locationTypes = new ArrayList<String>();
			locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
			locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);
			
			processPoliticians(ServiceConstants.GOVERNORS,locationTypes,politicianData);
	  
	}

	@Override
	@Transactional
	public void importMinistries() throws InternalServerException {
		
	}
	@Transactional
	private void processPoliticians(String politicianType,List<String> locationType,List<PoliticianExportModel> politicianData) throws InternalServerException {
		
		Politician politicianMember = null;
		
		PoliticianAuthority politicianAuthority = null;
		
		List<PoliticianAuthority> politicianAuthorities = null;
		
		List<Politician> newPoliticians = new ArrayList<Politician>();
		
		List<PoliticianAuthority> newUpdatedPoliticians = new ArrayList<PoliticianAuthority>();
		
		//Load all existing list of politicians
		List<Politician> allPoliticians = new ArrayList<Politician>();
		
		allPoliticians = politicianDao.getAllPoliticians();
		
		//Create a map of politicians for easy retreival
		Map<String,List<Politician>> mapAllPoliticians = new HashMap<String,List<Politician>>();
		
		mapAllPoliticians = allPoliticians.stream()
						.collect(Collectors.groupingBy(politicianObject -> politicianObject.getFullName()));
		
		//Load existing current active Members from Politician Authority based on politicianType
		List<PoliticianAuthority> activePoliticianAuthorities = new ArrayList<PoliticianAuthority>();
		
		activePoliticianAuthorities = politicianAuthorityDao.getActivePoliticianAuthhoritiesByDesignation(politicianType);

		//Load all party information
		List<Party> allParties = partyDao.getAllParties();
		
		Map<String,List<Party>> mapAllPartiesByName = allParties.stream()
				.collect(Collectors.groupingBy(partyObject -> partyObject.getPartyName().trim()));
		
		Map<String,List<Party>> mapAllPartiesByAbbreviation = allParties.stream()
				.collect(Collectors.groupingBy(partyObject -> partyObject.getPartyAbbrevation().trim()));
		
		//Load all location information by location type
		List<LocationMaster> allMpLocations = new ArrayList<LocationMaster>();
		
		for(int i=0;i<locationType.size();i++)
			allMpLocations.addAll(locationMasterDao.getAllMasterLocationsByType(locationType.get(i)));
		
		Map<String,List<LocationMaster>> mapAllMpLocations = allMpLocations.stream()
				.collect(Collectors.groupingBy(locationMasterObject -> locationMasterObject.getLocationName().trim()));
		
		for (PoliticianExportModel row : politicianData) {

			politicianMember = new Politician();
			politicianAuthority = new PoliticianAuthority();
			
			String eachMemberName = row.getPoliticianName();
			String eachMemberPartyName = row.getPartyName();
			String eachMemberLocation = row.getLocationName();
			
			String[] locationSplit =  eachMemberLocation.split("\\(");
			
			String extractedLocation = null;
			
			if(locationSplit != null && locationSplit.length >0){
				 extractedLocation = locationSplit[0].trim();
				 if(dataInconsistencyLocationMap.get(extractedLocation)!=null){
					 extractedLocation = dataInconsistencyLocationMap.get(extractedLocation);
				 }
			}
			
			if(eachMemberPartyName != null){
			
				String partyName = eachMemberPartyName.trim();
				
				if(dataInconsistencyPartyMap.containsKey(partyName)){
					partyName = dataInconsistencyPartyMap.get(partyName);
				}
				
				if(partyName != null && mapAllPartiesByName.get(partyName) != null && mapAllPartiesByName.get(partyName).size() >0){
					Party memberParty = mapAllPartiesByName.get(partyName).get(0); 
					politicianAuthority.setParty(memberParty);
				}else if(partyName != null && mapAllPartiesByAbbreviation.get(partyName) != null && mapAllPartiesByAbbreviation.get(partyName).size() >0){
					Party memberParty = mapAllPartiesByAbbreviation.get(partyName).get(0); 
					politicianAuthority.setParty(memberParty);
				}
			}
			
			
			if(extractedLocation != null && mapAllMpLocations.get(extractedLocation) != null && mapAllMpLocations.get(extractedLocation).size()>0){
				LocationMaster electedLocation = mapAllMpLocations.get(extractedLocation).get(0);
				politicianAuthority.setElectedLocation(electedLocation);
			}

			politicianMember.setFullName(eachMemberName);
			politicianMember.setCurrentDesignation(row.getDesignation());
			
			politicianAuthority.setDesignation(row.getDesignation());
			politicianAuthority.setPoliticianType(row.getPoliticianType());

			//Need to populate start date and is active fields in politician authhority
			politicianAuthority.setActive(true);
			politicianAuthority.setStartDate(new Date());
			
			newUpdatedPoliticians.add(politicianAuthority);

			//New members
			if(!allPoliticians.contains(politicianMember)){
				politicianAuthorities = new ArrayList<PoliticianAuthority>();
				politicianAuthority.setPolitician(politicianMember);
				politicianAuthorities.add(politicianAuthority);
				politicianMember.setPoliticianAuthorities(politicianAuthorities);
				newPoliticians.add(politicianMember);
			}else{
				//get the existing politician and get its authorities and decide on update/add/delete
				Politician currentPolitician = mapAllPoliticians.get(politicianMember.getFullName()).get(0);//Need to handle null.
				if(currentPolitician != null){
					politicianAuthority.setPolitician(currentPolitician);
					List<PoliticianAuthority> currentPoliticianAuthorities = currentPolitician.getPoliticianAuthorities();
					if(currentPoliticianAuthorities != null){
						
						Boolean exists = false;
						
						//Check if the current politician authority exists and is active handled in conatins
						//Iterate all authorities mark them as inactive if it doesnt match
						for(PoliticianAuthority pa: currentPoliticianAuthorities){
							
							// If there exists an active matching politician authority
							if(pa.equals(politicianAuthority)){
								exists = true;
							}else{ // if doesnt match check if is active if yes mark it inactive and set end date
								if(pa.isActive()){
									pa.setEndDate(new Date());
									pa.setActive(false);
								}
							}
						}
						
						//
						if(!exists){
							
							currentPoliticianAuthorities.add(politicianAuthority);
							//Set current designation in the politican object
							currentPolitician.setCurrentDesignation(row.getDesignation());
						}
						
						currentPolitician.setPoliticianAuthorities(currentPoliticianAuthorities);
						newPoliticians.add(currentPolitician);
						
					}else{ // There are no authorities associated with the user.
						politicianAuthorities = new ArrayList<PoliticianAuthority>();
						politicianAuthorities.add(politicianAuthority);
						currentPolitician.setPoliticianAuthorities(politicianAuthorities);
						
						//Set current designation in the politican object
						currentPolitician.setCurrentDesignation(row.getDesignation());
						
						newPoliticians.add(currentPolitician);
					}
				}
			}

		}//End of all politicians
		
		// Now find the difference of current active ones and the ones that came new.. those are to be marked as in active and end date
		if(activePoliticianAuthorities != null){
			activePoliticianAuthorities.removeAll(newUpdatedPoliticians);
		
			// Mark the above list as inactive and set end Date
			for(PoliticianAuthority pa: activePoliticianAuthorities){
				pa.setActive(false);
				pa.setEndDate(new Date());
			}
		}
		
		// DB OPS
		
		//Politician to be saved/updated -- newPolitician 
		if(newPoliticians != null && newPoliticians.size() > 0)
			politicianDao.saveOrUpdatePolitician(newPoliticians);
		
		// Politician Authorities to be updated - activePoliticianAuthorities
		if(activePoliticianAuthorities != null && activePoliticianAuthorities.size() > 0)
			politicianAuthorityDao.saveOrUpdatePolitician(activePoliticianAuthorities);

	}

	@Override
	@Transactional
	public void importVillageSarpanchas() throws InternalServerException {
		
		
	}

	@Override
	public void exportLoksabhaMPs(PoliticianImportExportRequest politicianImport) throws InternalServerException {

		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mp-loksabha.url"));
		
		String fileName = env.getProperty("india-politicians-mp-loksabha-export-file-name");
		
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		
		Select stateDropDown = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
		List<WebElement> stateOptions = stateDropDown.getOptions();
		
		for (int i = 0; i < stateOptions.size(); i++) {
			
			Select refreshedStateDropDown = new Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
			WebElement stateOption = refreshedStateDropDown.getOptions().get(i);
			
			if (i == 0) {
				continue;
			}
			
			String stateName = stateOption.getText().split("\\(")[0].trim();
			
			if(!politicianImport.getStates().contains(stateName)){
				continue;
			}
			
			stateOption.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}

			WebElement pageMainTable = driver.findElement(By.className("member_list_table"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> memberRows = pageMainTableBody.findElements(By.xpath("tr"));

			for (WebElement row : memberRows) {

				PoliticianExportModel politicianObj = new PoliticianExportModel();
				
				List<WebElement> cells = row.findElements(By.xpath("td"));

				WebElement eachMemberName = cells.get(1);
				WebElement eachMemberPartyName = cells.get(2);
				WebElement locationName = cells.get(3);
				
				politicianObj.setPoliticianName(eachMemberName.getText());
				
				String[] locationSplit = locationName.getText().split("\\("+stateName);
				String location = locationSplit[0].trim();
				
				politicianObj.setLocationName(location);
				politicianObj.setPartyName(eachMemberPartyName.getText());
				politicianObj.setDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);
				politicianObj.setPoliticianType(ServiceConstants.MP);
				politicianData.add(politicianObj);	

			}// Politician member by state
			
			String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
					+ stateName ;
			
			exportPoliticians(politicianData, fileName, folderPath);

		}// end of all states
		

		driver.close();
		driver.quit();
		
	}

	private void exportPoliticians(List<PoliticianExportModel> politicianData, String fileName, String folderPath) throws InternalServerException {
		
		String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
		
		Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);

		if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
			exportWorkBook.removeSheetAt(0);
		}
		Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.POLITICIAN_EXCEL);
		addHeaderRowForPoliticianExport(exportWorkBookSheet);

		//prepare sheet data
		Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
		
		int j=0;
		
		for (PoliticianExportModel eachPolitician : politicianData) {
			j++;
			sheetData.put(j, new Object[] { eachPolitician.getPoliticianName(), eachPolitician.getPoliticianType() , eachPolitician.getDesignation() , eachPolitician.getPartyName()
					,eachPolitician.getLocationName() });
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
	public void exportRajyasabhaMPs(PoliticianImportExportRequest politicianImport) throws InternalServerException {
		
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mp-rajyasabha.url"));
		
		String fileName = env.getProperty("india-politicians-mp-rajyasabha-export-file-name");
		
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		
		//State wise export
		//ContentPlaceHolder1_GridView1
		WebElement pageMainTable = driver.findElement(By.id("ContentPlaceHolder1_GridView1"));
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> states = pageMainTableBody
				.findElements(By.xpath("tr"));
		
		for(WebElement state:states){
			List<WebElement> stateCells = state.findElements(By.xpath("td"));
			
			if(stateCells.size() >0){
				
				WebElement eachStateName = stateCells.get(1);
				
				
				WebElement stateLink = eachStateName.findElement(By.xpath("a"));
				
				String stateName = stateLink.getText();
				
				if(!politicianImport.getStates().contains(stateName)){
					continue;
				}
				
				stateLink.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					throw new InternalServerException(e.getMessage());
				}
	
				//ContentPlaceHolder1_GridView2
				
				pageMainTable = driver.findElement(By.id("ContentPlaceHolder1_GridView2"));
				pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
				List<WebElement> memberRows = pageMainTableBody
						.findElements(By.xpath("tr"));
				
				for (WebElement row : memberRows) {

					List<WebElement> cells = row.findElements(By.xpath("td"));
						
					if(cells.size() >0){
						
						PoliticianExportModel politicianObj = new PoliticianExportModel();
						
						WebElement eachMemberName = cells.get(1);
						
						WebElement eachMemberPartyName = cells.get(2);
						
						WebElement locationName = cells.get(3);
						
						politicianObj.setPoliticianName(eachMemberName.getText());
						politicianObj.setLocationName(locationName.getText());
						politicianObj.setPartyName(eachMemberPartyName.getText());
						politicianObj.setDesignation(ServiceConstants.SITTING_RAJYASABHA_MP_DESIGNATION);
						politicianObj.setPoliticianType(ServiceConstants.MP);
						politicianData.add(politicianObj);
			
					}//For td rows
					
				}// For each member
				
				stateName = stateName.split("\\(")[0].trim();
				
				//Export for the state
				String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
						+ stateName ;
				
				exportPoliticians(politicianData, fileName, folderPath);
				
				//break the loop as the element wil be stale
				break;
			}
			
		}
		
		driver.close();
		driver.quit();
		
	}

	@Override
	public void exportGPSarpanch(PoliticianImportExportRequest politicianImport) throws InternalServerException, IOException {
		
		String hostName = env.getProperty("amazon.s3.host.name");
		String rawFileName = env.getProperty("india-politicians-gp-sarpanch-raw-file-name");
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.downloaded.folder.name");
		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");	
		String bucketName = env.getProperty("amazon.s3.politicians.bucket.name");
		
		uploadedFolderName = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
				+ ApplicationConstants.SUFFIX + countryFolderName;

		List<String> stateDirectories = AmazonS3Util.getListOfObjects(bucketName, uploadedFolderName);
		
		for(String statePath:stateDirectories){
			
			String[] pathSplit = statePath.split("/");
			String stateName = pathSplit[pathSplit.length - 1];

			if (politicianImport.getStates() != null && !politicianImport.getStates().isEmpty()) {
				if (!politicianImport.getStates().contains(stateName)) {
					continue;
				}
			}
			
			//Process and proceed to districts
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
					
					//Prepare file name and process sarpanches
					String filePath = hostName + bucketName + ApplicationConstants.SUFFIX
							+ eachStateDistrictDirectory + rawFileName;
					
					processSarpanchas(filePath,districtName,stateName);
					
				}
			}
			
		}
		
	}

	private void processSarpanchas(String fileName,String districtName,String stateName) throws IOException, InternalServerException{
		
//		switch (districtName.toLowerCase()) {
//		case LocationConstants.DISTRICT_ADILABAD_STATE_AP:
//			parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{ env.getProperty("adilabad-cols-index"), env.getProperty("adilabad-row-start-index") });
//		case LocationConstants.DISTRICT_ANANTHAPUR_STATE_AP:
//			parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{ env.getProperty("ananthapur-cols-index"), env.getProperty("ananthapur-row-start-index") });
//		case LocationConstants.DISTRICT_CHITTOOR_STATE_AP:
//			parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{ env.getProperty("chittoor-cols-index"), env.getProperty("chittoor-row-start-index") });
//		case LocationConstants.DISTRICT_EASTGODAVARI_STATE_AP:
//			parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{ env.getProperty("eastGodavari-cols-index"), env.getProperty("eastGodavari-row-start-index") });
//		
//		default:
//			break;
//		}	
		
		String districtPropertyName = districtName.toLowerCase().replaceAll(" ", "-");
		String colIndexProperty =districtPropertyName+"-cols-index";
		String rowStartIndexProperty = districtPropertyName+"-row-start-index";
		
		parseXLSSarpanchDetails(fileName,districtName,stateName,new String[]{ env.getProperty(colIndexProperty), env.getProperty(rowStartIndexProperty) });
		
	}
	
	private void parseXLSSarpanchDetails(String fileName,String districtName, String stateName, String[] cellInfo) throws InternalServerException{
		
		String exportfileName = env.getProperty("india-politicians-gp-sarpanch-export-file-name");
		
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");
		
		List<String> headerList = new ArrayList<String>();
		headerList.add("Name of the Gram Panchayat");
		headerList.add("Names of the candidate declared elected");
		headerList.add("Name of the candidate declared elected");
		headerList.add("Name of the Grampanchayat");
		headerList.add("Names of the Candidate declared Elected");
		headerList.add("4.0");
		headerList.add("5.0");
		headerList.add("3.0");
		
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(fileName);
		
		List<PoliticianExportModel> politicians = new ArrayList<PoliticianExportModel>();

		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {
			
			PoliticianExportModel politicianObj = new PoliticianExportModel();
			
			if(i<Integer.parseInt(cellInfo[1])){
				i++;
				continue;
			}
			
			String[] columns = cellInfo[0].split(",");
			
			System.out.println(eachRow.getCell(2));
			System.out.println(eachRow.getCell(3));
			
			String politicianName = eachRow.getCell(Integer.parseInt(columns[1])).toString().trim().replace("\n", " ");	
			String locationName = eachRow.getCell(Integer.parseInt(columns[0])).toString().trim();
			
			if(!headerList.contains(politicianName) && !(politicianName.isEmpty() || locationName.isEmpty())){
				politicianObj.setPoliticianName(politicianName);
				politicianObj.setLocationName(locationName);
				politicianObj.setDesignation(ServiceConstants.SITTING_SARPANCH_GP_DESIGNATION);
				politicianObj.setPoliticianType(ServiceConstants.SARPANCH);
				politicians.add(politicianObj);
			}
			
			i++;

		}
		
		//Export for the district
		String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
				+ stateName + ApplicationConstants.SUFFIX + districtName ;
		
		exportPoliticians(politicians, exportfileName, folderPath);
		
	}

	@Override
	public void exportMLA(PoliticianImportExportRequest politicianImport) throws InternalServerException {
		
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mla.url"));
		
		String fileName = env.getProperty("india-politicians-mla-export-file-name");
		
		String uploadedFolderName = env.getProperty("amazon.s3.politicians.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.politicians.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.politicians.india.folder.name");
		
		
		List<PoliticianExportModel> politicianData = new ArrayList<PoliticianExportModel>();
		
		List<WebElement> allStates = driver.findElements(By.className("sets"));
		
		for(WebElement we: allStates){	
			
			String stateName = we.getText();
			
			if(!politicianImport.getStates().contains(stateName)){
				continue;
			}
			
			we.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}
			
			WebElement activeResultDiv = driver.findElement(By.className("active_result"));
			
			WebElement pageMainTable = activeResultDiv.findElement(By.className("tableizer-table"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> memberRows = pageMainTableBody
					.findElements(By.xpath("tr"));
			
			int i =0;
			
			for (WebElement row : memberRows) {
				
				if(i==0){
					i++;
					continue;
				}
				List<WebElement> cells = row.findElements(By.xpath("td"));
				
				if(cells.size() >0){
					
					List<Integer> sequence = new ArrayList<Integer>();
					sequence.add(new Integer(1));
					sequence.add(new Integer(5));
					
					for(Integer j : sequence){
						
						PoliticianExportModel politicianObj = new PoliticianExportModel();
						
						// One entry
						WebElement locationName = cells.get(j);
						
						WebElement eachMemberName = cells.get(j+1);
						
						WebElement eachMemberPartyName = cells.get(j+2);
						
						if(!eachMemberName.getText().trim().isEmpty()){					
							politicianObj.setPoliticianName(eachMemberName.getText());
							politicianObj.setLocationName(locationName.getText());
							politicianObj.setPartyName(eachMemberPartyName.getText());
							politicianObj.setDesignation(ServiceConstants.SITTING_MLA_DESIGNATION);
							politicianObj.setPoliticianType(ServiceConstants.MLA);
							politicianData.add(politicianObj);
						}
					}
				}
				
					
			}// For each row.
			
			//Export for the district
			String folderPath = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName + ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
					+ stateName  ;
			
			exportPoliticians(politicianData, fileName, folderPath);
			
		}// For all states
		
		driver.close();
		driver.quit();
		
	}
	
}
