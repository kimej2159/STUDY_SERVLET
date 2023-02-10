<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='<c:url value="/"/>'>홈으로</a>
<hr>
<h3>사원목록</h3>
<table border='1'>
<tr><th>사번</th>
	<th>사원명</th>
	<th>부서명</th>
	<th>업무명</th>
	<th>급여</th>
	<th>입사일자</th>
</tr>
<c:forEach items="${list}" var='dto'>
<tr><td>${dto.employee_id}</td>
	<td><a href='info.do?id=${dto.employee_id}'>${dto.name}</a></td>
	<td>${dto.department_name}</td>
	<td>${dto.job_title}</td>
	<td>
	<fmt:formatNumber value="${dto.salary}" groupingUsed="true" />
	</td>
	<td>${dto.hire_date}</td>
</tr>
</c:forEach>
</table>
</body>
</html>