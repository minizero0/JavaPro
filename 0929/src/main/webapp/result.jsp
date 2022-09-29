<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이동되었습니다.
	<hr>
	<% 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String bloodType = request.getParameter("bloodType");
		String arr[]  = request.getParameterValues("hobby");
	%>
	아이디 : <%= id %>
	비밀번호 : <%= pw %>
	혈액형 : <%= bloodType %>
	취미 : <%= %>
</body>
</html>