package com.kasisripriyawebapps.myindia.endpoints;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.dto.LocationImportRequest;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.service.LocationImportExportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.LOCATION_IMPORT_EXPORT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.LOCATION_IMPORT_EXPORT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.LOCATION_IMPORT_EXPORT_ENDPOINT_API_TAGS }, description = EndPointConstants.LOCATION_IMPORT_EXPORT_ENDPOINT_API_DESCRIPTION)
public class LocationImportExportEndPoint extends BaseEndPoint {

	@Autowired
	LocationImportExportService locationImportExportService;

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_COUNTRY_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_COUNTRY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_COUNTRY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_COUNTRY_LOCATIONS_REQUEST_MAPPING)
	public Response importCountryLocations(LocationImportRequest locationImportRequest) throws InternalServerException {
		locationImportExportService.importCountries(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_STATE_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_STATE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_STATE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_STATE_LOCATIONS_REQUEST_MAPPING)
	public Response importStateLocations(LocationImportRequest locationImportRequest) throws InternalServerException {
		locationImportExportService.importStates(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_DISTRICT_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_DISTRICT_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_DISTRICT_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_DISTRICT_LOCATIONS_REQUEST_MAPPING)
	public Response importDistrictLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		locationImportExportService.importDistricts(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_SUB_DISTRICT_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_SUB_DISTRICT_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_SUB_DISTRICT_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_SUB_DISTRICT_LOCATIONS_REQUEST_MAPPING)
	public Response importSubDistrictLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		locationImportExportService.importSubDistricts(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_MUNCIPAL_CORPORATION_LOCATIONS_REQUEST_MAPPING)
	public Response importMuncipalCorporationLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		locationImportExportService.importMuncipalCorporations(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_MUNCIPALITY_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_MUNCIPALITY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_MUNCIPALITY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_MUNCIPALITY_LOCATIONS_REQUEST_MAPPING)
	public Response importMuncipalityLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		locationImportExportService.importMuncipalities(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_TOWN_PANCHAYATH_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_TOWN_PANCHAYATH_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_TOWN_PANCHAYATH_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_TOWN_PANCHAYATH_LOCATIONS_REQUEST_MAPPING)
	public Response importTownPanchayathLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		locationImportExportService.importTownPanchayathies(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_VILLAGE_PANCHAYATH_LOCATIONS_REQUEST_MAPPING)
	public Response importVillagePanchayathLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException {
		locationImportExportService.importVillagePanchayathies(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_VILLAGE_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_VILLAGE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_VILLAGE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_VILLAGE_LOCATIONS_REQUEST_MAPPING)
	public Response importVillageLocations(LocationImportRequest locationImportRequest) throws InternalServerException {
		locationImportExportService.importVillages(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_VILLAGE_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_VILLAGE_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_VILLAGE_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_VILLAGE_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	public Response importVillageReferenceLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException, PreConditionRequiredException {
		locationImportExportService.importVillageReferenceLocations(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	public Response importUrbanReferenceLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException, PreConditionRequiredException {
		locationImportExportService.importUrbanReferenceLocations(locationImportRequest);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_CONSTITUENCY_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_CONSTITUENCY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_CONSTITUENCY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_CONSTITUENCY_LOCATIONS_REQUEST_MAPPING)
	public Response importConstituencyLocations() throws InternalServerException {
		locationImportExportService.importConstituencyLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_COUNTRY_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_COUNTRY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_COUNTRY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_COUNTRY_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportCountryLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportCountries(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_STATE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_STATE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_STATE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_STATE_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportStateLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportStates(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_DISTRICT_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_DISTRICT_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_DISTRICT_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_DISTRICT_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportDistrictLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportDistricts(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportSubDistrictLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportSubDistricts(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportMuncipalCorporationLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportMuncipalCorporations(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportMuncipalityLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportMuncipalities(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportTownPanchayathLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportTownPanchayathies(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportVillagePanchayathLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportVillagePanchayathies(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_VILLAGE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_VILLAGE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_VILLAGE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_VILLAGE_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportVillageLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportVillages(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportVillageReferenceLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportVillageReferenceLocations(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response exportUrbanReferenceLocations(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail)
			throws InternalServerException, PreConditionRequiredException {
		String uploadedFileLocation = uploadExcelFileToDisk(uploadedInputStream, fileDetail);
		locationImportExportService.exportUrbanReferenceLocations(uploadedFileLocation);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_EXPORT_ALL_MASTER_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_EXPORT_ALL_MASTER_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_EXPORT_ALL_MASTER_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_EXPORT_ALL_MASTER_LOCATIONS_REQUEST_MAPPING)
	public Response importExportAllMasterLocations() throws InternalServerException {
		locationImportExportService.importExportAllMasterLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_EXPORT_ALL_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_EXPORT_ALL_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_EXPORT_ALL_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_EXPORT_ALL_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	public Response importExportAllReferenceLocations() throws InternalServerException {
		locationImportExportService.importExportAllReferenceLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

}
