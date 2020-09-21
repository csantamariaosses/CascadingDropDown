<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="conatiner">
		<div class="row">
			<div class="col-12">
				<h3>ComboBox Dependientes</h3>
				<form>
					<table>
						<tr>
							<td>Country:</td>
							<td><select name="comboboxCountry" id="comboboxCountry">
									<option value="0">Seleccione...</option>
									<c:forEach var="data" items="${countries}">
										<option value="${data.id}">${data.nombre}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>State:</td>
							<td><select name="comboboxState" id="comboboxState">
									<option value="0">Seleccione...</option>
							</select></td>
						</tr>
						<tr>
							<td>City:</td>
							<td><select name="comboboxCity" id="comboboxCity">
									<option value="0">Seleccione...</option>
							</select></td>
						</tr>
					</table>
				</form>

			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script>
$(document).ready ( function () {

	$("#comboboxCountry").change( function() {
		var countryId = $(this).val();
		$("#comboboxCity").html( '<option value="0">Selecione...</option>' );  
		$.ajax({
			type: 'GET',
			url : '${pageContext.request.contextPath}/loadStatesByCountry/' + countryId,
			success:function( result ) {
				var obj = JSON.parse( result );
				var length = Object.keys(obj).length; //you get length json result 4
				var s = '<option value="0">Seleccione...</option>';
				for(dato of obj) {
					s += '<option value="' + dato.id + '">' + dato.nombre + '</option>';
				}

				$("#comboboxState").html( s );  
		    }
		});
	});

	$("#comboboxState").change( function() {
		var id = $(this).val();
		$.ajax({
			type: 'GET',
			url : '${pageContext.request.contextPath}/loadCitiesByState/' + id,
			success:function( result ) {
				var obj = JSON.parse( result );
				var length = Object.keys(obj).length; //you get length json result 4
				var s = '<option value="0">Seleccione...</option>';
				for(dato of obj) {
					s += '<option value="' + dato.id + '">' + dato.nombre + '</option>';
				}

				$("#comboboxCity").html( s );  
		    }
		});
	});
});
</script>

</body>
</html>