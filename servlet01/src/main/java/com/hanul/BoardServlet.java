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

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//비지니스 로직: 화면에서 입력한 공지글 정보를 가져와 
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//프리젠테이션 로직 : 화면으로 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>공지글 안내</h3>");
		out.printf("<div>작성자: %s</div>", name);
		out.printf("<div>제목: %s</div>", title);
		out.printf("<div>내용: %s</div>", content);
		
		//세션 주소는 request의 메소드로 찾는다
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		out.printf("<div>Request: %s</div>", request.getAttribute("request"));
		out.printf("<div>Session: %s</div>", session.getAttribute("session"));
		out.printf("<div>Application: %s</div>", context.getAttribute("app"));	
		out.printf("<div><a href='home.html'>홈으로</div>");
		out.printf("<div><a href='board/new.html'>공지글쓰기</div>");
		out.print("</body>");
		out.print("</html>");
	}

}
