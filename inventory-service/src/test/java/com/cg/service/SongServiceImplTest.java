package com.cg.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;

import com.cg.exception.SongAlreadyExistException;
import com.cg.exception.SongNotFoundException;
import com.cg.model.Song;
import com.cg.repository.SongRepository;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



@ExtendWith(MockitoExtension.class)
class SongServiceImplTest {

	@Mock
	private SongRepository songRepository;
	
	@InjectMocks
	private SongServiceImpl songService;
	private Song song;
	
	@BeforeEach
	public void setup() {
		song = new Song(1,"title",List.of("singer 1","singer 2"),"category","album",2000);
	}
	
	@Test
	public void addSongTest() throws SongAlreadyExistException {
		// Given
		given(songRepository.existsById(song.getId())).willReturn(false);
		given(songRepository.save(song)).willReturn(song);
		
		// When
		Song save = songService.addSong(song);
		
		// Then
		assertThat(save).isNotNull();
		assertEquals(song,save);
	}
	
	@Test
	public void findAllSongTest() {
		// Given
		Song song2 = new Song(2,"title2",List.of("singer 3","singer 4"),"category2","album2",2001);

		given(songRepository.findAll()).willReturn(List.of(song,song2));
		
        // When 
        List<Song> songList = songService.findAllSong();

        // Then 
        assertThat(songList).isNotNull();
        assertEquals(2, songList.size());
	}
	@Test
	public void findAllSongWithIdsTest() {
		// Given
		Song song2 = new Song(2,"title2",List.of("singer 3","singer 4"),"category2","album2",2001);
		
		Iterable<Song> items = List.of(song,song2);
		
		given(songRepository.findAllById(List.of(1L,2L))).willReturn(items);
		
		// When 
		List<Song> songList = songService.findAllIdsSong(List.of(1L,2L)).getSongs();
		
		// Then 
		assertThat(songList).isNotNull();
		assertEquals(2, songList.size());
	}
	
	@Test
	public void findOneSongTest() throws SongNotFoundException  {
		// Given 
		long songId=1L;
		given(songRepository.findById(songId)).willReturn(Optional.of(song));
		
		// When
		Song findSong = songService.findSong(songId);
		
		// Then
		assertThat(findSong).isNotNull();
		assertEquals(song,findSong);
	}
	
	
	@Test
	public void deleteOneSongTest(){
	    // Given
        long songId = 1L;
        
        willDoNothing().given(songRepository).deleteById(songId);

        // When
        songService.deleteSongById(songId);

        // Then
        verify(songRepository, times(1)).deleteById(songId);
	}

	@Test
	public void updateOneSongTest() throws SongNotFoundException{
		// Given
        long songId = 1L;
        
		given(songRepository.existsById(songId)).willReturn(true);
		given(songRepository.save(song)).willReturn(song);
		song.setAlbum("rich album");
		
		// When
		Song updateOneSong = songService.updateSongById(songId, song);
	
		// Then
		assertEquals("rich album",updateOneSong.getAlbum());
	}
	
	@Test
	public void addIfAlreadyExistSongTest() throws SongAlreadyExistException {
		// Given
		given(songRepository.existsById(song.getId())).willReturn(true);
		
		assertThrows(SongAlreadyExistException.class,()->{
			songService.addSong(song);
		});
	}

	@Test
	public void updateOneIfNotExistSongTest() throws SongNotFoundException{
	
		// Given
		given(songRepository.existsById(song.getId())).willReturn(false);
		
		assertThrows(SongNotFoundException.class,()->{
			songService.updateSongById(song.getId(), song);
		});
	}
	
}
