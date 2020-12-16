package app.core.facades;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import InterfacesDao.AdoptionShelterDao;
import app.core.DBDAO.PostDbDao;
import app.core.DBDAO.PosterDbDao;
import app.core.beans.AdoptionShelter;
import app.core.beans.Post;
import app.core.beans.Poster;
/**
* This class contains all that actions that admin user can make.
<p>
*/
@Service("adminFacade")
@Scope("prototype")
public class AdminFacade extends ClientFacade {

	@Autowired
	private PostDbDao postDb;
	@Autowired
	private PosterDbDao posterDb;
	@Autowired
	private AdoptionShelterDao shelterDb;
	
	public boolean isShelterExists(String name) {
		return shelterDb.isShelterExists(name);
	}
			
	public void addNewShelter(AdoptionShelter shelter) {
		shelterDb.addShelter(shelter);
	}

	public void updateShelter(AdoptionShelter shelter) {
		shelterDb.updateShelter(shelter);
	}

	public void deleteShelter(int shelterId) {
		shelterDb.deleteShelter(shelterId);
	}

	public void addPost(Post post) {
		postDb.addPost(post);
	}
	
	public void updatePost(Post post) {
		postDb.updatePost(post);
	}
	
	public void deletePost(int postId) {
		postDb.deletePost(postId);
	}

	
	public void addNewPoster(Poster poster) {
		posterDb.addPoster(poster);
	}

	public void updatePoster(Poster poster) {
		posterDb.updatePoster(poster);
	}

	public void deletePoster(int posterId) {
		posterDb.deletePoster(posterId);
	}

	public ArrayList<Poster> getAllPosters() {
		ArrayList<Poster> result = posterDb.getAllPosters();

		return result;
	}

	public Poster getOnePoster(int posterId) {
		Poster result = posterDb.getOnePoster(posterId);

		return result;
	}
	
	public boolean posterExists(String email, String phoneNumber) {
		boolean result = posterDb.posterExists(email, phoneNumber);

		return result;
	}
}
