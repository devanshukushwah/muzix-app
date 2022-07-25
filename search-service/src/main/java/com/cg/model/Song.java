package com.cg.model;

import java.util.List;
import org.springframework.data.annotation.Id;

public class Song {
	@Id
	private long id;
	private String title;
	private List<String> artist;
	private String category;
	private String album;
	private String year;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(long id, String title, List<String> artist, String category, String album, String year) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.category = category;
		this.album = album;
		this.year = year;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getArtist() {
		return artist;
	}

	public void setArtist(List<String> artist) {
		this.artist = artist;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
