package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import utils.DbConnection;

public class UtenteDao {
	
	DbConnection connessioneDb = null;
	
	public UtenteDao() {
		this.connessioneDb = new DbConnection();
	}
	
	public boolean checkLogin(String email, String password) {
		
		String query = "SELECT * FROM utente WHERE email = '" + email + "' and password = '" + password + "'";
		
		Statement st;
		try {
			st = (Statement) connessioneDb.getConnessione().createStatement();
			ResultSet rs = st.executeQuery(query);			
			while (rs.next()) {				
				return true;
			}
		} 
		catch (SQLException e) {		
			e.printStackTrace();
		}
		
		return false;
	}
}