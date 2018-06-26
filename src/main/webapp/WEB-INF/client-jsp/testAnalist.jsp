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
	    xhttp.open("POST", "http://localhost:8080/stockMarket/getMarketPricesTest", false);
	    xhttp.setRequestHeader("Content-type", "application/json");
	    xhttp.send();
	    response = JSON.parse(xhttp.responseText);
	    noTurns=response.noTurns;
	    turnTimes=response.turnTime; 	    
	   loop();   
	   
}



function loop(){	
	
	document.getElementById("Event").innerHTML=response.events[turn].eventName;
	
	
	var eventMsg='Occurring Event : '+response.events[turn].eventName + '\n  Affected Companies : ';
	
	for(var x=0; x<response.events[turn].eventAfectedCompanies.length;x++){
		
		eventMsg= eventMsg+'\n  * '+response.events[turn].eventAfectedCompanies[x];
		//document.getElementById("eventTxtArea").innerHTML=response.events[turn].eventAfectedCompanies[x];
	}
	
	document.getElementById("eventTxtArea").innerHTML=eventMsg;
	
	var table = document.getElementById("demoTable");		
	var buyMessage=response.analysisMessage.turnMessage[turn].buyMessages.length;
	var sellMessage=response.analysisMessage.turnMessage[turn].sellMessages.length;
	  document.getElementById("demoturnCount").innerHTML=buyMessage;
	  document.getElementById("demo").innerHTML="curent turn= "+turn;
	  var analysisTxtMsg='Best Stocks for buy : ';
	  for(var x=0;x<buyMessage;x++){
		  analysisTxtMsg=analysisTxtMsg +'\n'+'        :- '+ response.analysisMessage.turnMessage[turn].buyMessages[x].message ;
	  } 
	  
	  
	
	
	  analysisTxtMsg=analysisTxtMsg+'\n\nBest Stocks for sell : ';
	
	for(var x=0;x<sellMessage;x++){
		
		analysisTxtMsg=analysisTxtMsg +'\n'+'        :- '+ response.analysisMessage.turnMessage[turn].sellMessages[x].message ;
		
	  } 
	
	document.getElementById("analysisTxtArea").innerHTML=analysisTxtMsg;
	
		
	 
	 setTimeout(function () {          
	      turn++;                     
	      if (turn < noTurns) {           
	    	
	    	  loop();             
	      }                        
	   }, 2000)
	   
	   
} 


</script>


</head>
<body onload="getStockMarketDetailFromService()">
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<label id="lbl"></label>
	<h1>Hello welcome to game screen</h1>
	<p id="demo">a</p>
	<p id="demoturnCount"></p>
	<div id="demodiv"></div>
	<div id="textContainer"></div>
	<p id="Event"></p>  

<div class="form-group">
  <label for="comment">Comment:</label>
  <textarea class="form-control" rows="18" cols="60" id="analysisTxtArea"></textarea>
  <textarea class="form-control" rows="18" cols="60" id="eventTxtArea"></textarea>
  events
</div>

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
