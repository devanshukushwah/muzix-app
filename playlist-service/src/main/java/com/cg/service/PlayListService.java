package com.cg.service;

import java.util.List;

import com.cg.model.PlayListForResponse;
import com.cg.exception.PlayListAlreadyExistException;
import com.cg.exception.PlayListNotFoundException;
import com.cg.model.PlayList;

public interface PlayListService {
	public PlayList addPlayList(PlayList playList) throws PlayListAlreadyExistException;
	public List<PlayListForResponse> findAllPlayList();
	public void deletePlayList(long id);
	public PlayListForResponse findPlayListWithId(long id)  throws PlayListNotFoundException;
}
