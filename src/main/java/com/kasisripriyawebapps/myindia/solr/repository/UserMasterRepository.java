package com.kasisripriyawebapps.myindia.solr.repository;

import org.springframework.data.repository.Repository;

import com.kasisripriyawebapps.myindia.solr.entity.SolrUserMaster;

public interface UserMasterRepository extends Repository<SolrUserMaster, Long> {

	SolrUserMaster findByIdCardTypeAndIdCardNo(String idCardType, String idCardNo);

	SolrUserMaster findByUserGuidAndElectorName(Long userGuid, String electorName);

	SolrUserMaster findByUserGuidAndReferenceName(Long userGuid, String referenceName);

	SolrUserMaster findByUserGuid(Long userGuid);

	SolrUserMaster findByIdCardNo(String idCardNo);
}
