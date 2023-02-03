package com.hanul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
//		int result;
//		switch( operator ) {
//		case "+":
//				result = no1 + no2;	break;
//		case "-":
//				result = no1 - no2; break;
//		case "*":
//				result = no1 * no2; break;
//		default:
//				result = no1 / no2; break;
//		}
//		return result;
//	}
//	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지니스로직: 화면에서 입력한 두 숫자, 연산자를 사용해 연산처리를 하여
		//String --> int 
		//Integer.valueOf: Integer, Integer.parseInt: int
		//Integer --> int : Unboxing
		int no1 = Integer.valueOf( 
				request.getParameter("no1").equals("")? "0"
				: request.getParameter("no1"));
		int no2 = Integer.parseInt( request.getParameter("no2") );
		String operator = request.getParameter("operator");
		Calculator c = new Calculator();
		int no3 = c.calculate(no1, no2, operator);		
//		int no3 = calculate(no1, no2, operator);
		
		//다른화면이 응답하도록 화면연결: 1.forward방식
		//응답할 화면에서 출력할 정보를 담아둔다
		request.setAttribute("no1", no1);
		request.setAttribute("no2", no2);
		request.setAttribute("result", no3);
		request.setAttribute("op", operator);
		
		RequestDispatcher rd 
			= request.getRequestDispatcher("calculator_forward");
		rd.forward(request, response);
		
		
		
		/*
		//프리젠테이션로직: 그 결과를 화면으로 응답		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>계산결과</h3>");
		//out.print(no1 + " " + operator +" " + no2 +" = " + " 50");
		out.printf("%d %s %d = %d", no1, operator, no2, no3);
		out.print("<div><a href='calculator.html'>계산기</a></div>");
		out.print("</body>");
		out.print("</html>");
		*/
	}

}
