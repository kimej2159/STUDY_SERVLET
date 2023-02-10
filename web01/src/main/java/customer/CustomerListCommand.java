package customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class CustomerListCommand implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//DB에서 고객목록을 조회해온다
		CustomerDAO dao = new CustomerDAO();
		List<CustomerDTO> customers = dao.customer_list();
		
		//화면에서 출력할 수 있도록 조회한 정보를 담는다
		request.setAttribute("list", customers);
	}

}
