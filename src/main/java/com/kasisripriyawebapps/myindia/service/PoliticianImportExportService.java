package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface PoliticianImportExportService {
	
	void importExportLoksabhaMPs() throws InternalServerException;

	void importExportRajyasabhaMPs() throws InternalServerException; 

}
