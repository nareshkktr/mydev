package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface UserImportExportDao {

	void saveElectroralRollesURLData(List<ElectroralRollesURL> electroralRollesUrlList) throws InternalServerException;

	List<ElectroralRollesURL> getElectroralRollesURLData(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException;

	void updateElectroralRollesURLData(List<ElectroralRollesURL> updatedElectroralRollesUrlList) throws InternalServerException;

	void deleteeElectroralRollesURLData(List<ElectroralRollesURL> existingElectroralRollesUrlList)
			throws InternalServerException;

}
