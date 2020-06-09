<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


</head>
<body>

	<div class="container">
		<h1>Registrazione Impiegato</h1>
		<form action="" method="post">
		<c:choose>
		<c:when test="${dto  ne null}">
			<div class="form-group">
				<label for="nome">Inserisci Nome</label> <input type="text"
					class="form-control" id="nome" aria-describedby="nome" name="nome">

				
			</div>
			<div class="form-group">
				<label for="cognome">Inserisci Cognome</label> <input type="text"
					class="form-control" id="cognome" aria-describedby="cognome"
					name="cognome">
			</div>
			<div class="form-group">
				<label for="exampleInputDataDiNascita"> Data di nascita </label> <input
					type="date" required class="form-control" name="datadinascita"
					id="exampleInputDataDiNascita">

			
			</div>
			<div class="form-group">
				<label for="citta">Inserisci Città</label> <input type="text"
					class="form-control" id="citta" aria-describedby="citta"
					name="citta">
			</div>
			<div class="form-group">
				<label for="via">Inserisci indirizzo</label> <input type="text"
					class="form-control" id="via" aria-describedby="via" name="via">
			</div>
			<div class="form-group">
				<label for="exampleInputCodiceFiscale"> Codice Fiscale </label> <input
					type="text" required class="form-control" name="codicefiscale"
					id="exampleInputCodiceFiscale">
			</div>
			<div class="form-group">
				<label for="via">Titolo di studio</label> <input type="text"
					class="form-control" id="via" aria-describedby="via" name="via">
			</div>
			</c:when>
			<c:otherwise>





			<div class="form-group">
				<label for="nome">Inserisci Nome</label> <input type="text"
					class="form-control" id="nome" aria-describedby="nome" name="nome">
			</div>
			<div class="form-group">
				<label for="cognome">Inserisci Cognome</label> <input type="text"
					class="form-control" id="cognome" aria-describedby="cognome"
					name="cognome">
			</div>
			<div class="form-group">
				<label for="exampleInputDataDiNascita"> Data di nascita </label> <input
					type="date" required class="form-control" name="datadinascita"
					id="exampleInputDataDiNascita">
			</div>
			<div class="form-group">
				<label for="citta">Inserisci Città</label> <input type="text"
					class="form-control" id="citta" aria-describedby="citta"
					name="citta">
			</div>
			<div class="form-group">
				<label for="via">Inserisci indirizzo</label> <input type="text"
					class="form-control" id="via" aria-describedby="via" name="via">
			</div>
			<div class="form-group">
				<label for="exampleInputCodiceFiscale"> Codice Fiscale </label> <input
					type="text" required class="form-control" name="codicefiscale"
					id="exampleInputCodiceFiscale">
			</div>
			<div class="form-group">
				<label for="via">Titolo di studio</label> <input type="text"
					class="form-control" id="via" aria-describedby="via" name="via">
			</div>
			</c:otherwise>
			</c:choose>





			<button type="submit" class="btn btn-primary" id="inserisciBtn">Registra
				Impiegato</button>
			<button type="submit" class="btn btn-primary" id="modificaBtn">Aggiorna
				Impiegato</button>
			<button type="submit" class="btn btn-primary" id="eliminaBtn">Elimina
				Impiegato</button>
		</form>

		
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inserisciBtn").click(function(event) {
				$("#callType").prop("value", "INSERTIMPIEGATO");
			});
			$("#modificaBtn").click(function(event) {
				$("#callType").prop("value", "UPDATEIMPIEGATO");
			});
			$("#eliminaBtn").click(function(event) {
				$("#callType").prop("value", "DELETEIMPIEGATO");
			});
		});
	</script>
</body>
</html>