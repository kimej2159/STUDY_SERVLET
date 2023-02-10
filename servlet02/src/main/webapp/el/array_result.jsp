<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>배열값 출력</h3>
<h4>전화번호목록</h4>
<div>홍길동: ${phones['홍길동']}</div>
<div>심청: ${phones["심청"]}</div>
<div>박문수: ${phones['박문수']}</div>

<hr>
<h4>과일목록</h4>
<div>${fruits[0]}</div>
<div>${fruits[1]}</div>
<div>${fruits[2]}</div>
<div>${fruits[3]}</div>
</body>
</html>