package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface PoliticianImportExportService {
	
	void importExportLoksabhaMPs() throws InternalServerException;

	void importExportRajyasabhaMPs() throws InternalServerException;

	void importExportMLA() throws InternalServerException; 
	
	void importExportChiefMinistors() throws InternalServerException;
	
    void importExportGoverners() throws InternalServerException;

	void importVillageSarpanchas()  throws InternalServerException;
}
