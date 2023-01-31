package com.hanul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Calculator;

// 클래스 import 선언문 : ctrl + shift + o
// 코드라인 복사,붙여넣기 : ctrl + alt + 방향키
// 코드라인 이동 : alt + 방향키
// 불필요한 코드라인 삭제 : ctrl + d


@WebServlet({"/HelloServlet", "/first"})		// 지정된 주소 이름으로 응답 페이지 받기
//	@WebServlet({"*.do"})		// 끝에 글자만 해당되면 원하는 응답 페이지 받
//	@WebServlet({"/*"})			// 어떤 주소라도 해당 페이지를 보여줌





public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Calculator c = new Calculator();
		int result = c.calculate(10, 20, "+");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<body>");
		writer.print("<h3> Hello Servlet </h3>");
		writer.print("<div>여기는 hello</div>");
		writer.print("연산결과 : " +  result);
		writer.print("</body>");
		writer.print("</html>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
