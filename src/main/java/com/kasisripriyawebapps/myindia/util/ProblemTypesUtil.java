package com.kasisripriyawebapps.myindia.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class ProblemTypesUtil {
	
static WebDriver driver;
	
	static {
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
	public static void main(String args[]) throws InternalServerException{
		
		//For problem types - Central
/*		driver = new ChromeDriver();
		driver.get("http://pgportal.gov.in/GrievanceNew.aspx");
		
		WebElement allMmebersRadioButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RBL_ChooseGrievance_0"));
		
		allMmebersRadioButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}
		
		//ctl00_ContentPlaceHolder1_chkbtn
		
		WebElement agreeButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkbtn"));
		
		agreeButton.click();
		
//		/ctl00$ContentPlaceHolder1$btnchk
		
		WebElement submitButton = driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnchk"));
		
		submitButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}
		
		List<String> lines = new ArrayList<String>();
		Path file = Paths.get("ProblemTypes-Central.txt");
		
		
		Select mainCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddl_min")));
		List<WebElement> mainDepartments = mainCategory.getOptions();
		
		for (int i = 0; i < mainDepartments.size(); i++) {
			Select refreshedmainCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddl_min")));
			WebElement mainCategoryOption = refreshedmainCategory.getOptions().get(i);
			if (i == 0) {
				continue;
			}
			lines.add(i+" "+mainCategoryOption.getText());
			mainCategoryOption.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}
			
			
			
			Select subCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$listgrievancecategory")));
			List<WebElement> subDepartments = subCategory.getOptions();
			for (int j = 0; j < subDepartments.size(); j++) {
				if(j==0){
					continue;
				}
				Select refreshedsubCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$listgrievancecategory")));
				WebElement subCategoryOption = refreshedsubCategory.getOptions().get(j);
				lines.add("-------"+j+" "+subCategoryOption.getText());
			}
			
			
		}
		
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		//For problem types - State
		/*driver = new ChromeDriver();
		driver.get("http://pgportal.gov.in/GrievanceNew.aspx");

		WebElement allMmebersRadioButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RBL_ChooseGrievance_0"));

		allMmebersRadioButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}

		//ctl00_ContentPlaceHolder1_chkbtn

		WebElement agreeButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkbtn"));

		agreeButton.click();

		//				/ctl00$ContentPlaceHolder1$btnchk

		WebElement submitButton = driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnchk"));

		submitButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}

		List<String> lines = new ArrayList<String>();
		Path file = Paths.get("ProblemTypes-State.txt");
		
		//ctl00_ContentPlaceHolder1_RBL_grievance_1
		WebElement satteRadioButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RBL_grievance_1"));

		satteRadioButton.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}


		Select mainCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddl_min")));
		List<WebElement> mainDepartments = mainCategory.getOptions();

		for (int i = 0; i < mainDepartments.size(); i++) {
			Select refreshedmainCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$ddl_min")));
			WebElement mainCategoryOption = refreshedmainCategory.getOptions().get(i);
			if (i == 0) {
				continue;
			}
			lines.add(i+" "+mainCategoryOption.getText());
			mainCategoryOption.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				throw new InternalServerException(e.getMessage());
			}



			Select subCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$listgrievancecategory")));
			List<WebElement> subDepartments = subCategory.getOptions();
			for (int j = 0; j < subDepartments.size(); j++) {
				if(j==0){
					continue;
				}
				Select refreshedsubCategory = new Select(driver.findElement(By.name("ctl00$ContentPlaceHolder1$listgrievancecategory")));
				WebElement subCategoryOption = refreshedsubCategory.getOptions().get(j);
				lines.add("-------"+j+" "+subCategoryOption.getText());
			}


		}

		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		//For problem types - Not Known
		/*driver = new ChromeDriver();
		driver.get("http://pgportal.gov.in/GrievanceNew.aspx");

		WebElement allMmebersRadioButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RBL_ChooseGrievance_0"));

		allMmebersRadioButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}

		//ctl00_ContentPlaceHolder1_chkbtn

		WebElement agreeButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkbtn"));

		agreeButton.click();

		//				/ctl00$ContentPlaceHolder1$btnchk

		WebElement submitButton = driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnchk"));

		submitButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}

		List<String> lines = new ArrayList<String>();
		Path file = Paths.get("ProblemTypes-Not listed.txt");
		
		//ctl00_ContentPlaceHolder1_RBL_grievance_1
		WebElement satteRadioButton = driver.findElement(By.id("ctl00_ContentPlaceHolder1_RBL_grievance_2"));

		satteRadioButton.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}


		Select mainCategory = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_listgrievancecategory")));
		List<WebElement> mainDepartments = mainCategory.getOptions();

		for (int i = 0; i < mainDepartments.size(); i++) {
			Select refreshedmainCategory = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_listgrievancecategory")));
			WebElement mainCategoryOption = refreshedmainCategory.getOptions().get(i);
			if (i == 0) {
				continue;
			}
			lines.add(i+" "+mainCategoryOption.getText());
		

		}

		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		//From another website
		driver = new ChromeDriver();
		driver.get("http://dpg.gov.in/grievance.aspx");
		
		//ctl00_menua_1 ctl00_menua_3
		WebElement allMmebersRadioButton = driver.findElement(By.linkText("LodgeComplaint/ViewStatus"));

		allMmebersRadioButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}
		
		//ctl00_Main_Label1
		
		WebElement newGrienvenceRadioButton = driver.findElement(By.id("ctl00_Main_Label1"));
		newGrienvenceRadioButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new InternalServerException(e.getMessage());
		}

		List<String> lines = new ArrayList<String>();
		Path file = Paths.get("ProblemTypes-dpgList.txt");
		
		


		Select mainCategory = new Select(driver.findElement(By.id("ctl00_Main_ddlSectors")));
		List<WebElement> mainDepartments = mainCategory.getOptions();

		for (int i = 0; i < mainDepartments.size(); i++) {
			Select refreshedmainCategory = new Select(driver.findElement(By.id("ctl00_Main_ddlSectors")));
			WebElement mainCategoryOption = refreshedmainCategory.getOptions().get(i);
			if (i == 0) {
				continue;
			}
			lines.add(i+" "+mainCategoryOption.getText());
		

		}

		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
