package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import app.core.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM post WHERE post_date < NOW() - INTERVAL 30 DAY", nativeQuery = true)
	void deleteExpiredPosts();

	@Modifying
	@Transactional
	@Query("delete Post where id=:id")
	void deletePost(@Param("id") int id);
	
	@Query("from Post")
	List<Post> getAllPosts();
	
	@Query("from Post where id=:id")
	Post getOnePost(@Param("id") int id);
}
