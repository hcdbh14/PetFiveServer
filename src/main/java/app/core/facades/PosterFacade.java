package app.core.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import app.core.DBDAO.PostDbDao;
import app.core.DBDAO.PosterDbDao;
import app.core.beans.Post;
import app.core.beans.Poster;

/**
* This class contains all the actions that poster user can make +
* all the actions of ClientFacade
<p>
*/
@Service("posterFacade")
@Scope("prototype")
public class PosterFacade extends ClientFacade {
	
	@Autowired
	private PostDbDao postDb;
	@Autowired
	private PosterDbDao posterDb;

		
	public void addPost(Post post) {
		postDb.addPost(post);
	}
	
	public void updatePost(Post post) {
		postDb.updatePost(post);
	}
	
	public void deletePost(int postId) {
		postDb.deletePost(postId);
	}
	
	public Poster getPosterDetails(int posterId) {
		return posterDb.getOnePoster(posterId);
	}
}
