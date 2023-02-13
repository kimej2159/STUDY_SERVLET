package customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class CustomerDeleteCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		
		//선택한 고객정보를 DB에서 삭제-고객정보 삭제 메소드 호출
		int id = Integer.parseInt(request.getParameter("id"));
		new CustomerDAO().customer_delete(id);
		

	}

}
