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
<a href='<c:url value="/"/>'>홈으로</a>
<a href='<c:url value="/member/info.jsp?name=나그네&gender=남"/>   '>회원가입결과</a>

<hr>
<h3>합 계산</h3>

<%
no1 = 10;
no2 = 20;
operator = "*";

// 1부터 10까지 합계산하기
int sum = 0;
for(int no=1; no<=10; no++){
 	out.print("<div>"+ no +"</div>");
	sum += no;
}
%>
<div>1~10의 합: <%=sum %> </div>
<div><%="1~10까지의 합 = " + sum %></div>
<div><%=no1 %> <%=operator %> <%=no2 %> = <%=calculate() %></div>
<div><%= no1 + operator + no2 + " = " + calculate() %></div>

<%!
int no1, no2;
String operator;

int calculate(){
	int result = 0;
	if( operator.equals("+") ){
		result = no1 + no2;
	}else if( operator.equals("-") ){
		result = no1 - no2;
	}else if( operator.equals("*") ){
		result = no1 * no2;
	}else{
		result = no1 / no2;
	}
	return result;
}

%>
<%@ include file="include/footer.jsp" %>
</body>
</html>





