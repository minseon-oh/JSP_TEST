package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.board.service.BoardService;
import com.test.board.service.ContentServiceImpl;
import com.test.board.service.DeleteServiceImpl;
import com.test.board.service.ListServiceImpl;
import com.test.board.service.ModifyServiceImpl;
import com.test.board.service.WriteServiceImpl;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardController() {
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
		
		BoardService service = null;
		int result = 0;
		
		if(command.equals("/bbs.board")) {
			
			service = new ListServiceImpl();
			service.execute(request, response);
			request.getRequestDispatcher("bbs.jsp").forward(request, response);
		
		}else if(command.equals("/write.board")) {
		
			request.getRequestDispatcher("bbs_write.jsp").forward(request, response);
		
		}else if(command.equals("/writeForm.board")) {
			
			service = new WriteServiceImpl();
			service.execute(request, response);
			response.sendRedirect("bbs.board");
		
		}else if(command.equals("/content.board")) {
		
			service = new ContentServiceImpl();
			service.execute(request, response);
			request.getRequestDispatcher("bbs_content.jsp").forward(request, response);
		
		}else if(command.equals("/modify.board")) {
			
			service = new ContentServiceImpl();
			service.execute(request, response);
			request.getRequestDispatcher("bbs_modify.jsp").forward(request, response);
			
		}else if(command.equals("/modifyForm.board")) {
			
			service = new ModifyServiceImpl();
			service.execute(request, response);
			response.sendRedirect("bbs.board");
			
		}else if(command.equals("/delete.board")) {
			
			service = new DeleteServiceImpl();
			service.execute(request, response);
			response.sendRedirect("bbs.board");
			
		}
	}
	
	

}
