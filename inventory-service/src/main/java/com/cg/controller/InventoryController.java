package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.SongAlreadyExistException;
import com.cg.exception.SongNotFoundException;
import com.cg.model.Song;
import com.cg.model.SongList;
import com.cg.service.SongService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private SongService songService;

	@PostMapping("/add")
	public Song addSong(@RequestBody @Valid Song song) throws SongAlreadyExistException {
		return songService.addSong(song);
	}

	@GetMapping("/findAll")
	public List<Song> findAllSong() {
		return songService.findAllSong();
	}

	@PostMapping("/findAllIds")
	public SongList findAllIdsSong(@RequestBody List<Long> ids) {
		return songService.findAllIdsSong(ids);
	}

	@GetMapping("/find/{id}")
	public Song findSong(@PathVariable long id) throws SongNotFoundException {
		return songService.findSong(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteSongById(@PathVariable long id)  {
		songService.deleteSongById(id);
	}

	@PutMapping("/update/{id}")
	public Song updateSongById(@PathVariable long id, @RequestBody @Valid Song song) throws SongNotFoundException {
		return songService.updateSongById(id, song);
	}

}