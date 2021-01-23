package app.core.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import interfaces.PostInterface;

/**
* Post object holds the data about a lost pet. Posts are created by Posters.
* <p>
*/

@Entity
public class Post implements PostInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int poster_id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String pet_type;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private Date post_date;
	@Column(nullable = false)
	private int pet_age;
	@Column(nullable = true)
	private String image;
	

	public Post() {
		super();
	}
	
	public Post(int id, int poster_id, String name, String pet_type, String description, Date post_date, int pet_age, String image) {
		super();
		this.id = id;
		this.poster_id = poster_id;
		this.name = name;
		this.pet_type = pet_type;
		this.description = description;
		this.post_date = post_date;
		this.pet_age = pet_age;
		this.image = image;
	}

	public int id() {
		return id;
	}
	
	public int poster_id() {
		return poster_id;
	}

	public String pet_type() {
		return pet_type;
	}

	public String name() {
		return name;
	}
	
	public String description() {
		return description;
	}

	public Date post_date() {
		return post_date;
	}

	public int pet_age() {
		return pet_age;
	}

	public String image() {
		return image;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPoster_id(int poster_id) {
		this.poster_id = poster_id;
	}


	public void setPet_type(String pet_type) {
		this.pet_type = pet_type;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public void setPet_age(int pet_age) {
		this.pet_age = pet_age;
	}


	public void setImage(String image) {
		this.image = image;
	}
}
