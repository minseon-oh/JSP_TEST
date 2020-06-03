package com.test.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.board.model.BoardDAO;
import com.test.board.model.BoardVO;


public class WriteServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		
		dao.write(vo);
		
		
	}

}
