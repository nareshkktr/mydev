/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PartyResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;
import com.kasisripriyawebapps.myindia.service.PartyService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

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
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(env.getProperty("india-parties.url"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			new InternalServerException(e.getMessage());
		}

		List<String> locationTypes = new ArrayList<String>();
		locationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		locationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);

		List<LocationMaster> stateLocations = locationMasterDao.getAllMasterLocationsByTypes(locationTypes);
		Map<String, List<LocationMaster>> stateMasterLocationsCodeMap = stateLocations.stream()
				.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationName().toUpperCase()));

		List<Party> existingParties = partyDao.getAllParties();
		List<Party> newParties = new ArrayList<Party>();
		List<Party> exportedParties = new ArrayList<Party>();

		processPartiesData(stateMasterLocationsCodeMap, newParties, existingParties, exportedParties);

		partyDao.saveParties(newParties);
		List<Party> updatedParties = findUpdatedParties(existingParties, exportedParties);
		if (updatedParties != null && !updatedParties.isEmpty()) {
			partyDao.updateParties(updatedParties);
		}
		if (existingParties != null && !existingParties.isEmpty()) {
			existingParties.removeAll(exportedParties);
			partyDao.deleteParties(existingParties);
		}
	}

	private List<Party> findUpdatedParties(List<Party> existingParties, List<Party> exportedParties) {

		List<Party> updatedParties = new ArrayList<Party>();
		Map<String, List<Party>> existingLocationCodeMap = existingParties.stream().collect(Collectors
				.groupingBy(partyObject -> partyObject.getPartyName() + "|" + partyObject.getPartyAbbrevation()));

		if (exportedParties != null && !exportedParties.isEmpty() && existingParties != null
				&& !existingParties.isEmpty()) {
			for (Party eachExportedParty : exportedParties) {
				if (existingParties.contains(eachExportedParty) && !updatedParties.contains(eachExportedParty)) {
					eachExportedParty.setGuid(existingLocationCodeMap
							.get(eachExportedParty.getPartyName() + "|" + eachExportedParty.getPartyAbbrevation())
							.get(0).getGuid());
					updatedParties.add(eachExportedParty);
				}
			}
		}
		return updatedParties;
	}

	private void processPartiesData(Map<String, List<LocationMaster>> stateMasterLocationsCodeMap,
			List<Party> newParties, List<Party> existingParties, List<Party> exportedParties) {
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
								partyNameCell = cells.get(1);
								partyAbbrevationCell = cells.get(2);
								partyFoundedOnCell = cells.get(3);
								partyLocatedInCell = cells.get(5);
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
									for (String stateName : stateNames) {
										stateName = CommonUtil.getResolvedConflictedLocationName(stateName);
										stateName = stateName.toUpperCase();
										System.out.println(stateName);
										// partyLocations.addAll(stateMasterLocationsCodeMap.get(stateName));
									}
								}
							}
							party.setLocatedIn(partyLocations);
							if (!newParties.contains(party) && !existingParties.contains(party)) {
								newParties.add(party);
							}
							if (!exportedParties.contains(party)) {
								exportedParties.add(party);
							}
						}
					}
					tableIndex++;
				}
			}
		}
		driver.close();
		driver.quit();
	}

	@Override
	@Transactional
	public List<PartyResponse> getAllParties() throws InternalServerException, RecordNotFoundException {
		List<Party> partiesList = partyDao.getAllParties();
		return preparePartyResponse(partiesList);
	}

	private List<PartyResponse> preparePartyResponse(List<Party> partiesList)
			throws InternalServerException, RecordNotFoundException {
		List<PartyResponse> partiesResponse = new ArrayList<PartyResponse>();
		for (Party party : partiesList) {
			PartyResponse partyResponse = new PartyResponse();
			partyResponse.setGuid(party.getGuid());
			partyResponse.setPartyAbbrevation(party.getPartyAbbrevation());
			partyResponse.setPartyName(party.getPartyName());
			partyResponse.setPhotoURL(party.getPhotoURL());
			partiesResponse.add(partyResponse);
		}
		return partiesResponse;
	}
}
