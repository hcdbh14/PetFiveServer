package InterfacesDao;

import java.util.ArrayList;

import app.core.beans.Post;

public interface PostDao {
	
	public void deleteExpiredPosts();
	public void addPost(Post post);
	public void updatePost(Post post);
	public void deletePost(int postId);
	public ArrayList<Post> getAllPosts();
	public Post getOnePost(int postId);
}
