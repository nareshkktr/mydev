package com.kasisripriyawebapps.myindia.util;

import java.io.File;
import java.io.FilenameFilter;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public class UploadLocationFilesToAmazonS3 {

	private static final String BUCKET_NAME = "myindialocations";
	private static final String SUFFIX = "/";
	private static final String FOLDER_NAME = "Downloaded";
	private static final String GLOBAL_FOLDER_NAME = "Global";
	private static final String COUNTRY_FOLDER_NAME = "India";
	private static final String URBAN_FOLDER_NAME = "Urban";
	private static final String RURAL_FOLDER_NAME = "Rural";

	private static void uploadCountriesToAmazonS3() {

		final String countriesFilePath = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\My India\\MyIndia\\Locations\\Downloaded\\Global\\Countries.xls";
		final String countriesFileName = FOLDER_NAME + SUFFIX + GLOBAL_FOLDER_NAME + SUFFIX + "Countries.xls";
		final byte[] countryLocationsContent = CommonUtil.readBytesFromFile(countriesFilePath);
		try {
			AmazonS3Util.createFile(BUCKET_NAME, null, countryLocationsContent, countriesFileName);
		} catch (InternalServerException e) {
			e.printStackTrace();
		}
	}

	private static void uploadStatesToAmazonS3() {

		final String statesFilePath = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\My India\\MyIndia\\Locations\\Downloaded\\Global\\India\\States.xls";
		final String statesFileName = FOLDER_NAME + SUFFIX + GLOBAL_FOLDER_NAME + SUFFIX + COUNTRY_FOLDER_NAME + SUFFIX
				+ "States.xls";
		final byte[] stateLocationsContent = CommonUtil.readBytesFromFile(statesFilePath);
		try {
			AmazonS3Util.createFile(BUCKET_NAME, null, stateLocationsContent, statesFileName);
		} catch (InternalServerException e) {
			e.printStackTrace();
		}
	}

	private static void uploadStateLocationBodiesToAmazonS3() {

		final String statesFolderPath = "C:\\Users\\kanduk\\Documents\\My Work\\Documents\\My Web Sites\\My India\\MyIndia\\Locations\\Downloaded\\Global\\India";

		final File locationsDirectoryFile = new File(statesFolderPath);

		if (locationsDirectoryFile.exists()) {
			String[] stateLocations = getSubDirectories(locationsDirectoryFile);
			if (stateLocations != null && stateLocations.length > 0) {
				for (String stateLocation : stateLocations) {
					
					final String stateLocationDirectoryPath = statesFolderPath + SUFFIX + stateLocation + SUFFIX;

					final String districtFileNameStr = "Districts.xls";
					final String subDistrictFileNameStr = "Sub Districts.xls";
					final String urbanBodiesFileNameStr = "Urban Bodies.xls";
					final String urbanLocalBodiesFileNameStr = "Urban Local Bodies.xls";
					final String villagePanchayathiesFileNameStr = "Village Panchayathies.xls";
					final String villagesFileNameStr = "Villages.xls";

					final String districtLocationFilePath = stateLocationDirectoryPath + districtFileNameStr;
					final String subDistrictLocationFilePath = stateLocationDirectoryPath + subDistrictFileNameStr;
					final String urbanLocationFilePath = stateLocationDirectoryPath + urbanBodiesFileNameStr;
					final String urbanLocalLocationFilePath = stateLocationDirectoryPath + urbanLocalBodiesFileNameStr;
					final String villagePanchayathLocationFilePath = stateLocationDirectoryPath
							+ villagePanchayathiesFileNameStr;
					final String villageLocationFilePath = stateLocationDirectoryPath + villagesFileNameStr;

					final byte[] districtLocationContent = CommonUtil.readBytesFromFile(districtLocationFilePath);
					final byte[] subDistrictLocationContent = CommonUtil.readBytesFromFile(subDistrictLocationFilePath);
					final byte[] urbanLocationContent = CommonUtil.readBytesFromFile(urbanLocationFilePath);
					final byte[] urbanLocalLocationContent = CommonUtil.readBytesFromFile(urbanLocalLocationFilePath);
					final byte[] villagePanchayathLocationContent = CommonUtil
							.readBytesFromFile(villagePanchayathLocationFilePath);
					final byte[] villageLocationContent = CommonUtil.readBytesFromFile(villageLocationFilePath);

					final String direcotryPath = FOLDER_NAME + SUFFIX + GLOBAL_FOLDER_NAME + SUFFIX + COUNTRY_FOLDER_NAME
							+ SUFFIX + stateLocation + SUFFIX;

					final String districtsFileName = direcotryPath + RURAL_FOLDER_NAME + SUFFIX + districtFileNameStr;
					final String subDistrictsFileName = direcotryPath + RURAL_FOLDER_NAME + SUFFIX + subDistrictFileNameStr;
					final String urbanBodiesFileName = direcotryPath + URBAN_FOLDER_NAME + SUFFIX + urbanBodiesFileNameStr;
					final String urbanLocalBodiesFileName = direcotryPath + URBAN_FOLDER_NAME + SUFFIX
							+ urbanLocalBodiesFileNameStr;
					final String villagePanchayathiesFileName = direcotryPath + RURAL_FOLDER_NAME + SUFFIX
							+ villagePanchayathiesFileNameStr;
					final String villagesFileName = direcotryPath + RURAL_FOLDER_NAME + SUFFIX + villagesFileNameStr;

					try {
						AmazonS3Util.createFile(BUCKET_NAME, stateLocation, districtLocationContent, districtsFileName);

						AmazonS3Util.createFile(BUCKET_NAME, stateLocation, subDistrictLocationContent,
								subDistrictsFileName);
						AmazonS3Util.createFile(BUCKET_NAME, stateLocation, urbanLocationContent, urbanBodiesFileName);
						AmazonS3Util.createFile(BUCKET_NAME, stateLocation, urbanLocalLocationContent,
								urbanLocalBodiesFileName);
						AmazonS3Util.createFile(BUCKET_NAME, stateLocation, villagePanchayathLocationContent,
								villagePanchayathiesFileName);
						AmazonS3Util.createFile(BUCKET_NAME, stateLocation, villageLocationContent, villagesFileName);

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
