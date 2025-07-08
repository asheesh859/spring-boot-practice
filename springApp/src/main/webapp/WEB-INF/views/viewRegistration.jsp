<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Employees Lists</h1>

	<table>
		<tr>
			<th>Name</th>
			<th>email</th>
			<th>mobile</th>
			
		</tr>


		<c:forEach var="emp" items="${employees}">
			<tr>

				<td>${emp.name}
				<td>
				<td>${emp.email}</td>

				<td>${emp.mobile}</td>
				<td>
				<a href="deleteEmpolyee?id=${emp.id}">delete</a>
			</td>
			
			<td>
				<a href="getRegisterById?id=${emp.id}">update</a>
			</td>

			</tr>

		</c:forEach>

	</table>


</body>
</html>