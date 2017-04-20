package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
		locationImportExportService.importVillageReferenceLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_URBAN_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	public Response importUrbanReferenceLocations(LocationImportRequest locationImportRequest)
			throws InternalServerException, PreConditionRequiredException {
		locationImportExportService.importUrbanReferenceLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_MP_CONSTITUENCY_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_MP_CONSTITUENCY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_MP_CONSTITUENCY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_MP_CONSTITUENCY_LOCATIONS_REQUEST_MAPPING)
	public Response importMPConstituencyLocations() throws InternalServerException {
		locationImportExportService.importMPConstituencyLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_MLA_CONSTITUENCY_LOCATIONS_API_VALUE, nickname = EndPointConstants.IMPORT_MLA_CONSTITUENCY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.IMPORT_MLA_CONSTITUENCY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_MLA_CONSTITUENCY_LOCATIONS_REQUEST_MAPPING)
	public Response importMLAConstituencyLocations() throws InternalServerException {
		locationImportExportService.importMLAConstituencyLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_MP_CONSTITUENCY_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_MP_CONSTITUENCY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_MP_CONSTITUENCY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_MP_CONSTITUENCY_LOCATIONS_REQUEST_MAPPING)
	public Response exportMPConstituencyLocations() throws InternalServerException {
		locationImportExportService.exportMPConstituencyLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_MLA_CONSTITUENCY_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_MLA_CONSTITUENCY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_MLA_CONSTITUENCY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_MLA_CONSTITUENCY_LOCATIONS_REQUEST_MAPPING)
	public Response exportMLAConstituencyLocations() throws InternalServerException {
		locationImportExportService.exportMLAConstituencyLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_COUNTRY_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_COUNTRY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_COUNTRY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_COUNTRY_LOCATIONS_REQUEST_MAPPING)
	public Response exportCountryLocations() throws InternalServerException {
		locationImportExportService.exportCountries();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_STATE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_STATE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_STATE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_STATE_LOCATIONS_REQUEST_MAPPING)
	public Response exportStateLocations() throws InternalServerException {
		locationImportExportService.exportStates();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_DISTRICT_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_DISTRICT_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_DISTRICT_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_DISTRICT_LOCATIONS_REQUEST_MAPPING)
	public Response exportDistrictLocations() throws InternalServerException {
		locationImportExportService.exportDistricts();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_SUB_DISTRICT_LOCATIONS_REQUEST_MAPPING)
	public Response exportSubDistrictLocations() throws InternalServerException {
		locationImportExportService.exportSubDistricts();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_MUNCIPAL_CORPORATION_LOCATIONS_REQUEST_MAPPING)
	public Response exportMuncipalCorporationLocations() throws InternalServerException {
		locationImportExportService.exportMuncipalCorporations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_MUNCIPALITY_LOCATIONS_REQUEST_MAPPING)
	public Response exportMuncipalityLocations() throws InternalServerException {
		locationImportExportService.exportMuncipalities();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_TOWN_PANCHAYATH_LOCATIONS_REQUEST_MAPPING)
	public Response exportTownPanchayathLocations() throws InternalServerException {
		locationImportExportService.exportTownPanchayathies();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_VILLAGE_PANCHAYATH_LOCATIONS_REQUEST_MAPPING)
	public Response exportVillagePanchayathLocations() throws InternalServerException, PreConditionRequiredException {
		locationImportExportService.exportVillagePanchayathies();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_VILLAGE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_VILLAGE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_VILLAGE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_VILLAGE_LOCATIONS_REQUEST_MAPPING)
	public Response exportVillageLocations() throws InternalServerException, PreConditionRequiredException {
		locationImportExportService.exportVillages();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_VILLAGE_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	public Response exportVillageReferenceLocations() throws InternalServerException {
		locationImportExportService.exportVillageReferenceLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.EXPORT_URBAN_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	public Response exportUrbanReferenceLocations() throws InternalServerException {
		locationImportExportService.exportUrbanReferenceLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

}
