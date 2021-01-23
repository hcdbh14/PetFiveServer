package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import app.core.entities.Poster;

public interface PosterRepository extends JpaRepository<Poster, Integer> {

	@Modifying
	@Transactional
	@Query("delete Poster where id=:id")
	void deletePoster(@Param("id") int id);
	
	@Query("from Poster")
	List<Poster> getAllPosters();
	
	@Query("from Poster where id=:id")
	Poster getOnePoster(@Param("id") int id);
	
	@Query("from Poster where phone_number=:phoneNumber")
	Poster findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
