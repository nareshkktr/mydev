package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LocationReferenceMasterResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ValidateElectorDetailsRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ValidateElectorDetailsResponse;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianAuthorityMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianMaster;

public interface SignUpService {

	ValidateElectorDetailsResponse validateElectorDetails(ValidateElectorDetailsRequest validateElectorDetailsRequest)
			throws RecordNotFoundException, InternalServerException;

	LocationReferenceMasterResponse getReferenceLocationForMaster(SolrLocationMaster solrLocationMaster) throws InternalServerException, RecordNotFoundException;

	SolrPoliticianAuthorityMaster validatePoliticianSelection(
			SolrPoliticianAuthorityMaster solrPoliticianAuthorityMaster)
			throws RecordNotFoundException, InternalServerException;

	List<SolrPoliticianMaster> getPoliticiansByName(Long userGuid)
			throws RecordNotFoundException, InternalServerException;

}
