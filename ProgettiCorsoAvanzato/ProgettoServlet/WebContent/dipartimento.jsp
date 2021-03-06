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
		<h1>Registrazione Dipartimento</h1>
		<form action="service" method="GET">
			<input type="hidden" name="callType" id="callType" value="">
			<c:choose>
				<c:when test="${dto  ne null}">
					<div class="form-group">
						<label for="nome">Inserisci Nome</label> <input type="text"
							class="form-control" id="nome" aria-describedby="nome"
							name="nome" value="<c:out value="${dto.nome}"/>">
					</div>
					<div class="form-group">
						<label for="descrizione">Inserisci Descrizione</label> <input
							type="text" class="form-control" id="descrizione"
							aria-describedby="descrizione" name="descrizione"
							value="<c:out value="${dto.descrizione}"/>">
					</div>
					<div class="form-group">
						<label for="partitaIva">Inserisci partita iva Azienda: </label> <input
							type="text" class="form-control" id="partitaIva"
							aria-describedby="partitaIva" name="partitaIva"
							value="<c:out value="${dto.nome}"/>">
					</div>

					<div class="form-group">
						<label for="nomeAzienda">Inserisci nome Azienda: </label> <input
							type="text" class="form-control" id="nomeAzienda"
							aria-describedby="nomeAzienda" name="nomeAzienda"
							value="<c:out value="${dto.descrizione}"/>">
					</div>
				</c:when>
				<c:otherwise>
					<div class="form-group">
						<label for="nome">Inserisci Nome</label> <input type="text"
							class="form-control" id="nome" aria-describedby="nome"
							name="nome">
					</div>
					<div class="form-group">
						<label for="descrizione">Inserisci Descrizione</label> <input
							type="text" class="form-control" id="descrizione"
							aria-describedby="descrizione" name="descrizione">
					</div>

					<div class="form-group">
						<label for="partitaIva">Inserisci partita iva Azienda: </label> <input
							type="text" class="form-control" id="partitaIva"
							aria-describedby="partitaIva" name="partitaIva">
					</div>

					<div class="form-group">
						<label for="nomeAzienda">Inserisci nome Azienda: </label> <input
							type="text" class="form-control" id="nomeAzienda"
							aria-describedby="nomeAzienda" name="nomeAzienda">
					</div>
				</c:otherwise>
			</c:choose>
			<button type="submit" class="btn btn-primary" id="inserisciBtn">Inserisci
				Dipartimento</button>
			<button type="submit" class="btn btn-primary" id="modificaBtn">Modifica
				Dipartimento</button>
			<button type="submit" class="btn btn-primary" id="eliminaBtn">Elimina
				Dipartimento</button>
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
				$("#callType").prop("value", "INSERTDIPARTIMENTO");
			});
			$("#modificaBtn").click(function(event) {
				$("#callType").prop("value", "UPDATEDIPARTIMENTO");
			});
			$("#eliminaBtn").click(function(event) {
				$("#callType").prop("value", "DELETEDIPARTIMENTO");
			});
		});
	</script>
</body>
</html>