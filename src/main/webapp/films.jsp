<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Films</title>
<link href="css/site.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<body style="margin-left:30px; margin-right:30px">
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="films">Home</a> 
      <center><h1 style="color:White;">Films MVC</h1></center> 
      <form class="d-flex" method="POST" action="./SearchController">
      		<input type="text" name="search" placeholder="Search">
		<button type="submit" class="btn btn-success" value="submit">Search</button>
      </form>
    </div>
</nav>
<br>
<h3>Insert a Film:</h3>
	<form method="POST" action="./films">
		<input type="text" name="title" placeholder="Enter Title">
		<input type="text" name="director" placeholder="Enter Director">
		<input type="text" name="year" placeholder="Enter Year">
		<input type="text" name="stars" placeholder="Enter Stars">
		<input type="text" name="review" placeholder="Enter Review">
		<button type="submit" class="btn btn-success" value="submit">Insert</button>
	</form>
<br>
	<table class="table table-bordered table-striped table-hover table-light">
		<tr class="table-primary">
			<th>ID</th>
			<th>Title</th>
			<th>Director</th>
			<th>Year</th>
			<th>Stars</th>
			<th>Review</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<f:forEach items="${films}" var="f">
			<tr>
				<td>${f.id}</td>
				<td>${f.title}</td>
				<td>${f.director}</td>
				<td>${f.year}</td>
				<td>${f.stars}</td>
				<td>${f.review}</td>
				<td><button type="submit" class="btn btn-success"><a href="./UpdateController?id=${f.id}">Edit</a></button></td>
				<td><button type="submit" class="btn btn-danger"><a href="./DeleteController?id=${f.id}">Delete</a></button></td>	
			</tr>
		</f:forEach>
	</table>
	<br>
</body>
</html>