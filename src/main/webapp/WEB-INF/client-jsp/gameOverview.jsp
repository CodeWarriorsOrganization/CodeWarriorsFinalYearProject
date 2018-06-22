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
	font-family: "Lato", sans-serif;
}

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

#Overview {
	background-color: red;
}

#Portfolio {
	background-color: green;
}

#TradeHistory {
	background-color: blue;
}

#Transactions {
	background-color: orange;
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
</style>

</head>

<body onload="checkOnLoad();displayWinnerName();disableBackButton();">

	<button class="tablink" onclick="openPage('Overview', this, 'red')"
		id="defaultOpen">Overview</button>
	<button class="tablink" onclick="openPage('Portfolio', this, 'green')"
		id="OpenPortfolioTab">Portfolio</button>
	<button class="tablink"
		onclick="openPage('TradeHistory', this, 'blue')"
		id="OpenTradeHistoryTab">TradeHistory</button>
	<button class="tablink"
		onclick="openPage('Transactions', this, 'orange')"
		id="OpenTransactionTab">Transactions</button>

	<div id="Overview" class="tabcontent">

		<h2>Congratulations!</h2>
		<h2 id="winner">${playerRankings[0].profileName}</h2>
		<h3>The Winner</h3>
		<div class="wrapper">
			<img id="trophy" src="/static/img/small_trophy.png" alt="Avatar">
		</div>
		<div class="table-responsive" id="tblRankings">
			<table class="table table-stripped table-bordered" id="tableRank"  style="cursor: pointer;">
				<thead>
					<tr>
						<th>RANK</th>
						<th>NAME</th>
						<th>TRADES</th>
						<th>NET WORTH</th>
						<th>TOTAL RETURNS</th>
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

	<div id="Portfolio" class="tabcontent">
		<h3 id="portfolioHeader"></h3>
		<pre>
 <label>RANK :</label>     <label>NET WORTH :</label>                 <label>OVERALL GAINS(+)/LOSS(-) :</label>
 <label id="pRank"></label>           <label id="netWorth"></label>              <label id="overall_perform"></label>
  </pre>

		<button id="btnTrade" name="btnTrade" type="button">View
			Trades</button>
		<button id="btnBank" name="btnBank" type="button">View
			Transactions</button>

		<div class="table-responsive" id="tblPlayerProfile">
			<table class="table table-stripped table-bordered"
				id="tablePlayerProfile">
				<thead>
					<tr>
						<th>COMPANY</th>
						<th>TYPE</th>
						<th>QUANTITY BOUGHT</th>
						<th>BOUGHT COST</th>
						<th>QUANTITY SOLD</th>
						<th>SOLD COST</th>
						<th>STOCK ON HAND</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>

	<div id="TradeHistory" class="tabcontent">

		<h3 id="portfolioHeader2"></h3>
		<pre>
 <label>RANK :</label>      <label>NET WORTH :</label>                 <label>OVERALL GAINS(+)/LOSS(-) :</label>
  <label id="pRank2"></label>                         <label id="netWorth2"></label>              <label
				id="overall_perform2"></label>
  </pre>

		<div class="table-responsive" id="tblTrades">
			<table class="table table-stripped table-bordered" id="tableTrades">
				<thead>
					<tr>
						<th style="align: center">COMPANY</th>
						<th style="align: center">TURN NO</th>
						<th style="align: center">TYPE</th>
						<th style="align: center">UNIT PRICE</th>
						<th style="align: center">QUANTITY</th>
						<th style="align: center">COST</th>

					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>

	<div id="Transactions" class="tabcontent">

		<h3 id="portfolioHeader3"></h3>
		<pre>
  <label>RANK :</label>             <label>NET WORTH :</label>                 <label>OVERALL GAINS(+)/LOSS(-) :</label>
   <label id="pRank3"></label>      <label id="netWorth3"></label>              <label
				id="overall_perform3"></label>
  </pre>

		<div class="table-responsive" id="tblTransactions">
			<table class="table table-stripped table-bordered"
				id="tableTransactions">
				<thead>
					<tr>
						<th>TURN NO</th>
						<th>TRANSACTION TYPE</th>
						<th>AMOUNT</th>
						<th>BALANCE</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>

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
		document.getElementById("OpenPortfolioTab").disabled = true;
	    document.getElementById("OpenTradeHistoryTab").disabled = true;
		document.getElementById("OpenTransactionTab").disabled = true;
		
	</script>




</body>

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
		document.getElementById("winner").innerHTML = document.getElementById("tableRank").rows[1].cells[1].innerHTML;
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
						var index = $(this).index();
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
										document
										.getElementById("pRank").innerText = data[3];


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
					
						document.getElementById("OpenPortfolioTab").click();
						return false;
					});
</script>

<script type="text/javascript">

$(document).on("click","#btnTrade",function() {
	$("#tableTrades tr").remove();
				//document.getElementById("OpenPortfolioTab").disabled = true;
				document.getElementById("OpenTransactionTab").disabled = true;
				document.getElementById("OpenTradeHistoryTab").disabled = false;
		var name = document.getElementById("portfolioHeader").innerText;
		var balance = document.getElementById("netWorth").innerText;
		var returns = document.getElementById("overall_perform").innerText;
		var rank = document.getElementById("pRank").innerText;


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
								.getElementById("portfolioHeader2").innerText = data[0];
						document.getElementById("netWorth2").innerText = data[1];
						document
								.getElementById("overall_perform2").innerText = data[2];
						document
						.getElementById("pRank2").innerText = data[3];

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
       
						$
								.each(
										data,
										function(i, item) {
											$('<tr>')
													.html(
															"<td>"
															+ data[i].compName
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

													.appendTo(
															'#tableTrades');
										});

					}
				});
	
	document.getElementById("OpenTradeHistoryTab").click();
		return false;
	});
</script>
<script type="text/javascript">

$(document).on("click","#btnBank",function() {
	$("#tableTransactions tr").remove();
		document.getElementById("OpenPortfolioTab").disabled = false;
		document.getElementById("OpenTransactionTab").disabled = false;
		document.getElementById("OpenTradeHistoryTab").disabled = true;
		
		var name = document.getElementById("portfolioHeader").innerText;
		var balance = document.getElementById("netWorth").innerText;
		var returns = document.getElementById("overall_perform").innerText;
		var rank = document.getElementById("pRank").innerText;

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
								.getElementById("portfolioHeader3").innerText = data[0];
						document.getElementById("netWorth3").innerText = data[1];
						document
						.getElementById("overall_perform3").innerText = data[2];
				document
				.getElementById("pRank3").innerText = data[3];

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
    
						$
								.each(
										data,
										function(i, item) {
											$('<tr>')
													.html(
															"<td>"
															+ data[i].turnNo
															+ "</td><td>"
															+ data[i].type
															+ "</td><td>"
															+ data[i].amount
															+ "</td><td>"
															+ data[i].balance
															+ "</td>")

													.appendTo(
															'#tableTransactions');
										});

					}
				});
		
	document.getElementById("OpenTransactionTab").click();
		return false;
	});
</script>
<script type="text/javascript">
$(document).ready(function() {
    $("#OpenPortfolioTab").click(function(){
    	
		document.getElementById("OpenTransactionTab").disabled = true;
		document.getElementById("OpenTradeHistoryTab").disabled = true;
		
    }); 
});


</script>
<script type="text/javascript">
function disableBackButton(){
history.pushState(null, null, location.href);
window.onpopstate = function () {
    history.go(1);
}
}
</script>
</html>
