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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		
<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>Account Number</th>
							<th>Full Name</th>
							<th>Opening Balance</th>
							<th>Current Balance</th>

						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Account Number</th>
							<th>Full Name</th>
							<th>Opening Balance</th>
							<th>Current Balance</th>
						</tr>
					</tfoot>
					<tbody>
						<%
                        List <Customer> cslist= (List <Customer>) request.getAttribute("cslist");
                        for(Customer cs: cslist){             	
                        %>
						<tr>
							<th><%=cs.getAccountNumber() %></th>
							<th><%=cs.getFullName() %></th>
							<th><%=cs.getOpeningBalance() %></th>
							<th><%=cs.getCurrentbalanace() %></th>
						</tr>
						<% } %>
						
					</tbody>
				</table>
				
			</div>
		</div>
	</div>

</body>
</html>
</body>
</html>