<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Modifica elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="/navbar.jsp" />
	
	<main role="main" class="container">
	
			<%-- alert con lista errori --%>
		<div class="alert alert-danger ${ingredienteDaModificare.hasErrors()?'':'d-none'}" role="alert">
			<c:forEach var ="errorItem" items="${ingredienteDaModificare.errors }">
	        	<ul>
					<li> ${errorItem }</li>	
				</ul>
	      	</c:forEach>
		</div>
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Modifica elemento</h5>
		    </div>
		    <div class='card-body'>
		    
		    		<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteModificaIngredienteServlet" novalidate="novalidate" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>descrizione<span class="text-danger">*</span></label>
								<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione" value="${ingredienteDaModificare.descrizione }" autocomplete="nope" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>prezzo<span class="text-danger">*</span></label>
								<input type="text" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo" value="${ingredienteDaModificare.prezzo}" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>codice <span class="text-danger">*</span></label>
								<input type="text" class="form-control" name="codice" id="codice" placeholder="Inserire il cognome" value="${ingredienteDaModificare.codice }" required>
							</div>

						</div>
							<input type ="hidden" name="id" value ="${ingredienteDaModificare.id}">
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>

						<br/>
					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>