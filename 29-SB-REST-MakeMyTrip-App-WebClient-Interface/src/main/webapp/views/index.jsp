<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Ticket</title>
</head>
<body>

	<form action="bookTicket" method="post" >
	
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Date Of Journey:</td>
				<td><input type="text" name="doj"></td>
			</tr>
			<tr>
				<td>From:</td>
				<td><input type="text" name="from"></td>
			</tr>
			<tr>
				<td>To:</td>
				<td><input type="text" name="to"></td>
			</tr>
			<tr>
				<td>Train Number:</td>
				<td><input type="text" name="trainNum"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Book Ticket"></td>
			</tr>
		</table>
	</form>
	
	<a href="search">Search Ticket</a>
</body>
</html>