<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<b>Product Name</b>:  ${productAttr.productname }	<br>
<b>Product Description</b>:  ${productAttr.productdesc }	<br>
<b>Product Price</b>:  ${productAttr.price }	<br>
<b>In Stock</b>:  ${productAttr.quantity }	<br>
<button class="btn btn-lg btn-info">Add to Cart</button>
<a href="<c:url value='/all/getallproducts'></c:url>"> Back to previous page</a>
</div>
</body>
</html>