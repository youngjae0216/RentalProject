package controller.Action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.Board;
import board.BoardRequestDto;
import board.controller.BoardDao;
import client.Client;

public class ModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String postno = request.getParameter("postno");
		
		
		Timestamp modDate = new Timestamp(System.currentTimeMillis());
		
		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("log");
		
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.getBoardByPostno(postno);
		
		
		BoardRequestDto boardDto = new BoardRequestDto(postno, client.getClientId(), title, content, modDate, board.getDate());
		
		boardDao.modifyBoard(boardDto);
		
		response.sendRedirect("community");
		
	}

}
