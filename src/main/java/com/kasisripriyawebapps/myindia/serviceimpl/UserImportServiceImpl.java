package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.kasisripriyawebapps.myindia.dao.UserImportDao;
import com.kasisripriyawebapps.myindia.dto.ElectroralRollPDFHeaderData;
import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.service.UserImportService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class UserImportServiceImpl implements UserImportService {

	static WebDriver driver;
	@Autowired
	private Environment env;

	@Autowired
	UserImportDao userImportDao;

	@Autowired
	UserDao userDao;

	static {
		System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");

		System.setProperty("http.proxyHost", "proxy.cat.com");
		System.setProperty("http.proxyPort", "80");

		System.setProperty("https.proxyHost", "proxy.cat.com");
		System.setProperty("https.proxyPort", "80");
	}

	@Override
	@Transactional
	public void saveStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL)
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

	private void handleAndhraPradeshTeleganaElectroralRollesURL(ElectroralRollesURL electroralRollesURL,
			String stateUrl) throws InternalServerException {
		List<ElectroralRollesURL> pdfElectroralRollesUrlList = new ArrayList<ElectroralRollesURL>();
		List<ElectroralRollesURL> newElectroralRollesUrlList = new ArrayList<ElectroralRollesURL>();
		List<ElectroralRollesURL> existingElectroralRollesUrlList = userImportDao
				.getElectroralRollesURLData(electroralRollesURL);
		driver = new ChromeDriver();
		driver.get(stateUrl);

		Select districtDropDown = new Select(driver.findElement(By.id("ddlDist")));
		List<WebElement> districtOptions = districtDropDown.getOptions();
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
				Select refreshedMlaConstituencyDropDown = new Select(driver.findElement(By.id("ddlAC")));
				WebElement mlaConstituencyOption = refreshedMlaConstituencyDropDown.getOptions().get(j);
				if (j == 0) {
					continue;
				}
				mlaConstituencyOption.click();
				WebElement getPollingStationButton = driver.findElement(By.id("btnGetPollingStations"));
				getPollingStationButton.click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					throw new InternalServerException(e.getMessage());
				}
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
				getPollingStationElectorsUrls(electroralRollesURL, districtName, mlaConstituencyName, mlaConstituencyNo,
						pdfElectroralRollesUrlList, existingElectroralRollesUrlList, newElectroralRollesUrlList);
			}
		}
		saveStateElectroralRollesURLData(electroralRollesURL, pdfElectroralRollesUrlList,
				existingElectroralRollesUrlList, newElectroralRollesUrlList);
		driver.close();
		driver.quit();
	}

	private void saveStateElectroralRollesURLData(ElectroralRollesURL electroralRollesURL,
			List<ElectroralRollesURL> pdfElectroralRollesUrlList,
			List<ElectroralRollesURL> existingElectroralRollesUrlList,
			List<ElectroralRollesURL> newElectroralRollesUrlList) throws InternalServerException {
		userImportDao.saveElectroralRollesURLData(newElectroralRollesUrlList);
		newElectroralRollesUrlList.clear();
		List<ElectroralRollesURL> updatedElectroralRollesUrlList = findUpdatedElectroralRollesURLData(
				existingElectroralRollesUrlList, pdfElectroralRollesUrlList);
		userImportDao.updateElectroralRollesURLData(updatedElectroralRollesUrlList);
		existingElectroralRollesUrlList.removeAll(pdfElectroralRollesUrlList);
		userImportDao.deleteeElectroralRollesURLData(existingElectroralRollesUrlList);
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
			String mlaConstituencyName, int mlaConstituencyNo, List<ElectroralRollesURL> pdfElectroralRollesUrlList,
			List<ElectroralRollesURL> existingElectroralRollesUrlList,
			List<ElectroralRollesURL> newElectroralRollesUrlList, int pollingStationIndex, int pollingStationSize,
			String existingPDFUrl) {
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
			ElectroralRollesURL electroralRolleURL = new ElectroralRollesURL();
			electroralRolleURL.setDistrictName(districtName);
			electroralRolleURL.setMlaConstituencyName(mlaConstituencyName);
			electroralRolleURL.setMlaConstituencyNo(mlaConstituencyNo);
			electroralRolleURL.setStateName(electroralRollesURL.getStateName());
			electroralRolleURL.setPollingStationName(polingStationName);
			electroralRolleURL.setPollingStationAddress(polingStationAddress);
			electroralRolleURL.setPdfUrl(pdfUrl);
			electroralRolleURL.setPartNo(partNo);
			if (!existingElectroralRollesUrlList.contains(electroralRolleURL)) {
				newElectroralRollesUrlList.add(electroralRolleURL);
			}
			if (!pdfElectroralRollesUrlList.contains(electroralRolleURL)) {
				pdfElectroralRollesUrlList.add(electroralRolleURL);
			}

			processAPTNPollingStationURLs(electroralRollesURL, districtName, mlaConstituencyName, mlaConstituencyNo,
					pdfElectroralRollesUrlList, existingElectroralRollesUrlList, newElectroralRollesUrlList,
					pollingStationIndex + 1, statesTableRowsWithHeader.size(), existingPDFUrl);

		}

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
			String mlaConstituencyName, int mlaConstituencyNo, List<ElectroralRollesURL> pdfElectroralRollesUrlList,
			List<ElectroralRollesURL> existingElectroralRollesUrlList,
			List<ElectroralRollesURL> newElectroralRollesUrlList) {

		WebElement pageMainTable = driver.findElement(By.id("GridView1"));
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> statesTableRowsWithHeader = pageMainTableBody.findElements(By.xpath("tr"));

		if (statesTableRowsWithHeader != null && !statesTableRowsWithHeader.isEmpty()) {

			processAPTNPollingStationURLs(electroralRollesURL, districtName, mlaConstituencyName, mlaConstituencyNo,
					pdfElectroralRollesUrlList, existingElectroralRollesUrlList, newElectroralRollesUrlList, 1,
					statesTableRowsWithHeader.size(), "");
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
		List<ElectroralRollesURL> pdfElectroralRollesUrlList = new ArrayList<ElectroralRollesURL>();
		List<ElectroralRollesURL> newElectroralRollesUrlList = new ArrayList<ElectroralRollesURL>();
		List<ElectroralRollesURL> existingElectroralRollesUrlList = userImportDao
				.getElectroralRollesURLData(electroralRollesURL);
		driver = new ChromeDriver();
		driver.get(stateUrl);

		WebElement districtMainTable = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
		WebElement districtMainTableTbody = districtMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> districtTableRowsWithHeader = districtMainTableTbody.findElements(By.xpath("tr"));

		processKarnatakaDistrict(electroralRollesURL, 1, districtTableRowsWithHeader.size(), pdfElectroralRollesUrlList,
				newElectroralRollesUrlList, existingElectroralRollesUrlList);

		driver.close();
		driver.quit();

		saveStateElectroralRollesURLData(electroralRollesURL, pdfElectroralRollesUrlList, newElectroralRollesUrlList,
				existingElectroralRollesUrlList);
	}

	private static void processKarnatakaDistrict(ElectroralRollesURL electroralRollesURL, int districtNo,
			int districtSize, List<ElectroralRollesURL> pdfElectroralRollesUrlList,
			List<ElectroralRollesURL> newElectroralRollesUrlList,
			List<ElectroralRollesURL> existingElectroralRollesUrlList) throws InternalServerException {

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
						districtNo, districtSize, districtName, pdfElectroralRollesUrlList, newElectroralRollesUrlList,
						existingElectroralRollesUrlList);

			} else {
				processKarnatakaDistrict(electroralRollesURL, districtNo + 1, districtSize, pdfElectroralRollesUrlList,
						newElectroralRollesUrlList, existingElectroralRollesUrlList);
			}
		}

	}

	private static void processKarnatakaDistrictMLAConstituency(ElectroralRollesURL electroralRollesURL,
			int mlaConstituencyNo, int mlaConstituencySize, int districtNo, int districtSize, String districtName,
			List<ElectroralRollesURL> pdfElectroralRollesUrlList, List<ElectroralRollesURL> newElectroralRollesUrlList,
			List<ElectroralRollesURL> existingElectroralRollesUrlList) throws InternalServerException {

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
						districtNo, districtSize, districtName, mlaConstituencyName, pdfElectroralRollesUrlList,
						newElectroralRollesUrlList, existingElectroralRollesUrlList);
			} else {
				processKarnatakaDistrictMLAConstituency(electroralRollesURL, mlaConstituencyNo + 1, mlaConstituencySize,
						districtNo, districtSize, districtName, pdfElectroralRollesUrlList, newElectroralRollesUrlList,
						existingElectroralRollesUrlList);
			}
		} else {
			driver.navigate().back();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}

			processKarnatakaDistrict(electroralRollesURL, districtNo + 1, districtSize, pdfElectroralRollesUrlList,
					newElectroralRollesUrlList, existingElectroralRollesUrlList);
		}
	}

	private static void processKarnatakaDistrictMLAPollingStation(ElectroralRollesURL electroralRollesURL,
			int mlaConstituencyNo, int mlaConstituencySize, int districtNo, int districtSize, String districtName,
			String mlaConstituencyName, List<ElectroralRollesURL> pdfElectroralRollesUrlList,
			List<ElectroralRollesURL> newElectroralRollesUrlList,
			List<ElectroralRollesURL> existingElectroralRollesUrlList) throws InternalServerException {

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
				if (!existingElectroralRollesUrlList.contains(electroralRolleURL)) {
					newElectroralRollesUrlList.add(electroralRolleURL);
				}
				if (!pdfElectroralRollesUrlList.contains(electroralRolleURL)) {
					pdfElectroralRollesUrlList.add(electroralRolleURL);
				}
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
				districtNo, districtSize, districtName, pdfElectroralRollesUrlList, newElectroralRollesUrlList,
				existingElectroralRollesUrlList);
	}

	@Override
	@Transactional
	public void saveStateElectroralRolleData(ElectroralRollesURL electroralRollesURL) throws InternalServerException {
		// TODO Auto-generated method stub
		List<ElectroralRollesURL> electroralRollesUrlList = userImportDao
				.getElectroralRollesURLData(electroralRollesURL);

		List<User> users = new ArrayList<User>();
		if (electroralRollesUrlList != null) {

			for (ElectroralRollesURL eachURLData : electroralRollesUrlList) {
				List<User> eachPageUsers = parseElectroralData(eachURLData);
				System.out.println("i>>" + eachURLData.getPdfUrl() + ">>" + eachPageUsers.size());
				users.addAll(eachPageUsers);
			}
		}
		if (users != null && !users.isEmpty()) {
			userDao.saveUsers(users);
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
					int ly = 21;
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

		int ly = 360;
		int uy = 490;
		int lx = 320;
		int ux = 500;

		Rectangle rect = new Rectangle(lx, ly, ux, uy);

		RenderFilter filter = new RegionTextRenderFilter(rect);
		strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
		String tableContent = null;
		try {
			tableContent = PdfTextExtractor.getTextFromPage(reader, 1, strategy);
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}

		if (tableContent != null && !tableContent.isEmpty()) {
			String[] lines = tableContent.split("\n");
			int noOfLines = lines.length;
			if (lines != null && noOfLines != 0) {

				String mainTownLine = lines[0];
				String mainTown = "";
				if (mainTownLine != null && !mainTownLine.isEmpty()) {
					mainTownLine.split(":")[1].trim();
				}

				String policeStationLine = lines[1];
				String policeStation = "";
				if (policeStationLine != null && !policeStationLine.isEmpty()) {
					policeStationLine.split(" ")[2].trim();
				}

				String mandalLine = lines[2];

				if (mandalLine.split(":").length < 1) {
					mandalLine = lines[3];
				}

				String mandal = "";
				if (mandalLine != null && !mandalLine.isEmpty()) {
					mandalLine.split(":")[1].trim();
				}

				String revenueDivisionLine = lines[4];
				String revenueDivision = "";
				if (revenueDivisionLine != null && !revenueDivisionLine.isEmpty()) {
					revenueDivisionLine.split(":")[1].trim();
				}

				String pinCodeLine = lines[6];

				if (pinCodeLine.trim().split(":").length < 1) {
					pinCodeLine = lines[7];
				}

				String pinCode = "";
				if (pinCodeLine != null && !pinCodeLine.isEmpty()) {
					if (pinCodeLine.trim() != null && !pinCodeLine.trim().isEmpty()
							&& pinCodeLine.trim().split(" ").length > 2) {
						pinCodeLine = pinCodeLine.split(" ")[2].trim();
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
		int lx1 = 380;
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

		pdfHeaderData.setMpConstituencyNo(Integer.parseInt(tableContent1.trim().replaceAll("\\D+", "")));
		pdfHeaderData.setMpConstituencyName(tableContent1.trim().replaceAll("[^a-zA-Z]", ""));

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

		int processingLineNo = 0;

		try {
			if (tableContent != null && !tableContent.trim().isEmpty()) {
				String[] lines = tableContent.split("\n");
				int noOfLines = lines.length;
				if (lines != null && noOfLines != 0) {

					String sexLine = lines[noOfLines - 1];
					if (!sexLine.equalsIgnoreCase(ServiceConstants.DELETE_USER)) {
						String[] sexLineColon = sexLine.split(":");
						if (sexLineColon != null) {
							if (sexLineColon.length == 1) {
								sex = lines[noOfLines - 2];
								processingLineNo = noOfLines - 2;
							} else {
								sex = sexLineColon[1].trim();
								processingLineNo = noOfLines - 1;
							}
						}
						String ageLine = lines[processingLineNo - 1];
						String[] ageLineColon = ageLine.split(":");
						if (ageLineColon != null) {
							if (ageLineColon.length == 1) {
								age = lines[processingLineNo - 2];
								processingLineNo = processingLineNo - 2;
							} else {
								age = ageLineColon[1].trim();
								processingLineNo = processingLineNo - 1;
							}
						}

						String houseNoLine = lines[processingLineNo - 1];
						String[] houseNoLineColon = houseNoLine.split(":");
						if (houseNoLineColon != null) {
							if (houseNoLineColon.length == 1) {
								houseNo = lines[processingLineNo - 2];
								processingLineNo = processingLineNo - 2;
							} else {
								houseNo = houseNoLineColon[1].trim();
								processingLineNo = processingLineNo - 1;
							}
						}

						Map<String, String> referenceTypeNameMap = getReferenceName(lines, processingLineNo,
								referenceName, referenceType);
						referenceType = referenceTypeNameMap.get("referenceType");
						if (referenceType.contains("'s")) {
							referenceType = referenceType.split("'s")[0];
						}
						referenceName = referenceTypeNameMap.get("referenceName");
						processingLineNo = Integer.parseInt(referenceTypeNameMap.get("processingLineNo"));
						Map<String, String> electorNameMap = getElectorName(lines, processingLineNo - 1, electorName);
						electorName = electorNameMap.get("electorName");
						processingLineNo = Integer.parseInt(electorNameMap.get("processingLineNo"));
						processingLineNo = processingLineNo - 1;
						if (electorName == null || electorName.isEmpty()) {
							processingLineNo = processingLineNo - 1;
							electorName = lines[processingLineNo];
						}

						String voterIdLine = lines[processingLineNo - 1];
						String[] eachVoterIdLineSpaces = voterIdLine.split(" ");
						if (eachVoterIdLineSpaces.length != 0) {
							voterId = eachVoterIdLineSpaces[2].trim();
						}

						User user = new User();
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
			}
		} catch (Exception ex) {
			isProcessed = false;
		}
		return isProcessed;
	}

	private static Map<String, String> getReferenceName(String[] lines, int processingLineNo, String referenceName,
			String referenceType) {
		Map<String, String> referenceTypeName = new HashMap<String, String>();

		String tempReferenceTypeName = lines[processingLineNo - 1];
		if (tempReferenceTypeName.contains(":")) {
			if (tempReferenceTypeName.split(":").length == 1) {
				referenceName += "";
				referenceType = tempReferenceTypeName.trim();
			} else {
				referenceName = tempReferenceTypeName.split(":")[1].trim() + referenceName;
				referenceType = tempReferenceTypeName.split(":")[0].trim();
			}
			referenceTypeName.put("referenceName", referenceName);
			referenceTypeName.put("referenceType", referenceType);
			referenceTypeName.put("processingLineNo", String.valueOf(processingLineNo));

		} else {
			referenceName = lines[processingLineNo - 1].trim() + " " + referenceName.trim();
			referenceTypeName = getReferenceName(lines, processingLineNo - 1, referenceName, referenceType);
		}

		return referenceTypeName;
	}

	private static Map<String, String> getElectorName(String[] lines, int processingLineNo, String electorName) {
		Map<String, String> electorNameMap = new HashMap<String, String>();
		String tempReferenceTypeName = lines[processingLineNo - 1];
		if (tempReferenceTypeName.contains(":")) {
			if (tempReferenceTypeName.split(":").length == 1) {
				electorName += "";
			} else {
				electorName = tempReferenceTypeName.split(":")[1].trim() + " " + electorName;
			}

			electorNameMap.put("electorName", electorName);
			electorNameMap.put("processingLineNo", String.valueOf(processingLineNo));

		} else {
			electorName = lines[processingLineNo - 1].trim() + " " + electorName.trim();
			electorNameMap = getElectorName(lines, processingLineNo - 1, electorName);
		}
		return electorNameMap;
	}
}
