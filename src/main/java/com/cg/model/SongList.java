package com.cg.model;

import java.util.List;

public class SongList {
	private List<Song> songs;

	public SongList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SongList(List<Song> songs) {
		super();
		this.songs = songs;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

}
