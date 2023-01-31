package com.hanul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 서비스");
		//주소창을 통해 전달된 파라미터 데이터 접근 : request.getParameter("파라미터명");
		// 파라미터에 한글값이 있는 경우 한글이 깨지지 않게 인코딩을 해줘야함
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 웹페이지에서 한글이 깨지지 않도록 해줌
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h3>로그인 정보</h3>");
		writer.println("<div>아이디: " + id + " </div>");
		writer.println("<div>비밀번호: " + pw + " </div>");

		// 밑에 로그인 화면, 홈 화면의 링크를 달아줌
		writer.println("<div><a href='login_form.html'>로그인 화면</a></div>");
		writer.println("<div><a href='home.html'>홈 화면</a></div>");
		
		writer.print("</body>");
		writer.print("</html>");
	}
}







