<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>스코프 데이터</h3>
<div>page값: <%= pageContext.getAttribute("pageValue") %>, ${pageValue}</div>
<div>request값: <%= request.getAttribute("requestValue") %>, ${requestValue}</div>
<div>session값: <%= session.getAttribute("sessionValue") %>, ${sessionValue}</div>

</body>
</html>