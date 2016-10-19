/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.dao.LocationDao;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.LocationService;

/**
 * The Class LocationServiceImpl.
 */
@Service
public class LocationServiceImpl implements LocationService {

	/** The location dao. */
	@Autowired
	LocationDao locationDao;

	@Autowired
	LocationMasterDao locationMasterDao;

	@Override
	@Transactional
	public void uploadLocations() throws InternalServerException {
		// TODO Auto-generated method stub

		String file = "C:\\Users\\kanduk\\Documents\\My Web Sites\\My WebSite\\Locations.xlsx";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			new InternalServerException(e.getMessage());
		}

		// Finds the workbook instance for XLSX file
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			new InternalServerException(e.getMessage());

		}

		List<LocationMaster> masterLocations = new ArrayList<LocationMaster>();

		for (int j = 0; j < myWorkBook.getNumberOfSheets(); j++) {
			if (j < 6) {
				XSSFSheet countrySheet = myWorkBook.getSheetAt(j);
				List<LocationMaster> sheetMasterLocations = prepareMasterLocations(countrySheet);
				masterLocations.addAll(sheetMasterLocations);
			}
		}
		saveAllMasterLocations(masterLocations);
	}

	private void saveAllMasterLocations(List<LocationMaster> allMasterLocations) throws InternalServerException {
		locationMasterDao.saveAllMasterLocations(allMasterLocations);
	}

	private List<LocationMaster> prepareMasterLocations(XSSFSheet sheet) {
		List<LocationMaster> masterLocations = new ArrayList<LocationMaster>();
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (i == 0) {
				continue;
			}
			Row eachRow = sheet.getRow(i);
			String locationCode = eachRow.getCell(0).getStringCellValue().trim();
			String locationName = eachRow.getCell(1).getStringCellValue().trim();
			String parentLocationCode = eachRow.getCell(2).getStringCellValue().trim();
			String locationType = eachRow.getCell(3).getStringCellValue().trim();

			LocationMaster locationMaster = new LocationMaster();
			locationMaster.setLocationCode(locationCode);
			locationMaster.setLocationName(locationName);
			locationMaster.setParentLocationCode(parentLocationCode);
			locationMaster.setLocationType(locationType);
			masterLocations.add(locationMaster);
		}
		return masterLocations;
	}

}
