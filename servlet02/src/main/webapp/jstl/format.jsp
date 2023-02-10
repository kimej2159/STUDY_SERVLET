<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='<c:url value="/"/>'>홈으로</a>
<hr>
<h3>포맷 라이브러리</h3>
<h4>숫자</h4>
<div>2. 숫자: 천단위 표시, 지정</div>
<div>   천단위 표시, 지정: groupingUsed="true" </div>
<div>   통화기호: type='currency'</div>
<ul>
	<li>기본: <fmt:formatNumber value='123456789' groupingUsed="false" /> </li>
	<li>통화기호: <fmt:formatNumber value='123000' type='currency' /> </li>
	
</ul>

<hr>
<h4>날짜 및 시각</h4>
<div>1. 타입(날짜/시각): type='date'(기본) / type='time'</div>
<div>   날짜표현스타일: dateStyle - medium(기본), full, long, short</div>
<div>   사용자형식지정: pattern="yyyy MM dd hh mm ss"</div>
<div>   시각표현스타일: timeStyle - medium(기본), full, long, short</div>
<c:set var='today' value='<%=new java.util.Date() %>'/>
<ul>
	<li>오늘 medium: <fmt:formatDate value="${today}" type='date' dateStyle="medium"/> </li>
	<li>오늘 full: <fmt:formatDate value="${today}" type='date' dateStyle="full"/> </li>
	<li>오늘 long: <fmt:formatDate value="${today}" type='date' dateStyle="long"/> </li>
	<li>오늘 short: <fmt:formatDate value="${today}" type='date' dateStyle="short"/> </li>
	<li>오늘: <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/></li>
</ul>
<ul>
	<li>현재 시각 medium: <fmt:formatDate value="${today}" type='time' timeStyle='medium'/> </li>
	<li>현재 시각 full: <fmt:formatDate value="${today}" type='time' timeStyle='full'/> </li>
	<li>현재 시각 long: <fmt:formatDate value="${today}" type='time' timeStyle='long'/> </li>
	<li>현재 시각 short: <fmt:formatDate value="${today}" type='time' timeStyle='short'/> </li>
	<li>현재 시각: <fmt:formatDate value="${today}" type='time' pattern="hh:mm:ss"/> </li>
	<li>오늘 현재:<fmt:formatDate value="${today}" type="both" 
					pattern="yyyy년 MM월 dd일 E hh시 mm분 ss초"/> </li>
</ul>



</body>
</html>




