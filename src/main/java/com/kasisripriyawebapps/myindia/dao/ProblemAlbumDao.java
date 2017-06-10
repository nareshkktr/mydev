package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.ProblemAlbum;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface ProblemAlbumDao {

	ProblemAlbum getProblemAlbumByGuid(Long objectId) throws InternalServerException;

	Long saveProblemAlbum(ProblemAlbum problemAlbum) throws InternalServerException;

	void updateProblemAlbum(ProblemAlbum problemAlbum) throws InternalServerException;

	void mergeProblemAlbum(ProblemAlbum problemAlbum) throws InternalServerException;

	List<ProblemAlbum> getAllAlbumsByGuid(Long objectGuid, Integer pageLimit, Integer pageOffset) throws InternalServerException;

}
