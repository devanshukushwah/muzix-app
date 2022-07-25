package com.cg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.model.Song;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SongRepositoryTest {

	@Autowired
	private SongRepository songRepository;

	@InjectMocks
	private Song song;
	private List<Song> backUpSongs;

	@BeforeEach
	public void setup() {
		song = new Song(142,"title",List.of("singer 1","singer 2"),"category","album",2000);
	}
	
	@BeforeAll
	public   void storeOldDatabaseState() {
		backUpSongs = songRepository.findAll();
		songRepository.deleteAll();
	}
	
	@AfterAll
	public  void restoreOldDatabaseState() {
		songRepository.deleteAll();
		songRepository.saveAll(backUpSongs);
	}
	

	@Test
	public void saveTest() {
		songRepository.save(song);
		Song found = songRepository.findById(song.getId()).get();
		assertEquals(song.getId(), found.getId());

	}
	
	@Test
	public void findAllTest() {
		songRepository.deleteAll();
		songRepository.save(song);
		List<Song> mobiles = songRepository.findAll();
		assertEquals(mobiles.size(), 1);
	}
	
	@Test
	public void findByIdTest() {
		songRepository.save(song);
		Song result = songRepository.findById(song.getId()).get();
		assertEquals(song.getId(), result.getId());
	}

	@Test
	public void deleteByIdTest() {
		songRepository.deleteAll();
		songRepository.save(song);
		songRepository.deleteById(song.getId());
		List<Song> result = songRepository.findAll();
		assertEquals(result.size(), 0);
	}

}
