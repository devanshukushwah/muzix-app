package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Song;

public interface SongRepository extends MongoRepository<Song, Long> {

}
