package interfaces;

import java.sql.Date;

public interface NoticeImageInterface {

	int getId();
	void setId(int id);
	int getNoticeId();
	void setNoticeId(int shelterId);
	Date getPostDate();
	void setPostDate(Date postDate);
	String getImage();
	void setImage(String image);
}
