<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Market Phobia</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>

<body onload="countDownFunction()">
	<div class="container">
		<div class="row col-md-6 table-responsive">
			<table id="tblStock" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Company Name</th>
						<th>Price</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>IFS</td>
						<td>500</td>
					</tr>
					<tr>
						<td>Virtusa</td>
						<td>250</td>
					</tr>
					<tr>
						<td>99x</td>
						<td>450</td>
					</tr>
					<tr>
						<td>MIT</td>
						<td>300</td>
					</tr>
					<tr>
						<td>Telecom</td>
						<td>150</td>
					</tr>
					<tr>
						<td>Dialog</td>
						<td>500</td>
					</tr>
				</tbody>
			</table>
			<div>
				<label id="lblCountdown"
					style="width: 200px; height: 200px; color: red; background-color: yellow;"></label>
			</div>
		</div>
		<div class="row col-md-1"></div>
		<div class="row col-md-6" style="background-color: yellow;">
			<label>Player Name :</label><br> <input type="text" name="pName"
				id="playerName" value="${pName}"><br> <label>Balance
				:</label><br> <input type="text" id="balance" value="${balance}"
				readonly><br>
			<div
				style="background-color: green; margin-top: 15px; margin-bottom: 15px;">
				<pre> <label>Stock Value :</label>     <input type="text"
						id="totStockVal" style="text-align: right" value=0 readonly>
				</pre>
				<div>
					<table id="tblShares" class="table table-hover">
						<thead style='display: none;'>
							<tr>
								<th>Company</th>
								<th>Unit Price</th>
								<th>Shares</th>
								<th>Value</th>
							</tr>
						</thead>
						<tbody style="height: 5px;">
						</tbody>
					</table>
				</div>
			</div>
			<div>
				<pre>
                   <label id="lblName"></label>	<label id="name2"></label>
                   <label id="lblSector"></label>  <label id="name3"></label>
                   <label id="lblDetails"></label>  <a id="name4"
						target="_blank"></a>
               </pre>
			</div>
			<div class="row"
				style="background-color: green; margin-top: 15px; margin-bottom: 15px;">
				<div class="row col-md-3">
					<button id="btnTrade" name="btnTrade" type="button"
						onclick="checkExist()"
						style="height: 30px; width: 60px; margin-top: 35px; margin-bottom: 35px; margin-left: 15px; margin-right: 15px">Buy</button>
				</div>
				<div class="row col-md-1"></div>
				<div class="row col-md-5"
					style="height: 100px; width: 250px; margin-top: 15px; margin-bottom: 15px; margin-left: 15px; margin-right: 15px">
					<pre>
                       <label id="lblQuantity">Quantity :</label>  <input
							type="number" id="upDownQty" min="1" max="20" step="1" value="1"
							style="outline: 0; border: 0; border-top: 1px solid red; border-left: 1px solid red; border-right: 1px solid red; width: 200px;"
							required>
                       <label id="lblCost">Cost     :</label>  <input
							type="text" id="cost"
							style="outline: 0; border: 0; border-bottom: 1px solid red; border-left: 1px solid red; border-right: 1px solid red; width: 200px;"
							value=0 readonly>
                    </pre>
				</div>
			</div>
		</div>
	</div>
	<input type="text" id="cName" name="cName" />
	<input type="text" id="price">
	<div>
		<div id="dialog-message" title="Insufficient Balance"
			style="background-color: yellow">
			<p id="alert" style="background-color: yellow">
				<span class="ui-icon ui-icon-circle-check"
					style="float: left; margin: 0 7px 50px 0;"></span> Sorry, your
				balance is insufficient to buy these stocks.
			</p>
		</div>
		
	</div>
</body>

<script type="text/javascript">
	//This script is to set time for the game

	function countDownFunction() {
		var i = 2;
		document.getElementById('lblCountdown').style.fontSize = '1000%';
		document.getElementById('lblCountdown').innerHTML = 1;
		function myLoop() {
			setTimeout(
					function() {
						document.getElementById('lblCountdown').style.fontSize = '1000%';
						document.getElementById("lblCountdown").innerHTML = i;
						i++;
						if (i <= 10) {
							myLoop();
						}
					}, 10000)
		}
		myLoop();
	}
</script>

<script type="text/javascript">

	//Load company details when click on the stock market table

	var table = document.getElementById("tblStock");
	for (var i = 1; i < table.rows.length; i++) {
		table.rows[i].onclick = function() {

			document.getElementById("cName").value = this.cells[0].innerHTML;
			document.getElementById("price").value = this.cells[1].innerHTML;
			var price = this.cells[1].innerHTML;
			document.getElementById("upDownQty").value = 1;
			document.getElementById("cost").value = price
					* document.getElementById("upDownQty").value;

			$
					.ajax({
						type : "GET",
						url : "${pageContext.request.contextPath}/displayDetails",
						data : {
							"cName" : document.getElementById("cName").value
						},
						success : function(data) {

							document.getElementById("lblName").innerHTML = "Name    :";
							document.getElementById("lblSector").innerHTML = "Sector  :";
							document.getElementById("lblDetails").innerHTML = "Details :";

							document.getElementById("name2").innerHTML = data.companyName;
							document.getElementById("name3").innerHTML = data.sectorName;
							document.getElementById("name4").innerHTML = "Official Website";
							$("a#name4").attr('href', data.details);

						}
					});
		};
	}
</script>

<script type="text/javascript">

	//This code is for selling, when click on the bought stock table this set of code is executed

	var table = document.getElementById("tblShares");

	for (var i = 1; i < table.rows.length; i++) {

		table.rows[i].onclick = function() {
			
			alert("you clicked the right table");
			
			document.getElementById("btnTrade").innerHTML = "Sell";
			document.getElementById("cName").value = this.cells[0].innerHTML;
			document.getElementById("price").value = this.cells[1].innerHTML;
			var price = this.cells[1].innerHTML;
			document.getElementById("upDownQty").value = 1;
			document.getElementById("cost").value = price
					* document.getElemickkentById("upDownQty").value;

			$
					.ajax({
						type : "GET",
						url : "${pageContext.request.contextPath}/displayDetails",
						data : {
							"cName" : document.getElementById("cName").value
						},
						success : function(data) {

							document.getElementById("lblName").innerHTML = "Name    :";
							document.getElementById("lblSector").innerHTML = "Sector  :";
							document.getElementById("lblDetails").innerHTML = "Details :";

							document.getElementById("name2").innerHTML = data.companyName;
							document.getElementById("name3").innerHTML = data.sectorName;
							document.getElementById("name4").innerHTML = "Official Website";
							$("a#name4").attr('href', data.details);

						}
					});
		};
	}
</script>

<script>
	// Redirect to another page after certain time

	$(document).ready(function() {
		document.getElementById("alert").style.display = 'none';
		setTimeout(function() {
			$.ajax({
				type : "GET",
				url : "${pageContext.request.contextPath}/gameOverview",
				data : {

				},
				success : function(data) {

					window.location = '/gameOverview';

				}
			});
		}, 90000);
	});
</script>

<script type="text/javascript">
	//Add records to table shares bought by  player
	//first this method will check whether the company is already exist or not
	//if it does exist it will update the stock record
	//or else it will add a new record
	//then send data to the controller so it will be able to create bank and transaction records 

	function checkExist() {
		var rows = "";
		var cost = document.getElementById("cost").value;
		var cName = document.getElementById("cName").value;
		var price = document.getElementById("price").value;
		var qty = document.getElementById("upDownQty").value;
		var total = price * qty;
		var i;
		var y;
		var cName = document.getElementById("cName").value;
		var count = 0;
		var getRow;
		var z = document.getElementById("tblShares").rows.length;
		var p = document.getElementById("totStockVal").value;
		var balance = document.getElementById("balance").value;

		if (balance >= total) {
			for (var i = 0; i < z; i++) {
				var x = document.getElementById("tblShares").rows[i].cells[0].innerHTML;

				if (x == cName) {
					count = count + 1;
					y = i;
				}
			}

			if (count != 0) {
				document.getElementById("tblShares").rows[y].cells[2].innerHTML = Number(document
						.getElementById("tblShares").rows[y].cells[2].innerHTML)
						+ Number(qty);

				document.getElementById("tblShares").rows[y].cells[3].innerHTML = Number(document
						.getElementById("tblShares").rows[y].cells[3].innerHTML)
						+ Number(cost);
				document.getElementById("totStockVal").value = (Number(p) + Number(cost));
				document.getElementById("balance").value = balance
						- Number(cost);
			} else {
				rows += "<td>" + cName + "</td><td>" + price + "</td><td>"
						+ qty + "</td><td>" + total + "</td>";
				var tbody = document.querySelector("#tblShares tbody");
				var tr = document.createElement("tr");

				tr.innerHTML = rows;
				tbody.appendChild(tr);

				document.getElementById("totStockVal").value = (Number(p) + Number(total));
				document.getElementById("balance").value = balance- Number(cost);
			}

			$
					.ajax({
						type : "GET",
						url : "${pageContext.request.contextPath}/saveDetails",
						data : {
							"pName" : document.getElementById("playerName").value,
							"cName" : document.getElementById("cName").value,
							"turnNo" : document.getElementById("lblCountdown").innerText,
							"type" : document.getElementById("btnTrade").innerText,
							"unitPrice" : document.getElementById("price").value,
							"quantity" : document.getElementById("upDownQty").value,
							"amount" : document.getElementById("cost").value,
							"balance" : document.getElementById("balance").value
						},
						success : function(data) {
						}
					});

		}

		else {
			$(function() {
				$("#dialog-message").dialog({
					modal : true,
					buttons : {
						Ok : function() {
							$(this).dialog("close");
						}
					}
				});
			});
		}
	}
</script>

<script>   
 
// this is to update cost according to the quantity

$("#upDownQty").bind('keyup mouseup', function () {
   // alert("changed");   
       var qty = $(this).val();
       var price = document.getElementById("price").value
       
       document.getElementById("cost").value = qty*price
       
});
</script>

</html>