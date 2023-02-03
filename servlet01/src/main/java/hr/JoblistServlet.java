package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		out.print("<a href='home.html'>홈으로</a>");
		out.print("<a href='index.html'>사원관리</a>");
		out.print("<hr>");
		out.print("<h3>업무목록</h3>");
		out.print("<table border='1'>");
		
		
		
		JoblistDAO dao = new JoblistDAO();
		ArrayList<JoblistDTO> list = dao.Joblist();
		
		
		// 선택한 사원의 정보를 조회해서 반환하는 메소드
		//JoblistDTO dto = dao.Joblist(job_id);
		
		for( JoblistDTO dto : list) {
			out.printf("<tr><td>%s</td><td>%d</td></tr>" 
					, dto.getJob_id()
					, dto.getJob_title());
		}
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
