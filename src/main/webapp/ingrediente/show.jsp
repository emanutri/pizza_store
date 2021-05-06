<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
    <jsp:include page="../header.jsp" />
    <title>Visualizza elemento</title>

    <!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">

</head>
<body>
<jsp:include page="/navbar.jsp" />

<main role="main" class="container">

    <div class='card'>
        <div class='card-header'>
            Visualizza dettaglio
        </div>

        <div class='card-body'>
            <dl class="row">
                <dt class="col-sm-3 text-right">Id:</dt>
                <dd class="col-sm-9">${show_ingrediente_attr.id}</dd>
            </dl>

            <dl class="row">
                <dt class="col-sm-3 text-right">descrizione:</dt>
                <dd class="col-sm-9">${show_ingrediente_attr.descrizione}</dd>
            </dl>

            <dl class="row">
                <dt class="col-sm-3 text-right">prezzo:</dt>
                <dd class="col-sm-9">${show_ingrediente_attr.prezzo}</dd>
            </dl>

            <dl class="row">
                <dt class="col-sm-3 text-right">codice:</dt>
                <dd class="col-sm-9">${show_ingrediente_attr.codice}</dd>
            </dl>
        </div>

        <div class='card-footer'>
            <a href="ExecuteListIngredienteServlet" class='btn btn-outline-secondary' style='width:80px'>
                <i class='fa fa-chevron-left'></i> Back
            </a>
        </div>
    </div>



    <!-- end main container -->
</main>
<jsp:include page="../footer.jsp" />

</body>
</html>