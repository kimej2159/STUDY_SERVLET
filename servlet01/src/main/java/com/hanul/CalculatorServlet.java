package com.hanul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Calculator;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
//	int calculate(int no1, int no2, String operator) {
//		int result = 0;
//		switch(operator) {
//		case	"+" :
//				result = no1+no2; break;
//		case	"-" :
//				result = no1-no2; break;
//		case	"*" :
//				result = no1*no2; break;
//		case	"/" :
//				result = no1/no2; break;
//		}
//		return result;
//	}
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비지니스 로직 : 	화면에서 입력한 두 숫자, 연산자를 사용해 연산처리를 하여
		// 프리젠테이션 로직 :  그 결과를 화면으로 응답
		// String --> int 
		// Integer.valueOf : Integer 형으로 반환
		// Integer.parseInt : int 형으로 반환
		// Integer --> int : Unboxing
		
		int no1 = Integer.valueOf(request.getParameter("no1"));
		int no2 = Integer.parseInt(request.getParameter("no2"));
		String operator = request.getParameter("operator");
		Calculator c = new Calculator();
		
		
		int no3 = c.calculate(no1, no2, operator);		// 어디서든 사용할 수 있는 메소드
//		int no3 = calculate(no1, no2, operator);		// servlet에 선언된 로컬 메소드 
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>계산결과</h3>");
		out.printf("%d %s %d=%d", no1, operator, no2, no3);
		out.print("<div><a href='calculator.html'>계산기</a></div>");
		out.print("</body>");
		out.print("</html>");
		
	}
}









