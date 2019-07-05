package it.uniroma1.fabbricasemantica.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;
import net.sf.extjwnl.JWNLException;


/**
 * Servlet implementation class RichiestaJSON
 */
@WebServlet("/RichiestaJSON")
public class RichiestaJSON extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Task> tasks;
	private DataProvider<String> dataProvider;
	
    
	@Override
	public void init() throws ServletException {
		super.init();

		dataProvider = new StandardDataProvider();
		tasks = Arrays.stream(StandardTask.values()).collect(Collectors.toMap(Task::getTaskID, s -> s));
		
	}

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sTask = (String) request.getParameter("task");
		Task task = tasks.get(sTask);
		String json = dataProvider.getData(task);
		response.getWriter().write(json);
		
	}

}
