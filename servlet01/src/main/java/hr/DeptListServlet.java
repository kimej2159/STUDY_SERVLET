package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hr/dept_list")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<a href='../'>홈으로</a>");
		out.print("<a href='index.html'>사원관리</a>");
		out.print("<hr>");
		out.print("<h3>부서목록</h3>");
		out.print("<table border='1'>");
		out.print("<tr><th>부서코드</th><th>부서명</th></tr>");
		
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<DepartmentDTO> list = dao.department_list();
		for(DepartmentDTO dto : list) {
			out.printf("<tr><td>%d</td><td>%s</td></tr>"
					, dto.getDepartment_id()
					, dto.getDepartment_name());
		}
	
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	
	}
	
}
