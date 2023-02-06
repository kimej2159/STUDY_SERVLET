package employee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDAO;
import hr.EmployeeDTO;

public class EmployeeList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스 로직 
		// : DB에서 사원 목록을 조회해 온다
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.employee_list();
		
		// 응답할 화면에 출력할 수 있도록 담는 처리 필요 : attribute를 request에 담는다 
		request.setAttribute("list", list);
		
	}



}


