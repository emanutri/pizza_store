<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<jsp:include page="../header.jsp" />
	<link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">
		
	<title>Elimina ingrediente</title>
	
</head>

<body>

	<jsp:include page="../navbar.jsp" />

	
	<main role="main" class="container">

			<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio da eliminare
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Descrizione:</dt>
				  <dd class="col-sm-9">${ingrediente_delete.descrizione}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Prezzo:</dt>
				  <dd class="col-sm-9">${ingrediente_delete.prezzo}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Descrizione:</dt>
				  <dd class="col-sm-9">${ingrediente_delete.codice}</dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <form action="ExecuteDeleteIngredienteServlet" method="post">
			       <a href="ExecuteListIngredienteServlet" class='btn btn-outline-secondary' style='width:7em'>
		             <i class='fa fa-chevron-left'></i> Indietro
		           </a>
			       	<input type="hidden" name="idDeleteInput" value="${ingrediente_delete.id}">
		        	<button type="submit" name="submit" value="submit" id="submit" class="btn btn-danger" style='width:7em;'>Elimina</button>
		        </form>
		       
		    </div>
		    
		</div>	
		
	</main>
	
	<jsp:include page="../footer.jsp" />

</body>

</html>