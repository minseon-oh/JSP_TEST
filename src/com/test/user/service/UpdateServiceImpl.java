package com.test.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.user.model.UserDAO;
import com.test.user.model.UserVO;

public class UpdateServiceImpl implements UserService{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String name = request.getParameter("name");
		String addr_basic = request.getParameter("addr_basic");
		String addr_detail = request.getParameter("addr_detail");
		
		UserVO vo = new UserVO(id, pw, name, phone1, phone2, phone3, email1, email2, addr_basic, addr_detail);

		UserDAO dao = UserDAO.getInstance();
		dao.update(vo);
		
		return 0;
	}

}
