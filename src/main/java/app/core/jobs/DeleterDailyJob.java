package app.core.jobs;


import java.util.Date;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import app.core.repositories.NoticeRepository;
import app.core.repositories.PostRepository;

/**
* This class runs on a daily basis and deletes posts and notices that pass their expiration date.
<p>
*/

@Service("deleterDailyJob")
@Scope("singleton")
public class DeleterDailyJob extends TimerTask {

	static DeleterDailyJob instance;
	@Autowired
	public PostRepository repoPost;
	@Autowired
	public NoticeRepository repoNotice;
	
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
		repoPost.deleteExpiredPosts();
		repoNotice.deleteExpiredNotices();
	}
}
