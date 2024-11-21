package com.nt.runners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Artist;
import com.nt.service.ArtistManagmentService;

@Component
public class ArtistRunner implements CommandLineRunner {

	@Autowired
	private ArtistManagmentService artistservice;

	@Override
	public void run(String... args) throws Exception {

		// save method

		/*Artist artist  = new Artist("Prabhas", "Hero", 9000000.0);
		
		try {
		String msg = artistservice.registerArtist(artist);
		System.out.println(msg);
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}*/

		// saveAll method

		/*	Artist artist1  = new Artist("Trivikram","Director", 4000000.0);
			Artist artist2  = new Artist("PoojaHedge","Heroine", 6000000.0);
			Artist artist3  = new Artist("DilRaju","Producer", 10000000.0);
			
			List<Artist> list = List.of(artist1,artist2,artist3);
			
			
			try {
				String msg = artistservice.registerArtistBatch(list);
				System.out.println(msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			*/

		/*//existsById method
		
		try {
			
			boolean flag=artistservice.isArtistAvailable(1);
			
			if(flag)
			{System.out.println("Artist is available");}
			else
			{System.out.println("Artist is not avialable");}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		// count method
		/*try {
			Long cnt=artistservice.countArtists();
			System.out.println("Available artists are:: "+cnt);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		/*	//findAll method
			try {
				
				Iterable<Artist>list=artistservice.showAllArtists();
				
				//java 8 forEach(-) method
				list.forEach(art->{
					System.out.println(art);
				});
				System.out.println("-------------------------------------ForEach--------------------------------");
				
				//Java 8 foreach and streaming api
				((Collection<Artist>)list).stream().forEach(System.out::println);
				System.out.println("--------------------------ForEach + Stream API--------------------------");
				
				//Improved java 8 forEach feature
				list.forEach(art->System.out.println(art));
				System.out.println("--------------------------Improved Java8 ForEach----------------------");
				
				//Java 8 forEach(-) + Static method reference
				list.forEach(System.out::println);
				System.out.println("---------------------ForEach + StaticMethReference------------------");
				
				//Java 5 enhanced for loop
				for(Artist art:list){
					System.out.println(art);
				}
				System.out.println("------------------------------Enhanced For--------------------------------");
				
				Stream.of(list).forEachOrdered(System.out::println);
				System.out.println("------------------ForEachOrdered + Stream API-----------------------");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/

		/*	//findAllById method
			try {
				
				//static method reference + forEach
				artistservice.showAllArtistById(List.of(28,29,30,1,2,100)).forEach(System.out::println);
				
				//other method-forEach
				//artistservice.showAllArtistById(List.of(28, 29, 30, 1, 2, 100)).forEach(artist -> System.out.println(artist));
				
				//Stream+Filter(Role)+forEach
			((Collection<Artist>) artistservice.showAllArtistById(List.of(28,29,30,1,2,100)))
			.stream()
			.filter(artist -> 	"Director".equals(artist.getArole()))
			.forEach(System.out::println);
				
				//Stream+Filter(Salary)+forEach
			((Collection<Artist>) artistservice.showAllArtistById(List.of(28,29,30,1,2,100)))
			.stream()
			.filter(artist -> 	artist.getAsal()>6000000)
			.forEach(System.out::println);
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/

		// --------------------------------------------------------------------------------------------------------
		// FindById method
		/*try {
			 artistservice.getArtistById(28);
			 //for this method client no need of worrying about exceptions. thats why we had written in Service impl itself.
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		// Second variation of findById()
		/*	try {
				Artist art = artistservice.fetchArtistById(28);
				System.out.println(art);
				
				artistservice.fetchArtistById(28);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
		
		//---------------------------------------------
		
		//updation : fully update
		/*try {
			Artist artist= new Artist(34,"Konidela Pawan Kalyan", "Politician/Hero", 10000000.0);
			String msg = artistservice.registerOrUpdateArtist(artist);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
		//updation : partial update
		try {
			String msg = artistservice.hikeActorFeesByIdAndPercentage(330, 4);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
