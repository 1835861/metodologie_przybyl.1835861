package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DatabaseConnection;

/**
 * Servlet implementation class Logout
 */
@WebServlet(name = "/LogOut", urlPatterns = "/logOut.jsp")
public class LogOut extends BaseServlet{
	private static final long serialVersionUID = 1L;


	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DatabaseConnection.getInstance().getConnection().close();
		}catch(SQLException e) {}
		
		HttpSession session=request.getSession(false);  
		
		if(session != null)
			session.invalidate();
		
		response.sendRedirect("logIn.html");
	}
		
}
