package interfaces;

import java.sql.Date;

public interface NoticeInterface {

	int id();
	String name();
	int age();
	String description();
	String gender();
	String goodWords();
	String images();
	int isAdopted();
	String phoneNumber();
	int poopTrained();
	String race();
	String region();
	String size();
	String suitables();
	Date postDate();
	String petType();
	int shelter_id();
	int vaccinated();
}
