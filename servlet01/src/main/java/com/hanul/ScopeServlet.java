package com.hanul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//application
		ServletContext context = getServletContext();
		// 응답하는 화면에서 사용 할 정보를 저장하는 메소드 : setAttribute("속성명", 값)
		context.setAttribute("app", "Application Scope Data");
	
		// session
		HttpSession session = request.getSession();
		session.setAttribute("session", "Session Scope Data");
	
		//request
		request.setAttribute("request", "Request Scope Data");
		
		//응답할 화면
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>스코프 정보</h3>");
		out.printf("<div>Request: %s</div>", request.getAttribute("request"));
		out.printf("<div>Session: %s</div>", session.getAttribute("session"));
		out.printf("<div>Application: %s</div>", context.getAttribute("app"));	
		out.print("<div><a href='home.html'>홈으로</div>");
		out.print("</body>");
		out.print("</html>");
	
	}
}
