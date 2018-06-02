<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/postrequest.js"></script>
<script src="/js/getrequest.js"></script>
<title>index screen</title>
</head>
<body>
	<form action="waitingScreen" method="post">
		<pre>
        <input type="text" name="txtGetName" placeholder="Enter Player Name" size="75" required />   <label style="color: red">${errorMSG}</label>
        <span class="validity"></span>
        </pre>
		<input type="submit" name="btnPlay" size="75" />
	</form>
</body>
</html>