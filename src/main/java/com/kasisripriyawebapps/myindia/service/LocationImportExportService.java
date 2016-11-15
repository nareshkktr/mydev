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

	boolean exportCountries(String uploadedFileLocation) throws InternalServerException;

	boolean exportStates(String inputFilePath) throws InternalServerException;

	boolean exportDistricts(String inputFilePath) throws InternalServerException;

	boolean exportSubDistricts(String inputFilePath) throws InternalServerException;

	boolean exportMuncipalCorporations(String inputFilePath) throws InternalServerException;

	boolean exportMuncipalities(String inputFilePath) throws InternalServerException;

	boolean exportTownPanchayathies(String inputFilePath) throws InternalServerException;

	boolean exportVillagePanchayathies(String inputFilePath) throws InternalServerException;

	boolean exportVillages(String inputFilePath) throws InternalServerException;

	boolean exportVillageReferenceLocations(String uploadedFileLocation) throws InternalServerException;

	boolean exportUrbanReferenceLocations(String uploadedFileLocation) throws InternalServerException;

	boolean importVillageReferenceLocations(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importConstituencyLocations() throws InternalServerException;

	boolean importUrbanReferenceLocations(LocationImportRequest locationImportRequest) throws InternalServerException;

	boolean importExportAllLocations() throws InternalServerException;

}
