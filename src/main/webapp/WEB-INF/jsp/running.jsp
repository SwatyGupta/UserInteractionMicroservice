<!DOCTYPE html>
<html>
<head> 
<title>NOA Request sent successfully</TITLE> 
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<style>
.img {
	position:absolute;
	left:50%;
	top:50%;
	transform:translate(-50%,-50%);
}
</style>
<body>
<div class="container-fluid">
	<form action = "/response">
		<div class="img">
			<img src="carta.gif" ></img>
		</div>
		
		<div class="alert alert-success">
			<strong>Success!</strong> Notice of Admission request sent successfully. Click Response to see the response.<br>
			<button type="submit" class="button">Response</button>
		</div>
	</form>
</div>
</body>
</html>