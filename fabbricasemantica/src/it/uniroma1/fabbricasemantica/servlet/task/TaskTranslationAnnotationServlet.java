package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import it.uniroma1.fabbricasemantica.servlet.DatabaseConnection;
import it.uniroma1.fabbricasemantica.servlet.DatabaseTable;
import it.uniroma1.fabbricasemantica.servlet.user.SignUp;

@WebServlet(name = "TaskTranslationAnnotationServlet", urlPatterns = "/translationAnnotation.jsp")
public class TaskTranslationAnnotationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
		
		if(session.getAttribute("username") == null)
			response.sendRedirect("logIn.html");
		
		
		String attr = (String) session.getAttribute("username");
		String risposta  = request.getParameter("translation");
		String submit = request.getParameter("submit_button");
		

		if(submit.equals("Skip"))
			response.sendRedirect("definitionAnnotation.html");
		else if(submit.equals("Avanti")) {
			try {
				DatabaseConnection dbCon = DatabaseConnection.getInstance();
				Connection con = dbCon.getConnection();
	
				DatabaseTable.createTranslationAnnotation(con);
				int UserID = dbCon.getUserId(attr);
				
				con.prepareStatement("insert into translationAnnotation(translation, UtenteID) values ('"+risposta+"','"+String.valueOf(UserID)+"')").executeUpdate();
				response.sendRedirect("definitionAnnotation.html");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}

}
