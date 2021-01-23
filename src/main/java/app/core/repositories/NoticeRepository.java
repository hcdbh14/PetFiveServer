package InterfacesDao;

import java.util.ArrayList;

import app.core.beans.Notice;

public interface NoticeDao {

	public void deleteExpiredNotices();
	public void addNotice(Notice notice);
	public void updateNotice(Notice notice);
	public void deleteNotice(int noticeId);
	public ArrayList<Notice> getAllNotices(String filter);
	public Notice getOneNotice(int noticeId);
}
