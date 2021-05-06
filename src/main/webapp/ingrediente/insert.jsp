<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="/header.jsp" />
	<title>Inserisci nuovo</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="/navbar.jsp" />
	
	<main role="main" class="container">
	
		<%-- alert con lista errori --%>
		<div class="alert alert-danger ${insert_ingrediente_attr.hasErrors()?'':'d-none'}" role="alert">
			<c:forEach var ="errorItem" items="${insert_ingrediente_attr.errors }">
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
		        <h5>Inserisci nuovo elemento</h5> 
		    </div>
		    <div class='card-body'>
		    
		    		<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteInsertIngredienteServlet" novalidate="novalidate" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Descrizione</label>
								<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione" value="${insert_ingrediente_attr.descrizione}" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Prezzo</label>
								<input type="text" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo" value="${insert_ingrediente_attr.prezzo}" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Codice</label>
								<input type="text" class="form-control" name="codice" id="codice" placeholder="Inserire il codice" autocomplete="nope" value="${insert_ingrediente_attr.codice}" required>
							</div>
						</div>
						
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						<input class="btn btn-outline-warning" type="reset" value="Ripulisci">
					

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