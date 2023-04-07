package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardRequestDto;
import board.controller.BoardDao;
import client.Client;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("log");
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto boardDto = new BoardRequestDto(boardDao.getPostnoMax(), client.getClientId(), title, content, null, null);
		boardDao.createBoard(boardDto);
		
		response.sendRedirect("community");
		
	}

}
