package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// 어떤 처리를  실행한다 
	void execute(HttpServletRequest request, HttpServletResponse response);;
	

}
