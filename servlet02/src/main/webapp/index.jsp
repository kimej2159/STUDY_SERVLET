<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.util.Date"%>
<%@ page import = "java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>홈</h3>
<hr>
<div><a href='sum.jsp'>합 계산하기</a></div>
<div><a href='member/join.jsp'>회원가입</a></div>
<div><a href='member/info.jsp'>회원가입정보</a></div>

<hr>
<%
Date today = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
String now = sdf.format(today);

%>
<div>날짜정보 : <%= new java.util.Date() %></div>
<div>현재: <%=now %></div>
<%@ include file="include/footer.jsp" %>
</body>
</html>