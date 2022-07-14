<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registered Students</title>
	</head>
	<body>
		<h1>Registered Students</h1>
		<table>
			<tr>
				<td><a href="students/addStudent">Add a new Book</a></td>
				<td><a href="/Lab6/logout">Logout</a></td>
			</tr>
			</table>
		<table border="1">
			<thead>
			<tr><th>First Name</th><th>Last Name</th><th>Course</th><th>Country</th></tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${students}" var ="student">
					<tr>
					
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.course}</td>
					<td>${student.country}</td>
					<td><a href="updateStudent?studentId=${student.id}">Update</a></td>
					<td><a href="deleteStudent?studentId=${student.id}">Delete</a></td>			
					</tr>			
				</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>