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
<a href='<c:url value="emp_list.do"/>'>사원목록</a>
<hr>
<h3>100번 사원 조회</h3>
<table border='1' style='width:600px'>
<tr><th style='width:140px'>사번</th>
	<th>사원명</th>
	<th>부서명</th>
	<th>업무명</th>
	<th>급여</th>
	<th>입사일자</th>
</tr>

<tr><td>${dto.employee_id}</td>
	<td>${dto.name}</td>
	<td>${dto.department_name}</td>
	<td>${dto.job_title}</td>
	<td>
	<fmt:formatNumber value="${dto.salary}" groupingUsed="true" />
	</td>
	<td>${dto.hire_date}</td>
</tr>

</table>

</body>
</html>