package com.kasisripriyawebapps.myindia.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class PoliticianUtil {

	static WebDriver driver;

	static {
		File file = new File("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}

	public static void main(String args[]) {

		// For lok sabha
		/**
		 * driver = new ChromeDriver(); driver.get(
		 * "http://164.100.47.192/Loksabha/Members/AlphabeticalList.aspx");
		 * 
		 * Select stateDropDown = new
		 * Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
		 * List<WebElement> stateOptions = stateDropDown.getOptions(); for (int
		 * i = 0; i < stateOptions.size(); i++) { Select refreshedStateDropDown
		 * = new
		 * Select(driver.findElement(By.id("ContentPlaceHolder1_ddlstate")));
		 * WebElement stateOption = refreshedStateDropDown.getOptions().get(i);
		 * if (i == 0) { continue; } stateOption.click(); try {
		 * Thread.sleep(2000); } catch (InterruptedException e) { throw new
		 * InternalServerException(e.getMessage()); }
		 * 
		 * WebElement pageMainTable =
		 * driver.findElement(By.className("member_list_table")); WebElement
		 * pageMainTableBody =
		 * pageMainTable.findElements(By.xpath("tbody")).get(0); List
		 * <WebElement> memberRows = pageMainTableBody
		 * .findElements(By.xpath("tr"));
		 * 
		 * for (WebElement row : memberRows) {
		 * 
		 * List<WebElement> cells = row.findElements(By.xpath("td"));
		 * 
		 * WebElement eachMemberName = cells.get(1);
		 * 
		 * WebElement eachMemberPartyName = cells.get(2);
		 * 
		 * WebElement eachMemberConsituencyState = cells.get(3);
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 **/

		/**
		 * //For Rajya Sabha driver = new ChromeDriver();
		 * driver.get("http://164.100.47.5/Newmembers/memberstatewise.aspx");
		 * 
		 * WebElement allMmebersRadioButton =
		 * driver.findElement(By.id("ctl00_ContentPlaceHolder1_rdblist_1"));
		 * 
		 * allMmebersRadioButton.click();
		 * 
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { throw
		 * new InternalServerException(e.getMessage()); }
		 * 
		 * //ctl00_ContentPlaceHolder1_GridView2
		 * 
		 * WebElement pageMainTable =
		 * driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView2"));
		 * WebElement pageMainTableBody =
		 * pageMainTable.findElements(By.xpath("tbody")).get(0); List
		 * <WebElement> memberRows = pageMainTableBody
		 * .findElements(By.xpath("tr"));
		 * 
		 * for (WebElement row : memberRows) {
		 * 
		 * 
		 * 
		 * List<WebElement> cells = row.findElements(By.xpath("td"));
		 * 
		 * if(cells.size() >0){ WebElement eachMemberName = cells.get(1);
		 * 
		 * WebElement eachMemberPartyName = cells.get(2);
		 * 
		 * WebElement eachMemberConsituencyState = cells.get(3);
		 * 
		 * System.out.println(eachMemberName.getText());
		 * System.out.println(eachMemberPartyName.getText());
		 * System.out.println(eachMemberConsituencyState.getText()); }
		 * 
		 * 
		 * }
		 **/

		/**
		 * //For MLA driver = new ChromeDriver(); driver.get(
		 * "http://www.elections.in/government/member-of-legislative-assembly.html"
		 * );
		 * 
		 * List<WebElement> allStates =
		 * driver.findElements(By.className("sets"));
		 * 
		 * for(WebElement we: allStates){ we.click();
		 * 
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { throw
		 * new InternalServerException(e.getMessage()); }
		 * 
		 * WebElement pageMainTable =
		 * driver.findElement(By.className("tableizer-table")); WebElement
		 * pageMainTableBody =
		 * pageMainTable.findElements(By.xpath("tbody")).get(0); List
		 * <WebElement> memberRows = pageMainTableBody
		 * .findElements(By.xpath("tr"));
		 * 
		 * int i =0;
		 * 
		 * for (WebElement row : memberRows) {
		 * 
		 * if(i>=1){ List<WebElement> cells = row.findElements(By.xpath("td"));
		 * 
		 * if(cells.size() >0){ WebElement eachMemberName = cells.get(1);
		 * 
		 * WebElement eachMemberPartyName = cells.get(2);
		 * 
		 * WebElement eachMemberConsituencyState = cells.get(3);
		 * 
		 * System.out.println(eachMemberName.getText());
		 * System.out.println(eachMemberPartyName.getText());
		 * System.out.println(eachMemberConsituencyState.getText()); } } i++;
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 **/

		// //For Ministries
		// driver = new ChromeDriver();
		// driver.get("http://www.pmindia.gov.in/en/news_updates/portfolios-of-the-union-council-of-ministers-2/");
		//
		// WebElement pageMainTable =
		// driver.findElement(By.className("pms-list"));
		// WebElement pageMainTableBody =
		// pageMainTable.findElements(By.xpath("tbody")).get(0);
		// List<WebElement> memberRows = pageMainTableBody
		// .findElements(By.xpath("tr"));
		//
		// for (WebElement row : memberRows) {
		//
		// List<WebElement> cells = row.findElements(By.xpath("td"));
		//
		// if(cells.size() >=2){
		//
		// WebElement eachMemberConsituencyState = cells.get(2);
		//
		// System.out.println(eachMemberConsituencyState.getText());
		// }
		//
		// }

//		driver = new ChromeDriver();
//		driver.get("http://www.apsec.gov.in/EC_LIST.html");
//
//		WebElement pageMainTable = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[3]/table"));
//		WebElement pageMainTableBody = pageMainTable.findElements(By.xpath("tbody")).get(0);
//		List<WebElement> memberRows = pageMainTableBody.findElements(By.xpath("tr"));
//
//		Boolean processFromNextRow = false;
//
//		Boolean processed = false;
//
//		for (WebElement memeberRow : memberRows) {
//			List<WebElement> cells = memeberRow.findElements(By.xpath("td"));
//			if (processed) {
//				break;
//			}
//			for (WebElement col : cells) {
//				if (processFromNextRow) {
//					try {
//						// Process the records
//						WebElement findAnchor = col.findElement(By.xpath("div/a"));
//						System.out.println(findAnchor.getAttribute("href"));
//						processSarpanchas(findAnchor.getAttribute("href"));
//						
//					} catch (NoSuchElementException e) {
//						processed = true;
//					}
//				} else {
//					try {
//						WebElement findSpan = col.findElement(By.xpath("div/span"));
//
//						if (findSpan != null && findSpan.getText().contains("SARPANCHAS")) {
//							processFromNextRow = true;
//							break;
//						} else {
//							continue;
//						}
//					} catch (NoSuchElementException e) {
//						continue;
//					}
//				}
//			}
//		}
		
		//processSarpanchas("Adilabad_SAR-2013");
		
		try {
			processSarpanchasXLS();
		} catch (InternalServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void processSarpanchasXLS() throws InternalServerException {
		// TODO Auto-generated method stub
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile("https://s3.amazonaws.com/myindiapoliticians/Downloaded/Global/India/Andhra+Pradesh/Adilabad/Adilabad_SAR-2013.xlsx");

		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {
			
			if(i<4){
				i++;
				continue;
			}
			
			System.out.println(eachRow.getCell(2));
			System.out.println(eachRow.getCell(3));
			
			i++;

		}
	}

	private static void processSarpanchas(String fileName) {
		// TODO Auto-generated method stub
		

		String pdfFilePath = "C:\\Users\\venkasb\\Desktop\\Chittoor _SAR-2013.pdf";

		PdfReader reader = null;
		try {
			reader = new PdfReader(pdfFilePath);
			if (reader != null) {
				int noOfPages = reader.getNumberOfPages();
				TextExtractionStrategy strategy;
				// String tableContent =
				// PdfTextExtractor.getTextFromPage(reader, 1, new
				// HorizontalTextExtractionStrategy());

				// System.out.println(tableContent);
				for (int i = 1; i <= noOfPages; i++) {

					// Vertical scannign

					int ly = 40;
					int lx = 170;
					int ux = 180;
					int uy = 1000;

					Rectangle rect = new Rectangle(lx, ly, ux, uy);

					RenderFilter filter = new RegionTextRenderFilter(rect);
					strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
					String tableContent = null;
					try {
						tableContent = PdfTextExtractor.getTextFromPage(reader, i, strategy);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					 System.out.println("-----------------------------------------------");

					 System.out.println(tableContent);

					 System.out.println("-----------------------------------------------");
					String[] contentSplitGP = tableContent.split("\\n");

					ly = 40;
					lx = 345;
					ux = 400;
					uy = 1000;

					rect = new Rectangle(lx, ly, ux, uy);

					filter = new RegionTextRenderFilter(rect);
					strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
					tableContent = null;
					try {
						tableContent = PdfTextExtractor.getTextFromPage(reader, i, strategy);
					} catch (IOException e) {
						e.printStackTrace();
					}

					System.out.println(tableContent);
					System.out.println("-----------------------------------------------");

					String[] contentSplitCandidate = tableContent.split("\\n");

					int k = 0;
					 for(int j=0;j<contentSplitGP.length;j++){
					
//					 if(contentSplitCandidate[k].trim().equalsIgnoreCase("W/O SATYA RAO") || contentSplitCandidate[k].equalsIgnoreCase("URAM")){
//						 k++;
//					 }
					 
//					 if(contentSplitGP[j].startsWith("VU ")){
//						 contentSplitGP[j] = contentSplitGP[j].substring(3, contentSplitGP[j].length());
//					 }
//					 
//					 if(contentSplitGP[j].startsWith("mu Rural ")){
//						 contentSplitGP[j] = contentSplitGP[j].substring(9, contentSplitGP[j].length());
//					 }
//					 
//					 if(contentSplitGP[j].startsWith("I ") || contentSplitGP[j].startsWith("m ")){
//						 contentSplitGP[j] = contentSplitGP[j].substring(2, contentSplitGP[j].length());
//					 }
						 
						 if(contentSplitGP[j].startsWith("LLU ")){
							 contentSplitGP[j] = contentSplitGP[j].substring(4, contentSplitGP[j].length());
							 if(contentSplitGP[j].isEmpty()){
								 continue;
							 }
						 }
					 
					 System.out.println("--"+contentSplitGP[j]+"----"+contentSplitCandidate[k]);
					 k++;
					 }

					// Horizontal scanning

					// For number and

					// int ly=25;
					// int lx=140;
					// int ux=157;
					// int uy=ly;
					//
					// for(int k=0;k<10;k++){
					//
					// System.out.println("one row-----");
					//
					//
					// for(int j=0;j<2;j++){
					//
					// Rectangle rect = new Rectangle(lx, ly, ux, uy);
					//
					// RenderFilter filter = new RegionTextRenderFilter(rect);
					// strategy = new FilteredTextRenderListener(new
					// LocationTextExtractionStrategy(), filter);
					// String tableContent = null;
					// try {
					// tableContent = PdfTextExtractor.getTextFromPage(reader,
					// i, strategy);
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
					//
					// System.out.println(tableContent);
					//
					// lx = ux + 50;
					// ux = ux + 100;
					//
					// }
					//
					// lx=140;
					// ux=157;
					// ly = uy+25;
					// uy= ly-15;
					//
					// }

					// if (i < 3) {
					// continue;
					// }
					// int ly = 0;
					// int uy = 125;
					// for (int j = 0; j < 10; j++) {
					// int lx = 0;
					// int ux = 175;
					//
					// for (int k = 0; k < 3; k++) {
					// Rectangle rect = new Rectangle(lx, ly, ux, uy);
					//
					// RenderFilter filter = new RegionTextRenderFilter(rect);
					// strategy = new FilteredTextRenderListener(new
					// LocationTextExtractionStrategy(), filter);
					// String tableContent = null;
					// try {
					// tableContent = PdfTextExtractor.getTextFromPage(reader,
					// i, strategy);
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
					//
					// System.out.println(tableContent);
					//
					// lx = ux;
					// ux = ux + 175;
					// }
					//
					// ly = uy;
					// uy = uy + 73;
					// }
				}
				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

		
	}

}
