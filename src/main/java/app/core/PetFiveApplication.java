package app.core;

import java.util.Calendar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.core.DBDAO.NoticeDbDao;
import app.core.DBDAO.PostDbDao;
import app.core.beans.AdoptionShelter;
import app.core.beans.Notice;
import app.core.beans.Post;
import app.core.beans.Poster;
import app.core.facades.AdminFacade;
import app.core.facades.AdoptionShelterFacade;
import managers.ClientType;
import managers.LoginManager;

@SpringBootApplication
public class PetFiveApplication implements ApplicationContextAware {

	private static ApplicationContext ctx;
	
	public static void main(String[] args) {

		SpringApplication.run(PetFiveApplication.class, args);
//		AppContext ctx = new AppContext();
//		ctx.setApplicationContext(new ClassPathXmlApplicationContext("applicationContext.xml"));
//		addPoster();

		// SessionFactory - gives us session objects - connection

//		ENTITY_MANAGER_FACTORY.close();
//		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//		EntityTransaction et = null;
//		try {
//			et = em.getTransaction();
//			et.begin();
//			PosterHibernate poster = new PosterHibernate();
//			poster.setId(1);
//			poster.setName("KenBoi");
//			poster.setEmail("kenn@gmail.com");
//			poster.setPhoneNumber("0548071108");
//			em.persist(poster);
//			et.commit();
//		} catch(Exception ex) {
//			if (et != null) {
//				et.rollback();
//			} ex.printStackTrace();
//		} finally {
//			em.close();
//		}

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		java.sql.Date date = new java.sql.Date(cal.getTime().getTime());
//		
//		// Clients facades
		AdminFacade adminUser = ctx.getBean(AdminFacade.class);
		AdoptionShelterFacade shelterUser = ctx.getBean(AdoptionShelterFacade.class);
//		AdminFacade adminUser = (AdminFacade) LoginManager.login("054-8071108", ClientType.Administrator);

//		System.out.println(adminUser.getAllPosters().get(0).email());

//		AdoptionShelterFacade shelterUser = (AdoptionShelterFacade) LoginManager.login("07-3529583",
//				ClientType.AdoptionShelter);
//		PosterFacade posterUser = (PosterFacade) LoginManager.login("0548071108", ClientType.Poster);
//		posterUser.clientId = 1;
//		
//		// Data objects
		Post post = new Post(32, 1, "Keven", "dog", "his a good dog", date, 8, "");
		Notice notice = new Notice(5, "סקייפ", 2, "כלב מתוק שיגשים לכם את כל החלומות הפרועיים של לגדל כלב חמוד.",
				"female", "מסתדר עם כולם", "", 0, "0548071108", 1, "לוולאדור", "צפון", "קטן",
				"ילדים, מבוגרים, אלרגיים, דירה, בית עם חצר, בית עם חתול", date, "cat", 1, 1);
		Notice notice2 = new Notice(6, "סאם", 5, "כלב מתוק שיגשים לכם את כל החלומות הפרועיים של לגדל כלב חמוד.", "male",
				"מסתדר עם כולם", "", 0, "0548071108", 1, "לוולאדור", "צפון", "קטן",
				"ילדים, מבוגרים, אלרגיים, דירה, בית עם חצר, בית עם חתול", date, "cat", 1, 1);
		Poster poster = new Poster(5, "kenoi", "kennnkuro5@gmail.com", "0548071107");
		AdoptionShelter shelter = new AdoptionShelter(74, "עיעמותת חתול", "Save_Lives@gmail.com", "08-3529583",
				"עמותת כלבלאב מצילה כלבים נטושים, משקמת אותם ודואגת להם בזמן השהות בעמותה ועד לאימוץ.",
				"בקיבוץ יסעור (פנייה ראשונה שמאלה) אחרי חוות הסוסים וההסגר");
//		
//		// Create actions
//		posterUser.addPost(post);
//		shelterUser.addNewNotice(notice);
//		adminUser.addNewPoster(poster);
//		adminUser.addNewShelter(shelter);
//		
//		// Update actions
//		posterUser.updatePost(post);
//		shelterUser.updateNotice(notice);
//		adminUser.updatePoster(poster);
//		adminUser.updateShelter(shelter);
//		
//		// Delete actions
//		posterUser.deletePost(post);
//		shelterUser.deleteNotice(notice);
//		adminUser.deletePoster(poster);
//		adminUser.deleteShelter(shelter);
//		
//		// Get Data actions
//		ArrayList<Post> postList = posterUser.getAllPosts();
//		System.out.println("Teacher-Log ---> "+ postList.get(0).description());
//		System.out.println("Teacher-Log ---> " + posterUser.getOnePost(postList.get(0).id()).description());
//		System.out.println("Teacher-Log ---> " + posterUser.getDogPosts().get(0).name());
//		System.out.println("Teacher-Log ---> " + posterUser.getCatPosts().get(0).name());
//		System.out.println("Teacher-Log ---> " + posterUser.getPosterDetails(1).name());
//		System.out.println("Teacher-Log ---> " + posterUser.getAllShelters().get(3).description());
//		System.out.println("Teacher-Log ---> " + posterUser.getAllNotices().get(0).name());
//		
//		
//		// Daily deleter
//		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//
//		
//        TimerTask timerTask = new DeleterDailyJob();
//        executorService.scheduleAtFixedRate(timerTask, 0, 1, TimeUnit.MINUTES);

//		System.out.println(adminUser.getOnePoster(3).name());
//		adminUser.deletePoster(88);
//		adminUser.updatePoster(poster);
//		adminUser.addNewPoster(poster);
//		System.out.println(adminUser.posterExists("kennnkuro5@gmail.com", "0548071107"));
		System.out.println("hey");
		adminUser.addPost(post);
//		adminUser.updatePost(post);
////		adminUser.deletePost(175);
//		System.out.println(adminUser.getOnePost(100).description());
//		System.out.println(adminUser.getAllPosts().get(5).pet_type());

		PostDbDao test = new PostDbDao();
		NoticeDbDao test2 = new NoticeDbDao();
		shelterUser.addNewNotice(notice);
		shelterUser.updateNotice(notice2);
		shelterUser.deleteNotice(78);
		System.out.println(shelterUser.getAllNotices().get(0).name());
		System.out.println(shelterUser.getSpecificNotice(12).name());
		System.out.println(shelterUser.getSpecificShelter(2).name());
		System.out.println(shelterUser.getAllShelters().get(0).name());
		adminUser.addNewShelter(shelter);
		System.out.println(adminUser.isShelterExists("עמותת כלבלאב"));
//		adminUser.deleteShelter(75);
//		test.deleteExpiredPosts();
//		test2.deleteExpiredNotices();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}

}
