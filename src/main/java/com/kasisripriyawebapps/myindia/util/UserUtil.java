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
	static {
		System.setProperty("http.proxyHost", "proxy.cat.com");
		System.setProperty("http.proxyPort", "80");
		System.setProperty("https.proxyHost", "proxy.cat.com");
		System.setProperty("https.proxyPort", "80");
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

				for (int i = 1; i <= 0; i++) {
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
				
				
				for(int i=0;i<lines.length;i++){
					if(lines[i].contains("Main Town")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							mainTown = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Town");
							mainTown = linesSplit[1].trim();
						}
					}
					
					if(lines[i].contains("Police Station")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							policeStation = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Station");
							policeStation = linesSplit[1].trim();
						}
					}
					
					if(lines[i].contains("Mandal")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							mandal = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Mandal");
							mandal = linesSplit[0].trim();
						}
					}
					
					if(lines[i].contains("Revenue Division")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							revenueDivision = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Division");
							revenueDivision = linesSplit[1].trim();
						}
					}
					
					if(lines[i].contains("Pin Code")){
						
						if(lines[i].contains(":")){
							String[] linesSplit = lines[i].split(":");
							pinCode = linesSplit[1].trim();
						}else{
							String[] linesSplit = lines[i].split("Code");
							pinCode = linesSplit[1].trim();
						}
					}
					
					

				}

				System.out.println(mainTown);
				System.out.println(policeStation);
				System.out.println(mandal);
				System.out.println(revenueDivision);
				System.out.println(pinCode);

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

					// System.out.println(user.getIdCardNo());
					// System.out.println(user.getElectorName());
					// System.out.println(user.getReferenceName());
					// System.out.println(user.getReferenceType());
					// System.out.println(user.getAge());
					// System.out.println(user.getGender());
					// System.out.println(user.getHouseNo());
					// System.out.println("---------------------------");

				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
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

	public static void main(String args[]) {
		ElectroralRollesURL eachURLData = new ElectroralRollesURL();
		// eachURLData.setPdfUrl(
		// "http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR_2017_Final_Roles\\ANDHRA\\AC_154\\English\\S01A154P080.PDF");
		 eachURLData.setPdfUrl(
		 "http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR_2017_Final_Roles\\ANDHRA\\AC_151\\English\\S01A151P106.PDF");
		//eachURLData.setPdfUrl(
		//		"http://ceoaperms.ap.gov.in/TS_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR2016_Final\\Telangana\\AC_007\\English\\S29A007P002.PDF");
		// http://ceoaperms.ap.gov.in/Electoral_Rolls/PDFGeneration.aspx?urlPath=D:\\SSR_2017_Final_Roles\\ANDHRA\\AC_148\\English\\S01A148P001.PDF
		List<User> eachPageUsers = new ArrayList<User>();
		eachPageUsers = parseElectroralData(eachURLData);

		System.out.println(">>>eachPageUsers>>" + eachPageUsers.size());
	}

}
