package app.core.DBDAO;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import InterfacesDao.AdoptionShelterDao;
import app.core.beans.AdoptionShelter;
import managers.HibernateUtility;

/**
* This class contains all the SQL actions that interact with the adoption_shelters table.
* <p>
*/
@Repository
@Transactional
@Service("adoptionShelterDao")
@Scope("prototype")
public class AdoptionShelterDbDao implements AdoptionShelterDao {
	
	public boolean isShelterExists(String name) {
		boolean result = false;
		Session session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String query = "SELECT count(*) FROM adoption_shelters s where s.name= :name";
		Query<Long>readyQuery = session.createQuery(query, Long.class);
		readyQuery.setParameter("name", name);

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

	public void addShelter(AdoptionShelter adoptionShelter) {
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			session.save(adoptionShelter);
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void updateShelter(AdoptionShelter adoptionShelter) {
		AdoptionShelter shelterDB = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			shelterDB = session.get(AdoptionShelter.class, adoptionShelter.id());
			if (shelterDB != null) {
				shelterDB.setName(adoptionShelter.name());
				shelterDB.setEmail(adoptionShelter.email());
				shelterDB.setPhoneNumber(adoptionShelter.phoneNumber());
				shelterDB.setDescription(adoptionShelter.description());
				shelterDB.setAddress(adoptionShelter.address());
				session.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void deleteShelter(int shelterId) {
		AdoptionShelter shelter = null;
		Session session = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			shelter = session.get(AdoptionShelter.class, shelterId);
			if (shelter != null) {
				session.delete(shelter);
				session.getTransaction().commit();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public ArrayList<AdoptionShelter> getAllShelters() {
		
		Session session = null;
		String query = "FROM adoption_shelters";
		ArrayList<AdoptionShelter> shelters = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query<AdoptionShelter> readyQuery = session.createQuery(query, AdoptionShelter.class);

		try {
			shelters = (ArrayList<AdoptionShelter>) readyQuery.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return shelters;
	}

	public AdoptionShelter getOneShelter(int shelterId) {
	
		Session session = null;
		AdoptionShelter shelter = null;
		session = HibernateUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			shelter = session.get(AdoptionShelter.class, shelterId);
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return shelter;
	}
}
