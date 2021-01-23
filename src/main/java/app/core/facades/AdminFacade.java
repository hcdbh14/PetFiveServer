package app.core.facades;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import app.core.entities.AdoptionShelter;
import app.core.entities.Post;
import app.core.entities.Poster;
/**
* This class contains all that actions that admin user can make.
<p>
*/
@Service("adminFacade")
@Scope("prototype")
public class AdminFacade extends ClientFacade {


			
	public void addShelter(AdoptionShelter shelter) {
		adoptionRepo.save(shelter);
	}

	public void updateShelter(AdoptionShelter shelter) {
		adoptionRepo.save(shelter);
	}

	public void deleteShelter(int shelterId) {
		adoptionRepo.deleteShelter(shelterId);
	}

	public void addPost(Post post) {
		repoPost.save(post);
	}
	
	public void updatePost(Post post) {
		repoPost.save(post);
	}
	
	public void deletePost(int postId) {
		repoPost.deletePost(postId);
	}

	
	public void addNewPoster(Poster poster) {
		repoPoster.save(poster);
	}

	public void updatePoster(Poster poster) {
		repoPoster.save(poster);
	}

	public void deletePoster(int posterId) {
		repoPoster.deletePoster(posterId);
	}

	public List<Poster> getAllPosters() {
		List<Poster> result = repoPoster.getAllPosters();

		return result;
	}

	public Poster getOnePoster(int posterId) {
		Poster result = repoPoster.getOnePoster(posterId);

		return result;
	}
}
