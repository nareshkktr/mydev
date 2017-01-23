package com.kasisripriyawebapps.myindia.util;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class PoliticianUtil {
	
static WebDriver driver;
	
	static {
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
	public static void main(String args[]) throws InternalServerException{
		
		//For lok sabha
		/**
		driver = new ChromeDriver();
		driver.get("http://164.100.47.192/Loksabha/Members/AlphabeticalList.aspx");
		
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
			List<WebElement> memberRows = pageMainTableBody
					.findElements(By.xpath("tr"));
			
			for (WebElement row : memberRows) {
				
				List<WebElement> cells = row.findElements(By.xpath("td"));
				
				WebElement eachMemberName = cells.get(1);
				
				WebElement eachMemberPartyName = cells.get(2);
				
				WebElement eachMemberConsituencyState = cells.get(3);
				
				
			
				
			}
			
			
		}**/
		
		/**
		//For Rajya Sabha
		driver = new ChromeDriver();
		driver.get("http://164.100.47.5/Newmembers/memberstatewise.aspx");
		
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
				WebElement eachMemberName = cells.get(1);
				
				WebElement eachMemberPartyName = cells.get(2);
				
				WebElement eachMemberConsituencyState = cells.get(3);
				
				System.out.println(eachMemberName.getText());
				System.out.println(eachMemberPartyName.getText());
				System.out.println(eachMemberConsituencyState.getText());
			}
		
			
		} **/
		
		/**
		//For MLA
		driver = new ChromeDriver();
		driver.get("http://www.elections.in/government/member-of-legislative-assembly.html");
		
		List<WebElement> allStates = driver.findElements(By.className("sets"));
		
		for(WebElement we: allStates){
			we.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}
			
			WebElement pageMainTable = driver.findElement(By.className("tableizer-table"));
			WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
			List<WebElement> memberRows = pageMainTableBody
					.findElements(By.xpath("tr"));
			
			int i =0;
			
			for (WebElement row : memberRows) {
				
				if(i>=1){
					List<WebElement> cells = row.findElements(By.xpath("td"));
					
					if(cells.size() >0){
						WebElement eachMemberName = cells.get(1);
						
						WebElement eachMemberPartyName = cells.get(2);
						
						WebElement eachMemberConsituencyState = cells.get(3);
						
						System.out.println(eachMemberName.getText());
						System.out.println(eachMemberPartyName.getText());
						System.out.println(eachMemberConsituencyState.getText());
					}
				}
				i++;
				
					
			} 
			
			
			
		}**/
		
		//For Ministries
		driver = new ChromeDriver();
		driver.get("http://www.pmindia.gov.in/en/news_updates/portfolios-of-the-union-council-of-ministers-2/");
		
		WebElement pageMainTable = driver.findElement(By.className("pms-list"));
		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
		List<WebElement> memberRows = pageMainTableBody
				.findElements(By.xpath("tr"));
		
		for (WebElement row : memberRows) {
			
			List<WebElement> cells = row.findElements(By.xpath("td"));
			
			if(cells.size() >=2){
				
				WebElement eachMemberConsituencyState = cells.get(2);
				
				System.out.println(eachMemberConsituencyState.getText());
			}
			
		}
		
		
	}

}
