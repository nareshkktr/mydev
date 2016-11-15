package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;

public interface UserImportService {

	void saveStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException, RecordNotFoundException;

	void saveStateElectroralRolleData(ElectroralRollesURL electroralRollesURL) throws InternalServerException;

}
