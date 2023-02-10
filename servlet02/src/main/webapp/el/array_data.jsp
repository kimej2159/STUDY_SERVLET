<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>배열값 저장 출력: 배열, 자료구조배열(ArrayList), 맵(HashMap)</h3>
<%
ArrayList<String> list = new ArrayList<String>();
list.add("사과");
list.add("배");
list.add("귤");
session.setAttribute("fruits", list);


HashMap<String, String> map 
	= new HashMap<String, String>();
map.put("홍길동", "010-1234-5678");
map.put("심청", "062-9876-5412");
map.put("박문수", "032-5236-9874");
session.setAttribute("phones", map);

RequestDispatcher rd = request.getRequestDispatcher("array_result.jsp");
rd.forward(request, response);
%>
</body>
</html>





