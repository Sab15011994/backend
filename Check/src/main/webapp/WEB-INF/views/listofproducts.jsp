<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="header.jsp" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped" border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody></tbody>

			<c:forEach items="${products}" var="p">
			<tr>
			   <td>${p.id}</td>
			   <td>${p.productname}</td> 
			   <td>${p.price}</td> 
			   <td>
			   <a href="<c:url value='/all/getproduct?id=${p.id}'></c:url>"><span class="glyphicon glyphicon-info-sign"></span></a>
			   <a href="<c:url value='/admin/deleteproduct?id=${p.id}'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
			   <a href="<c:url value='/admin/getupdateproductform?id=${p.id}'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
			   
			   
			   </td>

               </c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>