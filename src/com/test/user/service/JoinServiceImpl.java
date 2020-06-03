package com.test.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.user.model.UserDAO;
import com.test.user.model.UserVO;

public class JoinServiceImpl implements UserService{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String addr_basic = request.getParameter("addr_basic");
		String addr_detail = request.getParameter("addr_detail");
		
		UserDAO dao = UserDAO.getInstance();
		
		int result = dao.checkId(id);
		
		if(result == 1) { //아이디 중복
			return 1;
		}else { //중복없음
			UserVO vo = new UserVO(id, pw, name, phone1, phone2, phone3, email1, email2, addr_basic, addr_detail);
			dao.insert(vo);
			return 0;
		}

	}

}
