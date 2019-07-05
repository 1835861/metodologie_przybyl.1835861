package it.uniroma1.fabbricasemantica.servlet;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseTable {

	public static void createDefinitionAnnotation(Connection con) throws ClassNotFoundException, SQLException {

		PreparedStatement create = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS definitionAnnotation"+
				"(id INTEGER not NULL AUTO_INCREMENT,"+ 
				"definition VARCHAR(255)," +
				"UtenteID int,"+ 
				"PRIMARY KEY ( id ),"+
				"FOREIGN KEY (UtenteID) REFERENCES utente(id))" );
		int res = create.executeUpdate();

	}
	
	public static void createTranslationAnnotation(Connection con) throws ClassNotFoundException, SQLException {

		PreparedStatement ps = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS translationAnnotation"+
				"(id INTEGER not NULL AUTO_INCREMENT,"+ 
				"translation VARCHAR(255)," +
				"UtenteID int,"+ 
				"PRIMARY KEY ( id ),"+
				"FOREIGN KEY (UtenteID) REFERENCES utente(id))" );
		int res = ps.executeUpdate();
	}
	

	public static void createWordAnnotation(Connection con) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS wordAnnotation"+
				"(id INTEGER not NULL AUTO_INCREMENT,"+ 
				"description VARCHAR(255)," +
				"UtenteID int,"+ 
				"PRIMARY KEY ( id ),"+
				"FOREIGN KEY (UtenteID) REFERENCES utente(id))" );
		int res = ps.executeUpdate();
	}
	
	public static void createSenseAnnotation(Connection con) throws ClassNotFoundException, SQLException {

		PreparedStatement ps = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS senseAnnotation"+
				"(id INTEGER not NULL AUTO_INCREMENT,"+ 
				"sense VARCHAR(255)," +
				"UtenteID int,"+ 
				"PRIMARY KEY ( id ),"+
				"FOREIGN KEY (UtenteID) REFERENCES utente(id))" );
		int res = ps.executeUpdate();
	}
	
	public static void createTranslationValidation(Connection con) throws ClassNotFoundException, SQLException {

		PreparedStatement ps = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS translationValidation"+
				"(id INTEGER not NULL AUTO_INCREMENT,"+ 
				"translation VARCHAR(255)," +
				"UtenteID int,"+ 
				"PRIMARY KEY ( id ),"+
				"FOREIGN KEY (UtenteID) REFERENCES utente(id))" );
		int res = ps.executeUpdate();
	}
	
	public static void createSenseValidation(Connection con) throws ClassNotFoundException, SQLException {

		PreparedStatement ps = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS senseValidation"+
				"(id INTEGER not NULL AUTO_INCREMENT,"+ 
				"validation VARCHAR(255)," +
				"UtenteID int,"+ 
				"PRIMARY KEY ( id ),"+
				"FOREIGN KEY (UtenteID) REFERENCES utente(id))" );
		int res = ps.executeUpdate();
	}
	
	public static void createMyAnnotation(Connection con) throws ClassNotFoundException, SQLException {

		PreparedStatement ps = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS myAnnotation"+
				"(id INTEGER not NULL AUTO_INCREMENT,"+ 
				"translation VARCHAR(255)," +
				"UtenteID int,"+ 
				"PRIMARY KEY ( id ),"+
				"FOREIGN KEY (UtenteID) REFERENCES utente(id))" );
		int res = ps.executeUpdate();
	}
	
	public static void createTableUtente(Connection con) throws SQLException {
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS utente " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " username VARCHAR(255), " + 
                " password VARCHAR(255), " +  
                " lingue VARCHAR(255), " +  
                " PRIMARY KEY ( id ))"); 
		int res = ps.executeUpdate();
	}
}
