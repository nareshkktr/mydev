package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.ProblemTypeDao;
import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateDeleteProblemTypeRequest;
import com.kasisripriyawebapps.myindia.service.ImageService;
import com.kasisripriyawebapps.myindia.service.ProblemTypeService;

@Service
public class ProblemTypeServiceImpl implements ProblemTypeService {

	@Autowired
	ProblemTypeDao problemTypeDao;

	@Autowired
	ImageService imageService;

	@Override
	@Transactional
	public Long createProblemType(CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, ConflictException {
		Long problemTypeGuid = null;
		if (validateDuplicateProblemTypeByTypeNameRequest(createUpdateDeleteProblemTypeRequest)) {
			ProblemType problemType = new ProblemType();
			problemType.setProblemTypeName(createUpdateDeleteProblemTypeRequest.getProblemTypeName());
			problemType.setProblemTypeDesc(createUpdateDeleteProblemTypeRequest.getProblemTypeDesc());
			problemType.setProblemTypePhotoURL(
					imageService.addImageToLocalDrive(ApplicationConstants.OBJECT_TYPE_PROBLEM_TYPE,
							createUpdateDeleteProblemTypeRequest.getProblemTypeName(),
							createUpdateDeleteProblemTypeRequest.getProblemTypePhoto(),
							createUpdateDeleteProblemTypeRequest.getProblemTypeName()));
			problemTypeGuid = problemTypeDao.createProblemType(problemType);
		}
		return problemTypeGuid;
	}

	private boolean validateDuplicateProblemTypeByTypeNameRequest(
			CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws ConflictException, InternalServerException {
		Boolean isDuplicateProblemType = Boolean.FALSE;
		if (getProblemTypeByName(createUpdateDeleteProblemTypeRequest.getProblemTypeName()) != null) {
			throw new ConflictException(ExceptionConstants.PROBLEM_TYPE_EXISTS_WITH_NAME);
		}
		return isDuplicateProblemType;
	}

	@Override
	@Transactional(readOnly = true)
	public ProblemType getProblemTypeByName(String problemTypeName) throws InternalServerException {
		final ProblemType problemType = problemTypeDao.getProblemTypeByName(problemTypeName);
		return problemType;
	}

	@Override
	@Transactional(readOnly = true)
	public ProblemType getProblemTypeById(Long problemTypeGuid)
			throws InternalServerException, RecordNotFoundException {
		final ProblemType problemType = problemTypeDao.getProblemTypeById(problemTypeGuid);
		if (problemType == null) {
			throw new RecordNotFoundException(ExceptionConstants.PROBLEM_TYPE_NOT_FOUND);
		}
		return problemType;
	}

	@Override
	@Transactional
	public Long deleteProblemType(Long problemTypeId) throws InternalServerException, RecordNotFoundException {
		final ProblemType problemType = getProblemTypeById(problemTypeId);
		problemTypeDao.deleteProblemType(problemType);
		return problemTypeId;
	}

	@Override
	public Long updateProblemType(CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, RecordNotFoundException {
		final ProblemType problemType = getProblemTypeById(createUpdateDeleteProblemTypeRequest.getProblemTypeId());
		problemTypeDao.updateProblemType(problemType);
		return problemType.getGuid();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProblemType> getAllProblemTypes(Integer offset, Integer limit) throws InternalServerException {
		List<ProblemType> problemTypes = null;
		if (offset == null || offset.intValue() <= 0) {
			problemTypes = problemTypeDao.getAllProblemTypes();
		} else {
			if (limit == null || limit.longValue() <= 0) {
				limit = ServiceConstants.DEAFULT_PAGE_LIMIT;
			}
			problemTypes = problemTypeDao.getAllProblemTypes(offset, limit);
		}
		return problemTypes;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProblemType> getAllProblemTypes() throws InternalServerException {
		final List<ProblemType> problemTypes = problemTypeDao.getAllProblemTypes();
		return problemTypes;
	}
}
