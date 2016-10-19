package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ImageDao;
import com.kasisripriyawebapps.myindia.entity.ProblemImage;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class ImageDaoImpl extends BaseDaoImpl<Long, ProblemImage> implements ImageDao {

	@Override
	public void addImage(Object imageEntity) throws InternalServerException {
		// saveObject(imageEntity);
	}

}
