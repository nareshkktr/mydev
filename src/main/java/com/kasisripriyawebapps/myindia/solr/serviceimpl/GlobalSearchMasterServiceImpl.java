package com.kasisripriyawebapps.myindia.solr.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;
import com.kasisripriyawebapps.myindia.solr.repository.GlobalSearchRepository;
import com.kasisripriyawebapps.myindia.solr.service.GlobalSearchMasterService;

@Service
public class GlobalSearchMasterServiceImpl implements GlobalSearchMasterService{
	
	@Resource
    private GlobalSearchRepository solrGlobalSearchMasterRepository;

	@Transactional
	@Override
	public void addToIndex(Problem problem) {
		// TODO Auto-generated method stub
		SolrGlobalSearchMaster globalSearchProblem = SolrGlobalSearchMaster.getBuilder(problem.getGuid(), problem.getProblemShortDescription()).
			objectType(ApplicationConstants.OBJECT_TYPE_PROBLEM).build();//.objectSubType(problem.getProblemType().getProblemCategory()).build();
		
		solrGlobalSearchMasterRepository.save(globalSearchProblem);
	}

	@Transactional
	@Override
	public void deleteFromIndex(Long id) {
		solrGlobalSearchMasterRepository.delete(id);
	}

}
