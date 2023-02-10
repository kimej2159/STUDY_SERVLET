<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>데이터저장 및 출력</h3>
<%
	pageContext.setAttribute("pageValue", 100);
	request.setAttribute("requestValue", 200);
	session.setAttribute("sessionValue", 300);
	
	pageContext.setAttribute("value", 100);
	request.setAttribute("value", 200);
// 	session.setAttribute("value", 300);
// 	session.removeAttribute("value"); //attribute 삭제: removeAttribute("속성명")
%>
<div>page값: <%= pageContext.getAttribute("pageValue") %>, ${pageValue}</div>
<div>request값: <%= request.getAttribute("requestValue") %>, ${requestValue}</div>
<div>session값: <%= session.getAttribute("sessionValue") %>, ${sessionValue}</div>
<hr>
<div>값: ${value}</div>
<div>값: ${requestScope.value}</div> <!-- 특정scope의 속성 출력시 scope를 명시 -->
<!-- 
scope 를 명시하지 않으면 
좁은 scope 에서 부터 넓은 scope 로 범위를 넓혀가며 해당 속성명을 찾는다
page -> request -> session -> application
-->
<%
	RequestDispatcher rd = request.getRequestDispatcher("scope_result.jsp");
	rd.forward(request, response);
%>
</body>
</html>