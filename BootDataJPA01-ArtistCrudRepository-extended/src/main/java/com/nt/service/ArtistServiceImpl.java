package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Artist;
import com.nt.repository.ArtistRepo;

@Service("art_service")
public class ArtistServiceImpl implements ArtistManagmentService {

	@Autowired
	public ArtistRepo artrepo;
	
	//save method
	@Override
	public String registerArtist(Artist artist) {
		
		System.out.println("Before saving the object:: "+artist.getAid());
		Artist service = artrepo.save(artist);
		System.out.println("After saving the object:: "+ service.getAid());
		return artist.getAid()==null?"Artist not registered":"Artist registered";
	}

	//saveAll method
	@Override
	public String registerArtistBatch(List<Artist> list) {
		
		Iterable<Artist>savedList=artrepo.saveAll(list);
		
		//using stream method		
		/*List<Integer>idsList=((Collection<Artist>) savedList).stream().map(art->art.getAid()).collect(Collectors.toList());
		return idsList.size()+" no. of artists are registered having the idValues "+idsList;*/
		
		//using forEach
		List<Integer>idsList=new ArrayList<Integer>();
		savedList.forEach(art->{
			idsList.add(art.getAid());
		});
		return idsList.size()+" no. of artists registered having idValues "+idsList.toString();
		
	}

	//existsById method
	@Override
	public boolean isArtistAvailable(Integer id) {
		boolean flag = artrepo.existsById(id);
		return flag;
	}

	//count method
	@Override
	public Long countArtists() {
		Long cnt=artrepo.count();
		return cnt;
	}

	//findAll method
	@Override
	public Iterable<Artist> showAllArtists() {
		Iterable<Artist>list=artrepo.findAll();
		
		//sorting the table records based on Artist id
		((List<Artist>)list).sort((t1,t2)->t1.getAid().compareTo(t2.getAid()));
		return list;
	}

	//6.findAllById method
	@Override
	public Iterable<Artist> showAllArtistById(Iterable<Integer> ids) {
		
		Iterable<Artist>showIds =  artrepo.findAllById(ids);
		return showIds;
	}

	//7.findById method
	@Override
	public Optional<Artist> getArtistById(Integer id) {
	  
		Optional<Artist>art=artrepo.findById(id);
		if(art.isPresent())
			System.out.println("Artist is available:: "+art.get());
		else
			System.out.println("Artist not available");
		return art;
	}
	
	//---------------------2nd variation-----------------------------------
     @Override
     public Artist fetchArtistById(Integer id) {
      
    	 Artist art= artrepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Artist not available"));
    	 System.out.println(art);
    	 return art;
}
}