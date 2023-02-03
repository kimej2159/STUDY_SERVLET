package hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hr/emp_info")
public class EmpinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<a href=''>홈으로</a>");
		out.print("<a href=''>사원관리</a>");
		out.print("<a href=''>사원목록</a>");
		out.print("<hr>");
		out.print("<h3>사원정보</h3>");
		out.print("<table border='1'>");
		
		// 주소창을 통해 전달된 파라미터는 request.getParameter(파라미터명)로
		// String --> int
		int id = Integer.parseInt( request.getParameter("id"));
		EmployeeDAO dao = new EmployeeDAO();
		
		// 선택한 사원의 정보를 조회해서 반환하는 메소드
		EmployeeDTO dto = dao.employee_info(id);
		
		
		out.printf("<tr><th>사번</th><th>%d</th></tr>", dto.getEmployee_id());
		out.printf("<tr><th>사원명</th><th>%s</th></tr>", dto.getName());
		out.printf("<tr><th>부서</th><th>%d</th></tr>", dto.getDepartment_id());
		out.printf("<tr><th>업무</th><th>%s</th></tr>", dto.getJob_id());
		out.printf("<tr><th>급여</th><th>%d</th></tr>", dto.getSalary());
		out.printf("<tr><th>입사일지</th><th>%s</th></tr>", dto.getHire_date());
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
