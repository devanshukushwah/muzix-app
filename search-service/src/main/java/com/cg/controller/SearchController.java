package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Song;
import com.cg.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchService songService;

	@GetMapping("/byId")
	public Song searchByTitle(@RequestParam("value") long id) {
		return songService.searchById(id);
	}

	@GetMapping("/byTitle")
	public List<Song> searchByTitle(@RequestParam("value") String title) {
		return songService.searchByTitle(title);
	}

	@GetMapping("/byArtist")
	public List<Song> searchByArtist(@RequestParam("value") String artist) {
		return songService.searchByArtist(artist);
	}

	@GetMapping("/byCategory")
	public List<Song> searchByCategory(@RequestParam("value") String category) {
		return songService.searchByCategory(category);
	}

	@GetMapping("/byYear")
	public List<Song> searchByYear(@RequestParam("value") int year) {
		return songService.searchByYear(year);
	}

	@GetMapping("/byAlbum")
	public List<Song> searchByAlbum(@RequestParam("value") String album) {
		return songService.searchByAlbum(album);
	}

	@GetMapping("/byDuration")
	public List<Song> searchByAlbum(@RequestParam("from") int fromYear,@RequestParam("to") int toYear) {
//		return songService.searchByAlbum(album);
		return songService.searchByDuration(fromYear,toYear);
	}
}