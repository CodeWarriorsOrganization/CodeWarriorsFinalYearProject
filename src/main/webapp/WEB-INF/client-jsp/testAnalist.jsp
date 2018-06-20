<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
	    
	 //   document.getElementById("demo").innerHTML=response.analysisMessage.turnMessage[0].buyMessages[0].message;
	    
	    loop();
	   
	   
	   
}

function loop(){	
	var table = document.getElementById("demoTable");	
	//document.getElementById("demotextArea").value. =response.analysisMessage.turnMessage[0].buyMessages[0].message;
	//document.getElementById("demotextArea").value =response.analysisMessage.turnMessage[0].buyMessages[1].message;
	//document.getElementById("demotextArea").value =response.analysisMessage.turnMessage[0].buyMessages[2].message;
	
	//var element='<p>This is<br>a paragraph<br>with line breaks.</p>';
//	document.getElementById("textContainer").innerHTML=element;
	//document.getElementById("demo").innerHTML=response.analysisMessage.turnMessage[0].buyMessages[0].message[0];
	
	document.getElementById("demo").innerHTML="curent turn= "+turn;
	for (var i = 0; i < 3; i++) {
		 
		 var object = response.companies[i];		 
		 var row = table.insertRow(i);
		 var cell1 = row.insertCell(0);
		 var cell2 = row.insertCell(1); 		
		//table.rows[i].cells[0].innerHTML=object['companyName'];
		// table.rows[i].cells[1].innerHTML=object.turns[turn].price;	
		
		 table.rows[i].cells[0].innerHTML=response.analysisMessage.turnMessage[turn].buyMessages[i].message;
		 table.rows[i].cells[1].innerHTML=response.analysisMessage.turnMessage[turn].sellMessages[i].message;
		// table.rows[i].cells[0].innerHTML="sellMessages";
		// table.rows[i].cells[1].innerHTML=response.analysisMessage.turnMessage[turn].sellMessages[i].message;
	    }   
	 	
	 
	 setTimeout(function () {          
	      turn++;                     
	      if (turn < noTurns) {           
	    	       
	    	  table.deleteRow(0);
	    	  table.deleteRow(0);
	          table.deleteRow(0);
	      /*    table.deleteRow(0);
	          table.deleteRow(0);
	          table.deleteRow(0);
	         table.deleteRow(0);
	         table.deleteRow(0);
	          table.deleteRow(0);
	          table.deleteRow(0);
	          table.deleteRow(0);
	          table.deleteRow(0);*/
	    	  loop();             
	      }                        
	   }, 2000)
	   
	   
} 


</script>


</head>
<body onload="getStockMarketDetailFromService()">
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.1.min.js"></script>


	<h1>Hello welcome to game screen</h1>
	<p id="demo">a</p>
<!--	<div id="textContainer"></div>
	  <textarea rows="10" cols="100" id="demotextArea">

</textarea> -->

	<div class="table-responsive" id="refresh">
		<table class="table table-stripped table-bordered">
			<thead>
				<tr>
					<th>Buy message</th>
					<th>Sell Price</th>
				</tr>

			</thead>
			<tbody id="demoTable">

			</tbody>
		</table>
	</div>
	<a href="https://stackoverflow.com/questions/27870671/how-do-i-change-an-html-table-cell-value-by-a-dynamically-added-button-in-each-r">link</a>
</body>
</html>