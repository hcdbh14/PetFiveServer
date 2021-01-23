package InterfacesDao;

import java.util.ArrayList;

import app.core.beans.Poster;

public interface PosterDao {
	
	public boolean posterExists(String email, String phoneNumber);
	public void addPoster(Poster poster);
	public void updatePoster(Poster poster);
	public void deletePoster(int posterID);
	public ArrayList<Poster> getAllPosters();
	public Poster getOnePoster(int posterID);
}
