package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.service.UserImportExportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.USER_IMPORT_EXPORT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.USER_IMPORT_EXPORT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.USER_IMPORT_EXPORT_ENDPOINT_API_TAGS }, description = EndPointConstants.USER_IMPORT_EXPORT_ENDPOINT_API_DESCRIPTION)
public class UserImportExportEndPoint {

	@Autowired
	UserImportExportService userImportExportService;

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_ELECTRORAL_ROLLES_URLS_API_VALUE, nickname = EndPointConstants.EXPORT_ELECTRORAL_ROLLES_URLS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_ELECTRORAL_ROLLES_URLS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_ELECTRORAL_ROLLES_URLS_REQUEST_MAPPING)
	public Response exportStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException, RecordNotFoundException {
		userImportExportService.exportStateElectroralRolleUrls(electroralRollesURL);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_ELECTRORAL_ROLLES_URLS_API_VALUE, nickname = EndPointConstants.IMPORT_ELECTRORAL_ROLLES_URLS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_ELECTRORAL_ROLLES_URLS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_ELECTRORAL_ROLLES_URLS_REQUEST_MAPPING)
	public Response importStateElectroralRolleUrls(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException, RecordNotFoundException {
		userImportExportService.importStateElectroralRolleUrls(electroralRollesURL);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_ELECTRORAL_ROLLES_DATA_API_VALUE, nickname = EndPointConstants.EXPORT_ELECTRORAL_ROLLES_DATA_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_ELECTRORAL_ROLLES_DATA_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_ELECTRORAL_ROLLES_DATA_REQUEST_MAPPING)
	public Response exportElectroralRolleData(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException, RecordNotFoundException {
		userImportExportService.exportElectroralRolleData(electroralRollesURL);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_ELECTRORAL_ROLLES_DATA_API_VALUE, nickname = EndPointConstants.IMPORT_ELECTRORAL_ROLLES_DATA_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_ELECTRORAL_ROLLES_DATA_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_ELECTRORAL_ROLLES_DATA_REQUEST_MAPPING)
	public Response importElectroralRolleData(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException, RecordNotFoundException {
		userImportExportService.importElectroralRolleData(electroralRollesURL);
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}
}
