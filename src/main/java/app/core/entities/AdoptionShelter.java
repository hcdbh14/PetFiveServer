package app.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import interfaces.AdoptionShelterInterface;

@Entity
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
	@Column(nullable = false, columnDefinition="MEDIUMTEXT")
	private String logo;

	public AdoptionShelter() {
		super();
	}
	
	public AdoptionShelter(int id, String name, String email, String phoneNumber, String description, String address, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.address = address;
		this.logo = logo;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getLogo() {
		return logo;
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
	
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
