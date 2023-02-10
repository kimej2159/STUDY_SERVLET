<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>form태그 파라미터</h3>
<div>이름: ${param.name}</div>
<div>전화번호: ${phones[param.name]}</div>
<div>성별: ${param.gender}</div>
<div>취미: ${paramValues.sports[0]}
		  ${paramValues.sports[1]}
		  ${paramValues.sports[2]}
		  ${paramValues.sports[3]}</div>
</body>
</html>