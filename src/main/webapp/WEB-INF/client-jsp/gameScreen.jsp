<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="static/js/countdown.js" type="text/javascript"
	charset="utf-8"></script>
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

<script>


}
</script>
<script>
var turn=0;
var noTurns;
var turnTimes;
var response;

	
	
function getStockMarketDetailFromService() {
	
	
	 var xhttp = new XMLHttpRequest();
	    xhttp.open("POST", "http://localhost:8080/stockMarket/getMarketPrices", false);
	    xhttp.setRequestHeader("Content-type", "application/json");
	    xhttp.send();
	    response = JSON.parse(xhttp.responseText);
	    noTurns=response.noTurns;
	    turnTimes=response.turnTime;
	    loop();
	   
	   
	   
}

function loop(){
	
	var table = document.getElementById("demoTable");	 
	 for (var i = 0; i < response.companies.length; i++) {
		 
		 var object = response.companies[i];		 
		 var row = table.insertRow(i);
		 var cell1 = row.insertCell(0);
		 var cell2 = row.insertCell(1); 		
		 table.rows[i].cells[0].innerHTML=object['companyName'];
		 table.rows[i].cells[1].innerHTML=object.turns[turn].price;	      	  
	    }   
	 	
	 
	 setTimeout(function () {          
	      turn++;                     
	      if (turn < noTurns) {           
	    	       
	    	  table.deleteRow(0);
	    	  table.deleteRow(0);
	          table.deleteRow(0);
	          table.deleteRow(0);
	          table.deleteRow(0);
	          //table.deleteRow(0);
	         // table.deleteRow(0);
	         // table.deleteRow(0);
	         // table.deleteRow(0);
	        //  table.deleteRow(0);
	        //  table.deleteRow(0);
	        //  table.deleteRow(0);
	    	  loop();             
	      }                        
	   }, turnTimes)
} 


</script>



</head>
<body onload="getStockMarketDetailFromService()">
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.1.min.js"></script>


	<h1>Hello welcome to game screen</h1>
	<p id="demo"></p>

	<div class="table-responsive" id="refresh">
		<table class="table table-stripped table-bordered">
			<thead>
				<tr>
					<th>Company Name</th>
					<th>Stock Price</th>
				</tr>

			</thead>
			<tbody id="demoTable">

			</tbody>
		</table>
	</div>
	<a href="https://stackoverflow.com/questions/27870671/how-do-i-change-an-html-table-cell-value-by-a-dynamically-added-button-in-each-r">link</a>
</body>
</html>