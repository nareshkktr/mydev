/*
 * 
 */
package com.kasisripriyawebapps.myindia.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dto.ExternalServiceResponse;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

import sun.misc.BASE64Decoder;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonUtil.
 */
@SuppressWarnings("restriction")
public class CommonUtil {

	/** The id card types. */
	public static List<String> idCardTypes = new ArrayList<String>();
	public static List<String> objectTypes = new ArrayList<String>();
	public static List<String> searchTerms = new ArrayList<String>();
	public static Map<String, String> conflictLocationsMap = new HashMap<String, String>();

	static {
		idCardTypes.add(ApplicationConstants.IDENTITY_CARD_TYPE_ADHAR);
		idCardTypes.add(ApplicationConstants.IDENTITY_CARD_TYPE_VOTER_ID);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_USER);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_POLTIICIAN);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_PARTY);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_LOCATION);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_PROBLEM);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_EVENT);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_COMMENT);
		objectTypes.add(ApplicationConstants.OBJECT_TYPE_POST);

		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
			searchTerms.add(String.valueOf(alphabet));
		}

		conflictLocationsMap.put("Jammu & Kashmir", "Jammu And Kashmir");
		conflictLocationsMap.put("New Delhi", "Delhi");
		conflictLocationsMap.put("NCT of Delhi", "Delhi");
	}

	/**
	 * Checks if is valid email.
	 *
	 * @param email
	 *            the email
	 * @return true, if is valid email
	 */
	public static boolean isValidEmail(final String email) {
		boolean isValidEmail = true;
		if (email == null || email.isEmpty()) {
			isValidEmail = false;
		} else {
			final String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
			final Pattern pattern = Pattern.compile(regex);
			final Matcher matcher = pattern.matcher(email);
			isValidEmail = matcher.matches();
		}
		return isValidEmail;
	}

	/**
	 * Checks if is valid size filed.
	 *
	 * @param fieldName
	 *            the field name
	 * @param minSize
	 *            the min size
	 * @param maxSize
	 *            the max size
	 * @return true, if is valid size filed
	 */
	public static boolean isValidSizeFiled(final String fieldName, final Integer minSize, final Integer maxSize) {
		final boolean isValidSizeFiled = true;
		if (fieldName == null || fieldName.isEmpty()) {
			return false;
		}
		if (fieldName.length() < minSize) {
			return false;
		}
		if (maxSize != null && fieldName.length() > maxSize) {
			return false;
		}
		return isValidSizeFiled;
	}

	/**
	 * Checks if is value exist in list.
	 *
	 * @param inputString
	 *            the input string
	 * @param inputList
	 *            the input list
	 * @return true, if is value exist in list
	 */
	public static boolean isValueExistInList(final String inputString, final List<String> inputList) {
		boolean isValueExistInList = true;
		if (inputString == null || inputString.isEmpty() || inputList == null || inputList.isEmpty()) {
			return false;
		}
		if (!inputList.contains(inputString)) {
			isValueExistInList = false;
		}
		return isValueExistInList;
	}

	/**
	 * Generate salt.
	 *
	 * @param length
	 *            the length
	 * @return the string
	 */
	public static String generateSalt(final int length) {
		final Random rng = new Random();
		String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwzyz";
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	/**
	 * Salt password.
	 *
	 * @param password
	 *            the password
	 * @param salt
	 *            the salt
	 * @return the string
	 */
	public static String saltPassword(final String password, final String salt) {
		return salt.substring(0, 16) + password + salt.substring(16, 32);
	}

	/**
	 * Hash password.
	 *
	 * @param password
	 *            the password
	 * @return the string
	 */
	public static String hashPassword(final String password) {

		final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		byte[] input = null;
		try {
			input = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		digest.update(input);
		final byte[] output = digest.digest();
		final StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < output.length; i++) {
			buffer.append(hexDigits[(0xf0 & output[i]) >> 4]);
			buffer.append(hexDigits[0x0f & output[i]]);
		}
		return buffer.toString();

	}

	/**
	 * Gets the current gmt timestamp.
	 *
	 * @return the current gmt timestamp
	 */
	public static Timestamp getCurrentGMTTimestamp() {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ApplicationConstants.DEFAULT_TIMESTAMP_FORMAT);
		final ZoneId inputZone = ZoneId.of(ApplicationConstants.ZONE_ID_UTC);
		final LocalDateTime date = LocalDateTime.now(inputZone);
		return Timestamp.valueOf(date.format(formatter).toString());
	}

	/**
	 * Gets the image location.
	 *
	 * @param imageURL
	 *            the image url
	 * @return the image location
	 * @throws InternalServerException
	 *             the common exception
	 */
	public static String getImageLocation(String imageURL) throws InternalServerException {

		BufferedImage img = null;
		try {
			URL url = new URL(imageURL);
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String lsFilePath = "";
		try {
			String uploadFile = ServiceConstants.CAPTCHA_IMAGE_FILE_NAME + ".png";
			File f = new File(uploadFile);
			// write the image
			ImageIO.write(img, "png", f);
			lsFilePath = f.getAbsolutePath();
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}

		return lsFilePath;
	}

	/**
	 * Gets the image location.
	 *
	 * @param fsBase64
	 *            the fs base64
	 * @param fsFileName
	 *            the fs file name
	 * @return the image location
	 * @throws InternalServerException
	 *             the common exception
	 */
	public static String getImageLocation(String fsBase64, String fsFileName) throws InternalServerException {
		String lsFilePath = "";
		String base64String = fsBase64;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes = null;
		try {
			decodedBytes = decoder.decodeBuffer(base64String);
			String uploadFile = fsFileName;
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
			image = decodeToImage(base64String);
			File f = new File(uploadFile);

			ImageIO.write(image, FilenameUtils.getExtension(fsFileName), f);
			lsFilePath = f.getAbsolutePath();
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}

		return lsFilePath;
	}

	public static String saveFileIntoLocal(String fsBase64, String fsFileName) throws InternalServerException {
		String lsFilePath = "";
		String base64String = fsBase64;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes = null;
		try {
			decodedBytes = decoder.decodeBuffer(base64String);
			String uploadFile = fsFileName;

			File f = new File(uploadFile);
			lsFilePath = f.getAbsolutePath();

			FileOutputStream writer = new FileOutputStream(uploadFile);
			writer.write(decodedBytes);
			writer.flush();
			writer.close();

		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}

		return lsFilePath;
	}

	public static String saveFileIntoAmazonS3(String bucketName, String folderName, String fsBase64, String fsFileName)
			throws InternalServerException {
		String lsFilePath = "";
		String base64String = fsBase64;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes = null;
		try {
			decodedBytes = decoder.decodeBuffer(base64String);
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}

		return lsFilePath;
	}

	/**
	 * Decode to image.
	 *
	 * @param imageString
	 *            the image string
	 * @return the buffered image
	 */
	public static BufferedImage decodeToImage(String imageString) {
		BufferedImage image = null;
		byte[] imageByte;
		String base64Image = imageString.split(",")[1];
		BASE64Decoder decoder = new BASE64Decoder();
		ByteArrayInputStream bis = null;
		try {
			imageByte = decoder.decodeBuffer(base64Image);
			bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}
		return image;
	}

	/**
	 * Call url.
	 *
	 * @param myURL
	 *            the my url
	 * @return the external service response
	 * @throws InternalServerException
	 *             the common exception
	 */
	public static ExternalServiceResponse callURL(String myURL) throws InternalServerException {
		ExternalServiceResponse serviceResponse = new ExternalServiceResponse();

		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(120 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();

		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
		serviceResponse.setResponseHeaders(urlConn.getHeaderFields());
		serviceResponse.setResponse(sb.toString());

		return serviceResponse;
	}

	/**
	 * Gets the final captcha.
	 *
	 * @param captcha
	 *            the captcha
	 * @return the final captcha
	 */
	public static String getFinalCaptcha(String captcha) {
		String finalCaptcha = "";
		String[] lines = captcha.split("\r\n|\r|\n");
		String firstLine = "";
		if (lines != null && lines.length > 0) {
			firstLine = lines[0];
		}
		String nextLine = "";
		if (lines != null && lines.length > 1) {
			nextLine = lines[1];
		}
		if (firstLine != null && !firstLine.isEmpty()) {
			for (int i = 0; i < firstLine.length(); i++) {
				Character c = firstLine.charAt(i);
				if (c == ' ') {
					if (nextLine != null && !nextLine.isEmpty()) {
						c = nextLine.charAt(0);
					}
				}
				finalCaptcha += String.valueOf(convertString(c));
			}
		}
		if (nextLine != null && !nextLine.isEmpty()) {
			for (int i = 0; i < nextLine.length(); i++) {
				Character c = nextLine.charAt(i);
				if (c == ' ') {
					if (firstLine != null && !nextLine.isEmpty()) {
						c = firstLine.charAt(0);
					}
				}
				finalCaptcha += String.valueOf(convertString(c));
			}
		}
		return finalCaptcha;
	}

	/**
	 * Convert string.
	 *
	 * @param inputChar
	 *            the input char
	 * @return the character
	 */
	public static Character convertString(char inputChar) {
		Character returnChar;
		switch (inputChar) {
		case 'G':
			returnChar = '6';
			break;
		case 'B':
			returnChar = '8';
			break;
		default:
			returnChar = inputChar;
			break;
		}
		return returnChar;
	}

	public static void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {
		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static boolean isValidExcelFile(String fileName) {
		ArrayList<String> excelFileTypes = new ArrayList<>();
		excelFileTypes.add("xls");
		excelFileTypes.add("xlsx");
		String fileExtension = FilenameUtils.getExtension(fileName);
		if (fileExtension != null && excelFileTypes.contains(fileExtension)) {
			return true;
		} else {
			return false;
		}
	}

	public static Workbook getWorkBookFromFileName(String inputFileName) throws InternalServerException {

		Workbook workbook = null;
		if (FilenameUtils.getExtension(inputFileName)
				.equalsIgnoreCase(ServiceConstants.EXCEL_SHEET_TYPE_XLS_EXTENSION)) {
			workbook = new HSSFWorkbook();

		} else if (FilenameUtils.getExtension(inputFileName)
				.equalsIgnoreCase(ServiceConstants.EXCEL_SHEET_TYPE_XLSX_EXTENSION)) {
			workbook = new XSSFWorkbook();
		}
		return workbook;
	}

	public static void createExcelFile(String directoryPath, String fileName) throws InternalServerException {
		String outPutFilePath = "";

		outPutFilePath = directoryPath + fileName;
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File outPutFile = new File(outPutFilePath);
		if (!outPutFile.exists()) {
			FileOutputStream fileOut = null;
			try {
				fileOut = new FileOutputStream(outPutFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Workbook wb = getWorkBookFromFileName(outPutFilePath);
			try {
				wb.write(fileOut);
				fileOut.close();
				wb.close();
			} catch (IOException e) {
				throw new InternalServerException(e.getMessage());
			}

		}
	}

	public static Workbook getWorkBookFromFile(String inputFilePath) throws InternalServerException {

		InputStream fs = null;

		try {
			fs = new URL(inputFilePath.replace(" ", "%20")).openStream();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		Workbook workbook = null;
		if (fs != null) {
			if (FilenameUtils.getExtension(inputFilePath)
					.equalsIgnoreCase(ServiceConstants.EXCEL_SHEET_TYPE_XLS_EXTENSION)) {
				try {
					workbook = new HSSFWorkbook(fs);
				} catch (IOException e) {
					throw new InternalServerException(e.getMessage());
				}
			} else if (FilenameUtils.getExtension(inputFilePath)
					.equalsIgnoreCase(ServiceConstants.EXCEL_SHEET_TYPE_XLSX_EXTENSION)) {
				try {
					workbook = new XSSFWorkbook(fs);
				} catch (IOException e) {
					throw new InternalServerException(e.getMessage());
				}
			}
		}
		return workbook;
	}

	public static Workbook createWorkBook(String fileName) throws InternalServerException {

		Workbook workbook = null;
		if (FilenameUtils.getExtension(fileName).equalsIgnoreCase(ServiceConstants.EXCEL_SHEET_TYPE_XLS_EXTENSION)) {
			workbook = new HSSFWorkbook();
		} else if (FilenameUtils.getExtension(fileName)
				.equalsIgnoreCase(ServiceConstants.EXCEL_SHEET_TYPE_XLSX_EXTENSION)) {
			workbook = new XSSFWorkbook();

		}
		return workbook;
	}

	public static String removeEndsWith(String mainString, String endsWith) {
		String str = "";
		if (mainString != null && endsWith != null && !mainString.isEmpty() && !endsWith.isEmpty()
				&& mainString.trim().endsWith(endsWith.trim())) {
			str = mainString.trim().split(endsWith.trim())[0].trim();
		} else {
			str = mainString;
		}
		return str;
	}

	public static int getCurrentYear() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static void main(String args[]) {

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);

		System.out.println(year);

		String str = "Tuting-Yingkiong, Pangin, Nari-Koyu, Pasighat (West), Pasighat (East), Mebo, Mariyang-Geku, Anini, Dambuk, Roing,Tezu, Hayuliang, Chowkham, Namsai, Lekang, Bordumsa-Diyum, Miao, Nampong, Changlang South,Changlang North, Namsang, Khonsa East, Khonsa West, Borduria-Bagapani, Kanubari, Longding-Pumao, Pongchou-Wakka";
		String[] part = str.split("(?<=\\D)(?=\\d)");

		boolean isHavingHyphon = false;
		boolean isHavingDot = false;

		if (str.trim().charAt(1) == '-') {
			isHavingHyphon = true;
		}

		if (str.trim().charAt(1) == '.') {
			isHavingDot = true;
		}

		for (int i = 0; i < part.length; i++) {
			String eachStr = part[i];
			System.out.println(eachStr);
			Long locationCode = null;
			String locationName = "";

			if (eachStr.matches(".*\\d+.*") && isHavingDot) {
				locationCode = Long.parseLong(eachStr.split("\\.")[0]);
				locationName = eachStr.split("\\.")[1];
			} else if (eachStr.matches(".*\\d+.*") && isHavingHyphon) {
				locationCode = Long.parseLong(eachStr.split("-")[0]);
				locationName = eachStr.split("-")[1];
			} else {
				String[] locationNamesArray = eachStr.split(",");
				for (int j = 0; j < locationNamesArray.length; j++) {
					locationName = locationNamesArray[j];
				}
			}
			System.out.println(locationCode);
			if (locationName.contains("(")) {
				String[] subDistrictCodeArray = locationName.split("\\(");
				if (subDistrictCodeArray.length > 2) {
					locationName = subDistrictCodeArray[0] + "(" + subDistrictCodeArray[1];
				} else {
					locationName = subDistrictCodeArray[subDistrictCodeArray.length - 2];
				}
			}
			if (locationName.endsWith(".") || locationName.endsWith(",")) {
				locationName = locationName.substring(0, locationName.length() - 1);
			}
			System.out.println(locationName.trim());
		}
	}

	public static String getResolvedConflictedLocationName(String locationName) {
		for (String param : conflictLocationsMap.keySet()) {
			if (param.equalsIgnoreCase(locationName)) {
				locationName = conflictLocationsMap.get(locationName);
				break;
			}
		}
		return locationName;
	}

	public static boolean isListNotNullAndNotEmpty(List<?> inputList) {
		if (inputList != null && !inputList.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isSetNotNullAndNotEmpty(Set<?> inputSet) {
		if (inputSet != null && !inputSet.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean containsIgnoreCase(String str, String searchStr) {
		if (str == null || searchStr == null) {
			return false;
		}
		int len = searchStr.length();
		int max = str.length() - len;
		for (int i = 0; i <= max; i++) {
			if (str.regionMatches(true, i, searchStr, 0, len)) {
				return true;
			}
		}
		return false;
	}

	public static void removeStringFromStringArray(String[] myStringArray, String stringToRemove) {

		for (int i = 0; i < myStringArray.length; i++) {
			if (myStringArray[i].equals(stringToRemove)) {
				myStringArray[i] = null;
				break;
			}
		}
	}

	public static byte[] readBytesFromFile(String filePath) {

		FileInputStream fileInputStream = null;
		byte[] bytesArray = null;

		try {
			File file = new File(filePath);
			bytesArray = new byte[(int) file.length()];

			// read file into bytes[]
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bytesArray);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bytesArray;
	}
}
