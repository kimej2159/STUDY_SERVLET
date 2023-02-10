package command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import dao.TestDAO;

public class FirstCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//비지니스 로직
		// DB에서 데이터를 조회해온다: DB연결 - 조회 메소드 연결
		TestDAO dao = new TestDAO();
		Date today = dao.select_today();
		String now = dao.select_now();
		int count = dao.select_count();
		
		//화면에서 출력할 수 있도록 request에   attribute로 담는다
		request.setAttribute("today", today);
		request.setAttribute("now", now);
		request.setAttribute("count", count);
		
	}
}
