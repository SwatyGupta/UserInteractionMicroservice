<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<title>NOA Request</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <!--<link rel="stylesheet" type="text/css" href="css/global.css">-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style>
	body{
	background: url('Hospital-Management.png');
	background-repeat: no-repeat;
    background-position: center center;
    background-attachment: fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
	}
	
	.button {
    border: 3px;
	border-radius: 25px;
    color: white;
    padding: 14px 30px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 2px 2px;
    cursor: pointer;
	 background-color: #4CAF50;
	}
  </style>

</head>
<body >
<div class="container-fluid" >
<div class="row">
<div class = "col-md-4 col-sm-4 col-xs-12"></div>
<div class = "col-md-4 col-sm-4 col-xs-12">
  <h2>Notice of Admission Response</h2>
	<hr>
			<form>
				<div class="form-group">
				  <label for="firstName">First Name:</label>
					<input type="text" readonly class="form-control" id="firstName" value = "${firstName }">
				 </div>
				
				<div class="form-group">
				  <label for="lastName">Last Name:</label>
					<input type="text" readonly class="form-control" id="lastName"  value = "${lastName }">
				 </div>
				
				<div class="form-group">
				  <label for="serviceProvider">Service Provider:</label>
					<input type="text" readonly class="form-control" id="serviceProvider"  value = "${serviceProvider }">
				</div>
				
				<div class="form-group">
				  <label for="payer">Payer:</label>
					<input type="text" readonly class="form-control" id="payer" value = "${payer }">
				</div>
				
				<div class="form-group">
				  <label for="admissionDate">Admission Date:</label>
					<input type="text" readonly class="form-control" id="admissionDate"  value = "${admissionDate }">
				</div>
				
				<div class="form-group">
				  <label for="transactionType">Transaction Type:</label>
					<input type="text" readonly class="form-control" id="transactionType"  value = "${transactionType }">
				</div>
				
				<div class="form-group">
				  <label for="transactionDate">Transaction Date:</label>
					<input type="text" readonly class="form-control" id="transactionDate"  value = "${transactionDate }">
				</div>
				
				<div class="form-group">
				  <label for="transactionTime">Transaction Time:</label>
					<input type="text" readonly class="form-control" id="transactionTime"  value = "${transactionTime }">
				</div>
				
				<div class="form-group">
				  <label for="facilityTypeCode">Facility Type Code:</label>
					<input type="text" readonly class="form-control" id="facilityTypeCode"  value = "${facilityTypeCode }">
				</div>
				
				<div class="form-group">
				  <label for="reviewDecisionReasonCode">Review Decision Reason Code:</label>
					<input type="text" readonly class="form-control" id="reviewDecisionReasonCode"  value = "${reviewDecisionReasonCode }">
				</div>
				
				<div class="form-group">
				  <label for="reviewIdentificationNumber">Review Identification Number:</label>
					<input type="text" readonly class="form-control" id="reviewIdentificationNumber"  value = "${reviewIdentificationNumber }">
				</div>
				
				<div class="form-group">
				  <label for="certificationActionCode">Certification Action Code:</label>
					<input type="text" readonly class="form-control" id="certificationActionCode"  value = "${certificationActionCode }">
				</div>
			
		</form>		
	</div>
	<div class = "col-md-4 col-sm-4 col-xs-12"></div> 
</div>
</div>
<script src="demo_script_src.js">
</script>
</body>
</html>