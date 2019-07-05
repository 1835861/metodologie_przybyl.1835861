package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DatabaseConnection;
import it.uniroma1.fabbricasemantica.servlet.DatabaseTable;
import it.uniroma1.fabbricasemantica.servlet.user.SignUp;


@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] value = request.getParameterValues("wordName");

		HttpSession session=request.getSession(false);  
		
		if(session.getAttribute("username") == null)
			response.sendRedirect("logIn.html");
		
		
		String attr = (String) session.getAttribute("username");
		String submit = request.getParameter("submit_button");
		
		if(submit.equals("Skip"))
			response.sendRedirect("logOut.html");
		else if(submit.equals("Avanti")) {
			try {
				DatabaseConnection dbCon = DatabaseConnection.getInstance();
				Connection con = dbCon.getConnection();
	
				DatabaseTable.createMyAnnotation(con);
				int UserID = dbCon.getUserId(attr);
				
				PreparedStatement ps;
				for(String v : value) {
					ps = (PreparedStatement) con.prepareStatement("insert into myAnnotation(translation, UtenteID) values (?,'"+String.valueOf(UserID)+"')");
					ps.setString(1, v);
					ps.executeUpdate();
				}
				response.sendRedirect("logOut.html");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}
}
