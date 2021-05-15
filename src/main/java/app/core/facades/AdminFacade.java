package app.core.facades;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import app.core.entities.AdoptionShelter;
/**
* This class contains all that actions that admin user can make.
<p>
*/
@Service("adminFacade")
@Scope("prototype")
public class AdminFacade extends ClientFacade {


			
	public AdoptionShelter addShelter(AdoptionShelter shelter) {
		return adoptionRepo.save(shelter);
	}

	public void updateShelter(AdoptionShelter shelter) {
		adoptionRepo.save(shelter);
	}

	public void deleteShelter(int shelterId) {
		adoptionRepo.deleteShelter(shelterId);
	}

	public void deleteOldNotices() {
		repoNotice.deleteExpiredNotices();
	}
}
