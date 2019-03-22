<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<springform:form modelAttribute="vendor" method="post" action="viewVendorProduct.htm">
<table>
<tr>
	<th></th><th>Product List</th><th>ID</th><th>Brand</th><th>Category</th><th>Product_ID</th><th>Quantity</th>
</tr>
	<c:forEach items="${productList}" var="product">
<tr>
<td><c:out value="${product.productId}"/></td>
    <td><c:out value="${product.productName}"/></td>
    <td><c:out value="${product.productCategory}"/></td>
    
    <td><input type="text" name="Product_Id" align="top" placeholder="Product_Id" class="form">></td>
	<td><input type="text" name="Quantity" align="top" placeholder="Quantity" class="form" ></td>



</tr>
</c:forEach>
</table>
</springform:form>
<table>
<tr>
<td>
	<form action="addQuantity.htm">
	<input type="submit" value="Add Product"><br></td>
	</form>
</td>
<td>	
	<form action="logoutUser.htm">
<input type=submit value="Logout">
</td>
</form>
</tr>
</table>

</body>
</html>