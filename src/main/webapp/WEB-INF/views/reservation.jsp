<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reservation de salle</title>
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css"/>
	
</head>
<body >
<div class="row">
	<div class="col" style="width: 50%; min-height:100%;background-color: rgba(52, 146, 235,0.3)">
		<div class="container p-5">
			<h3>Reservation de la salle 201</h3>
			<form:form servletRelativeAction="reservation" modelAttribute="reservationsDto" acceptCharset="utf-8">
				
				<div class="row">
					<div class="col">
					  <div class="form-group">
					    <label for="dateDebut">Date de debut</label>
					    <form:input type="datetime-local" class="form-control" id="dateDebut" path="dateDebut"/> <form:errors path="dateDebut"/>
					  </div>
				  	</div>
					<div class="col">
						<div class="form-group">
						    <label for="duree">Duree</label>
						    <form:input type="number" class="form-control" id="duree" path="duree"/><form:errors path="duree"/>
					  	</div>
				  	</div> 
				</div>
				<div class="row">
					<div class="col">
					  <div class="form-group">
					    <label for="nom">Nom</label>
					    <form:input type="text" class="form-control" id="nom" path="nom"/><form:errors path="nom"/>
					  </div>
					</div>
					<div class="col">
					  <div class="form-group">
					    <label for="salle">Salle</label>
					    <form:select class="form-control" id="salle" path="salle">
					      <option value="201">Salle 201</option>
					      <option value="202">Salle 202</option>
					      <option value="203">Salle 203</option>
					      <option value="204">Salle 204</option>
					      <option value="201">Salle 205</option>
					    </form:select>
					    <form:errors path="salle"/>
					  </div>
					</div>
				</div>
			  <div class="form-group">
			    <label for="description">Description</label>
			    <form:textarea type="text" class="form-control" id="description" path="description"></form:textarea>
			    <form:errors path="description"/>
			  </div>
			  <div class="form-group">
			  
			    <label>Participant :</label>
			    <div id="participants">
				    <div class="form-group">
				    		<input type="text" class="form-control" name="participants"><form:errors path="participants"/>
				    </div>
			    </div>
			    <div class="text-center">
			    <button type="button" class="btn btn-outline-primary" onclick="ajoutParticipant()">+</button>
			    </div>
			  </div>
			  <button type="submit" class="btn btn-primary">Réserver la salle</button>
			</form:form>
		</div>
	</div>
	<div class="col" style="min-height:100vh;background-image:url('assets/formation.jpg'); background-size:100% ; background-repeat: no-repeat;">
	</div>
</div>
</body>
<script>
	var nbParticipant = 1;
	function ajoutParticipant(){
		document.getElementById("participants").insertAdjacentHTML('afterend',
				"<div class='form-group'><input type='text' class='form-control' name='participants'></div>");
		nbParticipant++;
	}
</script>
</html>