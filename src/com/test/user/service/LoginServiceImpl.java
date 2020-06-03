package com.test.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.user.model.UserDAO;

public class LoginServiceImpl implements UserService{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		int result = dao.login(id, pw);

		if(result == 1) { //로그인성공
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
		}else {
			result = 0;
		}
		
		return result;
	}

}
