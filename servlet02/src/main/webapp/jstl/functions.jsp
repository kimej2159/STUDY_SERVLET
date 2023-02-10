<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='<c:url value="/"/>'>홈으로</a>
<hr>
<h3>함수 라이브러리</h3>

<c:set var="title" value="  함수 라이브러리 FUNCTIONS" />
<h4>[${title}]</h4>
<div>1. 문자열의 길이를 반환하는 함수: length</div>
<div>2. 문자열의 일부를 반환하는 함수: substring</div>
<div>3. 공백을 제거한 결과를 반환하는 함수: trim</div>
<ul>
	<li>문자열 길이: ${fn: length(title) }</li>
	<li>문자열 일부: ${fn: substring(title,5,10) }</li>
	<li>공백제거하기: [${fn: trim(title) }]</li>
</ul>

<c:set var='email' value='hong2023@naver.com'/>
<h4>${email}</h4>
<div>4. 문자열에서 특정문자열의 위치를 반환하는 함수: indexOf</div>
<div>5. 문자열에서 특정문자열을 다른문자열로 바꿔서 반환하는 함수: replace</div>
<div>6. 영문자의 대/소문자화: toUpperCase/toLowerCase</div>
<ul>
	<li>특정문자열의 위치: ${fn: indexOf(email, '@') } </li>
	<li>이메일아이디: ${fn: substring(email, 0, fn: indexOf(email, '@')) }</li>
	<li>문자열 변경(com->co.kr): ${fn: replace(email, 'com', 'co.kr') }</li>
	<li>문자열 변경(o->e): ${fn: replace(email, 'o', 'e') }</li>
	<li>대문자화: ${fn: toUpperCase(email) }</li>
	<li>소문자화: ${fn: toLowerCase(title) }</li>
</ul>

<c:set var='subject' value='java,jsp/css?jquery'/>
<h4>존재유무</h4>
<div>7. 문자열에서 특정문자열이 포함되어 있는지의 여부를 true/false로 반환하는 함수: contains</div>
<ul>
	<li>${fn: contains(subject, 'jsp') }</li>
	<li><c:if test='${fn: contains(subject, "jsp") }'>jsp 과목 있음</c:if></li>
	<li><c:if test='${not fn: contains(subject, "oracle")}'>oracle 과목 없음</c:if></li>
</ul>
<%
String fruits[] = { "귤", "배", "감" };
%>
<c:set var='fruits' value='<%=fruits%>'/>
<h4>문자연결 또는 분리</h4>
<div>8. 배열의 문자를 특정 연결자로 연결해서 하나의 문자열을 반환하는 함수: join</div>
<div>9. 문자열에서 특정 구분자로 분리한 문자를 반환하는 함수: split</div>
<ul>
	<li>문자연결: ${fn: join(fruits, ' + ') }</li>
	<li><c:forEach items="${fn: split(subject, '?,/')}" var='subject' varStatus='state'>
	${subject}${state.last ? '' : ', &nbsp;&nbsp;&nbsp;' }
	</c:forEach>
	</li>
</ul>















</body>
</html>