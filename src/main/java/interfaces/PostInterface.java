package interfaces;

import java.sql.Date;

public interface PostInterface {
	
	int id();
	int poster_id();
	String pet_type();
	String name();
	String description();
	Date post_date();
	int pet_age();
	String image();
}
