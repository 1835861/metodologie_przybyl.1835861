package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DatabaseConnection;
import it.uniroma1.fabbricasemantica.servlet.DatabaseTable;

/**
 * Servlet implementation class SignUp
 */
@WebServlet(name = "/SignUp", urlPatterns = "/signUp.jsp")
public class SignUp extends BaseServlet {
	private static final Logger logger = Logger.getLogger(SignUp.class.getName());
	private static final long serialVersionUID = 1L;
       
	private DatabaseConnection dbCon;
	private Connection con;
       
	@Override
	public void init() {
		
		try {
			dbCon = DatabaseConnection.getInstance();
			con = dbCon.getConnection();
		    
			DatabaseTable.createTableUtente(con);
		} catch (SQLException e) {

		}

	}

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String confPass = request.getParameter("confPass");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] lingueParlate = request.getParameterValues("lingua");
		
		if(!password.equals(confPass)) {
			error += "Le  due password non coincidono\n";
		}
		if(username == "" || password == "")
			error += "i campi non possono essere lasciati vuoti\n";
			
		if(error != "") {
			response.getWriter().println(error + "\ntra 8 sec verrai rispedito alla pagina di registrazione");
			response.setHeader("Refresh", "8;url=signUp.html");
		}else {
			
			
			try {
			    
				String select_query = "select * from utente where username = '"+username+"' and password = '"+password+"'";
				PreparedStatement prepare_select = (PreparedStatement) con.prepareStatement(select_query);
				ResultSet select = prepare_select.executeQuery();
				
				if(select.next()) {
					//utente con queste credenziali gia presente nel sistema!!
					response.sendRedirect("registrazione.html");
				}
				else {
				    String sql_insert = "insert into utente(username, password, lingue) values(?, ?, ?)";
				    PreparedStatement insert = (PreparedStatement) con.prepareStatement(sql_insert);
				    insert.setString(1, username);
				    insert.setString(2, password);
				    insert.setString(3, String.join(",", lingueParlate));
				    insert.executeUpdate();
				}
				
				response.sendRedirect("logIn.html");
				
			    
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
