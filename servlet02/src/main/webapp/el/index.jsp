<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='../'>홈으로</a>
<hr>
<h3>EL 사용법</h3>
<div><a href='scope_data.jsp'>데이터 저장 및 출력</a></div>
<div><a href='form_data.jsp'>파라미터 출력</a></div>
<div><a href='calculator.jsp'>계산기(산술연산)</a></div>
<div><a href='array_data.jsp'>배열값 출력</a></div>

<hr>
<div>page값: <%= pageContext.getAttribute("pageValue") %>, ${pageValue}</div>
<div>request값: <%= request.getAttribute("requestValue") %>, ${requestValue}</div>
<div>session값: <%= session.getAttribute("sessionValue") %>, ${sessionValue}</div>

</body>
</html>