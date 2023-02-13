package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class CustomerInsertCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		// 신규입력 고객정보를 DB에 삽입저장처리
		//화면에서 입력한 정보를 수집 -> 신규고객저장메소드 호출
		CustomerDTO dto = new CustomerDTO();
		dto.setName(request.getParameter("name"));
		dto.setGender( request.getParameter("gender") );
		dto.setEmail( request.getParameter("email") );
		dto.setPhone( request.getParameter("phone") );
		new CustomerDAO().customer_insert(dto);
	}

}
