package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class CustomerInfoCommand implements Command  {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//선택한 고객의 정보를 DB에서 조회해온다 - 고객정보조회메소드 호출
		int id = Integer.parseInt( request.getParameter("id") );
		CustomerDTO dto = new CustomerDAO().customer_info(id);
		
		//화면에 출력할 수 있도록 request에 attribute로 담는다
		request.setAttribute("dto", dto);
	}

}
