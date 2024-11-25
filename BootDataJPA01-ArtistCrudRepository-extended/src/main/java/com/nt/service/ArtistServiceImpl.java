package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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

	@Override
	public String registerOrUpdateArtist(Artist artist) {
		artrepo.save(artist);
		if(artrepo.existsById(artist.getAid()))
			//if record found in table then updation happens
			return artist.getAname()+" Artist is updated";
		else
			//not found means registration happens
		return artist.getAname()+" Artist is registered";
	}
	
	@Override
	public String hikeActorFeesByIdAndPercentage(int id, double percentage) {
		//load the artist
		Optional<Artist>opt=artrepo.findById(id);
		if(opt.isPresent())
		{
			//get entity object
			Artist artist = opt.get();
			//hike the fee by given percentage
			artist.setAsal(artist.getAsal()+(artist.getAsal()*percentage/100.0f));
			//save the updated record
		    artrepo.save(artist);
		    return artist.getAname()+" Artist is found and fees is modified!";
		}
		else
		return "Artist not found for modification!";
	}
	
	//deleteAllById method
	@Override
	public String removeArtistsByIds(Iterable<Integer> ids) {
	
		Iterable<Artist>list=artrepo.findAllById(ids);
		//only for counting the records
		/*long count=StreamSupport.stream(list.spliterator(), false).count();*/
		long count=0;
		for(Artist artist:list) {
			count++;}
		 artrepo.deleteAllById(ids);
		
		return count+" : no. of artists are deleted";
	}
	
	
	//deleteById method
	@Override
	public String removeArtistById(Integer id) {
	
		Optional<Artist>opt=artrepo.findById(id);
		if(opt.isPresent())
		{
			artrepo.deleteById(id);
			return id+" artist found and deleted.";
		}
		else
			return id+" artist is not found for deletion";
	   }
	
	//deleteAll
	@Override
	public String removeAllArtists() {
     
		long count=artrepo.count();
		if(count>0)
		{
			artrepo.deleteAll();
			return count+" records are deleted.";
		}
		else
		return "no records found to delete.";
	}
}