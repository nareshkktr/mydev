package com.kasisripriyawebapps.myindia.service;

import java.io.IOException;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianImportExportRequest;

public interface PoliticianImportExportService {
	
	void importLoksabhaMPs() throws InternalServerException;

	void importRajyasabhaMPs() throws InternalServerException;

	void importExportMLA() throws InternalServerException; 
	
	void importExportChiefMinistors() throws InternalServerException;

	void importMinistries() throws InternalServerException;

	void importExportGoverners() throws InternalServerException;
	
	void importVillageSarpanchas()  throws InternalServerException;

	void exportLoksabhaMPs(PoliticianImportExportRequest politicianImport) throws InternalServerException;

	void exportRajyasabhaMPs(PoliticianImportExportRequest politicianImport) throws InternalServerException;

	void exportGPSarpanch(PoliticianImportExportRequest politicianImport) throws InternalServerException, IOException;

	void exportMLA(PoliticianImportExportRequest politicianImport) throws InternalServerException;
	
}
