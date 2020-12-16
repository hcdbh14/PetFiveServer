package managers;

import org.hibernate.cfg.Configuration;

import app.core.beans.AdoptionShelter;
import app.core.beans.Notice;
import app.core.beans.Post;
import app.core.beans.Poster;
import org.hibernate.SessionFactory;

public class HibernateUtility {
	
	private static SessionFactory factory;

	public static synchronized SessionFactory getSessionFactory() {

		if (factory == null) {
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Post.class)
					.addAnnotatedClass(Poster.class)
					.addAnnotatedClass(Notice.class)
					.addAnnotatedClass(AdoptionShelter.class)
					.buildSessionFactory();
		}
		return factory;
	}
}