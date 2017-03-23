package com.kasisripriyawebapps.myindia.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class AmazonS3Util {

	/*static {
		System.setProperty("http.proxyHost", "proxy.cat.com");
		System.setProperty("http.proxyPort", "80");
		System.setProperty("https.proxyHost", "proxy.cat.com");
		System.setProperty("https.proxyPort", "80");
	}*/

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
				ClientConfiguration clientConfig = new ClientConfiguration();
				clientConfig.setProtocol(Protocol.HTTP);
				s3Client = new AmazonS3Client(credentials, clientConfig);
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

	protected static void createFile(String bucketName, String folderName, File fileObj, String fileName)
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
			ByteArrayInputStream input = new ByteArrayInputStream(fileContent);
			s3Client.putObject(bucketName, fileName, input, new ObjectMetadata());
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

	public static void main(String[] argv) {
		try {
			String fileName = "problems" + SUFFIX + "Desert.jpg";
			createFile("myindiaproblems", "problems",
					new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg"), fileName);
		} catch (InternalServerException e) {
			e.printStackTrace();
		}
	}
}
