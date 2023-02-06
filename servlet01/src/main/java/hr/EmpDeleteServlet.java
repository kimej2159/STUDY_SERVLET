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
		//비지니스로직
		//화면에서 선택한 사번의 사원정보를 DB에서 삭제한다
		//String --> int
		int id = Integer.parseInt( request.getParameter("id") );
		EmployeeDAO dao = new EmployeeDAO();
		//선택한 사원정보 삭제 메소드 호출
		dao.employee_delete(id);
		
		//응답화면연결
		response.sendRedirect("emp_list");
	
	}

}
