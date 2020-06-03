package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.user.service.DeleteServiceImpl;
import com.test.user.service.JoinServiceImpl;
import com.test.user.service.LoginServiceImpl;
import com.test.user.service.MypageInfoServiceImpl;
import com.test.user.service.UpdateServiceImpl;
import com.test.user.service.UserService;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());
		
		System.out.println(command);
		
		UserService service = null;
		int result = 0;
		
		if(command.equals("/join.user")) {
			
			request.getRequestDispatcher("user_join.jsp").forward(request, response);
		
		}else if(command.equals("/joinForm.user")) {
			
			service = new JoinServiceImpl();
			result = service.execute(request, response);
			
			if(result == 1) {
				out.println("<script>");
				out.println("alert('이미 존재하는 회원입니다')");
				out.println("location.href='join.user'");
				out.println("</script>");
			}else {
				response.sendRedirect("login.user");
			}
		
		}else if(command.equals("/login.user")) {
		
			request.getRequestDispatcher("user_login.jsp").forward(request, response);			
		
		}else if(command.equals("/loginForm.user")) {
			
			service = new LoginServiceImpl();
			result = service.execute(request, response);
			
			if(result == 1) {
				request.getRequestDispatcher("mypage.user").forward(request, response);			
			}else {
				out.println("<script>");
				out.println("alert('아이디와 비밀번호를 확인하세요')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
			
		}else if(command.equals("/mypage.user")) {
		
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);			
		
		}else if(command.equals("/mypageinfo.user")) {
			
			service = new MypageInfoServiceImpl();
			service.execute(request, response);
			
			request.getRequestDispatcher("user_mypageinfo.jsp").forward(request, response);			
		
		}else if(command.equals("/infoForm.user")) {
			
			service = new UpdateServiceImpl();
			service.execute(request, response);
			
			response.sendRedirect("mypage.user");
		
		}else if(command.equals("/delete.user")) {
			
			service = new DeleteServiceImpl();
			result = service.execute(request, response);
			
			if(result == 1) {
				response.sendRedirect("login.user");
			}else {
				out.println("<script>");
				out.println("alert('아이디와 비밀번호를 확인하세요')");
				out.println("history.go(-1)");
				out.println("</script>");
			}

		}else if(command.equals("/logout.user")) {
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.user");
		
		}
	}

}
