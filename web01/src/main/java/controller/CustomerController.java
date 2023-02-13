package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDeleteCommand;
import customer.CustomerInfoCommand;
import customer.CustomerInsertCommand;
import customer.CustomerListCommand;
import customer.CustomerUpdateCommand;

@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String app = request.getContextPath();
		uri = uri.substring( app.length() );
		
		String view = ""; //응답할 화면명
		boolean redirect = false;
		if(uri.equals("/insert.cu")) {//신규고객 등록 처리 요청
			new CustomerInsertCommand().exec(request, response);
			view = "list.cu";
			
		}else if(uri.equals("/new.cu")) {//신규고객 등록 화면 요청
			
			view = "customer/new.jsp";
			
		}else if( uri.equals("/delete.cu") ) { //고객정보 삭제 요청
			new CustomerDeleteCommand().exec(request, response);
			
			redirect = true;
			view = "list.cu";
					
		}else if( uri.equals("/update.cu") ) { //고객정보 변경저장처리 요청
			new CustomerUpdateCommand().exec(request, response);
			
			redirect = true;
			view = "info.cu?id=" + request.getParameter("id");	
			
		}else if( uri.equals("/modify.cu") ) { //선택한 고객정보 수정화면 요청
			new CustomerInfoCommand().exec(request, response);
			
			view = "customer/modify.jsp";
			
		}else if( uri.equals("/info.cu") ) { //선택한 고객정보 화면 요청
			new CustomerInfoCommand().exec(request, response);
			
			view = "customer/info.jsp";
			
		}else if( uri.equals("/list.cu") ) { //고객목록 화면 요청
			//비지니스로직
			new CustomerListCommand().exec(request, response);
			
			//응답화면
			view = "customer/list.jsp";
		}
		
		if( redirect )
			response.sendRedirect(view);
		else
			request.getRequestDispatcher(view).forward(request, response);
	
	}

}
