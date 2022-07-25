package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.PlayList;

public interface PlayListRepository extends MongoRepository<PlayList,Long> {

}
