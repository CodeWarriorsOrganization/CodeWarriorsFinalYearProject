<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="shortcut icon" type="image/x-icon" href="/static/img/title-bar-logo.png" />
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
.body{
background-image:url("static/img/UI-without-buttons.svg");
}
</style>
</head>
<body>
	 <div class="containerback">
       <div class="row centered-form">
         <div class="col-md-4">
            <div>
               <form action="waitingScreen" method="post">
		
     <div class="logtable">
       <table>
         <tr>
           <td> 
             <div>
       
        <div class="">
             <input type="text" name="txtGetName" class="form-control" id="enternametext" placeholder="Enter Player Name" size="75" required /> 
           
         
       </div> 
       
       
       
       
       <!-- <button type="button"  class="entername"></button>-->
        
        </div>
      </td>
      
      <td>
      
        <div>
         <a href="http://localhost:8085/final/gamescrn.html"><input type="submit" name="btnPlay" class="playnow"size="75" value=""/> </a>
        
        
        
        
        </div>
             
        </td>
     </tr> 
     
     <tr><td>  <label id="errormsg" style="color: red;text-align:center;">${errorMSG}</label>    
              <span class="validity"></span>    </td></tr>
     
       
     </table>
     </div>  
    
    
    </form>
    </div>
    
    
     </div>
    </div>
   </div>
	
	
</body>
</html>