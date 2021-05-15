package app.core.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	@Modifying
	@Transactional
	@Query("delete Notice where id=:id")
	void deleteNotice(@Param("id") int id);

	@Query("from Notice")
	List<Notice> getAllNotices();
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM notice WHERE post_date < NOW() - INTERVAL 45 DAY", nativeQuery = true)
	void deleteExpiredNotices();

	@Query(value = "\n" + 
			"  SELECT * FROM (\n" + 
			"     (SELECT * FROM notice WHERE pet_type='כלב' ORDER BY id DESC LIMIT 3)\n" + 
			"     UNION\n" + 
			"     (SELECT * FROM notice WHERE pet_type='חתול' ORDER BY id DESC LIMIT 1))\n" + 
			"collection"
			, nativeQuery = true)
	List<Notice> getSpotLightPets();
	
	@Query(value = 
			"SELECT * FROM notice WHERE age IS NULL"
			, nativeQuery = true)
	List<Notice> getAllPetsWithNoAge();
	
	Page<Notice> findByName(String name, Pageable pageable);
	Page<Notice> findByGender(String gender, Pageable pageable);
	Page<Notice> findByRegion(String region, Pageable pageable);
	Page<Notice> findByPetType(String petType, Pageable pageable);
	Page<Notice> findByAgeGroup(String ageGroup, Pageable pageable);
	Page<Notice> findByRegionAndGender(String region, String gender, Pageable pageable);
	Page<Notice> findByGenderAndPetType(String gender, String petType, Pageable pageable);
	Page<Notice> findByPetTypeAndRegion(String petType, String region, Pageable pageable);
	Page<Notice> findByAgeGroupAndRegion(String ageGroup, String region, Pageable pageable);
	Page<Notice> findByAgeGroupAndGender(String ageGroup, String gender, Pageable pageable);
	Page<Notice> findByAgeGroupAndPetType(String ageGroup, String petType, Pageable pageable);
	Page<Notice> findByRegionAndGenderAndPetType(String region, String gender, String petType, Pageable pageable);
	Page<Notice> findByAgeGroupAndRegionAndGender(String ageGroup, String region, String gender, Pageable pageable);
	Page<Notice> findByAgeGroupAndRegionAndGenderAndPetType(String ageGroup, String region, String gender, String petType, Pageable pageable);

	Long countByName(String name);
	Long countByGender(String gender);
	Long countByRegion(String region);
	Long countByPetType(String petType);
	Long countByAgeGroup(String ageGroup);
	Long countByRegionAndGender(String region, String gender);
	Long countByGenderAndPetType(String gender, String petType);
	Long countByPetTypeAndRegion(String petType, String region);
	Long countByAgeGroupAndRegion(String ageGroup, String region);
	Long countByAgeGroupAndGender(String ageGroup, String gender);
	Long countByPetTypeAndAgeGroup(String petType, String ageGroup);
	Long countByRegionAndGenderAndPetType(String region, String gender, String petType);
	Long countByAgeGroupAndRegionAndGender(String ageGroup, String region, String gender);
	Long countByAgeGroupAndRegionAndGenderAndPetType(String ageGroup, String region, String gender, String petType);
}
