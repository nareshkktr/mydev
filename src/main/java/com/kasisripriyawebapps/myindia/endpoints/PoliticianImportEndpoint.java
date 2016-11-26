package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
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
	@ApiOperation(value = EndPointConstants.IMPORT_RAJYASABHA_MP_API_VALUE, nickname = EndPointConstants.IMPORT_RAJYASABHA_MP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_RAJYASABHA_MP_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_RAJYASABHA_MP_REQUEST_MAPPING)
	public Response importAllRajyasabhaMP()
			throws InternalServerException {
		politicianImportExportService.importExportRajyasabhaMPs();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	

}
