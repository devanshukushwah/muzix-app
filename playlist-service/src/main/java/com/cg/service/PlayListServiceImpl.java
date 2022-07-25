package com.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.exception.PlayListAlreadyExistException;
import com.cg.exception.PlayListNotFoundException;
import com.cg.model.PlayList;
import com.cg.model.PlayListForResponse;
import com.cg.model.Song;
import com.cg.model.SongList;
import com.cg.repository.PlayListRepository;

@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	private PlayListRepository playListRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public PlayList addPlayList(PlayList playList) throws PlayListAlreadyExistException {
		if (playListRepository.existsById(playList.getId()))
			throw new PlayListAlreadyExistException();
		return playListRepository.save(playList);
	}


	@Override
	public List<PlayListForResponse> findAllPlayList() {
		List<PlayList> findAll = playListRepository.findAll();

		return findAll.stream().map(data -> {
			List<Song> songs = restTemplate
					.postForObject("http://inventory-service/inventory/findAllIds", data.getSongIds(), SongList.class)
					.getSongs();
			return new PlayListForResponse(data.getId(), data.getName(), data.getCreatedBy(), songs);
		}).collect(Collectors.toList());
	}

	@Override
	public void deletePlayList(long id) {
		playListRepository.deleteById(id);
	}

	@Override
	public PlayListForResponse findPlayListWithId(long id) throws PlayListNotFoundException  {
		Optional<PlayList> findById = playListRepository.findById(id);
		
		if(findById.isEmpty()) throw new PlayListNotFoundException();
		
		PlayList playList = findById.get();

		List<Song> songs = restTemplate
				.postForObject("http://inventory-service/inventory/findAllIds", playList.getSongIds(), SongList.class)
				.getSongs();

		return new PlayListForResponse(playList.getId(), playList.getName(), playList.getCreatedBy(), songs);
	}

}
