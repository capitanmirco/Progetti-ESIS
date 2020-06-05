<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table id="table-1">
		<thead>
			<tr>
				<th>Header</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<form id="form-1" name="formpost" method="POST" action="/ProgettoServlet/service">
						<label for="user">User: </label>
						<input type="text" name="user" value="">
						<input type="submit" value="Submit" id="button-1"/>
					</form>
				</td>
				
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th><%=request.getAttribute("responsePostText")%></th>
			</tr>
		</tfoot>
	</table>
</body>
</html>