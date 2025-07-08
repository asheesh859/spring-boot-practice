<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration page....</h1>
	<form action="updateEmployeeDeteilsById" action="post">
	
	     <input type="hidden" name="id" value="${employees.id}"/>
		Name : <input type="text" name="name" value="${employees.name}"/>
		 email : <input type="text"	name="email" value="${employees.email} " /> 
		 mobile : <input type="text" name="mobile" value="${employees.mobile }"/>
		 <input	type="submit" value="update" />

	</form>
</body>
</html>