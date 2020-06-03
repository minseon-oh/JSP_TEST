package com.test.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.user.model.UserDAO;

public class DeleteServiceImpl implements UserService{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		System.out.println(id);
		System.out.println(pw);
		int result = dao.login(id, pw);
		System.out.println(result);
		if(result == 1) {
			dao.delete(id);
		}else {
			result = 0;
		}
		
		return result;
	}

}
