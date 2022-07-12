package com.cg.model;

import java.util.List;

import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "song")
public class Song {
	@Id
	@NotNull
	@Digits(integer = 10, fraction = 0)
	private long id;

	@NotBlank(message = "title should not blank or null")
	private String title;

	@Size(min = 1, max = 10)
	private List<String> artist;

	@NotBlank(message = "category should not blank or null")
	private String category;

	private String album;

	@Min(1900)
	@Max(2022)
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
	public int hashCode() {
		return Objects.hash(album, artist, category, id, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return Objects.equals(album, other.album) && Objects.equals(artist, other.artist)
				&& Objects.equals(category, other.category) && id == other.id && Objects.equals(title, other.title)
				&& year == other.year;
	}

}
