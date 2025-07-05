<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Registration page....</h1>
<form action="saveReg" action="post">
Name : <input type="text"  name="name"/>
email : <input type="text" name="email"/>
mobile : <input type="text" name="mobile"/>
City : <input type="text" name="city"/>
state : <input type="text" name="state"/>
PinCode : <input type="text" name="pincode"/>
AddressLine : <input type="text" name="AddressLine"/>
<input type="submit" value="save" />

</form>
</body>
</html>