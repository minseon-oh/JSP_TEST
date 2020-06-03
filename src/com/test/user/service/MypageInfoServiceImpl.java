package com.test.user.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.board.model.BoardVO;
import com.test.user.model.UserDAO;
import com.test.user.model.UserVO;

public class MypageInfoServiceImpl implements UserService{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		String id = (String)session.getAttribute("user_id");
		System.out.println(id);
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.info(id);
		ArrayList<BoardVO> list = dao.myContent(id);
		request.setAttribute("infoVO", vo);
		request.setAttribute("myList", list);
		
		return 0;
	}

}
