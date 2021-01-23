package app.core.facades;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import app.core.entities.Post;
import app.core.entities.Poster;

/**
* This class contains all the actions that poster user can make +
* all the actions of ClientFacade
<p>
*/
@Service("posterFacade")
@Scope("prototype")
public class PosterFacade extends ClientFacade  {
	
	
	public void addPost(Post post) {
		repoPost.save(post);
	}
	
	public void updatePost(Post post) {
		repoPost.save(post);
	}
	
	public void deletePost(int postId) {
		repoPost.deletePost(postId);;
	}
	
	public Poster getPosterDetails(int posterId) {
		return repoPoster.getOnePoster(posterId);
	}
	
	public Poster findByPhoneNumber(String phoneNumber) {
		return repoPoster.findByPhoneNumber(phoneNumber);
	}

	public void setBeanName(String name) {
		
		
	}

	public void afterPropertiesSet() throws Exception {
	
	}
}
