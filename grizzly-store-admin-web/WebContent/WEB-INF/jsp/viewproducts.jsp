<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table >
<tr>
	<th>Product_Id</th><th>Product_name</th><th>Product_Category</th><th>Product_Description</th><th>Product_Price</th><th>Brand</th>
</tr>	
<c:forEach items="${productList}" var="product">
<tr>
    <td><c:out value="${product.productId}"/></td>
    <td><c:out value="${product.productName}"/></td>
    <td><c:out value="${product.productCategory}"/></td>
    <td><c:out value="${product.productDescription}"/></td>
    <td><c:out value="${product.productPrice}"/></td>
    <td><c:out value="${product.brand}"/></td>
    <c:set var="id" value="${product.productId}"/>
    
    <td>
    <form method="get" action="delete.htm">
    <input type="hidden" name="productId" value="${product.productId}"/>
    <input type="submit" value="Delete"/>
    </form></td>
</tr>
</c:forEach>
</table>
<form action="productform.htm">
<input type=submit value="Add">
</form>
<form action="logoutUser.htm">
<input type=submit value="Logout">
</form>
</body>
</html>