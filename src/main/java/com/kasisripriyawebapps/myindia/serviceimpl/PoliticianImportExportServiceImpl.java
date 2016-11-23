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

	@Override
	@Transactional
	public void importExportLoksabhaMPs() throws InternalServerException {
		driver = new ChromeDriver();
		driver.get(env.getProperty("india-politicians-mp-loksabha.url"));

		Politician politicianMember = null;
		
		PoliticianAuthority politicianAuthority = null;
		
		List<PoliticianAuthority> politicianAuthorities = null;
		
		List<Politician> newPolitician = new ArrayList<Politician>();
		
		List<PoliticianAuthority> newUpdatedMemberOfParliment = new ArrayList<PoliticianAuthority>();
		
		//Load all existing list of politicians
		List<Politician> allPoliticians = new ArrayList<Politician>();
		
		allPoliticians = politicianDao.getAllPoliticians();
		
		//Create a map of politicians for easy retreival
		Map<String,List<Politician>> mapAllPoliticians = new HashMap<String,List<Politician>>();
		
		mapAllPoliticians = allPoliticians.stream()
						.collect(Collectors.groupingBy(politicianObject -> politicianObject.getFullName()));
		
		//Load existing current active lok sabha Members from Politician Authority
		List<PoliticianAuthority> activePoliticianAuthorities = new ArrayList<PoliticianAuthority>();
		
		activePoliticianAuthorities = politicianAuthorityDao.getActivePoliticianAuthhoritiesByDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);

		//Load all party information
		List<Party> allParties = partyDao.getAllParties();
		
		Map<String,List<Party>> mapAllParties = allParties.stream()
				.collect(Collectors.groupingBy(partyObject -> partyObject.getPartyName().trim()));
		
		//Load all Mp Constituencey location information
		List<LocationMaster> allMpLocations = locationMasterDao.getAllMasterLocationsByType(ServiceConstants.LOCATION_MP_CONSTITUENCT_TYPE);
		
		Map<String,List<LocationMaster>> mapAllMpLocations = allMpLocations.stream()
				.collect(Collectors.groupingBy(locationMasterObject -> locationMasterObject.getLocationName().trim()));
		
		//Map for data inconsistencies in locations
		Map<String,String> dataInconsistencyLocationMap = new HashMap<String,String>();
		
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

				politicianMember = new Politician();
				politicianAuthority = new PoliticianAuthority();
				
				List<WebElement> cells = row.findElements(By.xpath("td"));

				WebElement eachMemberName = cells.get(1);
				WebElement eachMemberPartyName = cells.get(2);
				WebElement eachMemberConsituencyState = cells.get(3);
				
				String[] locationSplit =  eachMemberConsituencyState.getText().split("\\(");
				
				String extractedLocation = null;
				
				if(locationSplit != null && locationSplit.length >0){
					 extractedLocation = locationSplit[0].trim();
					 if(dataInconsistencyLocationMap.get(extractedLocation)!=null){
						 extractedLocation = dataInconsistencyLocationMap.get(extractedLocation);
					 }
				}
				
				String partyName = eachMemberPartyName.getText().trim();
				
				if(partyName != null && mapAllParties.get(partyName) != null && mapAllParties.get(partyName).size() >0){
					Party memberParty = mapAllParties.get(partyName).get(0); 
					politicianAuthority.setParty(memberParty);
				}
				
				
				if(extractedLocation != null && mapAllMpLocations.get(extractedLocation) != null && mapAllMpLocations.get(extractedLocation).size()>0){
					LocationMaster electedLocation = mapAllMpLocations.get(extractedLocation).get(0);
					politicianAuthority.setElectedLocation(electedLocation);
				}

				politicianMember.setFullName(eachMemberName.getText());
				politicianMember.setCurrentDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);
				
				politicianAuthority.setDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);
				politicianAuthority.setPoliticianType(ServiceConstants.MP);

				//Need to populate start date and is active fields in politician authhority
				politicianAuthority.setActive(true);
				politicianAuthority.setStartDate(new Date());
				
				newUpdatedMemberOfParliment.add(politicianAuthority);

				//New members
				if(!allPoliticians.contains(politicianMember)){
					politicianAuthorities = new ArrayList<PoliticianAuthority>();
					politicianAuthority.setPolitician(politicianMember);
					politicianAuthorities.add(politicianAuthority);
					politicianMember.setPoliticianAuthorities(politicianAuthorities);
					newPolitician.add(politicianMember);
				}else{
					//get the existing politician and get its authorities and decide on update/add/delete
					Politician currentPolitician = mapAllPoliticians.get(politicianMember.getFullName()).get(0);//Need to handle null.
					if(currentPolitician != null){
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
								politicianAuthority.setPolitician(currentPolitician);
								currentPoliticianAuthorities.add(politicianAuthority);
								//Set current designation in the politican object
								currentPolitician.setCurrentDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);
							}
							
							currentPolitician.setPoliticianAuthorities(currentPoliticianAuthorities);
							newPolitician.add(currentPolitician);
							
						}else{ // There are no authorities associated with the user.
							politicianAuthorities = new ArrayList<PoliticianAuthority>();
							politicianAuthority.setPolitician(currentPolitician);
							politicianAuthorities.add(politicianAuthority);
							currentPolitician.setPoliticianAuthorities(politicianAuthorities);
							
							//Set current designation in the politican object
							currentPolitician.setCurrentDesignation(ServiceConstants.SITTING_LOKSABHA_MP_DESIGNATION);
							
							newPolitician.add(currentPolitician);
						}
					}
				}
				
				

			}// Politician member by state

		}// end of all states
		
		driver.close();
		driver.quit();
		
		// Now find the difference of current active ones and the ones that came new.. those are to be marked as in active and end date
		if(activePoliticianAuthorities != null){
			activePoliticianAuthorities.removeAll(newUpdatedMemberOfParliment);
		
			// Mark the above list as inactive and set end Date
			for(PoliticianAuthority pa: activePoliticianAuthorities){
				pa.setActive(false);
				pa.setEndDate(new Date());
			}
		}
		
		// DB OPS
		
		//Politician to be saved/updated -- newPolitician 
		if(newPolitician != null && newPolitician.size() > 0)
			politicianDao.saveOrUpdatePolitician(newPolitician);
		
		// Politician Authorities to be updated - activePoliticianAuthorities
		if(activePoliticianAuthorities != null && activePoliticianAuthorities.size() > 0)
			politicianAuthorityDao.saveOrUpdatePolitician(activePoliticianAuthorities);
		

	}
}
