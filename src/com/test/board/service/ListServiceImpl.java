package com.test.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.model.BoardDAO;
import com.test.board.model.BoardVO;
import com.test.util.PageVO;


public class ListServiceImpl implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		

		BoardDAO dao = BoardDAO.getInstance();

		int pageNum = 1; //현재페이지번호
		int amount = 10;

		if(request.getParameter("pageNum") != null | request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}

		ArrayList<BoardVO> list = dao.getList(pageNum, amount);

		int total = dao.getTotal();

		PageVO pageVO = new PageVO(pageNum, total, amount);

		request.setAttribute("pageVO", pageVO);
		request.setAttribute("list", list);
	}

}
