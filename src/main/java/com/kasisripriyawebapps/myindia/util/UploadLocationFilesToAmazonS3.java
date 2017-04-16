package com.kasisripriyawebapps.myindia.util;

import java.io.File;
import java.io.FilenameFilter;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class UploadLocationFilesToAmazonS3 {

	private static String bucketName = "myindialocations";
	private static String SUFFIX = "/";
	private static String folderName = "Downloaded";
	private static String globalFolderName = "Global";
	private static String countryFolderName = "India";
	private static String urbanFolderName = "Urban";
	private static String ruralFolderName = "Rural";

	static {
		
	}

	private static void uploadCountriesToAmazonS3() {

		String countriesFilePath = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\My India\\MyIndia\\Locations\\Downloaded\\Global\\Countries.xls";
		String countriesFileName = folderName + SUFFIX + globalFolderName + SUFFIX + "Countries.xls";
		byte[] countryLocationsContent = CommonUtil.readBytesFromFile(countriesFilePath);
		try {
			AmazonS3Util.createFile(bucketName, null, countryLocationsContent, countriesFileName);
		} catch (InternalServerException e) {
			e.printStackTrace();
		}
	}

	private static void uploadStatesToAmazonS3() {

		String statesFilePath = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\My India\\MyIndia\\Locations\\Downloaded\\Global\\India\\States.xls";
		String statesFileName = folderName + SUFFIX + globalFolderName + SUFFIX + countryFolderName + SUFFIX
				+ "States.xls";
		byte[] stateLocationsContent = CommonUtil.readBytesFromFile(statesFilePath);
		try {
			AmazonS3Util.createFile(bucketName, null, stateLocationsContent, statesFileName);
		} catch (InternalServerException e) {
			e.printStackTrace();
		}
	}

	private static void uploadStateLocationBodiesToAmazonS3() {

		String statesFolderPath = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\My India\\MyIndia\\Locations\\Downloaded\\Global\\India";

		File locationsDirectoryFile = new File(statesFolderPath);

		if (locationsDirectoryFile.exists()) {
			String[] stateLocations = getSubDirectories(locationsDirectoryFile);
			if (stateLocations != null && stateLocations.length > 0) {
				for (String stateLocation : stateLocations) {
					String stateLocationDirectoryPath = statesFolderPath + SUFFIX + stateLocation + SUFFIX;

					String districtFileNameStr = "Districts.xls";
					String subDistrictFileNameStr = "Sub Districts.xls";
					String urbanBodiesFileNameStr = "Urban Bodies.xls";
					String urbanLocalBodiesFileNameStr = "Urban Local Bodies.xls";
					String villagePanchayathiesFileNameStr = "Village Panchayathies.xls";
					String villagesFileNameStr = "Villages.xls";

					String districtLocationFilePath = stateLocationDirectoryPath + districtFileNameStr;
					String subDistrictLocationFilePath = stateLocationDirectoryPath + subDistrictFileNameStr;
					String urbanLocationFilePath = stateLocationDirectoryPath + urbanBodiesFileNameStr;
					String urbanLocalLocationFilePath = stateLocationDirectoryPath + urbanLocalBodiesFileNameStr;
					String villagePanchayathLocationFilePath = stateLocationDirectoryPath
							+ villagePanchayathiesFileNameStr;
					String villageLocationFilePath = stateLocationDirectoryPath + villagesFileNameStr;

					byte[] districtLocationContent = CommonUtil.readBytesFromFile(districtLocationFilePath);
					byte[] subDistrictLocationContent = CommonUtil.readBytesFromFile(subDistrictLocationFilePath);
					byte[] urbanLocationContent = CommonUtil.readBytesFromFile(urbanLocationFilePath);
					byte[] urbanLocalLocationContent = CommonUtil.readBytesFromFile(urbanLocalLocationFilePath);
					byte[] villagePanchayathLocationContent = CommonUtil
							.readBytesFromFile(villagePanchayathLocationFilePath);
					byte[] villageLocationContent = CommonUtil.readBytesFromFile(villageLocationFilePath);

					String direcotryPath = folderName + SUFFIX + globalFolderName + SUFFIX + countryFolderName + SUFFIX
							+ stateLocation + SUFFIX;

					String districtsFileName = direcotryPath + ruralFolderName + SUFFIX + districtFileNameStr;
					String subDistrictsFileName = direcotryPath + ruralFolderName + SUFFIX + subDistrictFileNameStr;
					String urbanBodiesFileName = direcotryPath + urbanFolderName + SUFFIX + urbanBodiesFileNameStr;
					String urbanLocalBodiesFileName = direcotryPath + urbanFolderName + SUFFIX
							+ urbanLocalBodiesFileNameStr;
					String villagePanchayathiesFileName = direcotryPath + ruralFolderName + SUFFIX
							+ villagePanchayathiesFileNameStr;
					String villagesFileName = direcotryPath + ruralFolderName + SUFFIX + villagesFileNameStr;

					try {
						AmazonS3Util.createFile(bucketName, stateLocation, districtLocationContent, districtsFileName);

						AmazonS3Util.createFile(bucketName, stateLocation, subDistrictLocationContent,
								subDistrictsFileName);
						AmazonS3Util.createFile(bucketName, stateLocation, urbanLocationContent, urbanBodiesFileName);
						AmazonS3Util.createFile(bucketName, stateLocation, urbanLocalLocationContent,
								urbanLocalBodiesFileName);
						AmazonS3Util.createFile(bucketName, stateLocation, villagePanchayathLocationContent,
								villagePanchayathiesFileName);
						AmazonS3Util.createFile(bucketName, stateLocation, villageLocationContent, villagesFileName);

					} catch (InternalServerException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	public static void main(String argv[]) {
		uploadCountriesToAmazonS3();
		uploadStatesToAmazonS3();
		uploadStateLocationBodiesToAmazonS3();
	}

	private static String[] getSubDirectories(File locationsDirectoryFile) {

		String[] directories = locationsDirectoryFile.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		return directories;
	}

}
