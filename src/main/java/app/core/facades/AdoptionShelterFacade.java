package app.core.facades;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.core.entities.AdoptionShelter;
import app.core.entities.Notice;
import app.core.entities.NoticeImage;

/**
* This class contains all the actions that adoption shelter user can make +
* all the actions of ClientFacade
<p>
*/
@Service("adoptionShelterFacade")
@Scope("prototype")
public class AdoptionShelterFacade extends ClientFacade {
	
	public Notice addNotice(Notice notice) {
		return repoNotice.save(notice);
	}
	
	public void updateNotice(Notice notice) {
		repoNotice.save(notice);
	}
	
	public void deleteNotice(int noticeId) {
		repoNotice.deleteNotice(noticeId);
	}
	
	public void addPetImage(NoticeImage image) {
		repoNoticeImage.save(image);
	}
		
	public AdoptionShelter findByPhoneNumber(String phoneNumber) {
		return adoptionRepo.findByPhoneNumber(phoneNumber);
	}
}
