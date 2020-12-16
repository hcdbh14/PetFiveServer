package app.core.DBDAO;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import InterfacesDao.NoticeDao;
import app.core.beans.Notice;
import managers.HibernateUtility;

/**
* This class contains all the SQL actions that interact with the adoption_notices table.
<p>
*/
@Repository
@Transactional
@Service("noticeDao")
@Scope("prototype")
public class NoticeDbDao implements NoticeDao {

	public void deleteExpiredNotices() {
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.createSQLQuery("DELETE FROM adoption_notices\n" 
					+ "WHERE " 
					+ "post_date < NOW() - INTERVAL 30 DAY")
			.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void addNotice(Notice notice) {
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			session.save(notice);
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void updateNotice(Notice notice) {
		Notice noticeDB = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			noticeDB = session.get(Notice.class, notice.id());
			
			if (noticeDB != null) {
				System.out.println("nice");
				noticeDB.setName(notice.name());
				noticeDB.setAge(notice.age());
				noticeDB.setDescription(notice.description());
				noticeDB.setGender(notice.gender());
				noticeDB.setGoodWords(notice.goodWords());
				noticeDB.setImages(notice.images());
				noticeDB.setAdopted(notice.isAdopted());
				noticeDB.setPhoneNumber(notice.phoneNumber());
				noticeDB.setPoopTrained(notice.poopTrained());
				noticeDB.setRace(notice.race());
				noticeDB.setRegion(notice.region());
				noticeDB.setSize(notice.size());
				noticeDB.setSuitables(notice.suitables());
				noticeDB.setPostDate(notice.postDate());
				noticeDB.setPetType(notice.petType());
				noticeDB.setShelter_id(notice.shelter_id());
				noticeDB.setVaccinated(notice.vaccinated());
				session.getTransaction().commit();
				System.out.println("done");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void deleteNotice(int noticeId) {
		Notice notice = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			notice = session.get(Notice.class, noticeId);
			if (notice != null) {
				session.delete(notice);
				session.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public ArrayList<Notice> getAllNotices(String filter) {
		Session session = null;
		String query = "FROM adoption_notices";
		ArrayList<Notice> notices = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query<Notice> readyQuery = session.createQuery(query, Notice.class);

		try {
			notices = (ArrayList<Notice>) readyQuery.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return notices;
	}

	public Notice getOneNotice(int noticeId) {
		Notice notice = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			notice = session.get(Notice.class, noticeId);
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return notice;
	}
}
