package com.kasisripriyawebapps.myindia.service;

import java.io.IOException;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianImportExportRequest;

public interface PoliticianImportExportService {

	void importLoksabhaMPs() throws InternalServerException;

	void importRajyasabhaMPs() throws InternalServerException;

	void importMLAs() throws InternalServerException;

	void importChiefMinisters() throws InternalServerException;

	void importMinistries() throws InternalServerException;

	void importGovernors() throws InternalServerException;

	void importVillageSarpanchas() throws InternalServerException;

	void exportLoksabhaMPs() throws InternalServerException;

	void exportRajyasabhaMPs() throws InternalServerException;

	void exportGPSarpanch(PoliticianImportExportRequest politicianImport) throws InternalServerException, IOException;

	void exportMLAs() throws InternalServerException;

	void exportChiefMinisters() throws InternalServerException;

	void exportGovernors() throws InternalServerException;

	void importGPSarpanch(PoliticianImportExportRequest politicianImport) throws InternalServerException;
	
}
