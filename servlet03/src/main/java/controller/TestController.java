package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.EmployeeListCommand;
import command.EmployeeinfoCommand;
import command.FirstCommand;

@WebServlet("*.do")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		uri = uri.substring(path.length());
	
		if(uri.equals("/info.do")) {// 선택한 사원정보 조회
			new EmployeeinfoCommand().execute(request, response);
			
			request.getRequestDispatcher("employee/info.jsp").forward(request, response);
		}
		
		else if(uri.equals("/emp_list.do")) {
			
			//조회테스트
			// 비지니스 로직
			new EmployeeListCommand().execute(request, response);
			
			request.getRequestDispatcher("employee/list.jsp").forward(request, response);
		
		}else if( uri.equals("/test.do")) {
			//
		
		// DB에서 데이터 연결 - 조회 메소드 호출
			new FirstCommand().execute(request,response);
			
			// 응답할 화면 연결
			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
			rd.forward(request, response);
		}
	}

	private void connect() {
		// TODO Auto-generated method stub
		
	}
}
