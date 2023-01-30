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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h3>로그인 정보</h3>");
		writer.print("<div>아이디: " + id + " </div>");
		writer.print("<div>비밀번호: " + pw + " </div>");

		writer.print("</body>");
		writer.print("</html>");
	}
}







