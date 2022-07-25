package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Song;
import com.cg.repository.SongRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SongRepository songRepository;

	@Override
	public Song searchById(long id) {
		return songRepository.findById(id).get();
	}

	@Override
	public List<Song> searchByArtist(String artist) {
		return songRepository.findAllByArtist(artist);
	}

	@Override
	public List<Song> searchByTitle(String title) {
		return songRepository.findAllByTitle(title);
	}

	@Override
	public List<Song> searchByCategory(String category) {
		return songRepository.findAllByCategory(category);
	}

	@Override
	public List<Song> searchByAlbum(String album) {
		return songRepository.findAllByAlbum(album);
	}

	@Override
	public List<Song> searchByYear(int year) {
		return songRepository.findAllByYear(year);
	}

	@Override
	public List<Song> searchByDuration(int fromYear, int toYear) {
		return songRepository.findAllByDuration(fromYear,toYear);
	}

}
