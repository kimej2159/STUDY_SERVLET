package com.hanul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator_forward")
public class CalculatorForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//프리젠테이션로직: 그 결과를 화면으로 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>계산결과-Forward방식</h3>");
		
		out.printf("%d %s %d = %d"
					, request.getAttribute("no1")
					, request.getAttribute("op")
					, request.getAttribute("no2")
					, request.getAttribute("result"));
		out.print("</body>");
		out.print("</html>");
	
	}

}
