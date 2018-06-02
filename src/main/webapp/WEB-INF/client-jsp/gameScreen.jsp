<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
    $(document).ready(
            function() {
                setInterval(function() {
                    var randomnumber = Math.floor(Math.random() * 100);
                    $('#show').text(
                            'I am getting refreshed every 3 seconds..! Random Number ==> '
                                    + randomnumber);
                }, 3000);
            });
</script>



</head>
<body>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

   
	<h1>Hello welcome to game screen</h1>
	<div  class="table-responsive" id="refresh">
		<table class="table table-stripped table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Player Name</th>
				</tr>

			</thead>
			<tbody>
			<c:forEach var="player" items="${players}" >
			<tr>
			<td>${player.pID}</td>
			<td>${player.playerName}</td>
			
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
<script type="text/javascript">
$(document).ready(function()){
	
	setInterval(function(){
		$('#refresh').load("/gameScreen");
		//refresh();
	});
	
});



</script>
</body>
</html>