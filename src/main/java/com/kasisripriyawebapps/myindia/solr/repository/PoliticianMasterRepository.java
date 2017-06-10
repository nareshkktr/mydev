package com.kasisripriyawebapps.myindia.solr.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrUserMaster;

public interface PoliticianMasterRepository extends Repository<SolrUserMaster, Long>{

	List<SolrPoliticianMaster> findAll();

}
