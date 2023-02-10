<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='index.jsp'>EL홈</a>
<hr>
<h3>계산결과-EL논리연산</h3>
<div>no1: 값이 ${empty param.no1 ? '없다' : '있다'} </div>
<div>no2: 값이 ${not empty param.no2 ? '있다' : '없다'} </div>
<div>no1 과 no2 값이 ${param.no1>10 and param.no2 gt 10 
					? '둘 다 10보다 크다' : '둘 다 10보다 크지는 않다'}</div>
<div>no1 과 no2 값이 ${param.no1>10 or param.no2 gt 10
					? '둘 중 하나는 10보다 크다': '둘 다 10보다 크지 않다' }
</div> 

<hr>
<h3>계산결과-EL비교연산</h3>
<div>${param.no1} 과 ${param.no2} 중 큰 수는 
		${param.no1 gt (param.no2-0) ? param.no1 : param.no2 }
		${(param.no1-0) gt param.no2 ? param.no1 : param.no2 }
		${ param.no1-param.no2>0 ? param.no1 : param.no2 }
		</div>
<hr>
<h3>계산결과-EL산술연산</h3>
<div>덧셈: ${param.no1} + ${param.no2} = ${param.no1 + param.no2}</div>
<div>뺄셈: ${param.no1} - ${param.no2} = ${param.no1 - param.no2}</div>
<div>곱셈: ${param.no1} * ${param.no2} = ${param.no1 * param.no2}</div>
<div>나눗셈: ${param.no1} / ${param.no2} = 
			${param.no2==0 ? 0 : param.no1 div param.no2}</div>
<div>나머지: ${param.no1} / ${param.no2}의 나머지 = 
			${param.no2==0 ? param.no1 : param.no1 mod param.no2}</div>

</body>
</html>




