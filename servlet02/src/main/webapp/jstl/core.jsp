<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import='java.util.*'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='<c:url value="/"/>'>홈으로</a>
<a href='index.jsp'>JSTL 홈</a>
<hr>
<h3>코어 라이브러리 실습</h3>
<h4>화면연결</h4>
<a href='../member/info.jsp?name=웅디라디&gender=여'>회원가입결과</a>
<hr>
<h4>3.반복문 - 향상된for문</h4>
<%
String values = "자바,오라클|HTML?변수";
StringTokenizer token = new StringTokenizer("?,|");
while( token.hasMoreTokens() ){
	String val = token.nextToken();	
}
request.setAttribute("values", values);

String subjects[] = { "자바", "오라클", "HTML", "jQuery", "안드로이드" };
request.setAttribute("subjects", subjects);

ArrayList<Integer> scores = new ArrayList<Integer>();
scores.add(84);
scores.add(67);
scores.add(91);
scores.add(92);
scores.add(74);
request.setAttribute("scores", scores);

HashMap<String, Integer> map = new HashMap<String, Integer>();
map.put("자바", 84);
map.put("오라클", 67);
map.put("HTML", 91);
map.put("jQuery", 92);
map.put("안드로이드", 74);
request.setAttribute("subject_score", map);
%>
<div>토큰분리:
<c:forTokens items="${values}" delims="?,|" var="val">
	${val}
</c:forTokens>
</div>
<hr>
<div>과목별 성적:
	<c:forEach items='${subject_score}' var='subject'>
	<div>${subject.key} : ${subject.value}</div>
	</c:forEach>
</div>
<div>성적: 
	<c:forEach items="${scores}" var='s' varStatus="state">
		${s} ${state.last ? '' : ',' } 		
	</c:forEach>
</div>
<div>과목명: 
	<c:forEach items='${subjects}' var='s' varStatus='state'>
		${state.index eq 0 ? '' : ','} ${s}
<%-- 		${!state.first ? ',' : ''} ${s} --%>
	</c:forEach>
</div>
<h4>3.반복문 - 기본for문</h4>
<div>1~10까지 출력

<c:forEach var="no" begin="1" end="10">
	${no}
	<c:set var='sum' value='${sum+no }'/>
</c:forEach>
</div>
<div>1~10까지의 합: ${sum}</div>

<hr>
<h4>2.조건문 - choose문</h4>
<c:set var='score' value='54'/>
<c:choose>
	<c:when test='${score-90 >= 0}'><c:set var='grade' value='A'/></c:when>
	<c:when test='${score-80 >= 0}'><c:set var='grade' value='B'/></c:when>
	<c:when test='${score-70 >= 0}'><c:set var='grade' value='C'/></c:when>
	<c:when test='${score-60 >= 0}'><c:set var='grade' value='D'/></c:when>
	<c:otherwise><c:set var='grade' value='F'/></c:otherwise>
</c:choose>
<div>성적: ${score} ${grade}학점</div>
<h4>2.조건문 - if문</h4>
<c:set var='no1' value='1500'/>
<c:set var='no2' value='300'/>
<div>
${no1} 과 ${no2} 중 큰 수는 
	<c:if test='${no1 gt (no2-0)}'>
	${no1}
	</c:if>
	<c:if test='${(no1-0) lt no2}'>
	${no2}
	</c:if>
</div>
<hr>
<h4>1.변수선언</h4>
<c:set var="name" value="홍길동"/>
<div>선언한 변수값 이름: ${name}</div>
<c:remove var="name" />
<div>삭제후 변수값 이름: ${name}</div>
</body>
</html>









