package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateDeleteProblemTypeRequest;

public interface ProblemTypeService {

	Long createProblemType(CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, ConflictException;

	ProblemType getProblemTypeByName(String problemTypeName) throws InternalServerException;

	ProblemType getProblemTypeById(Long problemTypeGuid) throws InternalServerException, RecordNotFoundException;

	Long deleteProblemType(Long problemTypeId) throws InternalServerException, RecordNotFoundException;

	Long updateProblemType(CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, RecordNotFoundException;

	List<ProblemType> getAllProblemTypes() throws InternalServerException;

	List<ProblemType> getAllProblemTypes(Integer offset, Integer limit) throws InternalServerException;

	void importAllProblemTypes() throws InternalServerException;
}
