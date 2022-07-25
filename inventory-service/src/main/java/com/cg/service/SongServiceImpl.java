package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.SongAlreadyExistException;
import com.cg.exception.SongNotFoundException;
import com.cg.model.Song;
import com.cg.model.SongList;
import com.cg.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository songRepository;

	@Override
	public Song addSong(Song song) throws SongAlreadyExistException {

		if (songRepository.existsById(song.getId()))
			throw new SongAlreadyExistException();

		Song save = songRepository.save(song);
		return save;
	}

	@Override
	public List<Song> findAllSong() {
		return songRepository.findAll();
	}

	@Override
	public void deleteSongById(long id) {

		songRepository.deleteById(id);
	}

	@Override
	public Song updateSongById(long id, Song song) throws SongNotFoundException {
		if (!songRepository.existsById(id))
			throw new SongNotFoundException();
		Song save = songRepository.save(song);
		return save;
	}

	@Override
	public Song findSong(long id) throws SongNotFoundException {
		Optional<Song> findById = songRepository.findById(id);
		if (findById.isEmpty())
			throw new SongNotFoundException();
		return findById.get();
	}

	@Override
	public SongList findAllIdsSong(List<Long> ids) {
		return new SongList((List<Song>) songRepository.findAllById(ids));
	}

}
