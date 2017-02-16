/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LocationReferenceMasterResponse;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

public interface UserService {

	GetUserByPropertyResponse getUserByVoterIdAndName(GetUserByPropertyRequest getUserByPropertyRequest)
			throws RecordNotFoundException;

	GetUserByPropertyResponse getUserByVoterReferenceAndAge(GetUserByPropertyRequest getUserByPropertyRequest)
			throws RecordNotFoundException;

	LocationReferenceMasterResponse getReferenceLocationForMaster(SolrLocationMaster solrLocationMaster)
			throws RecordNotFoundException;

	GetUserByPropertyResponse getUserByVoterCardDetails(GetUserByPropertyRequest getUserByPropertyRequest)
			throws RecordNotFoundException;

}
