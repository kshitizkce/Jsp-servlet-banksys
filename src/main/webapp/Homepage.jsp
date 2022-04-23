<%@page import="com.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta charset="ISO-8859-1">
<title>Bank apppage</title>
<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
</head>
<body>
	<p>Welcome</p>
	<p style="color: green">${User}</p>
	<br>
	<hr>
	<p style="color: green">${message}:: ${customer}</p>
	<form class="Admin" action="Logoutserv" method="Get">


		<a class="dropdown-item" href="#" data-toggle="modal"
			data-target="#logoutModal"> <i
			class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i> <input
			type="submit" value="Logout" class="form-control">

		</a>
	</form>
	<hr>
	<h1>Customer Add below</h1>



	<form class="Admin" action="Customeraddserv" method="post">
		<div class="form-group">
			<label for="usr">FullName:</label> <input type="text" name="fl"
				class="form-control">
		</div>
		<br>
		<div class="form-group">
			<label for="usr">Current Balance:</label> <input type="number"
				name="cb" class="form-control">
		</div>
		<br>

		<div class="form-group">
			<label for="usr">Opening Balance:</label> <input type="number"
				name="ob" class="form-control">
		</div>
		<br>

		<div class="form-group">
			<input type="submit" value="ADD Customer" class="form-control"">
		</div>


	</form>
	<hr>
	<p style="color: green">${message3}:: ${amount}</p>

	<h1>Deposite Below</h1>
	<form class="Admin" action="Depositeserv" method="post">

		<div class="form-group">
			<label for="usr">Amount to be deposited:</label> <input type="number"
				name="am" class="form-control">
		</div>
		<br>

		<div class="form-group">
			<label for="usr">Account Number:</label> <input type="number"
				name="an" class="form-control">
		</div>
		<br>

		<div class="form-group">
			<input type="submit" value="Deposite" class="form-control"">
		</div>

	</form>
	<hr>
	<p style="color: green">${message4}:: ${amount1}</p>

	<h1>Withdraw Below</h1>
	<form class="Customer" action="Withdrawserv" method="post">

		<div class="form-group">
			<label for="usr">Amount to be Withdrawn:</label> <input type="number"
				name="am1" class="form-control">
		</div>
		<br>

		<div class="form-group">
			<label for="usr">Account Number:</label> <input type="number"
				name="an1" class="form-control">
		</div>
		<br>

		<div class="form-group">
			<input type="submit" value="Withdraw" class="form-control"">
		</div>

	</form>
	
		<form class="Customer" action="CustomerListservlet" method="get">
	

<div class="form-group">
			<input type="submit" value="View Customer Data" class="form-control"">
		</div>

	</form>
	
		
		
		