package com.kasisripriyawebapps.myindia.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationReference;

public interface LocationReferenceRepository extends SolrCrudRepository<SolrLocationReference, Long> {

	List<SolrLocationReference> findByLocationVillage(Long locationGuid);

	List<SolrLocationReference> findByLocationMunicipalCorporation(Long locationGuid);

	List<SolrLocationReference> findByLocationMunicipality(Long locationGuid);

	List<SolrLocationReference> findByLocationTownPanchayat(Long locationGuid);

	List<SolrLocationReference> findByLocationSubDistrict(Long locationGuid);

}
