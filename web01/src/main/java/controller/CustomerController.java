package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerListCommand;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String app = request.getContextPath();
		uri = uri.substring( app.length() );
		
		String view = ""; //응답할 화면명
		if( uri.equals("/info.cu") ) { //선택한 고객정보 화면 요청
			
			view = "customer/info.jsp";
		}else if( uri.equals("/list.cu") ) { //고객목록 화면 요청
			//비지니스로직
			new CustomerListCommand().exec(request, response);
			
			//응답화면
			view = "customer/list.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	
	}

}
