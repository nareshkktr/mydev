package com.kasisripriyawebapps.myindia.serviceimpl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.constants.LocationConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.dao.UserImportExportDao;
import com.kasisripriyawebapps.myindia.dto.ElectroralRollPDFHeaderData;
import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.service.UserImportExportService;
import com.kasisripriyawebapps.myindia.util.AmazonS3Util;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class UserImportExportServiceImpl implements UserImportExportService {

	static WebDriver driver;
	@Autowired
	private Environment env;

	@Autowired
	UserImportExportDao userImportExportDao;

	@Autowired
	UserDao userDao;

	static {
		System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
	}

	@Override
	@Transactional
	public void exportStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException, RecordNotFoundException {

		driver = new ChromeDriver();
		driver.get(env.getProperty("india-electroral-rolles.url"));
		WebElement pageMainTable = driver.findElement(By.id("Table_01"));
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		WebElement pageMainTableMainRow = pageMainTableBody.findElements(By.xpath("tr")).get(3);
		WebElement pageMainTableMainRowMainCel = pageMainTableMainRow.findElements(By.xpath("td")).get(0);
		WebElement pageMainTableMainRowMainCelTable = pageMainTableMainRowMainCel.findElements(By.xpath("table"))
				.get(0);
		WebElement pageMainTableMainRowMainCelTableTbody = pageMainTableMainRowMainCelTable
				.findElements(By.xpath("tbody")).get(0);
		WebElement pageMainTableMainRowMainCelTableTbodyTr = pageMainTableMainRowMainCelTableTbody
				.findElements(By.xpath("tr")).get(0);
		WebElement pageMainTableMainRowMainCelTableTbodyTd = pageMainTableMainRowMainCelTableTbodyTr
				.findElements(By.xpath("td")).get(1);

		WebElement pageMainTableMainRowMainCelTableTbodyTdTable = pageMainTableMainRowMainCelTableTbodyTd
				.findElements(By.xpath("table")).get(0);

		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbody = pageMainTableMainRowMainCelTableTbodyTdTable
				.findElements(By.xpath("tbody")).get(0);

		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTr = pageMainTableMainRowMainCelTableTbodyTdTableTbody
				.findElements(By.xpath("tr")).get(1);
		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTd = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTr
				.findElements(By.xpath("td")).get(0);

		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTable = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTd
				.findElements(By.xpath("table")).get(0);

		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbody = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTable
				.findElements(By.xpath("tbody")).get(0);

		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTr = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbody
				.findElements(By.xpath("tr")).get(2);
		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTrTd = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTr
				.findElements(By.xpath("td")).get(0);
		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTrTdTable = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTrTd
				.findElements(By.xpath("table")).get(0);
		WebElement pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTrTdTableTbody = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTrTdTable
				.findElements(By.xpath("tbody")).get(0);
		List<WebElement> statesTableRowsWithHeader = pageMainTableMainRowMainCelTableTbodyTdTableTbodyTrTdTableTbodyTrTdTableTbody
				.findElements(By.xpath("tr"));

		int i = 0;
		for (WebElement row : statesTableRowsWithHeader) {
			if (i == 0) {
				i++;
				continue;
			}
			List<WebElement> cells = row.findElements(By.xpath("td"));
			WebElement eachRowStateCell = cells.get(0);
			WebElement eachRowStateCellOne = cells.get(2);
			String stateUrl = "";
			if (eachRowStateCell.getText().trim().equalsIgnoreCase(electroralRollesURL.getStateName())) {
				WebElement eachRowStateCellLink = eachRowStateCell.findElement(By.xpath("a"));
				stateUrl = eachRowStateCellLink.getAttribute("href");
			} else if (eachRowStateCellOne.getText().trim().equalsIgnoreCase(electroralRollesURL.getStateName())) {
				WebElement eachRowStateCellOneLink = eachRowStateCellOne.findElement(By.xpath("a"));
				stateUrl = eachRowStateCellOneLink.getAttribute("href");
			}
			if (eachRowStateCell.getText().trim().equalsIgnoreCase(electroralRollesURL.getStateName())
					|| eachRowStateCellOne.getText().trim().equalsIgnoreCase(electroralRollesURL.getStateName())) {
				driver.close();
				driver.quit();
				processStateElectroralRollesUrls(electroralRollesURL, stateUrl);
				break;
			}
			i++;
		}
	}

	private void processStateElectroralRollesUrls(ElectroralRollesURL electroralRollesURL, String stateUrl)
			throws RecordNotFoundException, InternalServerException {

		switch (electroralRollesURL.getStateName()) {
		case LocationConstants.STATE_ANDHRA_PRADESH:
			handleAndhraPradeshTeleganaElectroralRollesURL(electroralRollesURL, stateUrl);
			break;
		case LocationConstants.STATE_TELANGANA:
			handleAndhraPradeshTeleganaElectroralRollesURL(electroralRollesURL, stateUrl);
			break;
		case LocationConstants.STATE_KARNATAKA:
			handleKarnatakaElectroralRollesURL(electroralRollesURL, stateUrl);
			break;
		default:
			throw new RecordNotFoundException(electroralRollesURL.getStateName() + ExceptionConstants.NOT_FOUND);
		}
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
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				} else if (obj == null) {
					cell.setCellType(Cell.CELL_TYPE_BLANK);
				}
			}
		}
	}

	private void handleAndhraPradeshTeleganaElectroralRollesURL(ElectroralRollesURL electroralRollesURL,
			String stateUrl) throws InternalServerException {

		driver = new ChromeDriver();
		driver.get(stateUrl);

		String bucketName = env.getProperty("amazon.s3.users.bucket.name");
		String fileName = env.getProperty("project.electroral.url.data-file-name");
		String uploadedFolderName = env.getProperty("amazon.s3.users.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.users.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.users.india.folder.name");

		TreeMap<Integer, Object[]> electroralURLDaraMp = new TreeMap<Integer, Object[]>();

		Select districtDropDown = new Select(driver.findElement(By.id("ddlDist")));
		List<WebElement> districtOptions = districtDropDown.getOptions();

		// Iterate districts
		for (int i = 0; i < districtOptions.size(); i++) {

			Select refreshedDistrictDropDown = new Select(driver.findElement(By.id("ddlDist")));
			WebElement districtOption = refreshedDistrictDropDown.getOptions().get(i);
			if (i == 0) {
				continue;
			}
			districtOption.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}
			String districtNoName = new Select(driver.findElement(By.id("ddlDist"))).getOptions().get(i).getText();
			String districtName = districtNoName.split("-")[1];
			if (electroralRollesURL.getDistrictName() != null && !electroralRollesURL.getDistrictName().isEmpty()) {
				if (!districtName.equalsIgnoreCase(electroralRollesURL.getDistrictName())) {
					continue;
				}
			}
			Select mlaConstituencyDropDown = new Select(driver.findElement(By.id("ddlAC")));
			List<WebElement> mlaConstituencyOptions = mlaConstituencyDropDown.getOptions();
			for (int j = 0; j < mlaConstituencyOptions.size(); j++) {

				electroralURLDaraMp = new TreeMap<Integer, Object[]>();

				Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);
				if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
					exportWorkBook.removeSheetAt(0);
				}
				Sheet exportWorkBookSheet = exportWorkBook
						.createSheet(ServiceConstants.USER_EXCEL_BY_CONSTITUENCT_SHEET_NAME);

				addHeaderRow(exportWorkBookSheet);

				Select refreshedMlaConstituencyDropDown = new Select(driver.findElement(By.id("ddlAC")));
				WebElement mlaConstituencyOption = refreshedMlaConstituencyDropDown.getOptions().get(j);
				if (j == 0) {
					continue;
				}
				mlaConstituencyOption.click();

				String mlaConstituencyNoName = new Select(driver.findElement(By.id("ddlAC"))).getOptions().get(j)
						.getText();
				String mlaConstituencyName = mlaConstituencyNoName.split("-")[1];
				int mlaConstituencyNo = Integer.parseInt(mlaConstituencyNoName.split("-")[0].trim());
				if (electroralRollesURL.getMlaConstituencyName() != null
						&& !electroralRollesURL.getMlaConstituencyName().isEmpty()) {
					if (!mlaConstituencyName.equalsIgnoreCase(electroralRollesURL.getMlaConstituencyName())) {
						continue;
					}
				}

				WebElement getPollingStationButton = driver.findElement(By.id("btnGetPollingStations"));
				getPollingStationButton.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					throw new InternalServerException(e.getMessage());
				}
				getPollingStationElectorsUrls(electroralRollesURL, districtName, mlaConstituencyName, mlaConstituencyNo,
						electroralURLDaraMp);

				writeDataIntoSheet(electroralURLDaraMp, exportWorkBookSheet);
				// writeExcelDataIntoFile(outPutFilePath, exportWorkBook);

				String eachUploadedFolderName = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
						+ ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX
						+ electroralRollesURL.getStateName() + ApplicationConstants.SUFFIX
						+ electroralRollesURL.getDistrictName() + ApplicationConstants.SUFFIX + mlaConstituencyName;

				AmazonS3Util.writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName,
						eachUploadedFolderName);

			}
		}

		driver.close();
		driver.quit();
	}

	private void saveStateElectroralRollesURLData(ElectroralRollesURL electroralRollesURL,
			List<ElectroralRollesURL> pdfElectroralRollesUrlList,
			List<ElectroralRollesURL> existingElectroralRollesUrlList,
			List<ElectroralRollesURL> newElectroralRollesUrlList) throws InternalServerException {
		System.out.println(newElectroralRollesUrlList.size());
		userImportExportDao.saveElectroralRollesURLData(newElectroralRollesUrlList);
		newElectroralRollesUrlList.clear();
		List<ElectroralRollesURL> updatedElectroralRollesUrlList = findUpdatedElectroralRollesURLData(
				existingElectroralRollesUrlList, pdfElectroralRollesUrlList);
		userImportExportDao.updateElectroralRollesURLData(updatedElectroralRollesUrlList);
		existingElectroralRollesUrlList.removeAll(pdfElectroralRollesUrlList);
		userImportExportDao.deleteeElectroralRollesURLData(existingElectroralRollesUrlList);
	}

	private List<ElectroralRollesURL> findUpdatedElectroralRollesURLData(
			List<ElectroralRollesURL> existingElectroralRollesUrlList,
			List<ElectroralRollesURL> pdfElectroralRollesUrlList) {

		List<ElectroralRollesURL> updatedElectroralRollesUrlList = new ArrayList<ElectroralRollesURL>();
		Map<String, List<ElectroralRollesURL>> existingElectroralRollesUrlMap = existingElectroralRollesUrlList.stream()
				.collect(Collectors.groupingBy(electroralRollObject -> electroralRollObject.getStateName()
						+ ServiceConstants.PIPE + electroralRollObject.getDistrictName() + ServiceConstants.PIPE
						+ electroralRollObject.getMlaConstituencyName() + ServiceConstants.PIPE
						+ electroralRollObject.getPollingStationName() + ServiceConstants.PIPE
						+ electroralRollObject.getPollingStationAddress()));
		if (pdfElectroralRollesUrlList != null && !pdfElectroralRollesUrlList.isEmpty()
				&& existingElectroralRollesUrlList != null && !existingElectroralRollesUrlList.isEmpty()) {
			for (ElectroralRollesURL eachPDFElectroralRolleData : pdfElectroralRollesUrlList) {
				if (existingElectroralRollesUrlList.contains(eachPDFElectroralRolleData)
						&& !updatedElectroralRollesUrlList.contains(eachPDFElectroralRolleData)) {
					eachPDFElectroralRolleData.setGuid(existingElectroralRollesUrlMap
							.get(eachPDFElectroralRolleData.getStateName() + ServiceConstants.PIPE
									+ eachPDFElectroralRolleData.getDistrictName() + ServiceConstants.PIPE
									+ eachPDFElectroralRolleData.getMlaConstituencyName() + ServiceConstants.PIPE
									+ eachPDFElectroralRolleData.getPollingStationName() + ServiceConstants.PIPE
									+ eachPDFElectroralRolleData.getPollingStationAddress())
							.get(0).getGuid());
					updatedElectroralRollesUrlList.add(eachPDFElectroralRolleData);
				}
			}
		}
		return updatedElectroralRollesUrlList;
	}

	private static void processAPTNPollingStationURLs(ElectroralRollesURL electroralRollesURL, String districtName,
			String mlaConstituencyName, int mlaConstituencyNo, int pollingStationIndex, int pollingStationSize,
			String existingPDFUrl, TreeMap<Integer, Object[]> electroralURLDaraMp) {
		if (pollingStationIndex < pollingStationSize) {
			WebElement pageMainTable = driver.findElement(By.id("GridView1"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> statesTableRowsWithHeader = pageMainTableBody.findElements(By.xpath("tr"));

			WebElement row = statesTableRowsWithHeader.get(pollingStationIndex);

			List<WebElement> cells = row.findElements(By.xpath("td"));
			WebElement partNoCell = cells.get(0);
			WebElement polingStationNameCell = cells.get(1);
			WebElement polingStationAddressCell = cells.get(2);
			WebElement downloadPdfEnglishCell = cells.get(4);

			String polingStationName = polingStationNameCell.getText().trim();
			String polingStationAddress = polingStationAddressCell.getText().trim();
			Integer partNo = Integer.parseInt(partNoCell.getText().trim());

			String pdfUrl = "";
			if (pollingStationIndex == 1) {
				pdfUrl = getPDFURL(downloadPdfEnglishCell);
				pdfUrl = pdfUrl.replace("\\", "\\\\");
				existingPDFUrl = pdfUrl;
			} else {
				pdfUrl = prepareNextPdfUrl(existingPDFUrl, pollingStationIndex);
			}

			System.out.println("pdfUrl>>" + pollingStationIndex + ">>" + pdfUrl);

			Integer rowNo = 0;
			if (electroralURLDaraMp != null) {
				if (!electroralURLDaraMp.keySet().isEmpty()) {
					rowNo = electroralURLDaraMp.lastKey();
				}
				electroralURLDaraMp.put(rowNo + 1,
						new Object[] { electroralRollesURL.getStateName(), districtName, mlaConstituencyName,
								mlaConstituencyNo, partNo, polingStationName, polingStationAddress, pdfUrl });
			}

			processAPTNPollingStationURLs(electroralRollesURL, districtName, mlaConstituencyName, mlaConstituencyNo,
					pollingStationIndex + 1, statesTableRowsWithHeader.size(), existingPDFUrl, electroralURLDaraMp);

		}

	}

	private void addHeaderRow(Sheet exportWorkBookSheet) {

		Row headerRow = exportWorkBookSheet.createRow(0);

		Cell stateNameHeaderCell = headerRow.createCell(0);
		Cell districtNameHeaderCell = headerRow.createCell(1);
		Cell mlaConstituencyNameHeaderCell = headerRow.createCell(2);
		Cell mlaConstituencyNoHeaderCell = headerRow.createCell(3);
		Cell polingStationNoHeaderCell = headerRow.createCell(4);
		Cell polingStationNameHeaderCell = headerRow.createCell(5);
		Cell polingStationLocationHeaderCell = headerRow.createCell(6);
		Cell pdfUrlHeaderCell = headerRow.createCell(7);

		stateNameHeaderCell.setCellValue(ServiceConstants.LOCATION_STATE_TYPE);
		districtNameHeaderCell.setCellValue(ServiceConstants.LOCATION_DISTRICT_TYPE);
		mlaConstituencyNameHeaderCell.setCellValue(ServiceConstants.LOCATION_MLA_CONSTITUENCT_TYPE);
		mlaConstituencyNoHeaderCell.setCellValue(ServiceConstants.LOCATION_MLA_CONSTITUENCY_NO);
		polingStationNoHeaderCell.setCellValue(ServiceConstants.POLING_STATION_NO);
		polingStationNameHeaderCell.setCellValue(ServiceConstants.POLING_STATION_NAME);
		polingStationLocationHeaderCell.setCellValue(ServiceConstants.POLING_STATION_ADDRESS);
		pdfUrlHeaderCell.setCellValue(ServiceConstants.LOCATION_STATE_TYPE);

	}

	private static String prepareNextPdfUrl(String existingPDFUrl, int pollingStationIndex) {

		String nextPDFUrl = "";

		int dotLastIndex = existingPDFUrl.lastIndexOf(".");
		String[] mainUrlWithIndexArray = { existingPDFUrl.substring(0, dotLastIndex),
				existingPDFUrl.substring(dotLastIndex) };

		String mainUrl = mainUrlWithIndexArray[0];
		String extension = mainUrlWithIndexArray[1];

		int baclSlachLastIndex = mainUrl.lastIndexOf("\\");
		String[] mainUrlWithIndex = { mainUrl.substring(0, baclSlachLastIndex), mainUrl.substring(baclSlachLastIndex) };

		String existingURL = mainUrlWithIndex[0];
		String currentValue = mainUrlWithIndex[1];

		String currentValueWithoutP = currentValue.split("P")[0];

		currentValueWithoutP = currentValueWithoutP + "P";

		if (pollingStationIndex < 10) {
			currentValueWithoutP += "00" + pollingStationIndex;
		} else if (pollingStationIndex >= 10 && pollingStationIndex < 100) {
			currentValueWithoutP += "0" + pollingStationIndex;
		} else {
			currentValueWithoutP += pollingStationIndex;
		}

		nextPDFUrl = existingURL + currentValueWithoutP + extension;

		return nextPDFUrl;
	}

	private static void getPollingStationElectorsUrls(ElectroralRollesURL electroralRollesURL, String districtName,
			String mlaConstituencyName, int mlaConstituencyNo, TreeMap<Integer, Object[]> sheetData) {

		WebElement pageMainTable = driver.findElement(By.id("GridView1"));
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> statesTableRowsWithHeader = pageMainTableBody.findElements(By.xpath("tr"));

		if (statesTableRowsWithHeader != null && !statesTableRowsWithHeader.isEmpty()) {

			processAPTNPollingStationURLs(electroralRollesURL, districtName, mlaConstituencyName, mlaConstituencyNo, 1,
					statesTableRowsWithHeader.size(), "", sheetData);
		}

	}

	private static String getPDFURL(WebElement downloadPdfEnglishCell) {
		String pdfUrl = "";
		String originalHandle = driver.getWindowHandle();
		downloadPdfEnglishCell.click();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				pdfUrl = driver.getCurrentUrl();
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);

		return pdfUrl;
	}

	private void handleKarnatakaElectroralRollesURL(ElectroralRollesURL electroralRollesURL, String stateUrl)
			throws InternalServerException {
		driver = new ChromeDriver();
		driver.get(stateUrl);

		WebElement districtMainTable = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
		WebElement districtMainTableTbody = districtMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> districtTableRowsWithHeader = districtMainTableTbody.findElements(By.xpath("tr"));

		processKarnatakaDistrict(electroralRollesURL, 1, districtTableRowsWithHeader.size());

		driver.close();
		driver.quit();

	}

	private static void processKarnatakaDistrict(ElectroralRollesURL electroralRollesURL, int districtNo,
			int districtSize) throws InternalServerException {

		if (districtNo < districtSize) {

			WebElement districtMainTable = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
			WebElement districtMainTableTbody = districtMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> districtTableRowsWithHeader = districtMainTableTbody.findElements(By.xpath("tr"));

			WebElement district = districtTableRowsWithHeader.get(districtNo);
			List<WebElement> cells = district.findElements(By.xpath("td"));
			WebElement districtNameCell = cells.get(1);

			String districtName = districtNameCell.getText().trim().replaceAll("[^A-Za-z]+", "");

			Boolean moveForward = false;
			if (electroralRollesURL.getDistrictName() != null && !electroralRollesURL.getDistrictName().isEmpty()) {
				if (districtName.equalsIgnoreCase(electroralRollesURL.getDistrictName())) {
					moveForward = true;
				}
			} else {
				moveForward = true;
			}

			if (moveForward) {
				districtNameCell.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					throw new InternalServerException(e.getMessage());
				}
				WebElement mlaCostituencyMainTable = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
				WebElement mlaCostituencyMainTableTbody = mlaCostituencyMainTable.findElements(By.xpath("tbody"))
						.get(0);
				List<WebElement> mandalTableRowsWithHeader = mlaCostituencyMainTableTbody.findElements(By.xpath("tr"));

				processKarnatakaDistrictMLAConstituency(electroralRollesURL, 1, mandalTableRowsWithHeader.size(),
						districtNo, districtSize, districtName);

			} else {
				processKarnatakaDistrict(electroralRollesURL, districtNo + 1, districtSize);
			}
		}

	}

	private static void processKarnatakaDistrictMLAConstituency(ElectroralRollesURL electroralRollesURL,
			int mlaConstituencyNo, int mlaConstituencySize, int districtNo, int districtSize, String districtName)
			throws InternalServerException {

		if (mlaConstituencyNo < mlaConstituencySize) {

			WebElement mlaCostituencyMainTable = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
			WebElement mlaCostituencyMainTableTbody = mlaCostituencyMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> mandalTableRowsWithHeader = mlaCostituencyMainTableTbody.findElements(By.xpath("tr"));

			WebElement mlaConstituency = mandalTableRowsWithHeader.get(mlaConstituencyNo);

			List<WebElement> mlaConstituencyData = mlaConstituency.findElements(By.xpath("td"));
			WebElement mlaConstituencyNameCell = mlaConstituencyData.get(1);

			String mlaConstituencyName = mlaConstituencyNameCell.getText().trim().replaceAll("[^A-Za-z]+", "");

			Boolean moveForward = false;
			if (electroralRollesURL.getMlaConstituencyName() != null
					&& !electroralRollesURL.getMlaConstituencyName().isEmpty()) {
				if (mlaConstituencyName.equalsIgnoreCase(electroralRollesURL.getMlaConstituencyName())) {
					moveForward = true;
				}
			} else {
				moveForward = true;
			}

			if (moveForward) {
				mlaConstituencyNameCell.click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					throw new InternalServerException(e.getMessage());
				}

				processKarnatakaDistrictMLAPollingStation(electroralRollesURL, mlaConstituencyNo, mlaConstituencySize,
						districtNo, districtSize, districtName, mlaConstituencyName);
			} else {
				processKarnatakaDistrictMLAConstituency(electroralRollesURL, mlaConstituencyNo + 1, mlaConstituencySize,
						districtNo, districtSize, districtName);
			}
		} else {
			driver.navigate().back();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}

			processKarnatakaDistrict(electroralRollesURL, districtNo + 1, districtSize);
		}
	}

	private static void processKarnatakaDistrictMLAPollingStation(ElectroralRollesURL electroralRollesURL,
			int mlaConstituencyNo, int mlaConstituencySize, int districtNo, int districtSize, String districtName,
			String mlaConstituencyName) throws InternalServerException {

		WebElement pollingStationMainTable = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
		WebElement pollingStationMainTableTbody = pollingStationMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> pollingStationTableRowsWithHeader = pollingStationMainTableTbody.findElements(By.xpath("tr"));
		int k = 0;
		for (WebElement polingStation : pollingStationTableRowsWithHeader) {
			if (k == 0) {
				k++;
				continue;
			}
			List<WebElement> polingStationData = polingStation.findElements(By.xpath("td"));
			WebElement polingStationAddressCell = polingStationData.get(2);
			WebElement mlaConstituencyNoCell = polingStationData.get(1);

			String polingStationAddress = polingStationAddressCell.getText();

			Boolean moveForward = false;
			if (electroralRollesURL.getPollingStationAddress() != null
					&& !electroralRollesURL.getPollingStationAddress().isEmpty()) {
				if (polingStationAddress.equalsIgnoreCase(electroralRollesURL.getPollingStationAddress())) {
					moveForward = true;
				}
			} else {
				moveForward = true;
			}

			if (moveForward) {

				WebElement eachRowPdfCellLink = polingStationAddressCell.findElement(By.xpath("a"));
				String pdfUrl = eachRowPdfCellLink.getAttribute("href");

				ElectroralRollesURL electroralRolleURL = new ElectroralRollesURL();
				electroralRolleURL.setDistrictName(districtName);
				electroralRolleURL.setMlaConstituencyName(mlaConstituencyName);
				electroralRolleURL.setMlaConstituencyNo(Integer.parseInt(mlaConstituencyNoCell.getText().trim()));
				electroralRolleURL.setStateName(electroralRollesURL.getStateName());
				electroralRolleURL.setPollingStationName(null);
				electroralRolleURL.setPollingStationAddress(polingStationAddress);
				electroralRolleURL.setPdfUrl(pdfUrl);

			}

			k++;
		}

		driver.navigate().back();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}

		processKarnatakaDistrictMLAConstituency(electroralRollesURL, mlaConstituencyNo + 1, mlaConstituencySize,
				districtNo, districtSize, districtName);
	}

	@Override
	@Transactional
	public void exportElectroralRolleData(ElectroralRollesURL electroralRollesURL) throws InternalServerException {

		List<ElectroralRollesURL> electroralRollesUrlList = userImportExportDao
				.getElectroralRollesURLData(electroralRollesURL);

		if (electroralRollesUrlList != null) {
			for (ElectroralRollesURL eachURLData : electroralRollesUrlList) {
				List<User> eachPageUsers = parseElectroralData(eachURLData);
				if (CommonUtil.isListNotNullAndNotEmpty(eachPageUsers)) {
					exportUsersToExcel(eachURLData, eachPageUsers);
				}
			}
		}

	}

	private void exportUsersToExcel(ElectroralRollesURL eachURLData, List<User> eachPageUsers)
			throws InternalServerException {

		String fileName = eachURLData.getPartNo() + ".xls";
		
		String bucketName = env.getProperty("amazon.s3.users.bucket.name");
		String uploadedFolderName = env.getProperty("amazon.s3.users.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.users.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.users.india.folder.name");
		
		String votersFolderName = env.getProperty("amazon.s3.users.voters.folder.name");
		
		uploadedFolderName = uploadedFolderName +ApplicationConstants.SUFFIX
				+ globalFolderName + ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX + eachURLData.getStateName()
				+ ApplicationConstants.SUFFIX + eachURLData.getDistrictName() + ApplicationConstants.SUFFIX + eachURLData.getMlaConstituencyName() +
				ApplicationConstants.SUFFIX + votersFolderName ;
		
		
		Workbook exportWorkBook = CommonUtil.createWorkBook(fileName);

		if (exportWorkBook.getNumberOfSheets() == 1 && exportWorkBook.getSheetAt(0) != null) {
			exportWorkBook.removeSheetAt(0);
		}
		Sheet exportWorkBookSheet = exportWorkBook.createSheet(ServiceConstants.USER_EXCEL_BY_CONSTITUENCT_SHEET_NAME);
		addHeaderRowForUserExport(exportWorkBookSheet);

		//prepare sheet data
		Map<Integer, Object[]> sheetData = new HashMap<Integer, Object[]>();
		
		int j=0;
		
		for (User eachPageUser : eachPageUsers) {
			j++;
			sheetData.put(j, new Object[] { eachPageUser.getAge(), eachPageUser.getAssemblyConstituencyName(), eachPageUser.getAssemblyConstituencyNo(), eachPageUser.getDistrict(),
					eachPageUser.getElectorName(), eachPageUser.getGender(), eachPageUser.getHouseNo(), eachPageUser.getIdCardNo(), eachPageUser.getReferenceName(), eachPageUser.getReferenceType(),
					eachPageUser.getState(), eachPageUser.getPollingStation(), eachPageUser.getPollingStationAddress(), eachPageUser.getPartNo(), eachPageUser.getMainTwon(), eachPageUser.getPoliceStation(),
					eachPageUser.getMandal(), eachPageUser.getRevenueDivision(), eachPageUser.getPincode(), eachPageUser.getParliamentaryConstituencyNo(), eachPageUser.getParliamentaryConstituencyName()});
		}
		
		writeDataIntoSheet(sheetData, exportWorkBookSheet);
		AmazonS3Util.writeExcelDataIntoAmazonS3File(fileName, exportWorkBook, bucketName, uploadedFolderName);

	}

	private void addHeaderRowForUserExport(Sheet exportWorkBookSheet) {
		Row headerRow = exportWorkBookSheet.createRow(0);

		Cell ageHeaderCell = headerRow.createCell(0);
		Cell assemblyConstituencyNameHeaderCell = headerRow.createCell(1);
		Cell assemblyConstituencyNoHeaderCell = headerRow.createCell(2);
		Cell districtHeaderCell = headerRow.createCell(3);
		Cell electorNameHeaderCell = headerRow.createCell(4);
		Cell genderHeaderCell = headerRow.createCell(5);
		Cell houseNoHeaderCell = headerRow.createCell(6);
		Cell idCardNoHeaderCell = headerRow.createCell(7);
		Cell referenceNameHeaderCell = headerRow.createCell(8);
		Cell referenceTypeHeaderCell = headerRow.createCell(9);
		Cell stateHeaderCell = headerRow.createCell(10);
		Cell pollingStationNameHeaderCell = headerRow.createCell(11);
		Cell pollingStationAddressHeaderCell = headerRow.createCell(12);
		Cell partNoHeaderCell = headerRow.createCell(13);
		Cell mainTownHeaderCell = headerRow.createCell(14);
		Cell policeStationHeaderCell = headerRow.createCell(15);
		Cell mandalHeaderCell = headerRow.createCell(16);
		Cell revenueDivisionHeaderCell = headerRow.createCell(17);
		Cell pinCodeHeaderCell = headerRow.createCell(18);
		Cell parliamentConstituencyNoHeaderCell = headerRow.createCell(19);
		Cell parliamentConstituencyNmaeHeaderCell = headerRow.createCell(20);

		ageHeaderCell.setCellValue(ServiceConstants.AGE);
		assemblyConstituencyNameHeaderCell.setCellValue(ServiceConstants.ASSEMBLY_CONSTITUENCY_NAME);
		assemblyConstituencyNoHeaderCell.setCellValue(ServiceConstants.ASSEMBLY_CONSTITUENCY_NO);
		districtHeaderCell.setCellValue(ServiceConstants.DISTRICT);
		electorNameHeaderCell.setCellValue(ServiceConstants.ELECTOR_NAME);
		genderHeaderCell.setCellValue(ServiceConstants.GENDER);
		houseNoHeaderCell.setCellValue(ServiceConstants.HOUSE_NO);
		idCardNoHeaderCell.setCellValue(ServiceConstants.ID_CARD_NO);
		referenceNameHeaderCell.setCellValue(ServiceConstants.REFERENCE_NAME);
		referenceTypeHeaderCell.setCellValue(ServiceConstants.REFERENCE_TYPE);
		stateHeaderCell.setCellValue(ServiceConstants.STATE);
		pollingStationNameHeaderCell.setCellValue(ServiceConstants.POLING_STATION_NAME);
		pollingStationAddressHeaderCell.setCellValue(ServiceConstants.POLING_STATION_ADDRESS);
		partNoHeaderCell.setCellValue(ServiceConstants.PART_NO);
		mainTownHeaderCell.setCellValue(ServiceConstants.MAIN_TOWN);
		policeStationHeaderCell.setCellValue(ServiceConstants.POLICE_STATION);
		mandalHeaderCell.setCellValue(ServiceConstants.MANDAL);
		revenueDivisionHeaderCell.setCellValue(ServiceConstants.REVENUE_DIVISION);
		pinCodeHeaderCell.setCellValue(ServiceConstants.PIN_CODE);
		parliamentConstituencyNoHeaderCell.setCellValue(ServiceConstants.PARLIAMENT_CONSTITUENCY_NO);
		parliamentConstituencyNmaeHeaderCell.setCellValue(ServiceConstants.PARLIAMENT_CONSTITUENCY_NAME);

	}

	@Override
	@Transactional
	public void importElectroralRolleData(ElectroralRollesURL electroralRollesURL) throws InternalServerException {

		List<ElectroralRollesURL> electroralRollesUrlList = userImportExportDao
				.getElectroralRollesURLData(electroralRollesURL);
		
		
		List<User> pdfElectroralRollesList = new ArrayList<User>();
		List<User> newElectroralRollesList = new ArrayList<User>();
		
		//Load existing user data
		List<User> existingElectroralRollesList = userDao
				.getElectroralRollesData(electroralRollesURL);

		if (electroralRollesUrlList != null) {

			for (ElectroralRollesURL eachURLData : electroralRollesUrlList) {
				extractDataFromUsersFile(eachURLData,pdfElectroralRollesList,newElectroralRollesList,existingElectroralRollesList);
			}
		}
		
//		if (users != null && !users.isEmpty()) {
////			userDao.saveUsers(users);
//		}
		
		saveElectroralRollesData(electroralRollesURL, pdfElectroralRollesList,
				existingElectroralRollesList, newElectroralRollesList);
		

	}

	private void saveElectroralRollesData(ElectroralRollesURL electroralRollesURL, List<User> pdfElectroralRollesList,
			List<User> existingElectroralRollesList, List<User> newElectroralRollesList) throws InternalServerException {
		
		System.out.println(newElectroralRollesList.size());
		userDao.saveUsers(newElectroralRollesList);
		newElectroralRollesList.clear();
		List<User> updatedElectroralRollesList = findUpdatedElectroralRollesData(
				existingElectroralRollesList, pdfElectroralRollesList);
		userDao.updateUsers(updatedElectroralRollesList);
		existingElectroralRollesList.removeAll(pdfElectroralRollesList);
		
		for(User existingElectroralRolle:existingElectroralRollesList){
			existingElectroralRolle.setIsActive(false);
		}
		
		// Identify list of users and mark those as inactive.
		userDao.updateUsers(existingElectroralRollesList);
		
	}

	private List<User> findUpdatedElectroralRollesData(List<User> existingElectroralRollesList,
			List<User> pdfElectroralRollesList) throws InternalServerException{
		
		List<User> updatedElectroralRollesList = new ArrayList<User>();
		Map<String, List<User>> existingElectroralRollesMap = existingElectroralRollesList.stream()
				.collect(Collectors.groupingBy(userObject -> userObject.getIdCardNo()));
		
		if (pdfElectroralRollesList != null && !pdfElectroralRollesList.isEmpty()
				&& existingElectroralRollesList != null && !existingElectroralRollesList.isEmpty()) {
			for (User eachPDFElectroralRolleData : pdfElectroralRollesList) {
				if (existingElectroralRollesList.contains(eachPDFElectroralRolleData)
						&& !updatedElectroralRollesList.contains(eachPDFElectroralRolleData)) {
					eachPDFElectroralRolleData.setGuid(existingElectroralRollesMap
							.get(eachPDFElectroralRolleData.getIdCardNo() )
							.get(0).getGuid());
					eachPDFElectroralRolleData.setCreatedTimeStamp(existingElectroralRollesMap
							.get(eachPDFElectroralRolleData.getIdCardNo() )
							.get(0).getCreatedTimeStamp());
					updatedElectroralRollesList.add(eachPDFElectroralRolleData);
				}
			}
		}
		return updatedElectroralRollesList;
	}

	private void extractDataFromUsersFile(ElectroralRollesURL eachURLData, List<User> pdfElectroralRollesList,List<User> newElectroralRollesList,List<User> existingElectroralRollesList) throws InternalServerException {

		String hostName = env.getProperty("amazon.s3.host.name");
		String bucketName = env.getProperty("amazon.s3.users.bucket.name");
		String uploadedFolderName = env.getProperty("amazon.s3.users.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.users.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.users.india.folder.name");
		
		String votersFolderName = env.getProperty("amazon.s3.users.voters.folder.name");

		String filePath = hostName + bucketName + ApplicationConstants.SUFFIX + uploadedFolderName +ApplicationConstants.SUFFIX
							+ globalFolderName + ApplicationConstants.SUFFIX + countryFolderName + ApplicationConstants.SUFFIX + eachURLData.getStateName()
							+ ApplicationConstants.SUFFIX + eachURLData.getDistrictName() + ApplicationConstants.SUFFIX + eachURLData.getMlaConstituencyName() +
							ApplicationConstants.SUFFIX + votersFolderName  + ApplicationConstants.SUFFIX + eachURLData.getPartNo()+".xls";

		System.out.println(filePath);
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(filePath);
	
		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {
			if (i < 1) {
				i++;
				continue;
			}
			
			Integer age = (int) eachRow.getCell(0).getNumericCellValue();
			String acName = eachRow.getCell(1).getStringCellValue();
			Integer acNo = (int) eachRow.getCell(2).getNumericCellValue();
			String districtName = eachRow.getCell(3).getStringCellValue();
			String electorName = eachRow.getCell(4).getStringCellValue();
			String sex = eachRow.getCell(5).getStringCellValue();
			String houseNo = eachRow.getCell(6).getStringCellValue();
			String voterId = eachRow.getCell(7).getStringCellValue();
			String referenceName = eachRow.getCell(8).getStringCellValue();
			String referenceType = eachRow.getCell(9).getStringCellValue();
			String stateName = eachRow.getCell(10).getStringCellValue();
			String pollingStationName = eachRow.getCell(11).getStringCellValue();
			String pollingStationAddress = eachRow.getCell(12).getStringCellValue();
			Integer partNo = (int)eachRow.getCell(13).getNumericCellValue();
			String mainTown = eachRow.getCell(14).getStringCellValue();
			String policeStation = eachRow.getCell(15).getStringCellValue();
			String mandal = eachRow.getCell(16).getStringCellValue();
			String revenueDivision = eachRow.getCell(17).getStringCellValue();
			String pinCode = eachRow.getCell(18).getStringCellValue();
			Integer pcNo = (int) eachRow.getCell(19).getNumericCellValue();
			String pcName = eachRow.getCell(20).getStringCellValue();
	
			User user = new User();
			user.setAge(age);
			user.setAssemblyConstituencyName(acName);
			user.setAssemblyConstituencyNo(acNo);
			user.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			user.setUpdatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			user.setDistrict(districtName);
			user.setElectorName(electorName);
			user.setGender(sex);
			user.setHouseNo(houseNo);
			user.setIdCardNo(voterId);
			user.setIdCardType(ApplicationConstants.IDENTITY_CARD_TYPE_VOTER_ID);
			user.setReferenceName(referenceName);
			user.setReferenceType(referenceType);
			user.setState(stateName);
			user.setPollingStation(pollingStationName);
			user.setPollingStationAddress(pollingStationAddress);
			user.setPartNo(partNo);
			user.setMainTwon(mainTown);
			user.setPoliceStation(policeStation);
			user.setMandal(mandal);
			user.setRevenueDivision(revenueDivision);
			user.setPincode(pinCode);
			user.setParliamentaryConstituencyNo(pcNo);
			user.setParliamentaryConstituencyName(pcName);
			user.setIsActive(true);
			
	
			if (!newElectroralRollesList.contains(user)
					&& !existingElectroralRollesList.contains(user)) {
				newElectroralRollesList.add(user);
			}
			if (!pdfElectroralRollesList.contains(user)) {
				pdfElectroralRollesList.add(user);
			}
		}
	}

	private static List<User> parseElectroralData(ElectroralRollesURL eachURLData) {

		List<User> eachPageUsers = new ArrayList<User>();
		String pdfURL = eachURLData.getPdfUrl();
		if (pdfURL != null && !pdfURL.isEmpty()) {
			PdfReader reader = null;
			try {
				reader = new PdfReader(pdfURL);
			} catch (IOException e) {
				new InternalServerException(e.getMessage());
			}
			if (reader != null) {
				int noOfPages = reader.getNumberOfPages();
				TextExtractionStrategy strategy;

				ElectroralRollPDFHeaderData pdfHeaderData = getPDFHeaderData(eachURLData.getPdfUrl());

				for (int i = 1; i <= noOfPages; i++) {
					if (i < 3) {
						continue;
					}
					int ly = 30;
					int uy = 125;
					for (int j = 0; j < 10; j++) {
						int lx = 0;
						int ux = 175;

						for (int k = 0; k < 3; k++) {
							Rectangle rect = new Rectangle(lx, ly, ux, uy);

							RenderFilter filter = new RegionTextRenderFilter(rect);
							strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
							String tableContent = null;
							try {
								tableContent = PdfTextExtractor.getTextFromPage(reader, i, strategy);
							} catch (IOException e) {
								new InternalServerException(e.getMessage());
							}

							Boolean isProcessed = prepareUserObject(tableContent, eachPageUsers, eachURLData,
									pdfHeaderData);
							if (!isProcessed) {
								break;
							}
							lx = ux;
							ux = ux + 175;
						}

						ly = uy;
						uy = uy + 73;
					}
				}
				reader.close();
			}
		}
		return eachPageUsers;
	}

	private static ElectroralRollPDFHeaderData getPDFHeaderData(String pdfURL) {

		ElectroralRollPDFHeaderData pdfHeaderData = new ElectroralRollPDFHeaderData();

		PdfReader reader = null;
		try {
			reader = new PdfReader(pdfURL);
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}

		TextExtractionStrategy strategy;

		int ly = 370;
		int uy = 530;
		int lx = 320;
		int ux = 530;

		Rectangle rect = new Rectangle(lx, ly, ux, uy);

		RenderFilter filter = new RegionTextRenderFilter(rect);
		strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
		String tableContent = null;
		try {
			tableContent = PdfTextExtractor.getTextFromPage(reader, 1, strategy);
		} catch (IOException e) {
			e.printStackTrace();
			new InternalServerException(e.getMessage());
		}

		if (tableContent != null && !tableContent.isEmpty()) {
			String[] lines = tableContent.split("\n");
			int noOfLines = lines.length;
			if (lines != null && noOfLines != 0) {

				String mainTown = "";
				String policeStation = "";
				String mandal = "";
				String revenueDivision = "";
				String pinCode = "";// lines[10];
				
				
				for(int i=0;i<lines.length;i++){
					if(lines[i] != null && lines[i].contains("Main Town")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							if(linesSplit.length >= 2)
								mainTown = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Town");
							if(linesSplit.length >= 2)
								mainTown = linesSplit[1].trim();
						}
					}
					
					if(lines[i] != null && lines[i].contains("Police Station")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							if(linesSplit.length >= 2)
								policeStation = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Station");
							if(linesSplit.length >= 2)
								policeStation = linesSplit[1].trim();
						}
					}
					
					if(lines[i] != null && lines[i].contains("Mandal")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							if(linesSplit.length >= 2)
								mandal = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Mandal");
							if(linesSplit.length >= 2)
								mandal = linesSplit[0].trim();
						}
					}
					
					if(lines[i] != null && lines[i].contains("Revenue Division")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							if(linesSplit.length >= 2)
								revenueDivision = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Division");
							if(linesSplit.length >= 2)
								revenueDivision = linesSplit[1].trim();
						}
					}
					
					if(lines[i] != null && lines[i].contains("Pin Code")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							if(linesSplit.length >= 2)
								pinCode = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Code");
							if(linesSplit.length >= 2)
								pinCode = linesSplit[1].trim();
						}
					}
				}

				pdfHeaderData.setMainTown(mainTown);
				pdfHeaderData.setPoliceStation(policeStation);
				pdfHeaderData.setMandal(mandal);
				pdfHeaderData.setRevenueDivision(revenueDivision);
				pdfHeaderData.setPinCode(pinCode);


			}
		}

		int ly1 = 710;
		int uy1 = 730;
		int lx1 = 360;
		int ux1 = 500;

		Rectangle rect1 = new Rectangle(lx1, ly1, ux1, uy1);

		RenderFilter filter1 = new RegionTextRenderFilter(rect1);
		String tableContent1 = "";
		TextExtractionStrategy strategy1 = new FilteredTextRenderListener(new LocationTextExtractionStrategy(),
				filter1);
		try {
			tableContent1 = PdfTextExtractor.getTextFromPage(reader, 1, strategy1);
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}
		
		String mpConstituencyNo = tableContent1.trim().replaceAll("\\D+", "");
		String mpConstituencyName = tableContent1.trim().replaceAll("[^a-zA-Z]", "");

		if(mpConstituencyNo != null && !mpConstituencyNo.isEmpty())
			pdfHeaderData.setMpConstituencyNo(Integer.parseInt(mpConstituencyNo));
		
		if(mpConstituencyName != null && !mpConstituencyName.isEmpty())
			pdfHeaderData.setMpConstituencyName(mpConstituencyName);

		return pdfHeaderData;

	}

	private static boolean prepareUserObject(String tableContent, List<User> eachPageUsers,
			ElectroralRollesURL eachURLData, ElectroralRollPDFHeaderData pdfHeaderData) {

		Boolean isProcessed = true;

		String voterId = "";
		String electorName = "";
		String referenceType = "";
		String referenceName = "";
		String age = "";
		String houseNo = "";
		String sex = "";

		try {
			if (tableContent != null && !tableContent.trim().isEmpty()) {

				String[] lines = tableContent.split("\n");
				int noOfLines = lines.length;
				if (lines != null && noOfLines != 0) {

					// System.out.println(tableContent);
					// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

					int processingLineNo = noOfLines - 1;
					Map<String, String> sexMap = getSex(lines, processingLineNo);
					sex = sexMap.get("sexValue");
					processingLineNo = Integer.parseInt(sexMap.get("currentLineNo"));

					Map<String, String> ageMap = getAge(lines, processingLineNo);
					age = ageMap.get("ageValue");
					processingLineNo = Integer.parseInt(ageMap.get("currentLineNo"));

					Map<String, String> houseNoMap = getHouseNo(lines, processingLineNo);
					houseNo = houseNoMap.get("houseNoValue");
					processingLineNo = Integer.parseInt(houseNoMap.get("currentLineNo"));

					Map<String, String> referenceTypeMap = getReferenceType(lines, processingLineNo);
					referenceType = referenceTypeMap.get("referenceTypeValue");
					processingLineNo = Integer.parseInt(referenceTypeMap.get("currentLineNo"));

					Map<String, String> referenceNameMap = getReferenceName(lines, processingLineNo);
					referenceName = referenceNameMap.get("referenceNameValue");
					processingLineNo = Integer.parseInt(referenceNameMap.get("currentLineNo"));

					Map<String, String> electorNameMap = getElectorName(lines, processingLineNo);
					electorName = electorNameMap.get("electorNameValue");
					processingLineNo = Integer.parseInt(electorNameMap.get("currentLineNo"));

					Map<String, String> idCardNoMap = getVoterID(lines, processingLineNo);
					voterId = idCardNoMap.get("voterIdValue");
					processingLineNo = Integer.parseInt(idCardNoMap.get("currentLineNo"));

					User user = new User();
					
					if(age!= null && !age.trim().isEmpty())
						user.setAge(Integer.parseInt(age.trim()));
					
					user.setAssemblyConstituencyName(eachURLData.getMlaConstituencyName());
					user.setAssemblyConstituencyNo(eachURLData.getMlaConstituencyNo());
					user.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
					user.setDistrict(eachURLData.getDistrictName());
					user.setElectorName(electorName);
					user.setGender(sex);
					user.setHouseNo(houseNo);
					user.setIdCardNo(voterId);
					user.setIdCardType(ApplicationConstants.IDENTITY_CARD_TYPE_VOTER_ID);
					user.setReferenceName(referenceName);
					user.setReferenceType(referenceType);
					user.setState(eachURLData.getStateName());
					user.setPollingStation(eachURLData.getPollingStationName());
					user.setPollingStationAddress(eachURLData.getPollingStationAddress());
					user.setPartNo(eachURLData.getPartNo());
					user.setMainTwon(pdfHeaderData.getMainTown());
					user.setPoliceStation(pdfHeaderData.getPoliceStation());
					user.setMandal(pdfHeaderData.getMandal());
					user.setRevenueDivision(pdfHeaderData.getRevenueDivision());
					user.setPincode(pdfHeaderData.getPinCode());
					user.setParliamentaryConstituencyNo(pdfHeaderData.getMpConstituencyNo());
					user.setParliamentaryConstituencyName(pdfHeaderData.getMpConstituencyName());
					eachPageUsers.add(user);

				}
			}

		} catch (Exception ex) {
			isProcessed = false;
		}
		return isProcessed;
	}

	private static Map<String, String> getVoterID(String[] boxContent, int currentLineNo) {
		Map<String, String> voterIdMap = new HashMap<String, String>();
		String votreIdLine = boxContent[currentLineNo];
		String voterIdValue = "";
		if (votreIdLine != null && !votreIdLine.isEmpty()) {
			String votreIdLineSpaces[] = votreIdLine.split(" ");
			if (votreIdLineSpaces.length == 3) {
				voterIdValue = votreIdLineSpaces[2];
			} else {
				voterIdValue = votreIdLineSpaces[0];
			}
		}
		voterIdMap.put("voterIdValue", voterIdValue.trim());
		voterIdMap.put("currentLineNo", "" + currentLineNo);

		return voterIdMap;
	}

	private static Map<String, String> getSex(String[] boxContent, int currentLineNo) {
		Map<String, String> sexMap = new HashMap<String, String>();
		String sexAgeLine = boxContent[currentLineNo];
		String sexValue = "";
		if (sexAgeLine.equalsIgnoreCase(ServiceConstants.DELETE_USER)) {
			currentLineNo--;
			sexAgeLine = boxContent[currentLineNo];
		}

		String[] sexAgeLineSpaces = sexAgeLine.split(" ");
		if (sexAgeLineSpaces.length == 2) {
			sexValue = sexAgeLineSpaces[1];
			currentLineNo--;
		} else if (sexAgeLineSpaces.length == 1) {
			currentLineNo--;
			sexValue = boxContent[currentLineNo];
			currentLineNo--;
		} else if (sexAgeLineSpaces.length == 3) {
		} else if (sexAgeLineSpaces.length == 4) {
			sexValue = sexAgeLineSpaces[3];
		}
		sexMap.put("sexValue", sexValue);
		sexMap.put("currentLineNo", "" + currentLineNo);
		return sexMap;
	}

	private static Map<String, String> getReferenceType(String[] boxContent, int currentLineNo) {
		Map<String, String> houseNoMap = new HashMap<String, String>();
		int referenceTypeLineNo = currentLineNo;
		String referenceTypeLine = boxContent[referenceTypeLineNo];
		String referenceTypeValue = "";
		if (referenceTypeLine != null && !referenceTypeLine.isEmpty()) {
			while (!referenceTypeLine.contains(":")) {
				referenceTypeLineNo--;
				referenceTypeLine = boxContent[referenceTypeLineNo];
			}
			referenceTypeValue = referenceTypeLine.split(":")[0];
		}
		referenceTypeValue = referenceTypeValue.split(" ")[0].split("'s")[0];
		houseNoMap.put("referenceTypeValue", referenceTypeValue.trim());
		houseNoMap.put("currentLineNo", "" + currentLineNo);

		return houseNoMap;
	}

	private static Map<String, String> getElectorName(String[] boxContent, int currentLineNo) {
		Map<String, String> houseNoMap = new HashMap<String, String>();
		String electorNameLine = boxContent[currentLineNo];
		String electorNameValue = "";

		if (electorNameLine != null && !electorNameLine.isEmpty()) {
			while (!electorNameLine.contains(":")) {
				String electorMiddleName = boxContent[currentLineNo];
				currentLineNo--;
				electorNameValue = electorMiddleName.trim() + " " + electorNameValue.trim();
				electorNameLine = boxContent[currentLineNo];
			}

			if (electorNameLine.split(":").length == 2) {
				String electorMiddleName = electorNameLine.split(":")[1].trim();
				electorNameValue = electorMiddleName.trim() + " " + electorNameValue.trim();
			} else if (electorNameLine.split(":").length == 1 && electorNameValue.isEmpty()) {
				currentLineNo--;
				String electorMiddleName = boxContent[currentLineNo];
				electorNameValue = electorMiddleName.trim() + " " + electorNameValue.trim();
			}
		}

		currentLineNo--;

		houseNoMap.put("electorNameValue", electorNameValue.trim());
		houseNoMap.put("currentLineNo", "" + currentLineNo);

		return houseNoMap;
	}

	private static Map<String, String> getReferenceName(String[] boxContent, int currentLineNo) {
		Map<String, String> houseNoMap = new HashMap<String, String>();
		String referenceNameLine = boxContent[currentLineNo];
		String referenceNameValue = "";

		if (referenceNameLine != null && !referenceNameLine.isEmpty()) {
			while (!referenceNameLine.contains(":")) {
				String referenceMiddleName = boxContent[currentLineNo];
				currentLineNo--;
				referenceNameValue = referenceMiddleName.trim() + " " + referenceNameValue.trim();
				referenceNameLine = boxContent[currentLineNo];
			}

			if (referenceNameLine.split(":").length == 2) {
				String referenceMiddleName = referenceNameLine.split(":")[1].trim();
				referenceNameValue = referenceMiddleName.trim() + " " + referenceNameValue.trim();

			}
		}
		currentLineNo--;
		houseNoMap.put("referenceNameValue", referenceNameValue.trim());
		houseNoMap.put("currentLineNo", "" + currentLineNo);

		return houseNoMap;
	}

	private static Map<String, String> getHouseNo(String[] boxContent, int currentLineNo) {
		Map<String, String> houseNoMap = new HashMap<String, String>();
		String houseNoLine = boxContent[currentLineNo];

		String houseNoValue = "";

		if (houseNoLine != null && !houseNoLine.isEmpty()) {
			if (houseNoLine.contains(":")) {
				String[] houseNoLineSpaces = houseNoLine.split(":");
				if (houseNoLineSpaces.length == 1) {
					currentLineNo--;
					houseNoValue = boxContent[currentLineNo];
					currentLineNo--;
				} else if (houseNoLineSpaces.length == 2) {
					houseNoValue = houseNoLineSpaces[1];
					currentLineNo--;
				}
			} else {
				currentLineNo--;
				houseNoValue = boxContent[currentLineNo];
				currentLineNo--;
			}
		}

		houseNoMap.put("houseNoValue", houseNoValue.trim());
		houseNoMap.put("currentLineNo", "" + currentLineNo);

		return houseNoMap;
	}

	private static Map<String, String> getAge(String[] boxContent, int currentLineNo) {
		Map<String, String> ageMap = new HashMap<String, String>();
		String sexAgeLine = boxContent[currentLineNo];
		String[] sexAgeLineSpaces = sexAgeLine.split(" ");
		String ageValue = "";

		if (sexAgeLineSpaces.length == 2) {
			ageValue = sexAgeLineSpaces[1];
			currentLineNo--;

		} else if (sexAgeLineSpaces.length == 1) {
			currentLineNo--;
			ageValue = boxContent[currentLineNo];
			currentLineNo--;
		} else if (sexAgeLineSpaces.length == 4) {
			ageValue = sexAgeLineSpaces[1];
			currentLineNo--;
		}
		ageMap.put("ageValue", ageValue);
		ageMap.put("currentLineNo", "" + currentLineNo);

		return ageMap;
	}

	@Override
	@Transactional
	public void importStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL) throws InternalServerException {
		List<ElectroralRollesURL> pdfElectroralRollesUrlList = new ArrayList<ElectroralRollesURL>();
		List<ElectroralRollesURL> newElectroralRollesUrlList = new ArrayList<ElectroralRollesURL>();
		List<ElectroralRollesURL> existingElectroralRollesUrlList = userImportExportDao
				.getElectroralRollesURLData(electroralRollesURL);

		String hostName = env.getProperty("amazon.s3.host.name");
		String bucketName = env.getProperty("amazon.s3.users.bucket.name");
		String fileName = env.getProperty("project.electroral.url.data-file-name");
		String uploadedFolderName = env.getProperty("amazon.s3.users.uploaded.folder.name");

		String globalFolderName = env.getProperty("amazon.s3.users.global.folder.name");
		String countryFolderName = env.getProperty("amazon.s3.users.india.folder.name");

		uploadedFolderName = uploadedFolderName + ApplicationConstants.SUFFIX + globalFolderName
				+ ApplicationConstants.SUFFIX + countryFolderName;

		List<String> stateDirectories = AmazonS3Util.getListOfObjects(bucketName, uploadedFolderName);

		if (stateDirectories != null && stateDirectories.size() > 0) {
			for (String eachStateDirectoryPath : stateDirectories) {

				String[] pathSplit = eachStateDirectoryPath.split("/");
				String name = pathSplit[pathSplit.length - 1];

				if (electroralRollesURL.getStateName() != null && !electroralRollesURL.getStateName().isEmpty()) {
					if (!name.equalsIgnoreCase(electroralRollesURL.getStateName())) {
						continue;
					}
				}

				List<String> districtDirectories = AmazonS3Util.getListOfObjects(bucketName, eachStateDirectoryPath);

				if (districtDirectories != null && districtDirectories.size() > 0) {
					for (String eachStateDistrictDirectory : districtDirectories) {

						pathSplit = eachStateDistrictDirectory.split("/");
						name = pathSplit[pathSplit.length - 1];

						if (electroralRollesURL.getDistrictName() != null
								&& !electroralRollesURL.getDistrictName().isEmpty()) {
							if (!name.equalsIgnoreCase(electroralRollesURL.getDistrictName())) {
								continue;
							}
						}

						List<String> acDirectories = AmazonS3Util.getListOfObjects(bucketName,
								eachStateDistrictDirectory);

						for (String eachStateDistrictAcDirectory : acDirectories) {

							pathSplit = eachStateDistrictAcDirectory.split("/");
							name = pathSplit[pathSplit.length - 1];

							if (electroralRollesURL.getMlaConstituencyName() != null
									&& !electroralRollesURL.getMlaConstituencyName().isEmpty()) {
								if (!name.equalsIgnoreCase(electroralRollesURL.getMlaConstituencyName())) {
									continue;
								}
							}

							String filePath = hostName + bucketName + ApplicationConstants.SUFFIX
									+ eachStateDistrictAcDirectory + fileName;

							System.out.println(filePath);
							Workbook myWorkBook = CommonUtil.getWorkBookFromFile(filePath);

							Sheet sheet = myWorkBook.getSheetAt(0);
							int i = 0;
							for (Row eachRow : sheet) {
								if (i < 1) {
									i++;
									continue;
								}

								String stateName = eachRow.getCell(0).getStringCellValue();
								String districtName = eachRow.getCell(1).getStringCellValue();
								String mlaConstituencyName = eachRow.getCell(2).getStringCellValue();
								Integer mlaConstituencyNo = (int) eachRow.getCell(3).getNumericCellValue();
								Integer partNo = (int) eachRow.getCell(4).getNumericCellValue();
								String polingStationName = eachRow.getCell(5).getStringCellValue();
								String polingStationAddress = eachRow.getCell(6).getStringCellValue();
								String pdfUrl = eachRow.getCell(7).getStringCellValue();

								ElectroralRollesURL electroralRolleURL = new ElectroralRollesURL();
								electroralRolleURL.setDistrictName(districtName);
								electroralRolleURL.setMlaConstituencyName(mlaConstituencyName);
								electroralRolleURL.setMlaConstituencyNo(mlaConstituencyNo);
								electroralRolleURL.setStateName(stateName);
								electroralRolleURL.setPollingStationName(polingStationName);
								electroralRolleURL.setPollingStationAddress(polingStationAddress);
								electroralRolleURL.setPdfUrl(pdfUrl);
								electroralRolleURL.setPartNo(partNo);

								if (!newElectroralRollesUrlList.contains(electroralRolleURL)
										&& !existingElectroralRollesUrlList.contains(electroralRolleURL)) {
									newElectroralRollesUrlList.add(electroralRolleURL);
								}
								if (!pdfElectroralRollesUrlList.contains(electroralRolleURL)) {
									pdfElectroralRollesUrlList.add(electroralRolleURL);
								}
							}

						}
					}
				}
			}
		}

		saveStateElectroralRollesURLData(electroralRollesURL, pdfElectroralRollesUrlList,
				existingElectroralRollesUrlList, newElectroralRollesUrlList);

	}
}
