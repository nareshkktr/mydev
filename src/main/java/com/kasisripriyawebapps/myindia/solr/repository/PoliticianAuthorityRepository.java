package com.kasisripriyawebapps.myindia.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianAuthorityMaster;

public interface PoliticianAuthorityRepository extends SolrCrudRepository<SolrPoliticianAuthorityMaster, Long> {

	List<SolrPoliticianAuthorityMaster> findAllByPoliticianGuid(Long politicianGuid);

}
