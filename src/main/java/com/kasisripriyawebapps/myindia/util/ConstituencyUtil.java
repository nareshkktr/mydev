package com.kasisripriyawebapps.myindia.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class ConstituencyUtil {

	static WebDriver driver;
	static Wait<WebDriver> wait;
	static String baseUrl = "https://en.wikipedia.org/wiki/List_of_constituencies_of_the_Lok_Sabha";

	static {
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}

	public static void loadMainPage() {

		List<LocationMaster> constituencyLocations = new ArrayList<LocationMaster>();
		processEachStateURL(null, null, null, constituencyLocations);
	}

	private static void processEachStateURL(Map<String, List<LocationMaster>> stateMasterLocationsCodeMap,
			List<LocationMaster> existingMasterLocations, List<LocationMaster> exportMasterLocations,
			List<LocationMaster> newMasterLocations) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
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
							WebElement mpConstituencyNamesCell = cells.get(3);
							System.out.println(mpConstituencyNamesCell.getText());
							System.out.println(">>>>>>>>>>>>>>");
						}
					}
				}
				if (tableIndex == 1) {
					break;
				}
				tableIndex++;
			}
		}
		driver.close();
		driver.quit();

	}

	public static void main(String args[]) throws InterruptedException {
		loadMainPage();
	}
}
