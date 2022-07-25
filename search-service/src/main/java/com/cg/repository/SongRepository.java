package com.cg.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cg.model.Song;

public interface SongRepository extends MongoRepository<Song, Long> {

	List<Song> findAllByArtist(String artist);

	List<Song> findAllByTitle(String title);

	List<Song> findAllByCategory(String category);

	List<Song> findAllByAlbum(String album);

	List<Song> findAllByYear(int year);
	
	@Query("{'year':{'$gte':?0,'$lte':?1}}")
	List<Song> findAllByDuration(int fromYear, int toYear);
	
}
