package it.uniroma1.fabbricasemantica.servlet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DatabaseConnection {
	
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/";
    private String username = "root";
    private String password = "root";
    private String database = "utenti";

    private DatabaseConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url+database, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }

    public Connection getConnection() {
        return connection;
    }
    
    /*
     * @return istanza se già esistente, altrimenti crea nuova istanza
     */
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
	
    /*
     * @param attributo preso dalla sessione (in questo caso l'username)
     * @return l'id associato
     */
	public int getUserId(String attr) throws SQLException {
		int UserId = 0;
		ResultSet rs = connection.prepareStatement("select * from utente where username = '"+attr+"'").executeQuery();
		while(rs.next())
			UserId = rs.getInt("id");
		return UserId;
	}
	
	
	
	
	
}
