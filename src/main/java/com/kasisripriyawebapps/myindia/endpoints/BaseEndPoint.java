package com.kasisripriyawebapps.myindia.endpoints;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

public class BaseEndPoint {

	@Autowired
	private Environment env;

	protected String uploadExcelFileToDisk(InputStream uploadedInputStream, FormDataContentDisposition fileDetail)
			throws PreConditionRequiredException {
		String downLoadedTempDir = env.getProperty("project.locations-files.download.temp-path");
		String fileName = "";
		String uploadedFileLocation = "";
		if (uploadedInputStream != null && fileDetail != null) {
			fileName = fileDetail.getFileName();
			if (CommonUtil.isValidExcelFile(fileName)) {
				uploadedFileLocation = downLoadedTempDir + fileName;
				CommonUtil.writeToFile(uploadedInputStream, uploadedFileLocation);
			} else {
				throw new PreConditionRequiredException(ExceptionConstants.EXCEL_FILE_TYPE_VALIDATION);
			}
		}
		/*
		 * else{ throw new PreConditionRequiredException(ExceptionConstants.
		 * ATLEAST_ONE_FILE_REQUIRED); }
		 */
		return uploadedFileLocation;
	}
}
