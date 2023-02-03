package hr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hr/emp_delete")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비지니스 로직
		// 화면에서 선택한 사번의 사원정보를 DB에서 삭제한다
		EmployeeDTO dto = new EmployeeDTO();
		int id = Integer.parseInt( request.getParameter("id"));
		
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.employee_delete(id);
		
		// 응답 화면 연결
		response.sendRedirect("emp_list");
	
	}

}
