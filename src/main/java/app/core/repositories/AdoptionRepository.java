package InterfacesDao;

import java.util.ArrayList;

import app.core.beans.AdoptionShelter;

public interface AdoptionShelterDao {
	
	public boolean isShelterExists(String name);
	public void addShelter(AdoptionShelter adoptionShelter);
	public void updateShelter(AdoptionShelter adoptionShelter);
	public void deleteShelter(int shelterId);
	public ArrayList<AdoptionShelter> getAllShelters();
	public AdoptionShelter getOneShelter(int shelterId);

}
