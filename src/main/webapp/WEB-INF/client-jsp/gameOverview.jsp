<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Phobia</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/x-icon" href="/static/img/title-bar-logo.png" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Lato", sans-serif;}

.tablink {
    background-color: #555;
    color: white;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px;
    width: 25%;
}

.tablink:hover {
    background-color: #777;
}

/* Style the tab content */
.tabcontent {
    color: white;
    display: none;
    padding: 50px;
    text-align: center;
}

#Overview {background-color:red;}
#Portfolio {background-color:green;}
#TradeHistory {background-color:blue;}
#Transactions {background-color:orange;}


.wrapper {
  width:150px;
  height:150px;
  margin: 25px auto;
  overflow: hidden;
  border-radius:50%;
  position: relative;
}

.wrapper img {
  position: absolute;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%)
}
</style>
	
</head>

<body onload="checkOnLoad();getFirstTab();">
<p>Click on the buttons inside the tabbed menu:</p>

<div id="Overview" class="tabcontent">
  <h3>The Winner</h3>
  <div class="wrapper">
  <img id="trophy" src="/static/img/small_trophy.png" alt="Avatar">
  </div>
</div>

<div id="Portfolio" class="tabcontent">
  <h3 id=portfolioHeader>${playerName}</h3>
  <p>Paris is the capital of France.</p> 
</div>

<div id="TradeHistory" class="tabcontent">
  <h3>Tokyo</h3>
  <p>Tokyo is the capital of Japan.</p>
</div>

<div id="Transactions" class="tabcontent">
  <h3>Oslo</h3>
  <p>Oslo is the capital of Norway.</p>
</div>

<button class="tablink" onclick="openTab('Overview', this, 'red')" id="defaultOpen">Overview</button>
<button class="tablink" onclick="openTab('Portfolio', this, 'green')" id="displayPortfolio">Portfolio</button>
<button class="tablink" onclick="openTab('TradeHistory', this, 'blue')">Trade History</button>
<button class="tablink" onclick="openTab('Transactions', this, 'orange')">Transactions</button>

<script>
function openTab(tabName,elmnt,color) {
    var i, tabcontent, tablinks;
    
    switch(tabName)
    {
     case "Overview" : 
    	{
    	   show1.style.display="block";
    	   tblRankings.style.display="block";
           tabcontent = document.getElementsByClassName("tabcontent");
           for (i = 0; i < tabcontent.length; i++) 
           {
              tabcontent[i].style.display = "none";
           }
           tablinks = document.getElementsByClassName("tablink");
           for (i = 0; i < tablinks.length; i++) 
           {
              tablinks[i].style.backgroundColor = "";
           }
           
     document.getElementById(tabName).style.display = "block";
     elmnt.style.backgroundColor = color;
       break;
    
    	}
    	
    	
    case "Portfolio" : 
	{   show1.style.display="none";
	 tblRankings.style.display="none";
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) 
        {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < tablinks.length; i++) 
        {
        tablinks[i].style.backgroundColor = "";
        }
        document.getElementById(tabName).style.display = "block";
        elmnt.style.backgroundColor = color;
         break;
	}
	
	
    case "TradeHistory" : 
	{    tblRankings.style.display="none";
    	show1.style.display="none";
       tabcontent = document.getElementsByClassName("tabcontent");
       for (i = 0; i < tabcontent.length; i++) 
       {
         tabcontent[i].style.display = "none";
        }
         tablinks = document.getElementsByClassName("tablink");
       for (i = 0; i < tablinks.length; i++)
       {
          tablinks[i].style.backgroundColor = "";
       }
        document.getElementById(tabName).style.display = "block";
        elmnt.style.backgroundColor = color;
        break;
	}
	
    case "Transactions" :  	
	{  
    	 tblRankings.style.display="none";
    	show1.style.display="none";
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++)
        {
          tabcontent[i].style.display = "none";
        }
          tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < tablinks.length; i++) 
        {
          tablinks[i].style.backgroundColor = "";
        }
          document.getElementById(tabName).style.display = "block";
          elmnt.style.backgroundColor = color;
           break;
	}
}
}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
<p id="show1" style="display:none;">hellooo my name is zikra</p>


 <div  class="table-responsive" id="tblRankings">
		<table class="table table-stripped table-bordered" id="tableRank">
			<thead>
				<tr>
				<th>RANK</th>
				<th>NAME</th>
				<th>NET WORTH</th>
				<th>TRADES</th>
				<th>TOTAL RETURNS</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="player" items="${playerProfile}" varStatus="loop">
			<tr>
			<td>${loop.count}</td>
			<td><a onclick="openPortfolioTab()" id="portfolioPName">${player.profileName}</a></td>
			<td>${player.pBalance}</td>
			<td>${player.noOfTrades}</td>
			<td id="totalreturns">${player.totalReturns}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>  
	
	<div>
	
	<label></label>
	
	
	</div>
	

	  	
</body>

<script type="text/javascript">


//This script is to set time for the game
var x = 0;
function checkOnLoad() {
	var tableRankRows = document.getElementById("tableRank").rows.length;
	var i = 1;
	function myLoop() {
		setTimeout(
				function() {
					for (var z = 1; z < tableRankRows; z++) 
					{
						var check =	document.getElementById("tableRank").rows[z].cells[4].innerHTML;
						
						if(check<0)
						{
							document.getElementById("totalreturns").style.color = "red";

						}
						else
							{
							document.getElementById("totalreturns").style.color = "green";
							
							}
						
					}
					i++;
					
						myLoop();
				
				}, 1000)
		x++;
	}
	myLoop();
}

</script>
<script type="text/javascript">
function getFirstTab(){
document.getElementById("defaultOpen").click();
}
</script>
<script type="text/javascript">
function openPortfolioTab(){
document.getElementById("displayPortfolio").click();
getData();
}
</script>
<script type="text/javascript">
	//pass data to controller

	function getData() {

		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/getPlayerDetails",
			data : {
				
				
			},
			success : function(data) {
							}
		});

	}
</script>

</html>