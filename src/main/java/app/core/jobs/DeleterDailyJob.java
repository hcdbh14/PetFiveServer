package jobs;


import java.util.Date;
import java.util.TimerTask;

import app.core.DBDAO.NoticeDbDao;
import app.core.DBDAO.PostDbDao;

/**
* This class runs on a daily basis and deletes posts and notices that pass their expiration date.
<p>
*/
public class DeleterDailyJob extends TimerTask {

	static DeleterDailyJob instance;
	
	public static DeleterDailyJob getInstance() {
		if (instance == null) {
			instance = new DeleterDailyJob();
		}
		
		return instance;
	}
	
	public void run() {
		System.out.println("Timer task started at:" + new Date());
		deleteOldPostsAndNotices();
		System.out.println("Timer task finished at:" + new Date());
	}

	private void deleteOldPostsAndNotices() {
		PostDbDao postDBDAO = new PostDbDao();
		NoticeDbDao noticeDBDAO = new NoticeDbDao();
		postDBDAO.deleteExpiredPosts();
		noticeDBDAO.deleteExpiredNotices();
	}
}
