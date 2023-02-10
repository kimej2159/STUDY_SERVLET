package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		//DB에서 사원목록을 조회해온다
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> list = dao.employee_list();
		//화면에서 출력할 수 있도록 request에 attribute로 담는다
		request.setAttribute("list", list);
	}

}
