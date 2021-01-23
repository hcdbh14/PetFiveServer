package app.core.facades;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import app.core.entities.AdoptionShelter;
import app.core.entities.Notice;
import app.core.entities.NoticeImage;
import app.core.entities.Post;
import app.core.repositories.AdoptionRepository;
import app.core.repositories.NoticeImageRepository;
import app.core.repositories.NoticeRepository;
import app.core.repositories.PostRepository;
import app.core.repositories.PosterRepository;
/**
* This class contains all the actions that a regular client can make.
<p>
*/
@Service("clientFacade")
@Scope("prototype")
public class ClientFacade {
	
	public int clientId = 0;

	@Autowired
	EntityManager em;
	
	@Autowired
	public PostRepository repoPost;
	
	@Autowired
	public PosterRepository repoPoster;
	
	@Autowired
	public NoticeRepository repoNotice;
	
	@Autowired
	public AdoptionRepository adoptionRepo;
	
	@Autowired
	public NoticeImageRepository repoNoticeImage;
	
	
	public List<Notice> getAllNotices() {
		List<Notice> result = repoNotice.getAllNotices();
		
		return result;
	}
	
	public Optional<Notice> getNoticeById(int noticeId) {
		Optional<Notice> result = repoNotice.findById(noticeId);

		return result;
	}
	
	public Post getOnePost(int postId) {
		Post result = repoPost.getOnePost(postId);
		
		return result;
	}  
	
	public List<Post> getAllPosts() {
		List<Post> result = repoPost.getAllPosts();
		
		return result;
	}  
	  
	
	public List<AdoptionShelter> getAllShelters() {
		List<AdoptionShelter> result = adoptionRepo.getAllShelters();
	
		return result;
	}
	
	public Optional<AdoptionShelter> getShelterById(int shelterId) {
		return adoptionRepo.findById(shelterId);
	}
	
	public AdoptionShelter getShelterByName(String name) {

		return adoptionRepo.getByName(name);
	}
	
	public long countNotices() {
		
		return repoNotice.count();
	}
	
	public List<NoticeImage> getImagesForPet(int noticeId) {

		return repoNoticeImage.getAllImagesForPet(noticeId);
	}
	
	public List<Notice> getSpotLightPets() {
		
		return repoNotice.getSpotLightPets();
	}
	
	public Page<Notice> filterNotices(int pageNumber, int pageSize, String ageGroup, String region, String gender, String petType, String name) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		System.out.println(ageGroup);
		System.out.println(region);
		System.out.println(gender);
		System.out.println(ageGroup);
		
		if (name.isBlank() == false) {
			return repoNotice.findByName(name, pageable);
		}
		
		if (ageGroup != null && region.isBlank()  && gender.isBlank()  && petType.isBlank() ) {
			System.out.println(ageGroup);
			return repoNotice.findByAgeGroup(ageGroup, pageable);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  == false&& gender.isBlank()  && petType.isBlank() ) {
			System.out.println(ageGroup);
			return repoNotice.findByAgeGroupAndRegion(ageGroup, region, pageable);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  && gender.isBlank()  == false&& petType.isBlank() ) {
			System.out.println(ageGroup);
			return repoNotice.findByAgeGroupAndGender(ageGroup,gender, pageable);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  && gender.isBlank()  && petType != "") {
			System.out.println(ageGroup);
			return repoNotice.findByAgeGroupAndPetType(ageGroup, petType, pageable);
		}
				
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  && petType.isBlank() ) {
			System.out.println(ageGroup);
			return repoNotice.findByRegion(region, pageable);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  == false&& petType.isBlank() ) {
			System.out.println(ageGroup);
			return repoNotice.findByRegionAndGender(region, gender, pageable);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  && gender.isBlank()  == false&& petType.isBlank() ) {
			System.out.println(ageGroup);
			return repoNotice.findByGender(gender, pageable);
		}
	
		if (ageGroup.isBlank()  && region.isBlank()  && gender.isBlank()  == false&& petType != "") {
			System.out.println(ageGroup);
			return repoNotice.findByGenderAndPetType(gender, petType, pageable);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  && gender.isBlank()  && petType != "") {
			return repoNotice.findByPetType(petType, pageable);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  && petType != "") {
			return repoNotice.findByPetTypeAndRegion(petType, region, pageable);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  == false&& petType != "") {
			return repoNotice.findByRegionAndGenderAndPetType(region, gender, petType, pageable);
		}
		
		if (ageGroup != null && region.isBlank()  == false&& gender.isBlank()  == false&& petType.isBlank() ) {
			return repoNotice.findByAgeGroupAndRegionAndGender(ageGroup, region, gender, pageable);
		}
		
		if (ageGroup != null && region != null && gender != null && petType != null) {
			return repoNotice.findByAgeGroupAndRegionAndGenderAndPetType(ageGroup, region, gender, petType, pageable);
		}

		return null;
    }
	
	public Long countFilteredNotices(String ageGroup, String region, String gender, String petType, String name) {
		
		if (name.isBlank() == false) {
			return repoNotice.countByName(name);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  && gender.isBlank()  && petType.isBlank() ) {
			return repoNotice.countByAgeGroup(ageGroup);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  == false&& gender.isBlank()  && petType.isBlank() ) {
			return repoNotice.countByAgeGroupAndRegion(ageGroup, region);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  && gender.isBlank()  == false&& petType.isBlank() ) {
			return repoNotice.countByAgeGroupAndGender(ageGroup,gender);
		}
				
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  && petType.isBlank() ) {
			return repoNotice.countByRegion(region);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  == false&& petType.isBlank() ) {
			return repoNotice.countByRegionAndGender(region, gender);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  && gender.isBlank()  == false&& petType.isBlank() ) {
			return repoNotice.countByGender(gender);
		}
	
		if (ageGroup.isBlank()  && region.isBlank()  && gender.isBlank()  == false&& petType != "") {
			return repoNotice.countByGenderAndPetType(gender, petType);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  && gender.isBlank()  && petType != "") {
			return repoNotice.countByPetType(petType);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  && petType != "") {
			return repoNotice.countByPetTypeAndRegion(petType, region);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  && gender.isBlank()  && petType != "") {
			return repoNotice.countByPetTypeAndAgeGroup(petType, ageGroup);
		}
		
		if (ageGroup.isBlank()  && region.isBlank()  == false&& gender.isBlank()  == false&& petType != "") {
			return repoNotice.countByRegionAndGenderAndPetType(region, gender, petType);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  == false&& gender.isBlank()  == false&& petType.isBlank() ) {
			return repoNotice.countByAgeGroupAndRegionAndGender(ageGroup, region, gender);
		}
		
		if (ageGroup.isBlank()  == false&& region.isBlank()  == false&& gender.isBlank()  == false&& petType != null) {
			return repoNotice.countByAgeGroupAndRegionAndGenderAndPetType(ageGroup, region, gender, petType);
		}
		
		return (long) 0;
	}
}
