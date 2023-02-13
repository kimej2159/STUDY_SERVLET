package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class CustomerUpdateCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 변경입력한 정보로 DB에 변경저장 - 변경저장메소드 호출
		//1.화면에서 변경입력한 정보를 수집한다 -> 2.변경저장메소드 호출
		CustomerDTO dto = new CustomerDTO();
		dto.setId( Integer.parseInt( request.getParameter("id") ) );
		dto.setName( request.getParameter("name") );
		dto.setGender( request.getParameter("gender") );
		dto.setEmail( request.getParameter("email") );
		dto.setPhone( request.getParameter("phone") );
		new CustomerDAO().customer_update(dto);
	}

}
