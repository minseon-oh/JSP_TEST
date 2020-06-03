package com.test.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.model.BoardDAO;
import com.test.board.model.BoardVO;

public class ModifyServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = new BoardVO();
		vo.setBno(Integer.parseInt(request.getParameter("bno")));
		vo.setWriter(request.getParameter("writer"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		dao.modify(vo);
		
	}

}
