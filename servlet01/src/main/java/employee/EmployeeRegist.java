package employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDAO;
import hr.EmployeeDTO;

public class EmployeeRegist implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스 로직 , 커맨드라고도 하심
		// 화면에서 입력한 정보를 DB에 신규 저장
		// DB에 저장하기위해 신규사원 등록 메소드 호출
		// 화면에서 입력한 정보를 수집
		EmployeeDTO dto = new EmployeeDTO();		//transfer할 object 객체 생성
		
		dto.setLast_name( request.getParameter("last_name") );
		dto.setFirst_name( request.getParameter("first_name") );
		dto.setEmail( request.getParameter("email") );
		dto.setPhone_number( request.getParameter("phone_number") );
		dto.setSalary( Integer.parseInt( request.getParameter("salary") ) );
		dto.setJob_id( request.getParameter("job_id") );
		// 숫자를 문자로 변형하기위한 함수 : Integer.valueOf / Integer.parseInt
		dto.setDepartment_id( Integer.valueOf(request.getParameter("department_id")) );
		
		EmployeeDAO dao = new EmployeeDAO();		// 등록하는 메소드 호출!! DB 연결된 DAO 객체를 호출해놈
		dao.employee_regist(dto);
	}

}
