<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Description file</title>
</head>
<body>
<tr>
<td><c:out value="${product.productName}"/></td>
<td><c:out value="${product.productDescription}"/></td>
<td><c:out value="${product.productCategory}"/></td>
</tr>>
</body>
</html>