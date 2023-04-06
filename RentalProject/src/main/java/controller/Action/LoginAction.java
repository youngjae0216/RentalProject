package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.Client;
import client.controller.ClientDao;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
request.setCharacterEncoding("utf-8");
		
		String clientId = request.getParameter("clientId");
		String password = request.getParameter("password");
		
		
		ClientDao clientDao = ClientDao.getInstance();
		Client client = clientDao.getClientById(clientId);
		
		if(client.getPassword().equals(password)) {
			response.sendRedirect("mypage");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("log", session);
		
	}

}
