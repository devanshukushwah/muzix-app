package com.cg.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PlayList")
public class PlayList {
	@Id
	private long id;
	private String name;
	private String createdBy;
	private List<Long> songIds;

	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayList(long id, String name, String createdBy, List<Long> songIds) {
		super();
		this.id = id;
		this.name = name;
		this.createdBy = createdBy;
		this.songIds = songIds;
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

	public List<Long> getSongIds() {
		return songIds;
	}

	public void setSongIds(List<Long> songIds) {
		this.songIds = songIds;
	}

}
