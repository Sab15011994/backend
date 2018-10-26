<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<c:url value='/admin/addproduct' var="url"></c:url>
<form:form action="${url}" method="post" modelAttribute="product">
	<table>
	<tr>
	<td>Enter Product Name</td>
	<td><form:input  path="productname"/>
	<form:errors path="productname" cssStyle="color:red"></form:errors>
	</td>
	</tr>
	<tr>
	<td>Enter Product Description</td>
	<td><form:textarea path="productdesc"/>
	<form:errors path="productdesc" cssStyle="color:red"></form:errors>
	</td>
	</tr>
	<tr><td>Enter Product Price</td>
	<td><form:input path="price"/>
	<form:errors path="price" cssStyle="color:red"></form:errors>
	</td>
	</tr>
	<tr>
	<td>Enter Product Quantity</td>
	<td><form:input path="quantity"/>
	<form:errors path="quantity" cssStyle="color:red"></form:errors>
	</td>
	</tr>
	
	<tr>
	<td>Select Category</td>
	<td><form:select path="category.id">
	<form:option value="1">Furniture</form:option>
	<form:option value="2">Educational Books</form:option>
	<form:option value="3">Electronic Items</form:option>
	<form:option value="4">Clothes</form:option>
	<form:option value="5">Others</form:option>
	</form:select></td>
	</tr>
	<tr><td>
	<input type="submit" value="Add Product"></td>
	<td></td>
	</tr>
		
	</table>
</form:form>
</div>
</body>
</html>