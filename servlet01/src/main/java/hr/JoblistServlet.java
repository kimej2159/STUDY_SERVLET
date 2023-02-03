package hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hr/joblist")
public class JoblistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<a href=''>홈으로</a>");
		out.print("<a href=''>사원관리</a>");
		out.print("<a href=''>업무목록</a>");
		out.print("<hr>");
		out.print("<h3>업무목록</h3>");
		out.print("<table border='1'>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
