package com.kasisripriyawebapps.myindia.endpoints;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianImportExportRequest;
import com.kasisripriyawebapps.myindia.service.PoliticianImportExportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.POLITICIN_IMPORT_EXPORT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.POLITICIN_IMPORT_EXPORT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.POLITICIN_IMPORT_EXPORT_ENDPOINT_API_TAGS }, description = EndPointConstants.POLITICIN_IMPORT_EXPORT_ENDPOINT_API_DESCRIPTION)

public class PoliticianImportEndpoint {

	@Autowired
	PoliticianImportExportService politicianImportExportService;

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_LOKSABHA_MP_API_VALUE, nickname = EndPointConstants.IMPORT_LOKSABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_LOKSABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_LOKSABHA_MP_REQUEST_MAPPING)
	public Response importLoksabhaMP() throws InternalServerException {
		politicianImportExportService.importLoksabhaMPs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_LOKSABHA_MP_API_VALUE, nickname = EndPointConstants.EXPORT_LOKSABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_LOKSABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_LOKSABHA_MP_REQUEST_MAPPING)
	public Response exportLoksabhaMP() throws InternalServerException {
		politicianImportExportService.exportLoksabhaMPs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_RAJYASABHA_MP_API_VALUE, nickname = EndPointConstants.IMPORT_RAJYASABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_RAJYASABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_RAJYASABHA_MP_REQUEST_MAPPING)
	public Response importRajyasabhaMP() throws InternalServerException {
		politicianImportExportService.importRajyasabhaMPs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_RAJYASABHA_MP_API_VALUE, nickname = EndPointConstants.EXPORT_RAJYASABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_RAJYASABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_RAJYASABHA_MP_REQUEST_MAPPING)
	public Response exportRajyasabhaMP() throws InternalServerException {
		politicianImportExportService.exportRajyasabhaMPs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_GP_SARPANCH_API_VALUE, nickname = EndPointConstants.EXPORT_GP_SARPANCH_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_GP_SARPANCH_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_GP_SARPANCH_REQUEST_MAPPING)
	public Response exportGPSarpanch(PoliticianImportExportRequest politicianImport)
			throws InternalServerException, IOException {
		politicianImportExportService.exportGPSarpanch(politicianImport);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_GP_SARPANCH_API_VALUE, nickname = EndPointConstants.IMPORT_GP_SARPANCH_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_GP_SARPANCH_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_GP_SARPANCH_REQUEST_MAPPING)
	public Response importGPSarpanch(PoliticianImportExportRequest politicianImport)
			throws InternalServerException, IOException {
		politicianImportExportService.importGPSarpanch(politicianImport);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	
	
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_MLA_API_VALUE, nickname = EndPointConstants.IMPORT_MLA_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_MLA_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_MLA_REQUEST_MAPPING)
	public Response importMLA() throws InternalServerException {
		politicianImportExportService.importMLAs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_MLA_API_VALUE, nickname = EndPointConstants.EXPORT_MLA_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_MLA_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_MLA_REQUEST_MAPPING)
	public Response exportMLA() throws InternalServerException {
		politicianImportExportService.exportMLAs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_CHIEF_MINISTER_API_VALUE, nickname = EndPointConstants.IMPORT_CHIEF_MINISTER_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_CHIEF_MINISTER_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_CHIEF_MINISTER_REQUEST_MAPPING)
	public Response importChiefMinisters() throws InternalServerException {
		politicianImportExportService.importChiefMinisters();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_GOVERNOR_API_VALUE, nickname = EndPointConstants.IMPORT_GOVERNOR_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_GOVERNOR_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_GOVERNOR_REQUEST_MAPPING)
	public Response importGovernors() throws InternalServerException {
		politicianImportExportService.importGovernors();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_CHIEF_MINISTER_API_VALUE, nickname = EndPointConstants.EXPORT_CHIEF_MINISTER_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_CHIEF_MINISTER_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_CHIEF_MINISTER_REQUEST_MAPPING)
	public Response exportChiefMinisters() throws InternalServerException {
		politicianImportExportService.exportChiefMinisters();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_GOVERNOR_API_VALUE, nickname = EndPointConstants.EXPORT_GOVERNOR_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_GOVERNOR_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_GOVERNOR_REQUEST_MAPPING)
	public Response exportGovernors() throws InternalServerException {
		politicianImportExportService.exportGovernors();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

}
