package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface ProblemTypeDao {

	ProblemType getProblemTypeByName(String problemTypeName) throws InternalServerException;

	Long createProblemType(ProblemType problemType) throws InternalServerException;

	ProblemType getProblemTypeById(Long problemTypeGuid) throws InternalServerException;

	void deleteProblemType(ProblemType problemType) throws InternalServerException;

	void updateProblemType(ProblemType problemType) throws InternalServerException;

	List<ProblemType> getAllProblemTypes(Integer offset, Integer limit) throws InternalServerException;

	List<ProblemType> getAllProblemTypes() throws InternalServerException;

	void saveProblemTypes(List<ProblemType> newProblemTypesList) throws InternalServerException;

	void updateProblemTypes(List<ProblemType> updatedProblemTypesList);

	void deleteProblemTypes(List<ProblemType> existingProblemTypesList);

}
