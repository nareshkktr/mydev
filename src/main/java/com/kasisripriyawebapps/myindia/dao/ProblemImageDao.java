package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.ProblemImage;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface ProblemImageDao {

	Long saveProblemImage(ProblemImage problemImage) throws InternalServerException;

	List<ProblemImage> getAllPhotosByGuid(Long objectGuid, Integer pageLimit, Integer pageOffset) throws InternalServerException;

	List<ProblemImage> getAlbumPhotosByGuid(Long subObjectGuid, Long objectGuid, Integer pageLimit, Integer pageOffset) throws InternalServerException;

}
