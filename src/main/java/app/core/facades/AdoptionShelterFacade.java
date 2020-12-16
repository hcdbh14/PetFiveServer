package app.core.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import InterfacesDao.NoticeDao;
import app.core.beans.Notice;

/**
* This class contains all the actions that adoption shelter user can make +
* all the actions of ClientFacade
<p>
*/
@Service("adoptionShelterFacade")
@Scope("prototype")
public class AdoptionShelterFacade extends ClientFacade {
	
	@Autowired
	private NoticeDao noticeDb;
	
	public void addNewNotice(Notice notice) {
		noticeDb.addNotice(notice);
	}
	
	public void updateNotice(Notice notice) {
		noticeDb.updateNotice(notice);
	}
	
	public void deleteNotice(int noticeId) {
		noticeDb.deleteNotice(noticeId);
	}
}
