package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hr/emp_list")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<a href='index.html'>사원관리</a>");
		out.print("<hr>");
		out.print("<h3>사원목록</h3>");
		out.print("<table border='1'>");
		out.print("<tr><th>사번</th><th>성명</th><th>부서</th><th>급여</th><th>입사일자</th></tr>");

		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.employee_list();
		for( EmployeeDTO dto : list) {
			out.printf("<tr><td>%d</td><td><a href='emp_info?id=%d'>%s</a></td><td>%d</td><td>%d</td><td>%s</td></tr>"
					, dto.getEmployee_id()
					, dto.getEmployee_id()
					, dto.getName()
					, dto.getDepartment_id()
					, dto.getSalary()
					, dto.getHire_date());
		}
		
		
//		try {
//			// 1. 드라이버로딩 : 드라이버관리자가 생긴다
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			// 2. DB연결 : 드라이버 관리자로
//			Connection conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe","hr","0000");
//			// 3.쿼리문
//			String sql = "select * from employees";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			// 4. 쿼리문 실행
//			ResultSet rs = ps.executeQuery();
//			while(rs.next() ) {
//				out.printf(
//						"<tr><td>%d</td><td>%s</td><td>%d</td><td>%d</td><td>%s</td></tr>"
//						,rs.getInt("employee_id")
//						,rs.getString("last_name") + "" + rs.getString("first_name")
//						,rs.getInt("department_id")
//						,rs.getInt("salary")
//						,rs.getDate("hire_date")
//						);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
