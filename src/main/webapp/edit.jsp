<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<head><title>Film Manager</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
      href="./css/styles.css"
      type="text/css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<br>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="films">Home</a> 
    </div>
</nav>
<br>
<body style="margin-left:30px; margin-right:30px">
<div class="col-md-8 m-auto block" id="main_content">
      <center><h2>Edit Film:</h2></center> 
<fieldset>
<form method="POST" action="./UpdateController">
      <div class="form-group form-group-position">
		<input type="hidden" name="id"  value="${film.id}"> 
		</div>
		      <div class="form-group form-group-position">
		<input type="text" name="title" class="form-control" placeholder="Enter Title" value="${film.title}">
		      </div>
		      <div class="form-group form-group-position">
		<input type="text" name="year" class="form-control" placeholder="Enter Title" value="${film.year}">
		</div>
		      <div class="form-group form-group-position">
		<input type="text" name="director" class="form-control" placeholder="Enter Title" value="${film.director}">
		</div>
		      <div class="form-group form-group-position">
		<input type="text" name="stars" class="form-control" placeholder="Enter Title" value="${film.stars}">
		</div>
		      <div class="form-group form-group-position">
		<input type="text" name="review" class="form-control" placeholder="Enter Title" value="${film.review}">      
		</div><br>
		<button type="submit" class="btn btn-success" value="submit">Update</button>
	</form>
</fieldset>
</div>

<script src="./scripts/ajax-utils.js"
        type="text/javascript"></script>
<script src="./scripts/ajax-data.js"
        type="text/javascript"></script>
</body>
</html>