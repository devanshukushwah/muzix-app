package com.cg.service;

import java.util.List;

import com.cg.model.Song;

public interface SearchService {
	public Song searchById(long id);

	public List<Song> searchByArtist(String artist);

	public List<Song> searchByTitle(String title);

	public List<Song> searchByCategory(String category);

	public List<Song> searchByAlbum(String album);

	public List<Song> searchByYear(int year);

	public List<Song> searchByDuration(int fromYear, int toYear);

}
