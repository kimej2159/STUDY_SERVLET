<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='join.jsp'>회원가입</a></div>
<hr>
<h3>회원가입정보</h3>
<%
	//request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String sports[] = request.getParameterValues("sports");
	request.setAttribute("sports", sports);
%>
<div>이름: <%=name %></div>
<div>성별: <%=gender %></div>
<div>스포츠(스크립트릿):
<%
if( sports != null ){
	for( String s : sports ){
		out.print( s + "&nbsp;&nbsp;");
	}
}
%> 
</div>

<div>스포츠(EL):
<c:forEach items="${paramValues.sports}" var="s" varStatus="state">
	${s}${state.last ? '' : ','}
</c:forEach>
</div>

<div>스포츠(EL):
<c:forEach items="${sports}" var="s" varStatus="state">
	${state.index eq 0? '':',' }${s}
</c:forEach>

<jsp:include page="../include/footer.jsp">
	<jsp:param value="202" name="no" />
</jsp:include>
</body>
</html>






