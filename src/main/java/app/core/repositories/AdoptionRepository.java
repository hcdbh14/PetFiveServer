package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import app.core.entities.AdoptionShelter;


public interface AdoptionRepository extends JpaRepository<AdoptionShelter, Integer> {	

	@Query("from AdoptionShelter where name=:name")
	AdoptionShelter getByName(@Param("name") String name);

	@Modifying
	@Transactional 
	@Query("update AdoptionShelter set address = :address, description = :description, email = :email, name = :name, phone_number = :phoneNumber where id = :id")
	void updateShelter(@Param("id") int id, @Param("address") String address, @Param("description") String description, @Param("email") String email, @Param("name") String name, @Param("phoneNumber") String phoneNumber);

	@Modifying
	@Transactional 
	@Query("delete AdoptionShelter where id = :id")
	void deleteShelter(@Param("id") int id);
	
	@Query("from AdoptionShelter")
	List<AdoptionShelter> getAllShelters();

	
	@Query("from AdoptionShelter where phone_number=:phoneNumber")
	AdoptionShelter findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
