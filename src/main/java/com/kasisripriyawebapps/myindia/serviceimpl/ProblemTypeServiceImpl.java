package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.ProblemTypeDao;
import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateDeleteProblemTypeRequest;
import com.kasisripriyawebapps.myindia.service.ImageService;
import com.kasisripriyawebapps.myindia.service.ProblemTypeService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class ProblemTypeServiceImpl implements ProblemTypeService {

	@Autowired
	ProblemTypeDao problemTypeDao;

	@Autowired
	ImageService imageService;

	@Autowired
	private Environment env;

	@Override
	@Transactional
	public Long createProblemType(CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, ConflictException {
		Long problemTypeGuid = null;
		if (validateDuplicateProblemTypeByTypeNameRequest(createUpdateDeleteProblemTypeRequest)) {
			ProblemType problemType = new ProblemType();
			problemType.setProblemTypeName(createUpdateDeleteProblemTypeRequest.getProblemTypeName());
			/*problemType.setProblemTypePhotoURL(
					imageService.addImageToLocalDrive(ApplicationConstants.OBJECT_TYPE_PROBLEM_TYPE,
							createUpdateDeleteProblemTypeRequest.getProblemTypeName(),
							createUpdateDeleteProblemTypeRequest.getProblemTypePhoto(),
							createUpdateDeleteProblemTypeRequest.getProblemTypeName()));
			*/problemTypeGuid = problemTypeDao.createProblemType(problemType);
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

	@Override
	@Transactional
	public void importAllProblemTypes() throws InternalServerException {

		List<ProblemType> apiProblemTypesList = new ArrayList<ProblemType>();
		List<ProblemType> newProblemTypesList = new ArrayList<ProblemType>();
		List<ProblemType> existingProblemTypesList = problemTypeDao.getAllProblemTypes();

		String filePath = env.getProperty("project.probem.types-file-name");
		Workbook myWorkBook = CommonUtil.getWorkBookFromFile(filePath);

		Sheet sheet = myWorkBook.getSheetAt(0);
		int i = 0;
		for (Row eachRow : sheet) {
			if (i < 1) {
				i++;
				continue;
			}
			ProblemType problemType = new ProblemType();
			String problemTypeName = eachRow.getCell(0).getStringCellValue();
			String problemTypeMinistry = eachRow.getCell(1).getStringCellValue();
			String problemTypeCategory = eachRow.getCell(2).getStringCellValue();
			problemType.setProblemTypeName(problemTypeName);
			problemType.setProblemTypeMinistry(problemTypeMinistry);
			problemType.setProblemCategory(problemTypeCategory);

			if (!newProblemTypesList.contains(problemType) && !existingProblemTypesList.contains(problemType)) {
				newProblemTypesList.add(problemType);
			}
			if (!apiProblemTypesList.contains(problemType)) {
				apiProblemTypesList.add(problemType);
			}
		}

		problemTypeDao.saveProblemTypes(newProblemTypesList);
		List<ProblemType> updatedProblemTypesList = findUpdatedProblemTypes(existingProblemTypesList,
				apiProblemTypesList);
		if (updatedProblemTypesList != null && !updatedProblemTypesList.isEmpty()) {
			problemTypeDao.updateProblemTypes(updatedProblemTypesList);
		}
		if (existingProblemTypesList != null && !existingProblemTypesList.isEmpty()) {
			existingProblemTypesList.removeAll(apiProblemTypesList);
			problemTypeDao.deleteProblemTypes(existingProblemTypesList);
		}
	}

	private List<ProblemType> findUpdatedProblemTypes(List<ProblemType> existingProblemTypesList,
			List<ProblemType> apiProblemTypesList) {

		List<ProblemType> updatedProblemTypesList = new ArrayList<ProblemType>();
		Map<String, List<ProblemType>> existingProblemTypesMap = existingProblemTypesList.stream()
				.collect(Collectors.groupingBy(problemTypeObject -> problemTypeObject.getProblemTypeName()));
		if (apiProblemTypesList != null && !apiProblemTypesList.isEmpty() && existingProblemTypesList != null
				&& !existingProblemTypesList.isEmpty()) {
			for (ProblemType eachProblemType : apiProblemTypesList) {
				if (existingProblemTypesList.contains(eachProblemType)
						&& !updatedProblemTypesList.contains(eachProblemType)) {
					eachProblemType.setGuid(
							existingProblemTypesMap.get(eachProblemType.getProblemTypeName()).get(0).getGuid());
					updatedProblemTypesList.add(eachProblemType);
				}
			}
		}
		return updatedProblemTypesList;

	}

	@Override
	@Transactional
	public List<ProblemType> getProblemTypesByCategory(String problemCategory) throws InternalServerException {
		final List<ProblemType> problemTypes = problemTypeDao.getProblemTypesByCategory(problemCategory);
		return problemTypes;
	}
}
