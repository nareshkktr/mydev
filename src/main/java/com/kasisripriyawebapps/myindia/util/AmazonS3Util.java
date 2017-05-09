package com.kasisripriyawebapps.myindia.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Workbook;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class AmazonS3Util {

	private static AmazonS3Util amazonS3Util = new AmazonS3Util();
	private static final String SUFFIX = "/";

	private AmazonS3Util() {
	}

	public static AmazonS3Util getInstance() {
		return amazonS3Util;
	}

	private static AmazonS3 s3Client = null;

	protected static void intializeAmazonS3Client() throws InternalServerException {

		if (s3Client == null) {
			try {
				AWSCredentials credentials = new BasicAWSCredentials("AKIAICXYUEBKQRPOMV6A",
						"1dtBl9l8A3TUf1EPhKVnw5d7nzJQebqkswsCa+sG");
				s3Client = new AmazonS3Client(credentials);
			} catch (Exception e) {
				throw new InternalServerException(e.getMessage());
			}
		}
	}

	protected static void createBucket(String bucketName) throws InternalServerException {
		intializeAmazonS3Client();
		try {
			s3Client.createBucket(bucketName);
		} catch (AmazonServiceException e) {
			throw new InternalServerException(e.getErrorMessage());
		}
	}

	protected static void createBucketFolder(String bucketName, String folderName) throws InternalServerException {
		try {
			intializeAmazonS3Client();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(0);
			InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + SUFFIX, emptyContent,
					metadata);
			s3Client.putObject(putObjectRequest);
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public static void createFile(String bucketName, String folderName, File fileObj, String fileName)
			throws InternalServerException {
		try {
			intializeAmazonS3Client();

			if (!isBucketExists(bucketName)) {
				createBucket(bucketName);
			}

			s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj)
					.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	public static void createFile(String bucketName, String folderName, byte[] fileContent, String fileName)
			throws InternalServerException {
		try {
			intializeAmazonS3Client();

			if (!isBucketExists(bucketName)) {
				createBucket(bucketName);
			}

			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(fileContent.length);

			InputStream input = new ByteArrayInputStream(fileContent);
			s3Client.putObject(bucketName, fileName, input, metadata);

			s3Client.setObjectAcl(bucketName, fileName, CannedAccessControlList.PublicRead);

		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	protected static Boolean isFolderExists(String bucketName, String folderName) throws InternalServerException {
		Boolean isFolderExists = false;
		intializeAmazonS3Client();
		List fileList = s3Client.listObjects(bucketName, folderName).getObjectSummaries();
		if (CommonUtil.isListNotNullAndNotEmpty(fileList)) {
			isFolderExists = true;
		}
		return isFolderExists;
	}

	protected static Boolean isBucketExists(String bucketName) throws InternalServerException {
		Boolean isBucketExists = false;
		intializeAmazonS3Client();
		for (Bucket bucket : s3Client.listBuckets()) {
			String eachBucketName = bucket.getName();
			if (eachBucketName.equalsIgnoreCase(bucketName)) {
				isBucketExists = true;
				break;
			}
		}
		return isBucketExists;
	}

	private final static char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
			.toCharArray();

	public static String encode(byte[] buf) {
		int size = buf.length;
		char[] ar = new char[((size + 2) / 3) * 4];
		int a = 0;
		int i = 0;
		while (i < size) {
			byte b0 = buf[i++];
			byte b1 = (i < size) ? buf[i++] : 0;
			byte b2 = (i < size) ? buf[i++] : 0;

			int mask = 0x3F;
			ar[a++] = ALPHABET[(b0 >> 2) & mask];
			ar[a++] = ALPHABET[((b0 << 4) | ((b1 & 0xFF) >> 4)) & mask];
			ar[a++] = ALPHABET[((b1 << 2) | ((b2 & 0xFF) >> 6)) & mask];
			ar[a++] = ALPHABET[b2 & mask];
		} // while

		switch (size % 3) {
		case 1:
			ar[--a] = '=';
		case 2:
			ar[--a] = '=';
		}// switch
		return new String(ar);
	}

	public static String imageToBase64String(File imageFile) throws Exception {

		String image = null;
		BufferedImage buffImage = ImageIO.read(imageFile);

		if (buffImage != null) {
			java.io.ByteArrayOutputStream os = new java.io.ByteArrayOutputStream();
			ImageIO.write(buffImage, "jpg", os);
			byte[] data = os.toByteArray();
			image = encode(data);

			// write to file the encoded character
			/*
			 * FileOutputStream fout =new
			 * FileOutputStream("c:\\temp\\encodedImage.txt");
			 * OutputStreamWriter out = new OutputStreamWriter(fout, "utf-8");
			 * out.write(image); out.close();
			 */
		} // if
		return image;
	}
	
	public static void writeExcelDataIntoAmazonS3File(String fileName, Workbook exportWorkBook, String bucketName,
			String uploadedFolderName) throws InternalServerException {
		FileOutputStream os = null;
		try {
			File exportedFile = new File(fileName);
			os = new FileOutputStream(exportedFile);
			try {
				exportWorkBook.write(os);
				os.close();
				exportWorkBook.close();

				AmazonS3Util.createFile(bucketName, null, exportedFile, uploadedFolderName + SUFFIX + fileName);

			} catch (IOException e) {
				throw new InternalServerException(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			throw new InternalServerException(e.getMessage());
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
	
	public static List<String> getListOfObjects(String bucketName, String prefixPath) throws InternalServerException{
		intializeAmazonS3Client();
		
		if(!prefixPath.endsWith("/")){
			prefixPath +=ApplicationConstants.SUFFIX;
		}
		
		ListObjectsRequest lor = new ListObjectsRequest().withBucketName(bucketName)
                .withPrefix(prefixPath)
                .withDelimiter("/");
		
		ObjectListing fileList = s3Client.listObjects(lor);
		
		List<String> files = fileList.getCommonPrefixes();
		
		return files;
	}

	public static void main(String argv[]) throws Exception {		
		File exportedFile = new File("C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\My India\\MyIndia\\ProblemTypes.xls");
		createFile("myindiaproblems",null,exportedFile,"problemtypes/ProblemTypes.xls");
		
	}

}
