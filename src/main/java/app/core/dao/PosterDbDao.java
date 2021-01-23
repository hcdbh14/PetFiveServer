package app.core.DBDAO;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import InterfacesDao.PosterDao;
import app.core.beans.Poster;
import managers.HibernateUtility;

/**
* This class contains all the SQL actions that interact with the posters table.
<p>
*/
@Repository
@Transactional
@Service("posterDao")
@Scope("prototype")
public class PosterDbDao implements PosterDao {
	
	public boolean posterExists(String email, String phoneNumber) {
		boolean result = false;
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String query = "SELECT count(*) FROM posters p where p.email= :email AND p.phoneNumber= :phoneNumber";
		Query<Long>readyQuery = session.createQuery(query, Long.class);
		readyQuery.setParameter("email", email);
		readyQuery.setParameter("phoneNumber", phoneNumber);

		try {
			if (readyQuery.uniqueResult() != 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public void addPoster(Poster poster) {
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			session.save(poster);
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void updatePoster(Poster poster) {
		Poster posterDB = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			posterDB = session.get(Poster.class, poster.id());
			if (posterDB != null) {
				posterDB.setName(poster.name());
				posterDB.setEmail(poster.email());
				posterDB.setPhoneNumber(poster.phoneNumber());
				session.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void deletePoster(int posterID) {
		Poster poster = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			poster = session.get(Poster.class, posterID);
			if (poster != null) {
				session.delete(poster);
				session.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public ArrayList<Poster> getAllPosters() {
		Session session = null;
		String query = "FROM posters";
		ArrayList<Poster> posters = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query<Poster> readyQuery = session.createQuery(query, Poster.class);
	
		try {
			posters = (ArrayList<Poster>) readyQuery.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return posters;
	}

	public Poster getOnePoster(int posterID) {
		Poster poster = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			poster = session.get(Poster.class, posterID);
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return poster;
	}
}
