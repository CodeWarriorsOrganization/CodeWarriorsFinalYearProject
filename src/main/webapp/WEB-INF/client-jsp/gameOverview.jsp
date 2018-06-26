<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Phobia</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="shortcut icon" type="image/x-icon"
	href="/static/img/title-bar-logo.png" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>



body {
    height: 100%;
    height: 100%;
    
	font-family: "Lato", sans-serif;
	background: url("/static/img/overview.jpeg");
	
	
	
	 box-sizing: border-box;
    -webkit-animation: slide 15s linear infinite;
	
}

@-webkit-keyframes slide {
    from { background-position: 0 0; }
    to { background-position: -400px -500px; }
}
.container-fluid{
height:100%;
width:100%;

}



	
.navbar1{
width:1500px;


}	

	



.tablink {
	background-color:#00BFFF;
	color: white;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 8px 10px;
	font-size: 16px;
	width: 16.5%;
	height:40px;
	/*border-radius:20px;*/
	opacity:0.9;
	
}

.tablink:hover {
	background-color:#07BBFA;
}







/* Style the tab content */
.tabcontent {
	color: yellow;
	display: block;
	
	text-align: center;
	width:100%;
	height:100%;
	opacity:0.8;
}

#Overview {
	background-color:#012b36;
	height:754px;
	width:cover;
    	
}

#Portfolio {
	background-color: #012b36;
	height:754px;
}

#TradeHistory {
	background-color: #012b36;
	height:754px;
}

#Transactions {
	background-color: #012b36;
	height:754px;
}

#StockPrices {
	background-color:#012b36;
	height:754px;
}

#HistoryOfWinners {
	background-color: #012b36;
	height:754px;
}





.wrapper {
	width: 150px;
	height: 150px;
	margin: 25px auto;
	overflow: hidden;
	border-radius: 50%;
	position: relative;
}

.wrapper img {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%)
}


#btnPlayAgain{
    width:120px;
	height:50px;
	background-color:#08495F;
	color:white;
	border-radius:30px;
	font-size:20px;
	text-align:center;
	font-weight:bold;
	

}

.table{
     Background-color:#012b36;	
	 font-weight:bold;
	 font-size:16px;
	 color:white;
	 text-align:center;
	 
	 
}

.table th{
Background-color:#0199c1;	
 color:white;

}






#tableRank{
Background-color:#012b36;
border-outline:none;
 text-align:center;
}




.blink{
	animation-name:blinker;
	animation-duration:1s;
	animation-timing-function:linear;
	animation-iteration-count:infinite;
		
}
@keyframes blinker
{
	0%{opacity:0}
	
	100%{opacity:1}
	
}







</style>

</head>

<body
	onload="checkOnLoad();displayWinnerName();disableBackButton();getStockMarketDetailFromService();pageLoad();">
	
	
	
	
	
	
     <div class="container-fluid"> 
  
  
  
  
    
	<div class="row">
     <div class="col-md-2">
     <div class="navbar-header navbar1">
	<button class="tablink" onclick="openPage('Overview', this, '#012b36')"
		id="defaultOpen">Overview</button>
		</div>
		</div>
		
		
	<div class="col-md-2">	
	<div class="navbar-header navbar1">
	<button class="tablink" onclick="openPage('Portfolio', this, '#012b36')"
		id="OpenPortfolioTab">Portfolio</button>
		</div>
		</div>
		
		
		<div class="col-md-2">
		<div class="navbar-header navbar1">
	<button class="tablink"
		onclick="openPage('TradeHistory', this, '#012b36')"
		id="OpenTradeHistoryTab">Trade History</button>
		</div>
		</div>
		
		<div class="col-md-2">
		<div class="navbar-header navbar1">
	<button class="tablink"
		onclick="openPage('Transactions', this, '#012b36')"
		id="OpenTransactionTab">Transactions</button>
		</div>
		</div>
		
		<div class="col-md-2">
		<div class="navbar-header navbar1">
	<button class="tablink"
		onclick="openPage('StockPrices', this, '#012b36')"
		id="OpenStockPriceTab">Stock Prices</button>
		</div>
		</div>
		
		<div class="col-md-2">
		<div class="navbar-header navbar1">
		<button class="tablink"
		onclick="openPage('HistoryOfWinners', this, '#012b36')"
		id="OpenWinnerHistoryTab">History Of Winners</button>
        </div>
        </div>
</div>
</div>





	<div id="Overview" class="tabcontent">
         <br>
		<h1>Congratulations!</h1>
		<h1 id="winner">${playerRankings[0].profileName}</h1>
		<h2>The Winner</h2>
		
		<div class="wrapper">
		<span class="d-block p-2 blink">
			<img id="trophy" src="/static/img/small_trophy.png" alt="Avatar">
			</span>
		</div>
		
		<button class="btn btn-success" id="btnPlayAgain" name="btnPlayAgain" type="button">Play Again</button>
		
		<br>
		<br>
		<div class="d-block p-2 table-responsive text-black" id="tblRankings">
		
		<div class="table"> 
		
			<table class="table table-stripped table-bordered" id="tableRank" style="cursor: pointer;">
				<thead>
					<tr>
						<th class="col-md-2 text-center">RANK</th>
						<th class="col-md-3 text-center">NAME</th>
						<th class="col-md-2 text-center">TRADES</th>
						<th class="col-md-2 text-center">NET WORTH</th>
						<th class="col-md-3 text-center">TOTAL RETURNS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="player" items="${playerRankings}" varStatus="loop">
						<tr>
							<td id="rank">${loop.count}</td>
							<td id="portfolioPName">${player.profileName}</td>
							<td id="balance">${player.noOfTrades}</td>
							<td>${player.pBalance}</td>
							<td id="totalreturns">${player.totalReturns}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
		
		
	</div>

	<div id="Portfolio" class="tabcontent">
		<h3 id="portfolioHeader">${Pname}</h3>
		<pre>
                   <label>RANK :</label>           <label>NET WORTH :</label>               <label>OVERALL GAINS(+)/LOSS(-) :</label>
             <label id="pRank"></label>               <label id="netWorth"></label>                    <label
				id="overall_perform"></label>
  </pre>

		
		
		<div class="table-responsive" id="tblPlayerProfile">
		

		
			<table class="table table-stripped table-bordered">
				
				<thead>
					<tr>
						<th class="col-md-2 text-center">COMPANY</th>
						<th class="col-md-1 text-center">QUANTITY BOUGHT</th>
						<th class="col-md-2 text-center">BOUGHT COST</th>
						<th class="col-md-1 text-center">QUANTITY SOLD</th>
						<th class="col-md-2 text-center">SOLD COST</th>
						<th class="col-md-2 text-center">STOCK ON HAND</th>
						<th class="col-md-2 text-center">RETURNS</th>
					</tr>
				</thead>
				<tbody id="tablePlayerProfile">
				</tbody>
			</table>
		</div>
		
		
		
		
		
	</div>

	<div id="TradeHistory" class="tabcontent">

		<h3 id="portfolioHeader2"></h3>
		<pre>
                   <label>RANK :</label>           <label>NET WORTH :</label>               <label>OVERALL GAINS(+)/LOSS(-) :</label>
             <label id="pRank2"></label>              <label id="netWorth2"></label>                    <label
				id="overall_perform2"></label>
  </pre>


		<div class="table-responsive" id="tblTrades">
			<table class="table table-stripped table-bordered">
				<thead>
					<tr>
						<th class="col-md-2 text-center">COMPANY</th>
						<th class="col-md-2 text-center">TURN NO</th>
						<th class="col-md-2 text-center">TYPE</th>
						<th class="col-md-2 text-center">UNIT PRICE</th>
						<th class="col-md-2 text-center">QUANTITY</th>
						<th class="col-md-2 text-center">COST</th>

					</tr>
				</thead>
				<tbody id="tableTrades">
				</tbody>
			</table>
		</div>
		
		
		
		
	</div>

	<div id="Transactions" class="tabcontent">

		<h3 id="portfolioHeader3"></h3>
		<pre>
                   <label>RANK :</label>           <label>NET WORTH :</label>               <label>OVERALL GAINS(+)/LOSS(-) :</label>
      <label id="pRank3"></label>              <label id="netWorth3"></label>                           <label
				id="overall_perform3"></label>
  </pre>

		<div class="table-responsive" id="tblTransactions">
			<table class="table table-stripped table-bordered">
				<thead>
					<tr>
						<th class="col-md-4 text-center">TURN NO</th>
						<th class="col-md-4 text-center">TRANSACTION TYPE</th>
						<th class="col-md-4 text-center">AMOUNT</th>
						<th class="col-md-4 text-center">BALANCE</th>
					</tr>
				</thead>
				<tbody id="tableTransactions">
				</tbody>
			</table>
		</div>
	</div>

	<div id="StockPrices" class="tabcontent">

		<h3 id="portfolioHeader4"></h3>


		<div class="table-responsive" id="tblStockPrices">
			<table class="table table-stripped table-bordered">
				<thead>
					<tr>
						<th>COMPANY</th>
						<th>TURN 1</th>
						<th>TURN 2</th>
						<th>TURN 3</th>
						<th>TURN 4</th>
						<th>TURN 5</th>
						<th>TURN 6</th>
						<th>TURN 7</th>
						<th>TURN 8</th>
						<th>TURN 9</th>
						<th>TURN 10</th>
						<th>TURN 11</th>
						<th>TURN 12</th>
						<th>TURN 13</th>
						<th>TURN 14</th>
						<th>TURN 15</th>
						<th>TURN 16</th>
						<th>TURN 17</th>
						<th>TURN 18</th>
						<th>TURN 19</th>
						<th>TURN 20</th>
						<th>TURN 21</th>
						<th>TURN 22</th>
						<th>TURN 23</th>
						<th>TURN 24</th>
						<th>TURN 25</th>
						<th>TURN 26</th>
						<th>TURN 27</th>
						<th>TURN 28</th>
						<th>TURN 29</th>
						<th>TURN 30</th>

					</tr>
				</thead>
				<tbody id="tableStockPrices">
				</tbody>
			</table>
		</div>
	</div>



	<div id="HistoryOfWinners" class="tabcontent">
	<h3 id="portfolioHeader">
	<marquee>Here are previous Winners...</marquee>
	</h3>
		<div class="table-responsive" id="tblWinnerHistory">
			<table class="table table-stripped table-bordered">
				<thead>
					<tr>
						<th class="col-md-2 text-center">ROUND NO</th>
						<th class="col-md-3 text-center">WINNER</th>
						<th class="col-md-3 text-center">TRADES</th>
						<th class="col-md-2 text-center">NET WORTH</th>
						<th class="col-md-2 text-center">RETURNS</th>
					</tr>
				</thead>
				<tbody id="tableWinnerHistory">
	
				</tbody>
			</table>
		</div>
	</div> 
	
	
	
	

</body>



<script>
		function openPage(pageName, elmnt, color) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].style.backgroundColor = "";
			}
			document.getElementById(pageName).style.display = "block";
			elmnt.style.backgroundColor = color;

		}
		// Get the element with id="defaultOpen" and click on it

		document.getElementById("defaultOpen").click();
	</script>














<script type="text/javascript">
	function pageLoad() {
		
		loadWinnerDetails();

		var tableRankRows = document.getElementById("tableRank").rows.length;
		for (var z = 1; z < tableRankRows; z++) {

			if (document.getElementById("tableRank").rows[z].cells[1].innerHTML == document
					.getElementById("portfolioHeader").innerHTML) {
				document.getElementById("tableRank").rows[z].cells[1].click();
				document.getElementById("OpenTradeHistoryTab").click();
				document.getElementById("OpenTransactionTab").click();
				document.getElementById("OpenWinnerHistoryTab").click();
			//	document.getElementById("btnBank").click();
				document.getElementById("OpenPortfolioTab").click();
				document.getElementById("defaultOpen").click();

			}
		}

	}
</script>

<script>
	var turn = 0;
	var noTurns;
	var turnTimes;
	var response;

	function getStockMarketDetailFromService() {

		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", "http://localhost:8080/stockMarket/getMarketPrices",
				false);
		xhttp.setRequestHeader("Content-type", "application/json");
		xhttp.send();
		response = JSON.parse(xhttp.responseText);
		noTurns = response.noTurns;
		turnTimes = response.turnTime;
		loop();

	}

	function loop() {

		var table = document.getElementById("tableStockPrices");

		for (var i = 0; i < response.companies.length; i++) {

			var object = response.companies[i];
			var row = table.insertRow(i);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			var cell8 = row.insertCell(7);
			var cell9 = row.insertCell(8);
			var cell10 = row.insertCell(9);
			var cell11 = row.insertCell(10);
			var cell12 = row.insertCell(11);
			var cell13 = row.insertCell(12);
			var cell14 = row.insertCell(13);
			var cell15 = row.insertCell(14);
			var cell16 = row.insertCell(15);
			var cell17 = row.insertCell(16);
			var cell18 = row.insertCell(17);
			var cell19 = row.insertCell(18);
			var cell20 = row.insertCell(19);
			var cell21 = row.insertCell(20);
			var cell22 = row.insertCell(21);
			var cell23 = row.insertCell(22);
			var cell24 = row.insertCell(23);
			var cell25 = row.insertCell(24);
			var cell26 = row.insertCell(25);
			var cell27 = row.insertCell(26);
			var cell28 = row.insertCell(27);
			var cell29 = row.insertCell(28);
			var cell30 = row.insertCell(29);
			var cell31 = row.insertCell(30);

			table.rows[i].cells[0].innerHTML = object['companyName'];
			table.rows[i].cells[1].innerHTML = object.turns[turn].price;
			table.rows[i].cells[2].innerHTML = object.turns[1].price;
			table.rows[i].cells[3].innerHTML = object.turns[2].price;
			table.rows[i].cells[4].innerHTML = object.turns[3].price;
			table.rows[i].cells[5].innerHTML = object.turns[4].price;
			table.rows[i].cells[6].innerHTML = object.turns[5].price;
			table.rows[i].cells[7].innerHTML = object.turns[6].price;
			table.rows[i].cells[8].innerHTML = object.turns[7].price;
			table.rows[i].cells[9].innerHTML = object.turns[8].price;
			table.rows[i].cells[10].innerHTML = object.turns[9].price;
			table.rows[i].cells[11].innerHTML = object.turns[10].price;
			table.rows[i].cells[12].innerHTML = object.turns[11].price;
			table.rows[i].cells[13].innerHTML = object.turns[12].price;
			table.rows[i].cells[14].innerHTML = object.turns[13].price;
			table.rows[i].cells[15].innerHTML = object.turns[14].price;
			table.rows[i].cells[16].innerHTML = object.turns[15].price;
			table.rows[i].cells[17].innerHTML = object.turns[16].price;
			table.rows[i].cells[18].innerHTML = object.turns[17].price;
			table.rows[i].cells[19].innerHTML = object.turns[18].price;
			table.rows[i].cells[20].innerHTML = object.turns[19].price;
			table.rows[i].cells[21].innerHTML = object.turns[20].price;
			table.rows[i].cells[22].innerHTML = object.turns[21].price;
			table.rows[i].cells[23].innerHTML = object.turns[22].price;
			table.rows[i].cells[24].innerHTML = object.turns[23].price;
			table.rows[i].cells[25].innerHTML = object.turns[24].price;
			table.rows[i].cells[26].innerHTML = object.turns[25].price;
			table.rows[i].cells[27].innerHTML = object.turns[26].price;
			table.rows[i].cells[28].innerHTML = object.turns[27].price;
			table.rows[i].cells[29].innerHTML = object.turns[28].price;
			table.rows[i].cells[30].innerHTML = object.turns[29].price;

		}
	}
</script>
<script type="text/javascript">
	function checkOnLoad() {

		var tableRankRows = document.getElementById("tableRank").rows.length;

		for (var z = 1; z < tableRankRows; z++) {

			var check = Number(document.getElementById("tableRank").rows[z].cells[4].innerHTML);

			if (check < 0) {
				document.getElementById("tableRank").rows[z].cells[4].style.color = "red";

			} else {
				document.getElementById("tableRank").rows[z].cells[4].style.color = "green";

			}

		}

	}
</script>
<script type="text/javascript">
	function displayWinnerName() {
		document.getElementById("winner").innerHTML = document
				.getElementById("tableRank").rows[1].cells[1].innerHTML;
	}
</script>
<script type="text/javascript">
	$(document)
			.on(
					'click',
					'#tableRank tr',
					function(e) {
						$("#tablePlayerProfile tr").remove();
						$("#tableTrades tr").remove();
						$("#tableTransactions tr").remove();

						document.getElementById("OpenPortfolioTab").disabled = false;

						e.stopPropagation();

						var name = this.cells[1].textContent;
						var balance = this.cells[3].textContent;
						var returns = this.cells[4].textContent;
						var rank = this.cells[0].textContent;

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/getPlayerDetailsHeader",
									data : {
										"pName" : name,
										"balance" : balance,
										"returns" : returns,
										"rank" : rank
									},
									success : function(data) {

										document
												.getElementById("portfolioHeader").innerText = data[0];
										document.getElementById("netWorth").innerText = data[1];
										document
												.getElementById("overall_perform").innerText = data[2];
										document.getElementById("pRank").innerText = data[3];

										document
												.getElementById("portfolioHeader2").innerText = data[0];
										document.getElementById("netWorth2").innerText = data[1];
										document
												.getElementById("overall_perform2").innerText = data[2];
										document.getElementById("pRank2").innerText = data[3];

										document
												.getElementById("portfolioHeader3").innerText = data[0];
										document.getElementById("netWorth3").innerText = data[1];
										document
												.getElementById("overall_perform3").innerText = data[2];
										document.getElementById("pRank3").innerText = data[3];

									}
								});

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/getPlayerDetails",
									data : {
										"pName" : name,
										"balance" : balance,
										"returns" : returns

									},
									success : function(data) {

										$
												.each(
														data,
														function(i, item) {
															$('<tr>')
																	.html(
																			"<td>"
																					+ data[i].companyName
																					+ "</td><td>"
																					+ data[i].boughtStockQty
																					+ "</td><td>"
																					+ data[i].boughtShares
																					+ "</td><td>"
																					+ data[i].sellStockQty
																					+ "</td><td>"
																					+ data[i].soldShares
																					+ "</td><td>"
																					+ data[i].stockInHand
																					+ "</td><td>"
																					+ data[i].lossOrGain
																					+ "</td>")
																	.appendTo(
																			'#tablePlayerProfile');
														});

									}
								});

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/getTransaction",
									data : {
										"pName" : name,
										"balance" : balance,
										"returns" : returns

									},
									success : function(data) {

										$.each(data, function(i, item) {
											$('<tr>').html(
													"<td>" + data[i].compName
															+ "</td><td>"
															+ data[i].turnID
															+ "</td><td>"
															+ data[i].type
															+ "</td><td>"
															+ data[i].unitPrice
															+ "</td><td>"
															+ data[i].quantity
															+ "</td><td>"
															+ data[i].cost
															+ "</td>")

											.appendTo('#tableTrades');
										});

									}
								});

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/getBankDetails",
									data : {
										"pName" : name,
										"balance" : balance,
										"returns" : returns

									},
									success : function(data) {

										$.each(data, function(i, item) {
											$('<tr>').html(
													"<td>" + data[i].turnNo
															+ "</td><td>"
															+ data[i].type
															+ "</td><td>"
															+ data[i].amount
															+ "</td><td>"
															+ data[i].balance
															+ "</td>")

											.appendTo('#tableTransactions');
										});

									}
								});

						document.getElementById("OpenPortfolioTab").click();

						return false;

					});
</script>

<script type="text/javascript">
	$(document)
			.on(
					"click",
					"#btnPlayAgain",
					function() {


						var winnerName =document.getElementById("tableRank").rows[1].cells[1].innerHTML;
						var trades =   document.getElementById("tableRank").rows[1].cells[2].innerHTML;
						var returns =  document.getElementById("tableRank").rows[1].cells[4].innerHTML;
						var netWorth =  document.getElementById("tableRank").rows[1].cells[3].innerHTML;

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/playAgain",
									data : {
										"winnerName" : winnerName,
										"trades" : trades,
										"returns" : returns,
										"netWorth" : netWorth

 
									},
									success : function(data) {
										
										window.location.href = ("/goToHome");
									}
										 
										
								});
						$("#tableWinnerHistory tr").remove();
						
					
					});
</script>
<script type="text/javascript">
function loadWinnerDetails(){

						$
						.ajax({
							type : "GET",
							url : "${pageContext.request.contextPath}/getWinnerHistory",
							data : {
								
							},
							success : function(data) {

								$.each(data, function(i, item) {
									$('<tr>').html(
											"<td>" + data[i].roundNo
													+ "</td><td>"
													+ data[i].winnerName
													+ "</td><td>"
													+ data[i].noOfTrades
													+ "</td><td>"
													+ data[i].netWorth
													+ "</td><td>"
													+ data[i].totalReturns
													+ "</td>")

									.appendTo('#tableWinnerHistory');
								});

							}
						});
					
}
</script>



<script type="text/javascript">
	function disableBackButton() {
		history.pushState(null, null, location.href);
		window.onpopstate = function() {
			history.go(1);
		}
	}
</script>

</html>
