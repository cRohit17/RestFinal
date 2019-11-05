<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>get page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("ready!");
		$.ajax({
			url : '/TestRest/rest/get',
			type : 'get',
			dataType : 'json',
			contentType : "application/json",
			success : function(data) {
				console.log(data);
				data.forEach((value) => {
					const row = `
						<tr>
							<td>${value.userId}</td>
							<td>${value.userName}</td>
							<td>${value.email}</td>
							<td>${value.mobile}</td>
						</tr>
					`;
					$('#user-table').append(row);
				})
			}
		});
	});
</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/TestRest/">SpringDemo</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="add.jsp">Add
						User </a></li>
				<li class="nav-item"><a class="nav-link" href="get.jsp">List
						Users</a></li>
			</ul>
		</div>
	</nav>
	<div class="container pt-4">
		<table id="user-table" class="table table-striped table-bordered">
			<tr>
				<th>User ID</th>
				<th>Username</th>
				<th>Email</th>
				<th>Mobile</th>
			</tr>
		</table>
	</div>
</body>
</html>