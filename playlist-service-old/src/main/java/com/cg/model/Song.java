package com.cg.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="song")
public class Song {
	@Id
	private long id;
	private String title;
	private List<String> artist;
	private String category;
	private String album;
	private int year;

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Song(long id, String title, List<String> artist, String category, String album, int year) {
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}



	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", artist=" + artist + ", category=" + category + ", album="
				+ album + ", year=" + year + "]";
	}

	
	
		
}
