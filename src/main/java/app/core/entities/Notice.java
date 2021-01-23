package app.core.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import interfaces.NoticeInterface;

/**
 * Notice object holds the data about a pet for adoption. Notices are created by
 * adoption shelters.
 * <p>
 */

@Entity
public class Notice implements NoticeInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String age;
	@Column(columnDefinition = "TEXT")
	private String description;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String goodWords;
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
	@Column(nullable = false)
	private String ageGroup;
	@Column(nullable = false, columnDefinition = "MEDIUMTEXT")
	private String image;

	public Notice() {
		super();
	}

	public Notice(int id, String name, String age, String description, String gender, String goodWords, int isAdopted,
			String phoneNumber, int poopTrained, String race, String region, String size, String suitables,
			Date postDate, String petType, int shelter_id, int vaccinated, String ageGroup, String image) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.description = description;
		this.gender = gender;
		this.goodWords = goodWords;
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
		this.ageGroup = ageGroup;
		this.image = image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
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

	public void setImage(String image) {
		this.image = image;
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

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getDescription() {
		return description;
	}

	public String getGender() {
		return gender;
	}

	public String getGoodWords() {
		return goodWords;
	}

	public String getImage() {
		return image;
	}

	public int getIsAdopted() {
		return isAdopted;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getPoopTrained() {
		return poopTrained;
	}

	public String getRace() {
		return race;
	}

	public String getRegion() {
		return region;
	}

	public String getSize() {
		return size;
	}

	public String getSuitables() {
		return suitables;
	}

	public Date getPostDate() {
		return postDate;
	}

	public String getPetType() {
		return petType;
	}

	public int getShelter_id() {
		return shelter_id;
	}

	public int getVaccinated() {
		return vaccinated;
	}

	public String getAgeGroup() {
		return ageGroup;
	}
}
