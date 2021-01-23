package app.core.DBDAO;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import InterfacesDao.PostDao;
import app.core.beans.Post;
import managers.HibernateUtility;

/**
* This class contains all the SQL actions that interact with the posts table.
* <p>
*/
@Repository
@Transactional
@Service("postDao")
@Scope("prototype")
public class PostDbDao implements PostDao {
	
	public void addPost(Post post) {

		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			session.save(post);
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void updatePost(Post post) {
		
		Post postDB = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			postDB = session.get(Post.class, post.id());
			if (postDB != null) {
				postDB.setName(post.name());
				postDB.setPet_type(post.pet_type());
				postDB.setDescription(post.description());
				postDB.setPost_date(post.post_date());
				postDB.setPet_age(post.pet_age());
				postDB.setImage(post.image());
				session.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void deletePost(int postId) {
		Post post = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			post = session.get(Post.class, postId);
			if (post != null) {
				session.delete(post);
				session.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public Post getOnePost(int postId) {
		
		Post post = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			post = session.get(Post.class, postId);
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return post;
	}


	public ArrayList<Post> getAllPosts() {

		Session session = null;
		String query = "FROM posts";
		ArrayList<Post> posts = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query<Post> readyQuery = session.createQuery(query, Post.class);

		try {
			posts = (ArrayList<Post>) readyQuery.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return posts;
	}


	public void deleteExpiredPosts() {
		
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.createSQLQuery("DELETE FROM posts\n" 
					+ "WHERE " 
					+ "post_date < NOW() - INTERVAL 30 DAY")
			.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
}
