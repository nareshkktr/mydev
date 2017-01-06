package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

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
import com.kasisripriyawebapps.myindia.service.PoliticianImportExportService;

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
		
		processPoliticians(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION,ServiceConstants.LOCATION_MP_CONSTITUENCT_TYPE,politicianData);
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
		
		processPoliticians(ServiceConstants.SITTING_RAJYASABHA_MP_DESIGNATION,ServiceConstants.LOCATION_STATE_TYPE,politicianData);
		
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
		
		processPoliticians(ServiceConstants.SITTING_MLA_DESIGNATION,ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE,politicianData);
	}
	
	@Transactional
	private void processPoliticians(String politicianType,String locationType,List<PoliticianExportModel> politicianData) throws InternalServerException {
		
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
		List<LocationMaster> allMpLocations = locationMasterDao.getAllMasterLocationsByType(locationType);
		
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
	
}
