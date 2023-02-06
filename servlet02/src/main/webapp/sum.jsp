<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='./'>홈으로</a></div>
<hr>
<h3>합 계산</h3>
<%
no1 = 10;
no2 = 20;
operator = " * ";

// 1부터 10까지 합계산하기
int sum = 0;
for(int no=1; no<11; no++){
	out.print("<div>"+ no + "</div>");
	sum += no;
}
%>
<div>1~10의 합 = <%=sum%></div>
<div><%= "1~10까지의 합 = " + sum %></div>
<div><%=no1 %> <%= operator%> <%= no2 %> = <%=calculate() %></div>
<div><%= no1 + operator + no2 + " = " + calculate()%></div>

<%!
int no1, no2;
String operator;

int calculate(){
	int result = 0;
	if( operator.equals("+")){
		result = no1 + no2;
	}else if( operator.equals("-")){
		result = no1 - no2;
	}else if( operator.equals("*")){
		result = no1 * no2;
	}else {
		result = no1/no2;
	}
	return result;
}
%>

<%@ include file="include/footer.jsp" %>
</body>
</html>


