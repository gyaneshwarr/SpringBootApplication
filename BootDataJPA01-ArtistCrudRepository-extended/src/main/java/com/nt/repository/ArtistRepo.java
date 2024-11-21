package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Artist;

public interface ArtistRepo extends CrudRepository<Artist, Integer> {

	
	
}
