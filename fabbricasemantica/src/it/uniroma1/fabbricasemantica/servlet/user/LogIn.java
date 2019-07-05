package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DatabaseConnection;
import it.uniroma1.fabbricasemantica.servlet.DatabaseTable;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "/LogIn", urlPatterns = "/logIn.jsp")
public class LogIn extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection dbCon;
	private Connection con;
       
	@Override
	public void init() {
		
		try {
			dbCon = DatabaseConnection.getInstance();
			con = dbCon.getConnection();
		    
		} catch (SQLException e) {

		}

	}

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		
		try {
			String select_query = "select * from utente where username = '"+username+"' and password = '"+password+"'";
			PreparedStatement prepare_select = (PreparedStatement) con.prepareStatement(select_query);
			ResultSet select = prepare_select.executeQuery();
			
			if(select.next()) {
		        HttpSession session=request.getSession();  
		        session.setAttribute("username",username);  
		        response.sendRedirect("wordAnnotation.html");
			}
			else {
				response.sendRedirect("logIn.html");;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
