package app.core.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import interfaces.NoticeInterface;

/**
* Notice object holds the data about a pet for adoption.
Notices are created by adoption shelters.
* <p>
*/

@javax.persistence.Entity(name = "adoption_notices")
@Component("notice")
@Scope("prototype")
@Table(name = "adoption_notices")
public class Notice implements NoticeInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	private String description;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String goodWords;
	@Column(nullable = false)
	private String images;
	@Column(nullable = false)
	private int isAdopted;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Column(name = "poop_trained", nullable = false)
	private int poopTrained;
	@Column(nullable = false)
	private String race;
	@Column(nullable = false)
	private String region;
	@Column(nullable = false)
	private String size;
	@Column(nullable = false)
	private String suitables;
	@Column(name = "post_date", nullable = false)
	private Date postDate;
	@Column(name = "pet_type", nullable = false)
	private String petType;
	@Column(nullable = false)
	private int shelter_id;
	@Column(nullable = false)
	private int vaccinated;
	
	
	public Notice() {
		super();
	}
	
	public Notice(int id, String name, int age, String description, String gender, String goodWords, String images,
			int isAdopted, String phoneNumber, int poopTrained, String race, String region, String size,
			String suitables, Date postDate, String petType, int shelter_id, int vaccinated) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.description = description;
		this.gender = gender;
		this.goodWords = goodWords;
		this.images = images;
		this.isAdopted = isAdopted;
		this.phoneNumber = phoneNumber;
		this.poopTrained = poopTrained;
		this.race = race;
		this.region = region;
		this.size = size;
		this.suitables = suitables;
		this.postDate = postDate;
		this.petType = petType;
		this.shelter_id = shelter_id;
		this.vaccinated = vaccinated;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setGoodWords(String goodWords) {
		this.goodWords = goodWords;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setAdopted(int isAdopted) {
		this.isAdopted = isAdopted;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPoopTrained(int poopTrained) {
		this.poopTrained = poopTrained;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setSuitables(String suitables) {
		this.suitables = suitables;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public void setShelter_id(int shelter_id) {
		this.shelter_id = shelter_id;
	}

	public void setVaccinated(int vaccinated) {
		this.vaccinated = vaccinated;
	}

	public int id() {
		return id;
	}

	public String name() {
		return name;
	}

	public int age() {
		return age;
	}

	public String description() {
		return description;
	}

	public String gender() {
		return gender;
	}


	public String goodWords() {
		return goodWords;
	}


	public String images() {
		return images;
	}


	public int isAdopted() {
		return isAdopted;
	}


	public String phoneNumber() {
		return phoneNumber;
	}


	public int poopTrained() {
		return poopTrained;
	}


	public String race() {
		return race;
	}


	public String region() {
		return region;
	}


	public String size() {
		return size;
	}


	public String suitables() {
		return suitables;
	}


	public Date postDate() {
		return postDate;
	}


	public String petType() {
		return petType;
	}


	public int shelter_id() {
		return shelter_id;
	}


	public int vaccinated() {
		return vaccinated;
	}
}
