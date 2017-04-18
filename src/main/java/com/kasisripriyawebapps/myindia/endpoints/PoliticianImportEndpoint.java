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

@Path(value = EndPointConstants.IMPORT_ALL_POLITICIANS_REQUEST_MAPPING)
@Api(value = EndPointConstants.IMPORT_ALL_POLITICIANS_API_VALUE, tags = {
		EndPointConstants.IMPORT_ALL_POLITICIANS_API_TAGS }, description = EndPointConstants.IMPORT_ALL_POLITICIANS_API_DESCRIPTION)

public class PoliticianImportEndpoint {
	
	@Autowired
	PoliticianImportExportService politicianImportExportService;
	
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_LOKSABHA_MP_API_VALUE, nickname = EndPointConstants.IMPORT_LOKSABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_LOKSABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_LOKSABHA_MP_REQUEST_MAPPING)
	public Response importAllLoksabhaMP()
			throws InternalServerException {
		politicianImportExportService.importExportLoksabhaMPs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_LOKSABHA_MP_API_VALUE, nickname = EndPointConstants.EXPORT_LOKSABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_LOKSABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_LOKSABHA_MP_REQUEST_MAPPING)
	public Response exportLoksabhaMP(PoliticianImportExportRequest politicianImport)
			throws InternalServerException {
		politicianImportExportService.exportLoksabhaMPs(politicianImport);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_RAJYASABHA_MP_API_VALUE, nickname = EndPointConstants.IMPORT_RAJYASABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_RAJYASABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_RAJYASABHA_MP_REQUEST_MAPPING)
	public Response importAllRajyasabhaMP()
			throws InternalServerException {
		politicianImportExportService.importExportRajyasabhaMPs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_RAJYASABHA_MP_API_VALUE, nickname = EndPointConstants.EXPORT_RAJYASABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_RAJYASABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_RAJYASABHA_MP_REQUEST_MAPPING)
	public Response exportRajyasabhaMP(PoliticianImportExportRequest politicianImport)
			throws InternalServerException {
		politicianImportExportService.exportRajyasabhaMPs(politicianImport);
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
	@ApiOperation(value = EndPointConstants.IMPORT_MLA_API_VALUE, nickname = EndPointConstants.IMPORT_MLA_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_MLA_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_MLA_REQUEST_MAPPING)
	public Response importAllMLA()
			throws InternalServerException {
		politicianImportExportService.importExportMLA();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_CHIEF_MINISTER_API_VALUE, nickname = EndPointConstants.IMPORT_CHIEF_MINISTER_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_CHIEF_MINISTER_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_CHIEF_MINISTER_REQUEST_MAPPING)
	public Response importAllStateChiefMinisters()
			throws InternalServerException {
		politicianImportExportService.importExportChiefMinistors();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
}
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_GOVERNOR_API_VALUE, nickname = EndPointConstants.IMPORT_GOVERNOR_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_GOVERNOR_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_GOVERNOR_REQUEST_MAPPING)
	public Response importAllStateGoverners()
			throws InternalServerException {
		politicianImportExportService.importExportGoverners();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
}
	
}
