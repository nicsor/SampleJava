<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<div>
			<label for="email">Email:</label> <input type="email" id="email"
				name="email" />
		</div>
		<div>
			<label for="pwd">Password:</label> <input type="password" id="pwd"
				name="password" />
		</div>

		<div>
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>