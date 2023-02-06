package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.EmployeeDTO;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<div><a href = './'>홈으로</a></div>");
		out.print("<div><a href = './front.html'>Front 패턴</a></div>");
		out.print("<hr>");
		out.print("<h3>사원목록 - select.do</h3>");
		out.print("<table border='1'>");
		out.print("<tr><th>사번</th><th>성명</th><th>부서</th><th>급여</th><th>입사일자</th><th></th></tr>");
		ArrayList<EmployeeDTO> list
		= (ArrayList<EmployeeDTO>)request.getAttribute("list"); // object타입을 자료구조 타입으로 형변환 필요함
		for( EmployeeDTO dto : list ) {
			out.printf("<tr><td>%d</td><td><a href='../emp_info?id=%d'>%s</a></td>"
					+ "<td>%d</td><td>%d</td><td>%s</td>"
					+ "<td><a onclick=\"if( confirm('정말 삭제?') ){ href='emp_delete?id=%d'} \">삭제</a></td></tr>"
					, dto.getEmployee_id()
					, dto.getEmployee_id()
					, dto.getName()
					, dto.getDepartment_id()
					, dto.getSalary()
					, dto.getHire_date()
					, dto.getEmployee_id()
					);
		}
		out.print("</body>");
		out.print("</html>");
	}

}
