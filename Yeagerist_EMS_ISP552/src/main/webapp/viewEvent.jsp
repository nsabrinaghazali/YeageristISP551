<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Details</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
	body{
        text-align: center;
        background-color: #C7BBBC;
	    color: #555555;
	    margin-left:250px;
	    margin-right:250px;
	    margin-top:5px;}
	div{
		text-align: left;
		border-radius:5px;
		padding:5px;
		border-style:solid;
		background-color:#F6F5F0;}
	button{
		width:15%;
		background-color: #CED6E0;;
		padding: 14px 20px;
		margin: 8px 0;
		border: none;
		border-radius: 4px;
		cursor: pointer;
		color:#555555;}
</style>
</head>
<body>
	<h1>EVENT MANAGEMENT SYSTEM</h1>
	<h2>Event Details</h2>
	<hr>
	<a href="ListEventController">
		<button>Back</button>
	</a><br><br>
	<div>
		ID: <c:out value="${e.id}"/><br><br>
		EVENT NAME: <c:out value="${e.name}"/><br><br>
		EVENT TYPE: <c:out value="${e.type}"/><br><br>
		NO OF PARTICIPANT:<c:out value="${e.participant}"/><br><br>
	</div>
	
</body>
</html>