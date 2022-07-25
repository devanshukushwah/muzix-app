package com.cg.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PlayList")
public class PlayListForResponse {
	@Id
	private long id;
	private String name;
	private String createdBy;
	private List<Song> songs;

	public PlayListForResponse() {
		super();
	}

	public PlayListForResponse(long id, String name, String createdBy, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.createdBy = createdBy;
		this.songs = songs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

}
