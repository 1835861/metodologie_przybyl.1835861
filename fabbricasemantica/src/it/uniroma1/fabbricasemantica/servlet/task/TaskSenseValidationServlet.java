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


@WebServlet(name = "TaskSenseValidationServlet", urlPatterns = "/senseValidation.jsp")
public class TaskSenseValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
		
		String attr = "";
		try {
			attr = (String) session.getAttribute("username");
		}catch(NullPointerException e) {response.sendRedirect("logIn.html");};
		

		String risposta  = request.getParameter("definition");
		String submit = request.getParameter("submit_button");
		String value = request.getParameter("radioButton");
		
		
		if(submit.equals("Skip"))
			response.sendRedirect("translationValidation.html");
		else if(submit.equals("Avanti")) {
			try {
				DatabaseConnection dbCon = DatabaseConnection.getInstance();
				Connection con = dbCon.getConnection();
	
				DatabaseTable.createSenseValidation(con);
				int UserID = dbCon.getUserId(attr);
				
				con.prepareStatement("insert into senseValidation(validation, UtenteID) values ('"+value+"','"+String.valueOf(UserID)+"')").executeUpdate();
				response.sendRedirect("translationValidation.html");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}			
		}
		
	}

}
