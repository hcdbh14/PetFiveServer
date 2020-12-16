package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.core.beans.Post;
import app.core.facades.AdminFacade;
import app.core.facades.AdoptionShelterFacade;
import app.core.facades.ClientFacade;
import app.core.facades.PosterFacade;

/**
 * This class receives a ClientType and searches if the client exists in the
 * relative table.
 * <p>
 */
public class LoginManager {

	static LoginManager instance;

	public static LoginManager getInstance() {
		if (instance == null) {
			instance = new LoginManager();
		}

		return instance;
	}

	public static ClientFacade login(String phoneNumber, ClientType clientType) {
		
		int clientId = 0;
		String SQL_QUERY = null;
		ClientFacade clientToPass = null;
		String phoneNumberDB = null;

		switch (clientType) {

		case Administrator:
			if (phoneNumber == "054-8071108" && clientType == ClientType.Administrator) {
				return new AdminFacade();
			}
		case Poster:
			SQL_QUERY = "SELECT id, phone_number FROM posters where phone_number=" + "'" + phoneNumber + "'" + " LIMIT 1";
			clientToPass = new PosterFacade();
			break;
		case AdoptionShelter:
			SQL_QUERY = "SELECT id, phone_number FROM adoption_shelters where phone_number=" + "'" + phoneNumber + "'"
					+ " LIMIT 1";
			clientToPass = new AdoptionShelterFacade();
			break;
		}

		try (Connection con = ConnectionPool.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_QUERY);
				ResultSet rs = pst.executeQuery();) {
			System.out.println(SQL_QUERY);
			while (rs.next()) {
				clientId = rs.getInt("id");
				phoneNumberDB = rs.getString("phone_number");
			}

			if (phoneNumberDB != null) {
				clientToPass.clientId = clientId;
				return clientToPass;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
