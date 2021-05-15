package app.core.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.core.entities.AdoptionShelter;
import app.core.entities.Notice;
import app.core.entities.NoticeImage;
import app.core.facades.AdminFacade;
import app.core.facades.AdoptionShelterFacade;
import app.core.facades.ClientFacade;

@RestController
public class PetAPI {

	@Autowired
	AdminFacade adminFacade;

	@Autowired
	ClientFacade clientFacade;

	@Autowired
	AdoptionShelterFacade shelterFacade;

	@GetMapping("/notices")
	public List<Notice> getAllNotices(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "12") int pageSize, HttpServletResponse response) {
		
		if (pageSize > 12) {
			response.setStatus(400);
			return null;
		}
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
		Page<Notice> page = clientFacade.repoNotice.findAll(pageable);

		List<Notice> notices = page.getContent();
		if (notices.isEmpty()) {
			response.setStatus(204);
		}
		return notices;
	}
	
	@GetMapping("/notices/spotLight")
	public List<Notice> getSpotLightPets(HttpServletResponse response) {
		
		List<Notice> notices = clientFacade.repoNotice.getSpotLightPets();
		if (notices.isEmpty()) {
			response.setStatus(204);
		}
		
		return notices;
	}
	
	@GetMapping("/notices/noAge")
	public List<Notice> getPetsWithNoAge(HttpServletResponse response) {
		
		List<Notice> notices = clientFacade.repoNotice.getAllPetsWithNoAge();
		if (notices.isEmpty()) {
			response.setStatus(204);
		}
		
		return notices;
	}
	
	
	@GetMapping("/notices/count")
	public Map<String, Long> countNotices() {
		Map<String, Long> responseMap = new HashMap<String, Long>();
		responseMap.put("count", clientFacade.countNotices());
		return responseMap;
	}
	
	@GetMapping("/notices/details")
	public Notice getNotice(@RequestParam(value = "noticeId") int noticeId, HttpServletResponse response) {
		
		Notice notice = null;
		Optional<Notice> optional = clientFacade.getNoticeById(noticeId);
		if(optional.isPresent()) {
			notice = optional.get();
		} else {
			response.setStatus(204);
		}
		
		return notice;
	}

	@GetMapping("/notices/pet/images")
	public List<NoticeImage> getPetImages(@RequestParam(value = "noticeId") int noticeId,
			HttpServletResponse response) {

		List<NoticeImage> images = clientFacade.getImagesForPet(noticeId);

		if (images.isEmpty()) {
			response.setStatus(204);
		}
		return images;
	}

	@GetMapping("/notices/filter")
	public List<Notice> filterNotices(@RequestParam(value = "ageGroup", defaultValue = "") String ageGroup,
			@RequestParam(value = "region", defaultValue = "") String region,
			@RequestParam(value = "gender", defaultValue = "") String gender,
			@RequestParam(value = "petType", defaultValue = "") String petType,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "12") int pageSize, HttpServletResponse response) {
		
		if (pageSize > 12) {
			response.setStatus(400);
			return null;
		}
		
		Page<Notice> page = clientFacade.filterNotices(pageNumber, pageSize, ageGroup, region, gender, petType, name);
		List<Notice> notices = page.getContent();
		
		if (page.isEmpty()) {
			response.setStatus(204);
		} 
		return notices;
	}

	@GetMapping("/notices/count/filter")
	public Map<String, Long> countFilteredNotices(@RequestParam(value = "ageGroup", defaultValue = "") String ageGroup,
			@RequestParam(value = "region", defaultValue = "") String region,
			@RequestParam(value = "gender", defaultValue = "") String gender,
			@RequestParam(value = "petType", defaultValue = "") String petType,
			@RequestParam(value = "name", defaultValue = "") String name) {
		Map<String, Long> responseMap = new HashMap<String, Long>();
		responseMap.put("count", clientFacade.countFilteredNotices(ageGroup, region, gender, petType, name));
		return responseMap;
	}

	@PostMapping("/notices/add")
	public Map<String, Integer> addNotice(@RequestBody Notice notice) {
		Notice savedNotice = shelterFacade.addNotice(notice);
		Map<String, Integer> responseMap = new HashMap<String, Integer>();
		responseMap.put("id", savedNotice.getId());
		return responseMap;
	}
	
	@PatchMapping("/notices/update")
	public void updateNotice(@RequestBody Notice notice, HttpServletResponse response) {

		if(shelterFacade.getNoticeById(notice.getId()).isPresent()) {
			shelterFacade.addNotice(notice);
		} else {
			response.setStatus(204);
		}
	}
	
	@DeleteMapping("/notices/delete")
	public void deleteNotice(@RequestParam(value = "noticeId") int noticeId) {
		shelterFacade.deleteNotice(noticeId);
	}
	
	@DeleteMapping("/notices/delete-all-old")
	public void deleteOldNotice() {
		adminFacade.deleteOldNotices();
	}
	
	@PostMapping("/notices/pet/images/add")
	public void addPetImages(@RequestBody NoticeImage image) {
		shelterFacade.addPetImage(image);
	}
	
	@GetMapping("/shelters/details")
	public AdoptionShelter getShelterDetails(@RequestParam(value = "shelterId") int shelterId,  HttpServletResponse response) {
		
		AdoptionShelter shelter = null;
		Optional<AdoptionShelter> optional = clientFacade.getShelterById(shelterId);
		
		if (optional.isPresent()) {
			shelter = optional.get();
		} else {
			response.setStatus(204);
		}
		
		return shelter;
	}
	
	@PostMapping("/shelters/add")
	public Map<String, Integer> addShelter(@RequestBody AdoptionShelter shelter) {
		AdoptionShelter savedShelter = adminFacade.addShelter(shelter);
		Map<String, Integer> responseMap = new HashMap<String, Integer>();
		responseMap.put("id", savedShelter.getId());
		return responseMap;
	}
	
	@PatchMapping("/shelters/update")
	public void updateShelter(@RequestBody AdoptionShelter shelter, HttpServletResponse response) {

		if(adminFacade.getShelterById(shelter.getId()).isPresent()) {
			adminFacade.addShelter(shelter);
		} else {
			response.setStatus(204);
		}
	}
	
	@DeleteMapping("/shelters/delete")
	public void deleteShelter(@RequestParam(value = "shelterId") int shelterId) {
		adminFacade.deleteShelter(shelterId);
	}
}
