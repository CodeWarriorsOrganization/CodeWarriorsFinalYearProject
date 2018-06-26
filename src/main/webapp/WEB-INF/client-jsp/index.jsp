<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="shortcut icon" type="image/x-icon"
	href="/static/img/title-bar-logo.png" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/static/css/style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/js/postrequest.js"></script>
<script src="/js/getrequest.js"></script>
<title>Market Phobia</title>
<style>
.body {
	background-image: url("static/img/UI-without-buttons.svg");
}
</style>
</head>
<body>
	<div class="containerback" style="height: 100%;">
		<!--       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa     -->

		<table style="width: 100%; height: 100%;">
			<tr>
				<td>""</td>
				<td>""</td>
				<td>""</td>
				<td>""</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td style="padding-left:50px">
					<form class="form-inline"  action="waitingScreen" method="post">
						 <div class="form-group">
						<input type="text" name="txtGetName" class="form-control " style="width:190px"
													id="enternametext" placeholder="Enter Player Name" 
													 required />
						  
						  </div>
						<button type="submit" name="btnPlay" class="btn btn-default playnow"></button>
					</form>

				</td>
				<td>""</td>
				<td>""</td>
				<td>""</td>
				

			</tr>
		</table>



		<!--       aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa     -->
	</div>


</body>
</html>