<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>


<head>
<meta charset="ISO-8859-1">
<title>Market Phobia</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="/static/css/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link rel="icon" type="image/gif" href="images/title-bar-logo.png" />
<style>
#dialogoverlay{
	display: none;
	opacity: .8;
	position: fixed;
	top: 0px;
	left: 0px;
	background: #FFF;
	width: 100%;
	z-index: 10;
}
#dialogbox{
	display: none;
	position: fixed;
	background: #000;
	border-radius:7px; 
	width:550px;
	z-index: 10;
}
#dialogbox > div{ background:#FFF; margin:8px; }
#dialogbox > div > #dialogboxhead{ background: #666; font-size:19px; padding:10px; color:#CCC; }
#dialogbox > div > #dialogboxbody{ background:#333; padding:20px; color:#FFF; }
#dialogbox > div > #dialogboxfoot{ background: #666; padding:10px; text-align:right; }
</style>


</head>


<!-- ================================================================================================= -->

<body onload="functionOnload()">
	<div class="container">
		<div class="col-md-4">
			<p id="demo" style="display: none"></p>
			<div class="stockgame1">

				<div class="userlogofront">
				 	<div class="playername">
					
					
					<div class="example1">
                     <div class="ex"></div>
                   </div>
					
					
					</div> 
				</div>


				<div class="tno">
					<table>
						<tr>
							<td>
								<div id="turn" style="height: 36px;">TURN NO :</div>
							</td>
							<td>
								<div id="lblCountdown">
									<label id="labelcountdown"></label>
								</div>
							</td>
							<td><label id="countdownno"> </label></td>
						</tr>
					</table>
				</div>
				<br>
				<div class="table">
				  
					<table id="tblStock" class="table table-black table-reponsive" style="cursor: pointer;">
					<thead>
                           
                            <tr>
                              
							 	<th class="col-md-6">Company Name</th>  
							  	<th class="col-md-6">Current Stock Price</th>
							</tr>

						
							
						</thead>
					      
                          
						 <tbody style="cursor: pointer;">
							
								<tbody id="demoTable" style="cursor: pointer;">
								</tbody>
					  <!-- </tbody> -->	
					  	
					  		
					  	
					</table>
							<br>
							<br>
					
				</div>
			</div>
			<br>
		</div>


		<!-- ==========================================Container 1 END====================================== -->

		<!--============================================ Container 2 =========================================-->


		<div class="col-md-4">
			<div class="stockgame2">
				
				
				
				<div class="form-group1">
					<div class="d-block p-2 text-black">
					  	
					   
						<p class="neon" data-text="[neon_light]">ANALYSIS 1</p>
					 <div class="analysis">
					 
					<div class="suggest1">
					
						
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					
						
					</div>	
				   </div>
					</div>
					
					</div>
					<br> 



					<!-- Stock Details ======================= -->

					<div class="stockdetails">
						<div class="form-group">
							<div class="d-block p-2 bg-primary text-white">
								<div class="stock">
									<label id="labelstock" for="text">Stock Details </label>
									<div class="d-block p-2 prestock ">
										<div>
											<br>
											<br> <label id="lblName"></label> <label id="name2"></label><br>
											<label id="lblSector"></label> <label id="name3"></label><br>
											<label id="lblDetails"></label> <a id="name4" target="_blank"></a><br>
											<br>
											<br>
											<br>
											<br>
											<br>
											<br>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					
					
                   <div class="row centered">
					<div class="d-block p-2 userdisplay">
					
							<div class="row">
						<!--  	<div class="userdisplay1">	-->
						    <div class="col-md-4 text-center">
									<div>
										<span class="d-block p-2 blink">
											<button id="btnTrade" class="userbutton" name="btnTrade"
												type="button" onclick="checkExist()">BUY</button>
										</span>
									</div>
							</div>
							
									
			
							
							<!-- quantity ============================ -->
							
							<div class="col-md-4 form-label text-center">
                             <div class="text-center qty">
					              <label for="text">Quantity</label>
						                 <input class="form-control qtyinput" type="number" id="upDownQty" min="1"
											max="10000" step="1" value="1" required>
				             </div>
					       </div>		
							
							<!-- Price ============================ -->
							
							     	<div class="col-md-4 form-label text-center centered">
                                      <div class="text-center qty">
										<label for="text">Cost</label>
										<input type="text" class="form-control qtyinput" id="cost" value=0 readonly>
									</div>		
							      </div>		
									
							
			<!--  		</div>-->
					</div>
					
					</div>
					</div>
				    
			</div>
		</div>
         

		<!-- Container 3 ===================-->

		<div class="col-md-4">
			<div class="stockgame3">
				<form action="">
					<div class="userimage">
						<img src="/static/img/user.jpg" class="img-circle"
							alt="Cinque Terre" width="70" height="70">
					</div>


					<!-- player name Value ============================ -->
					
               <div class="valuedisplay">
					<div class="row">
					   <label class="col-md-6 form-label text-right" for="text">Player Name :</label>
						  <input class="col-md-6 form-control playernamelabel" type="text" name="pName" id="playerName" value="${pName}" readonly>
				   </div>
              </div>
              <br>
                    <!-- Account Balance ============================ -->

               <div class="valuedisplay">
					<div class="row">
					   <label class="col-md-6 form-label text-right" for="text">Account Balance (Rs) :</label>
						  <input class="col-md-6 form-control playernamelabel" type="text" id="balance" value="${balance}" readonly>
				   </div>
              </div>
              <br>
              
              
              
         
              
                <!-- Stock value ============================ -->

               <div class="valuedisplay">
					<div class="row">
					   <label class="col-md-6 form-label text-right" for="text">Stock Value (Rs) :</label>
						  <input class="col-md-6 form-control playernamelabel" style="font-size:16px; height:32px; border-radius:20px;" type="text" id="totStockVal" value="0" readonly>
				   </div>
              </div>
              
              <br>
              
          
              
              
              

					
				</form>
                 

				<!-- ========================Invested Amount================================= -->

				<form>
					



					<!-- Value ======================= -->

					<div class="stockdisplay">
						<div class="form-group1">
							<div class="d-block p-2 text-white">
								<div class="stockvalue1">

									<div class="table">

										<table id="tblShares" class="table" style="cursor: pointer;">
											<thead>
												<tr>
												   
													<th class="col-md-4 company">Company</th>
													<th class="col-md-4 text-right">Current Price</th>
													<th class="col-md-2 shares">Shares</th>
													<th class="col-md-2 Value">Value</th>
												
												</tr>
											</thead>
											<tbody style="cursor: pointer;">

												
                                                
													<tbody class="tbody" style="cursor: pointer;">
													</tbody>
												
												</table>

										    <br>

									</div>
								</div>
							</div>
						</div>
					</div>
					
				</form>
			</div>
		</div>



	</div>
	<input type="hidden" id="cName" name="cName" />

	<input type="hidden" id="index" name="index">

	<input type="hidden" id="price" name="price">

	<div>
		<div id="dialog-message" title="Insufficient Balance"
			style="background-color: yellow">
			<p id="alert" style="background-color: yellow">
				<span class="ui-icon ui-icon-circle-check"
					style="float: left; margin: 0 7px 50px 0;"></span> Sorry, your
				balance is insufficient to BUY these stocks.
			</p>
		</div>

	</div>
<div id="dialogoverlay"></div>
<div id="dialogbox">
  <div>
    <div id="dialogboxhead"></div>
    <div id="dialogboxbody"></div>
    <div id="dialogboxfoot"></div>
  </div>
</div>

</body>


<!-- ============================================================================================================= -->

<!--===============================MY DOC============================================================  -->



<script type="text/javascript">
	function functionOnload() {

		countDown();
		countDownFunction();
		getStockMarketDetailFromService();
		shareTblPriceUpdate();
		totalAmountUpdateWithCurrentValue();
		disableBackButton();

	}
</script>

<script>
	//This script is to set time for the game
	var x = 0;
	function countDown() {

		var i = 8;

		document.getElementById('countdownno').style.fontSize = '150%';
		document.getElementById('countdownno').innerHTML = 9;
		function myLoop2() {
			setTimeout(
					function() {

						var turnz = document.getElementById('labelcountdown').textContent;
						document.getElementById('countdownno').style.fontSize = '150%';
						document.getElementById("countdownno").innerHTML = i;

						i--;
						if (i >= 0) {
							myLoop2();
						} else {
							if (turnz != '30') {

								i = 9;
								myLoop2();
							} else {
								$
										.ajax({
											type : "GET",
											url : "${pageContext.request.contextPath}/gameOverview",
											data : {

											},
											success : function(data) {

												window.location = '/gameOverview';

											}
										});

							}

						}
					}, 1000)
			x++;
		}
		myLoop2();
	}
</script>

<script type="text/javascript">
	//This script is to set time for the game
	var x = 0;
	function countDownFunction() {
		document.getElementById("btnTrade").disabled = true;
		var i = 2;
		document.getElementById('labelcountdown').style.fontSize = '300%';
		document.getElementById('labelcountdown').innerHTML = 1;
		function myLoop() {
			setTimeout(
					function() {
						document.getElementById('labelcountdown').style.fontSize = '300%';
						document.getElementById("labelcountdown").innerHTML = i;

						i++;
						if (i <= 30) {
							myLoop();
						}
					}, 10000)
			x++;
		}
		myLoop();
	}
</script>
<script type="text/javascript">
	function shareTblPriceUpdate() {

		var tblSharesRows = document.getElementById("tblShares").rows.length;
		var tblStockRows = document.getElementById("tblStock").rows.length;

		for (var y = 0; y < tblSharesRows; y++) {

			for (var z = 0; z < tblStockRows; z++) {

				if ((document.getElementById("tblShares").rows[y].cells[0].innerHTML) == (document
						.getElementById("tblStock").rows[z].cells[0].innerHTML)) {

					document.getElementById("tblShares").rows[y].cells[1].innerHTML = document
							.getElementById("tblStock").rows[z].cells[1].innerHTML;

					var unitPrice = document.getElementById("tblShares").rows[y].cells[1].innerHTML;
					var qty = document.getElementById("tblShares").rows[y].cells[2].innerHTML;
					//updating the amount column according to current price
					document.getElementById("tblShares").rows[y].cells[3].innerHTML = (Number(unitPrice) * Number(qty))
							.toFixed(2);
					// and schedule a repeat

				}

			}
			if ((document.getElementById("tblShares").rows[y].cells[0].innerHTML) == (document
					.getElementById("name2").innerHTML)){
				
			    var currentVal = document.getElementById("tblShares").rows[y].cells[1].innerHTML;
			     document.getElementById("cost").value = ((Number(currentVal)).toFixed(2))*(Number(document.getElementById("upDownQty").value));
				
			}
	
		}

		setTimeout(shareTblPriceUpdate, 10000);
	}

	// start the cycle
	shareTblPriceUpdate();
</script>

<script type="text/javascript">
	var sum = 0;
	function totalAmountUpdateWithCurrentValue() {

		var tblSharesRows = document.getElementById("tblShares").rows.length;

		for (var z = 1; z < tblSharesRows; z++) {
			sum = Number(sum)
					+ Number(document.getElementById("tblShares").rows[z].cells[3].innerHTML);

		}
		var amount = sum;
		document.getElementById("totStockVal").value = (Number(amount))
				.toFixed(2);
		sum = 0;

		setTimeout(totalAmountUpdateWithCurrentValue, 10000);
	}

	// start the cycle
	totalAmountUpdateWithCurrentValue();
</script>

<script type="text/javascript">
	//pass data to controller

	function passData(qty, amount) {

		$.ajax({
			type : "GET",
			url : "${pageContext.request.contextPath}/saveDetails",
			data : {
				"pName" : document.getElementById("playerName").value,
				"cName" : document.getElementById("cName").value,
				"turnNo" : document.getElementById("lblCountdown").innerText,
				"type" : document.getElementById("btnTrade").innerText,
				"unitPrice" : document.getElementById("price").value,
				"quantity" : qty,
				"amount" : amount,
				"balance" : document.getElementById("balance").value
			},
			success : function(data) {
			}
		});

	}
</script>


<script>

	$(document).ready(function() {
		document.getElementById("alert").style.display = 'none';
		setTimeout(function() {
			
			var name = document.getElementById("playerName").value;
		
		    window.location.href = ("/gameOverview?Pname="+name);

		}, 40000); // 310000
	});

</script>

<script type="text/javascript">
	//Add records to table shares bought by  player
	//first this method will check whether the company is already exist or not
	//if it does exist it will update the stock record
	//or else it will add a new record
	//then send data to the controller so it will be able to create bank and transaction records 
	function checkExist() {
		var type = document.getElementById("btnTrade").innerHTML;
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
		var z = document.getElementById("tblShares").rows.length;
		var totStock = document.getElementById("totStockVal").value;
		var balance = document.getElementById("balance").value;

		if (type == "BUY") {
			var qty = document.getElementById("upDownQty").value;
			if (balance >= Number(document.getElementById("cost").value))//total
			{
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
					document.getElementById("totStockVal").value = ((Number(totStock) + Number(cost)))
							.toFixed(2);
					document.getElementById("balance").value = (balance - Number(cost))
							.toFixed(2);
				} else {
					total = total.toFixed(2);
					rows += "<td class='col-md-6'>" + cName + "</td><td class='col-md-2 text-center'>" + price + "</td><td class='col-md-2 text-center'>"
							+ qty + "</td><td class='col-md-2 text-center'>" + total + "</td>";
					var tbody = document.querySelector("#tblShares tbody");
					var tr = document.createElement("tr");

					tr.innerHTML = rows;
					tbody.appendChild(tr);

					document.getElementById("totStockVal").value = ((Number(totStock) + Number(total)))
							.toFixed(2);
					document.getElementById("balance").value = (balance - Number(cost))
							.toFixed(2);
				}

				passData(qty, cost);

				document.getElementById("upDownQty").value = "1";
				var tableSharesRows = document.getElementById("tblStock").rows.length;
				for (var z = 1; z < tableSharesRows; z++) {

					if (document.getElementById("tblStock").rows[z].cells[0].innerHTML == document
							.getElementById("name2").innerHTML) {
				
						   document.getElementById("cost").value = document.getElementById("tblStock").rows[z].cells[1].innerHTML;

					}
				}



			}

			else {

				Alert.render('Sorry, your balance is insufficient!')

			
				
		document.getElementById("upDownQty").value = "1";
				var tableSharesRows = document.getElementById("tblShares").rows.length;
				for (var z = 1; z < tableSharesRows; z++) {

					if (document.getElementById("tblShares").rows[z].cells[0].innerHTML == document
							.getElementById("name2").innerHTML) {
				
						   document.getElementById("cost").value = (Number(document.getElementById("tblShares").rows[z].cells[1].innerHTML)).toFixed(2);

					}
				}

				
				
			}
		}

		if (type == "SELL") {

			var x = (Number(document.getElementById("index").value) + 1);
			var qty = document.getElementById("upDownQty").value;
			var tblqty = document.getElementById("tblShares").rows[x].cells[2].innerHTML;

			if ((Number(tblqty)) == (Number(qty))) {

				var amount = document.getElementById("tblShares").rows[x].cells[3].innerHTML;

				var unitPrice = document.getElementById("tblShares").rows[x].cells[1].innerHTML;

				document.getElementById("totStockVal").value = ((Number(totStock) - Number(amount)))
						.toFixed(2);

				document.getElementById("balance").value = (Number(balance) + (Number(amount))).toFixed(2);

				passData(tblqty, amount);

				document.getElementById('tblShares').deleteRow(x);

				document.getElementById("lblName").innerHTML = "";
				document.getElementById("lblSector").innerHTML = "";
				document.getElementById("lblDetails").innerHTML = "";

				document.getElementById("name2").innerHTML = "";
				document.getElementById("name3").innerHTML = "";
				document.getElementById("name4").innerHTML = "";
				document.getElementById("upDownQty").value = 1;
				document.getElementById("cost").value = 0;

			}
			
			
			if((Number(tblqty)) < (Number(qty))){
				
				Alert.render("Invalid Quantity! You only have "+tblqty+" stock on hand");
				document.getElementById("upDownQty").value = 1;
				var tblSharesRows = document.getElementById("tblShares").rows.length;
				for (var y = 0; y < tblSharesRows; y++) {

					
					if ((document.getElementById("tblShares").rows[y].cells[0].innerHTML) == (document
							.getElementById("name2").innerHTML)){
						
					     document.getElementById("cost").value = document.getElementById("tblShares").rows[y].cells[1].innerHTML;
					     document.getElementById("cost").value = (Number(document.getElementById("cost").value)*(Number(document.getElementById("upDownQty").value))).toFixed(2);
						
					}
								
				}
			}

			if (tblqty > qty) {
				
				var qty = document.getElementById("upDownQty").value;
				var amount = document.getElementById("tblShares").rows[x].cells[3].innerHTML;
				var unitPrice = document.getElementById("tblShares").rows[x].cells[1].innerHTML;
				
				
      document.getElementById("tblShares").rows[x].cells[3].innerHTML = (Number(amount) - (Number(qty) * Number(unitPrice))).toFixed(2);
				document.getElementById("tblShares").rows[x].cells[2].innerHTML = (Number(tblqty) - Number(qty));
				document.getElementById("totStockVal").value = ((Number(totStock) - (Number(qty) * Number(unitPrice))))
						.toFixed(2);
				document.getElementById("balance").value = ((Number(balance) + (Number(qty) * Number(unitPrice))))
						.toFixed(2);			
				
				//passData(qty, cost);

			}
			passData(qty, cost);
			document.getElementById("upDownQty").value = "1";
			var tableSharesRows = document.getElementById("tblStock").rows.length;
			for (var z = 1; z < tableSharesRows; z++) {

				if (document.getElementById("tblStock").rows[z].cells[0].innerHTML == document
						.getElementById("name2").innerHTML) {
			
					   document.getElementById("cost").value = (parseFloat(document.getElementById("tblStock").rows[z].cells[1].innerHTML)).toFixed(2);

				}
			}

		}

	}
</script>

<script>
	// this is to update cost according to the quantity

	$("#upDownQty").bind('keyup mouseup', function() {
		
        var tblStockRows = document.getElementById("tblStock").rows.length;
		var qty = $(this).val();

		for (var y = 0; y < tblStockRows; y++) {
		
		  if ((document.getElementById("tblStock").rows[y].cells[0].innerHTML) == (document
					.getElementById("name2").innerHTML))
		  {
				  var currentPrice = document.getElementById("tblStock").rows[y].cells[1].innerHTML;
				  document.getElementById("cost").value = ((parseFloat(currentPrice)).toFixed(2))*(Number(qty));
			}




		}
		
	});
</script>

<script>
	$("#tblShares")
			.delegate(
					"tr",
					"click",
					function(event) {
						var index = $(this).index();

						document.getElementById("btnTrade").innerHTML = "SELL";
						document.getElementById("cName").value = this.cells[0].innerText;
						document.getElementById("price").value = this.cells[1].innerText;
						document.getElementById("index").value = index;
					

						document.getElementById("cost").value = ((Number(document
								.getElementById("price").value)) * (Number(document
								.getElementById("upDownQty").value)));

						var table = document.getElementById("tblShares");
						var price = document.getElementById("price").value;
						var qty = document.getElementById("upDownQty").value;
						var cost = document.getElementById("cost").value;
						for (var i = 0; i < table.rows.length; i++) {

							table.rows[i].onclick = function() {

								document.getElementById("btnTrade").innerHTML = "SELL";
								document.getElementById("cName").value = this.cells[0].innerText;
								price = this.cells[1].innerText;
								document.getElementById("index").value = $(this)
										.index();

								document.getElementById("cost").value = ((Number(document
										.getElementById("price").value)) * (Number(document
										.getElementById("upDownQty").value)));

								$
										.ajax({
											type : "GET",
											url : "${pageContext.request.contextPath}/displayDetails",
											data : {
												"cName" : document
														.getElementById("cName").value
											},
											success : function(data) {

												document
														.getElementById("lblName").innerHTML = "Name    :";
												document
														.getElementById("lblSector").innerHTML = "Sector  :";
												document
														.getElementById("lblDetails").innerHTML = "Details :";

												document
														.getElementById("name2").innerHTML = data.companyName;
												document
														.getElementById("name3").innerHTML = data.sectorName;
												document
														.getElementById("name4").innerHTML = "Official Website";
												$("a#name4").attr('href',
														data.details);

											}
										});
							}
						}
				document.getElementById("upDownQty").value = 1;
					});
</script>
<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  -->
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

		var table = document.getElementById("tblStock");
		document.getElementById("demo").innerHTML = response.companies.length;
		for (var i = 0; i < response.companies.length; i++) {

			var object = response.companies[i];
			var row = table.insertRow(i);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			table.rows[i].cells[0].innerHTML = object['companyName'];
			table.rows[i].cells[1].innerHTML = object.turns[turn].price;
		}

		setTimeout(function() {
			turn++;
			if (turn < noTurns) {

				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				table.deleteRow(0);
				loop();
			}
		}, turnTimes)
	}
</script>
<script type="text/javascript">
	$(document)
			.on(
					'click',
					'#tblStock tr',
					function(e) {
						document.getElementById("btnTrade").disabled = false;
						e.stopPropagation();
						var index = $(this).index();

						document.getElementById("btnTrade").innerHTML = "BUY";
						document.getElementById("cName").value = this.cells[0].textContent;
						document.getElementById("price").value = this.cells[1].textContent;
						var price = document.getElementById("price").value;
						document.getElementById("upDownQty").value = 1;
						document.getElementById("cost").value = price
								* document.getElementById("upDownQty").value;

						$
								.ajax({
									type : "GET",
									url : "${pageContext.request.contextPath}/displayDetails",
									data : {
										"cName" : document
												.getElementById("cName").value
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
<script>
function CustomAlert(){
    this.render = function(dialog){
        var winW = window.innerWidth;
        var winH = window.innerHeight;
        var dialogoverlay = document.getElementById('dialogoverlay');
        var dialogbox = document.getElementById('dialogbox');
        dialogoverlay.style.display = "block";
        dialogoverlay.style.height = winH+"px";
        dialogbox.style.left = (winW/2) - (550 * .5)+"px";
        dialogbox.style.top = "100px";
        dialogbox.style.display = "block";
        document.getElementById('dialogboxhead').innerHTML = "Warning";
        document.getElementById('dialogboxbody').innerHTML = dialog;
        document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Alert.ok()">OK</button>';
    }
	this.ok = function(){
		document.getElementById('dialogbox').style.display = "none";
		document.getElementById('dialogoverlay').style.display = "none";
	}
}
var Alert = new CustomAlert();
</script>
</html>











