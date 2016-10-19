package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface ImageDao {

	void addImage(Object imageEntity) throws InternalServerException;

}
