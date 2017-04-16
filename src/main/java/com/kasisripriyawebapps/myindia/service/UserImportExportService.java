package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;

public interface UserImportExportService {

	void exportStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException, RecordNotFoundException;

	void exportElectroralRolleData(ElectroralRollesURL electroralRollesURL) throws InternalServerException;

	void importStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL)  throws InternalServerException;

	void importElectroralRolleData(ElectroralRollesURL electroralRollesURL) throws InternalServerException;

}
