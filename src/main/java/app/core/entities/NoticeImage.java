package app.core.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import interfaces.NoticeImageInterface;


@Entity
public class NoticeImage implements NoticeImageInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int noticeId;
	private Date postDate;
	@Column(columnDefinition="MEDIUMTEXT")
	private String image;
	
	public NoticeImage() {
		super();
	}
	
	public NoticeImage(int noticeId,Date postDate, String image) {
		super();
		this.noticeId = noticeId;
		this.postDate = postDate;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public Date getPostDate() {
		return postDate;
	}
	
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
