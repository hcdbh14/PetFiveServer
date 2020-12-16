package app.core.facades;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import InterfacesDao.AdoptionShelterDao;
import InterfacesDao.NoticeDao;
import InterfacesDao.PostDao;
import app.core.beans.AdoptionShelter;
import app.core.beans.Notice;
import app.core.beans.Post;

/**
* This class contains all the actions that a regular client can make.
<p>
*/
@Service("clientFacade")
@Scope("prototype")
public class ClientFacade {
	
	public int clientId = 0;
	@Autowired
	private PostDao postDb;
	@Autowired
	private NoticeDao noticeDb;
	@Autowired
	private AdoptionShelterDao shelterDb;
//	PostDao postDb = (PostDao) ctx.getBean("postDao");
//	
//	AdoptionShelterDao shelterDb = (AdoptionShelterDao) ctx.getBean("adoptionShelterDao");
	
	
	public ArrayList<Notice> getAllNotices() {
		ArrayList<Notice> result = noticeDb.getAllNotices("");
		
		return result;
	}
	
	public Notice getSpecificNotice(int noticeId) {
		Notice result = noticeDb.getOneNotice(noticeId);

		return result;
	}
	
	public Post getOnePost(int postId) {
		Post result = postDb.getOnePost(postId);
		
		return result;
	}  
	
	public ArrayList<Post> getAllPosts() {
		ArrayList<Post> result = postDb.getAllPosts();
		
		return result;
	}  
	
	public ArrayList<Post> getDogPosts() {
		ArrayList<Post> result = postDb.getAllPosts();
		System.out.print(result.get(0).name());
		return result;
	}  
	
	public ArrayList<Post> getCatPosts() {
		ArrayList<Post> result = postDb.getAllPosts();
		System.out.print(result.get(0).name());
		return result;
	}  
	
	public ArrayList<AdoptionShelter> getAllShelters() {
		ArrayList<AdoptionShelter> result = shelterDb.getAllShelters();
		
		return result;
	}
	
	public AdoptionShelter getSpecificShelter(int shelterId) {
		return shelterDb.getOneShelter(shelterId);
	}
}
