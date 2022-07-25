package com.cg.service;

import java.util.List;

import com.cg.exception.SongAlreadyExistException;
import com.cg.exception.SongNotFoundException;
import com.cg.model.Song;
import com.cg.model.SongList;

public interface SongService {
	public Song addSong(Song song) throws SongAlreadyExistException;

	public Song findSong(long id) throws SongNotFoundException;

	public List<Song> findAllSong();

	public void deleteSongById(long id);

	public Song updateSongById(long id, Song song) throws SongNotFoundException;

	public SongList findAllIdsSong(List<Long> ids);
}
