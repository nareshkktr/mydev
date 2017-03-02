package com.kasisripriyawebapps.myindia.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;

public interface GlobalSearchRepository extends SolrCrudRepository<SolrGlobalSearchMaster, Long> {

	List<SolrGlobalSearchMaster> findByObjectNameContainingIgnoreCaseOrderByObjectNameAsc(String searchTerm);

	List<SolrGlobalSearchMaster> findByObjectNameContainingIgnoreCaseAndObjectTypeOrderByObjectNameAsc(
			String searchText, String searchObjectType);
}
