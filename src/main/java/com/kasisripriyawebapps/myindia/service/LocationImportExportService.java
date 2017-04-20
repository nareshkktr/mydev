package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.dto.LocationImportRequest;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface LocationImportExportService {

	boolean importCountries(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importStates(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importDistricts(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importSubDistricts(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importMuncipalCorporations(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importMuncipalities(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importTownPanchayathies(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importVillagePanchayathies(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importVillages(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean exportCountries() throws InternalServerException;

	boolean exportStates() throws InternalServerException;

	boolean exportDistricts() throws InternalServerException;

	boolean exportSubDistricts() throws InternalServerException;

	boolean exportMuncipalCorporations() throws InternalServerException;

	boolean exportMuncipalities() throws InternalServerException;

	boolean exportTownPanchayathies() throws InternalServerException;

	boolean exportVillagePanchayathies() throws InternalServerException;

	boolean exportVillages() throws InternalServerException;

	boolean exportVillageReferenceLocations() throws InternalServerException;

	boolean exportUrbanReferenceLocations() throws InternalServerException;

	boolean importVillageReferenceLocations() throws InternalServerException;

	boolean importMPConstituencyLocations() throws InternalServerException;

	boolean importUrbanReferenceLocations() throws InternalServerException;

	boolean importMLAConstituencyLocations() throws InternalServerException;

	void exportMPConstituencyLocations() throws InternalServerException;

	void exportMLAConstituencyLocations() throws InternalServerException;

}
