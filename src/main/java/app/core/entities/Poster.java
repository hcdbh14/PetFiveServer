package app.core.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import interfaces.PosterInterface;

@javax.persistence.Entity(name = "posters")
@Component("poster")
@Scope("prototype")
@Table(name = "posters")
public class Poster implements PosterInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	public int id() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public Poster() {
		super();
	}
	
	public Poster(int id, String name, String email, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	public String email() {
		// TODO Auto-generated method stub
		return email;
	}

	public String phoneNumber() {
		// TODO Auto-generated method stub
		return phoneNumber;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
