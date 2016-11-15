/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dao.PartyDao;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.Party;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.PartyService;

// TODO: Auto-generated Javadoc
/**
 * The Class PartyServiceImpl.
 */
@Service
public class PartyServiceImpl implements PartyService {

	/** The party dao. */
	@Autowired
	PartyDao partyDao;

	static WebDriver driver;
	@Autowired
	private Environment env;

	@Autowired
	LocationMasterDao locationMasterDao;

	@Override
	@Transactional
	public void importParties() throws InternalServerException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(env.getProperty("india-parties.url"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			new InternalServerException(e.getMessage());
		}
		List<Party> politicalParties = new ArrayList<Party>();

		List<WebElement> partyTables = driver.findElements(By.cssSelector("table.wikitable"));
		if (partyTables != null && !partyTables.isEmpty()) {
			int tableIndex = 0;
			for (WebElement eachPartyTable : partyTables) {
				if (eachPartyTable != null) {
					WebElement eachPartyTableTbody = eachPartyTable.findElements(By.xpath("tbody")).get(0);
					List<WebElement> eachPartyTableTBodyTrList = eachPartyTableTbody.findElements(By.xpath("tr"));
					if (eachPartyTableTBodyTrList != null && !eachPartyTableTBodyTrList.isEmpty()) {
						for (WebElement row : eachPartyTableTBodyTrList) {

							Party party = new Party();

							List<WebElement> cells = row.findElements(By.xpath("td"));

							WebElement partyNameCell = null;
							WebElement partyAbbrevationCell = null;
							WebElement partyFoundedOnCell = null;
							WebElement partyLocatedInCell = null;

							Boolean isNationalParty = false;

							if (tableIndex == 0) {

								partyNameCell = cells.get(1);
								partyAbbrevationCell = cells.get(2);
								partyFoundedOnCell = cells.get(3);

								isNationalParty = true;

							} else if (tableIndex == 1) {

								partyNameCell = cells.get(1);
								partyAbbrevationCell = cells.get(2);
								partyFoundedOnCell = cells.get(3);
								partyLocatedInCell = cells.get(5);

							} else if (tableIndex == 2) {
								partyNameCell = cells.get(0);
								partyAbbrevationCell = cells.get(1);
								partyFoundedOnCell = cells.get(2);
								partyLocatedInCell = cells.get(4);
							}

							String partyName = partyNameCell.getText();
							String partyAbbrevation = partyAbbrevationCell.getText();
							String partyFoundedOn = partyFoundedOnCell.getText();

							party.setPartyName(partyName);
							party.setPartyAbbrevation(partyAbbrevation);
							party.setFoundationYear(Integer.parseInt(partyFoundedOn.trim()));
							party.setIsNationalParty(isNationalParty);

							List<LocationMaster> partyLocations = new ArrayList<LocationMaster>();
							List<String> stateNames = new ArrayList<String>();

							if (partyLocatedInCell != null) {

								String partyLocationNames = partyLocatedInCell.getText();
								if (partyLocationNames.contains(",")) {
									String[] partyLocationNamesArray = partyLocationNames.split(",");
									if (partyLocationNamesArray != null && partyLocationNamesArray.length > 0) {
										for (String eachPartyLocation : partyLocationNamesArray) {
											stateNames.add(eachPartyLocation.trim());
										}
									}
								} else {
									stateNames.add(partyLocationNames.trim());
								}

								if (stateNames != null && !stateNames.isEmpty()) {

									List<String> locationTypes = new ArrayList<String>();
									locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
									locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);

									partyLocations = locationMasterDao.getMasterLocationsByTypes(locationTypes,
											stateNames);
								}
							}

							party.setLocatedIn(partyLocations);
							politicalParties.add(party);

						}
					}
					tableIndex++;
				}
			}
		}
		driver.close();
		driver.quit();
		if (politicalParties != null && !politicalParties.isEmpty()) {
			partyDao.importParties(politicalParties);
		}
	}
}
