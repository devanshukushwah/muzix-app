package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.PlayList;
import com.cg.model.PlayListForResponse;
import com.cg.service.PlayListService;

@RestController
@RequestMapping("/playlist")
public class PlayListController {
	
	@Autowired
	private PlayListService playListService;
	
	@PostMapping("/add")
	public PlayList addToPlayList(@RequestBody PlayList PlayList) {
		return playListService.addPlayList(PlayList);
	}
	
	@GetMapping("/findAll")
	public List<PlayListForResponse> findAllPlayList() {
		return playListService.findAllPlayList();
	}
	
	@GetMapping("/find/{id}")
	public PlayListForResponse findPlayListWithIds(@PathVariable long id) {
		return playListService.findPlayListWithId(id);
	}
	
	@DeleteMapping("/delete/id")
	public void deletePlayListById(@PathVariable long id) {
		playListService.deletePlayList(id);
	}
	
}
