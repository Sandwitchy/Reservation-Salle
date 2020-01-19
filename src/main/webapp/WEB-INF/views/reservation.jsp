<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Reservation de salle</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body >
<div class="ml-auto mr-auto" style="width: 50%; min-height:100%;background-color: rgba(52, 146, 235,0.3)">
	<div class="container p-5">
		<h3>Reservation de la salle ${ salle }</h3>
		<form:form servletRelativeAction=""  modelAttribute="reservationsDto" acceptCharset="utf-8">
			<input type="hidden" name="salle" value="${salle}"/>
			<div class="row">
				<div class="col">
				  <div class="form-group">
					<label for="dateDebut">Date de debut</label>
					<form:input type="date" class="form-control" id="dateField" path="dateDebut"/>
					  <small class="text-danger"><form:errors  path="dateDebut"/></small>
				  </div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="duree">Duree</label>
						<form:input type="number" class="form-control" id="duree" path="duree"/><small class="text-danger"><form:errors path="duree"/></small>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
				  <div class="form-group">
					<label for="nom">Nom</label>
					  <form:input type="text" class="form-control" id="nom" path="nom"/><small class="text-danger"><form:errors path="nom"/></small>
				  </div>
				</div>
			</div>
		  <div class="form-group">
			<label for="description">Description</label>
			  <form:textarea type="text" class="form-control" id="description" path="description"></form:textarea>
			  <small class="text-danger"><form:errors path="description"/></small>
		  </div>
		  <div class="form-group">

			<label>Participant :</label>
			<div id="participants">
				<div class="form-group">
					<input type="text" class="form-control" name="participants"><small class="text-danger"><form:errors path="participants"/></small>
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
<input type="text" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
<div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
	<div class="input-group-text"><i class="fa fa-calendar"></i></div>
</div>
</body>
<script>
	var nbParticipant = 1;
	function ajoutParticipant(){
		document.getElementById("participants").insertAdjacentHTML('beforeend',
				"<div class='form-group'><input type='text' class='form-control' name='participants'></div>");
		nbParticipant++;
	}
</script>
</html>