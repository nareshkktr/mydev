package com.kasisripriyawebapps.myindia.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

public interface LocationMasterRepository extends SolrCrudRepository<SolrLocationMaster, Long> {

	SolrLocationMaster findByLocationTypeAndLocationName(String locationType, String locationName);

	List<SolrLocationMaster> findByLocationTypeAndParentLocationGuid(String locationVillageType, Long locationGuid);

	List<SolrLocationMaster> findByLocationTypeInAndParentLocationGuid(List<String> urbanLocationTypes,
			Long locationGuid);

	SolrLocationMaster findByLocationTypeInAndLocationName(List<String> stateLocationTypes, String upperCase);

	List<SolrLocationMaster> findByLocationGuidIn(List<Long> villageGuids);

	List<SolrLocationMaster> findByLocationNameContains(String searchTerm);

	List<SolrLocationMaster> findByLocationTypeIn(List<String> stateLocationTypes);

}
