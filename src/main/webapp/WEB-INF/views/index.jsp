<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>index</title>
</head>
<body>

	<div class="container mt-5">
		<h1>Server Printer</h1>

		<form action="processDoc" method="POST" enctype="multipart/form-data">
			<div class="form-group mt-3">
				<label for="fileUp">Upload Your File Here</label> <input type="file"
					class="form-control" id="fileUp" name="fileUp">
			</div>

			<div class="form-check">
				<input class="form-check-input" type="checkbox" checked="checked"
					 name="instantPrint" id="instantPrint" value="true" >
				<input type="hidden" name="!instantPrint" value="false" > 
				<label class="form-check-label" for="instantPrint"> Get Instant Print</label>
			</div>

			<button class="btn btn-primary mt-3	" type="submit">Upload
				File</button>
		</form>

	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>