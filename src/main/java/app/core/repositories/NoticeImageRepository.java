package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.NoticeImage;

public interface NoticeImageRepository extends JpaRepository<NoticeImage, Integer> {	
	
	@Query("from NoticeImage where noticeId=:noticeId")
	List<NoticeImage> getAllImagesForPet(@Param("noticeId") int noticeId);
	
	@Modifying
	@Transactional
	@Query("delete NoticeImage where noticeId=:noticeId")
	void deleteImagesForPet(@Param("noticeId") int noticeId);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM notice_image WHERE post_date < NOW() - INTERVAL 30 DAY", nativeQuery = true)
	void deleteExpiredNoticeImages();
}
