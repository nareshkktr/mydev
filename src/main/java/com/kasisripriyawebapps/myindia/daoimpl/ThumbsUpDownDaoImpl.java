/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ThumbsUpDownDao;
import com.kasisripriyawebapps.myindia.entity.ThumbsUpDown;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class ThumbsUpDownDaoImpl.
 */
@Repository
public class ThumbsUpDownDaoImpl extends BaseDaoImpl<Long, ThumbsUpDown> implements ThumbsUpDownDao {

	@Override
	public Long createThumbsUpDown(ThumbsUpDown thumbsUpDown) throws InternalServerException {
		return save(thumbsUpDown);
	}

}
