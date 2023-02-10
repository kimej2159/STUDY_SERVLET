<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>${fruits[0]}</div>
<div>${fruits[1]}</div>
<div>${fruits[2]}</div>
<div>${fruits[3]}</div>
<hr>
<form method='post' action='calculator_result.jsp'>
<input type='text' name='no1'>
<select name='operator'>
	<option value="+">더하기</option>
	<option value="-">빼기</option>
	<option value="*">곱하기</option>
	<option value="/">나누기</option>
</select>
<input type='text' name='no2'>
<div><input type='submit' value='계산하기'></div>

</form>
</body>
</html>