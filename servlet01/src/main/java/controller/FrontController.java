package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.EmployeeList;
import employee.EmployeeRegist;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // web/select.do
		String context = request.getContextPath(); // web
		uri = uri.substring( context.length());	 // 반환되는 데이터 : /select.do
	
		String business = "";
		String view = "";
		if( uri.equals("/select.do") ) {
			business = "조회 요청에 대한 비지니스 로직";
			EmployeeList command = new EmployeeList();
			command.execute(request, response);
			
			view = "조회 요청에 대한 응답 화면";
			RequestDispatcher rd = request.getRequestDispatcher("select");
			rd.forward(request, response);
			
		}else if( uri.equals("/insert.do") ) {
			business = "등록 요청에 대한 비지니스 로직";
			EmployeeRegist command = new EmployeeRegist();
			command.execute(request, response);
			
			view = "등록 요청에 대한 응답 화면";
//			화면 응답 방식 
//			1. 포워드 : 주소는 그대로 다른애가 응답
//			2. 리다이렉트 : 주소가 옮겨감
			response.sendRedirect("select.do");
			
		}else if( uri.equals("/update.do") ) {
			business = "변경 요청에 대한 비지니스 로직";
			view = "변경 요청에 대한 응답 화면";
			
		}else if( uri.equals("/delete.do") ) {
			business = "삭제 요청에 대한 비지니스 로직";
			view = "삭제 요청에 대한 응답 화면";
			
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.printf("<div>%s</div>", business);
		out.printf("<div>%s</div>", view);
		out.printf("<div><a href='front.html'>Front 패턴</a></div>", view);
		out.print("</body>");
		out.print("</html>");
	
	}
}
