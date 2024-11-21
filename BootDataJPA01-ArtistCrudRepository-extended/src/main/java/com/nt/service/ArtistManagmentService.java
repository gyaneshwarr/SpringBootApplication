package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Artist;

public interface ArtistManagmentService {

	//save
	public String registerArtist(Artist artist);
	
	//saveAll
	public String registerArtistBatch(List<Artist> list);
	
	//existsById
	public boolean isArtistAvailable(Integer id);
	
	//count
	public Long countArtists();
	
	//findAll
	public Iterable<Artist> showAllArtists();
	
	//findAllById
	public Iterable<Artist> showAllArtistById(Iterable<Integer> ids);
	
	//findById
	public Optional<Artist> getArtistById(Integer id);
	//2nd variation using Artist
	public Artist fetchArtistById(Integer id);
	
}
