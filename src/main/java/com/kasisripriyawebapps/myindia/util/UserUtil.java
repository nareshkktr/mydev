package com.kasisripriyawebapps.myindia.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dto.ElectroralRollPDFHeaderData;
import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class UserUtil {

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

				String mainTown = lines[0].trim();
				String policeStation = lines[2].trim();
				String mandal = lines[4].trim();
				String revenueDivision = lines[6];
				String pinCode = "";// lines[10];

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

		try {
			if (tableContent != null && !tableContent.trim().isEmpty()) {

				String[] lines = tableContent.split("\n");
				int noOfLines = lines.length;
				if (lines != null && noOfLines != 0) {

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


					/*
					 * String sexAgeLine = lines[processingLineNo].trim();
					 * String[] sexAgeLineSpaces = sexAgeLine.split(" "); if
					 * (sexAgeLineSpaces.length > 3) { age =
					 * sexAgeLineSpaces[1]; sex = sexAgeLineSpaces[3]; } else if
					 * (sexAgeLineSpaces.length == 3) { age =
					 * sexAgeLineSpaces[1]; processingLineNo--; sex =
					 * lines[processingLineNo].trim(); } else if
					 * (sexAgeLineSpaces.length == 2) { sex =
					 * lines[processingLineNo].trim(); } else {
					 * processingLineNo--; sexAgeLine =
					 * lines[processingLineNo].trim(); sexAgeLineSpaces =
					 * sexAgeLine.split(" "); if (sexAgeLineSpaces.length > 1) {
					 * age = sexAgeLineSpaces[0].trim(); sex =
					 * sexAgeLineSpaces[1].trim(); } }
					 * 
					 * System.out.println(">>>>>>>>>>>" + sex);
					 * 
					 * processingLineNo--; processingLineNo--; houseNo =
					 * lines[processingLineNo].trim(); processingLineNo--;
					 * 
					 * if (lines[processingLineNo].trim().contains(":")) {
					 * String referenceTypeWithS =
					 * lines[processingLineNo].trim(); referenceType =
					 * referenceTypeWithS.split(" ")[0].split("'s")[0];
					 * processingLineNo--; referenceName =
					 * lines[processingLineNo].trim(); processingLineNo--; if
					 * (lines[processingLineNo].trim().contains(":")) {
					 * processingLineNo--; electorName =
					 * lines[processingLineNo].trim();
					 * 
					 * } else { processingLineNo--; processingLineNo--;
					 * electorName = lines[processingLineNo].trim() + " " +
					 * lines[processingLineNo + 2].trim();
					 * 
					 * }
					 * 
					 * } else { processingLineNo--; String referenceTypeWithS =
					 * lines[processingLineNo].trim(); referenceType =
					 * referenceTypeWithS.split(" ")[0].split("'s")[0];
					 * processingLineNo--; referenceName =
					 * lines[processingLineNo].trim() + " " +
					 * lines[processingLineNo + 2].trim(); processingLineNo--;
					 * if (lines[processingLineNo].trim().contains(":")) {
					 * processingLineNo--; electorName =
					 * lines[processingLineNo].trim();
					 * 
					 * } else { processingLineNo--; processingLineNo--;
					 * electorName = lines[processingLineNo].trim() + " " +
					 * lines[processingLineNo + 2].trim();
					 * 
					 * } } processingLineNo--;
					 * 
					 * String voterIdLine = lines[processingLineNo].trim();
					 * String[] voterIdLineSpaces = voterIdLine.split(" "); if
					 * (voterIdLineSpaces.length > 1) { voterId =
					 * voterIdLineSpaces[1].trim(); } else { voterId =
					 * voterIdLine; }
					 * 
					 * if (electorName != null && !electorName.isEmpty()) {
					 * String[] electorNamesArray = electorName.split(" "); if
					 * (electorNamesArray != null) { electorName = ""; for (int
					 * m = 0; m < electorNamesArray.length; m++) { String
					 * eachSpaceElectorName = electorNamesArray[m]; if
					 * (!eachSpaceElectorName.isEmpty()) { electorName +=
					 * eachSpaceElectorName.trim() + " "; } } } electorName =
					 * electorName.toUpperCase().trim(); }
					 * 
					 * if (referenceName != null && !referenceName.isEmpty()) {
					 * String[] referenceNamesArray = referenceName.split(" ");
					 * if (referenceNamesArray != null) { referenceName = "";
					 * for (int m = 0; m < referenceNamesArray.length; m++) {
					 * String eachSpaceReferenceName = referenceNamesArray[m];
					 * if (!eachSpaceReferenceName.isEmpty()) { referenceName +=
					 * eachSpaceReferenceName.trim() + " "; } } } referenceName
					 * = referenceName.toUpperCase().trim(); }
					 */

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
					
					//System.out.println(user.getIdCardNo());
					//System.out.println(user.getElectorName());
					//System.out.println(user.getReferenceName());
					//System.out.println(user.getReferenceType());
					System.out.println(user.getAge());
					System.out.println(user.getGender());
					//System.out.println(user.getHouseNo());
					System.out.println("---------------------------");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			isProcessed = false;
		}
		return isProcessed;
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

	private static Map<String, String> getHouseNo(String[] boxContent, int currentLineNo) {
		Map<String, String> houseNoMap = new HashMap<String, String>();
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
		houseNoMap.put("houseNoValue", ageValue);
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

	public static void main(String args[]) {
		ElectroralRollesURL eachURLData = new ElectroralRollesURL();
		// eachURLData.setPdfUrl(
		// "http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR_2017_Final_Roles\\ANDHRA\\AC_154\\English\\S01A154P080.PDF");
		// eachURLData.setPdfUrl(
		// "http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR_2017_Final_Roles\\ANDHRA\\AC_148\\English\\S01A148P001.PDF");
		eachURLData.setPdfUrl(
				"http://ceoaperms.ap.gov.in/TS_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR2016_Final\\Telangana\\AC_007\\English\\S29A007P002.PDF");
		// http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR_2017_Final_Roles\\ANDHRA\\AC_148\\English\\S01A148P001.PDF
		List<User> eachPageUsers = new ArrayList<User>();
		eachPageUsers = parseElectroralData(eachURLData);

		System.out.println(">>>eachPageUsers>>" + eachPageUsers.size());
	}

}
