package controller.Action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.ClientRequestDto;
import client.controller.ClientDao;


public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직
		request.setCharacterEncoding("utf-8");
		
		String clientId = request.getParameter("clientId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Timestamp date = null;
		
		ClientRequestDto clientDto = new ClientRequestDto(clientId, password, name, date);

		ClientDao clientDao = ClientDao.getInstance();
		clientDao.createClient(clientDto);

		response.sendRedirect("login");
	}
	
}
