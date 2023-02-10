package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeinfoCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt( request.getParameter("id") );
		
		//선택한 사원정보를 DB에서 조회해온다 - 해당 사원정보조회 메소드 호출
		EmployeeDTO dto = new EmployeeDAO().employee_info(id);
				
		//화면에 출력할 수 있도록 조회한 정보를 request에 attribute로 담는다
		request.setAttribute("dto", dto);
	
//		//DB에서 사원목록을 조회해온다
//		EmployeeDAO dao = new EmployeeDAO();
//		List<EmployeeDTO> info = dao.employee_info();
//		//화면에서 출력할 수 있도록 request에 attribute로 담는다
//		request.setAttribute("info", info);
	}

}
