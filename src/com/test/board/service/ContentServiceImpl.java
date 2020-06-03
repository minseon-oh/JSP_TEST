package com.test.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.model.BoardDAO;
import com.test.board.model.BoardVO;

public class ContentServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.content(bno);
		request.setAttribute("BoardVO", vo);
	}

}
