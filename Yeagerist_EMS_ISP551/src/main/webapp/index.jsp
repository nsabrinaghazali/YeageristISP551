<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body
{
	margin:auto;
}
</style>
</head>
<body>
	<h1>MyMasjid: Event Management System</h1>
	<form method="post">
		<h2>--MOSQUE MANAGEMENT--</h2>
		 <h3>View Event</h3><br>
		 	 Choose Event:
		 	 <select name="selEvent">
		 	 	<option>Ramadhan Orphanage Community Service</option>
		 	 	<option>Aidilfitri Colouring Competition</option>
		 	 	<option>A drop of Iman talk with Ustaz Zayn</option>
		 	 </select>
		 	 <button type="button">View Event</button>
		 	 
		 <h3>Add Event</h3><br>
			 Event Name:<br>
			 <input type="text" name="eventName"><br>
			 Event Date:<br>
			 <input type="text" name="eventDate"><br>
			 Event Time:<br>
			 <input type="text" name="eventName"><br>
			 Other details:<br>
			 <input type="file"><br><br>
			 <button type="button">Add Event</button>
			 
		 <h3>Update Event</h3><br>
		 	 Choose Event:
		 	 <select name="selEvent">
		 	 	<option>Ramadhan Orphanage Community Service</option>
		 	 	<option>Aidilfitri Colouring Competition</option>
		 	 	<option>A drop of Iman talk with Ustaz Zayn</option>
		 	 </select>
		 	 <button type="button">Update Event</button>
		 	 
		 <h3>Delete Event Event</h3><br>
		 	 Choose Event:
		 	 <select name="selEvent">
		 	 	<option>Ramadhan Orphanage Community Service</option>
		 	 	<option>Aidilfitri Colouring Competition</option>
		 	 	<option>A drop of Iman talk with Ustaz Zayn</option>
		 	 </select>
		 	 <button type="button">Delete Event</button>
		 	 
	</form>

</body>
</html>