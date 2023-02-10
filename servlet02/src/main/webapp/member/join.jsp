<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href='../'>홈으로</a></div>
<hr>
<h3>회원가입</h3>
<form method='post' action='info.jsp'>
<table  border='1'>
<tr><th>이름</th>
	<td><input type='text' name='name'></td>
</tr>
<tr><th>성별</th>
	<td><input type='radio' name='gender' value='남' checked>남
		<input type='radio' name='gender' value='여'>여
	</td>
</tr>
<tr><th>스포츠</th>
	<td><input type='checkbox' name='sports' value='야구'>야구
		<input type='checkbox' name='sports' value='축구'>축구
		<input type='checkbox' name='sports' value='탁구'>탁구
		<input type='checkbox' name='sports' value='농구'>농구
	</td>
</tr>
</table>
<input type='submit' value='회원가입하기'>
</form>
<%@ include file='../include/footer.jsp' %>
</body>
</html>