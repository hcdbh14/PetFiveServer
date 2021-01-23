package app.core.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import interfaces.AdoptionShelterInterface;


@javax.persistence.Entity(name = "adoption_shelters")
@Component("adoptionShelter")
@Scope("prototype")
@Table(name = "adoption_shelters")
public class AdoptionShelter implements AdoptionShelterInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String address;

	public AdoptionShelter() {
		super();
	}
	
	public AdoptionShelter(int id, String name, String email, String phoneNumber, String description, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.address = address;
	}
	
	public int id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String email() {
		return email;
	}
	
	public String phoneNumber() {
		return phoneNumber;
	}
	
	public String description() {
		return description;
	}
	
	public String address() {
		return address;
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
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
