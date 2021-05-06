<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it">
<head>
    <jsp:include page="../header.jsp" />
    <title>Ricerca</title>

    <!-- style per le pagine diverse dalla index -->
    <link href="${pageContext.request.contextPath}/assets/css/global.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../navbar.jsp" />

<main role="main" class="container">

    <div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
        ${errorMessage}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>

    <div class='card'>
        <div class='card-header'>
            <h5>Ricerca elementi</h5>
        </div>
        <div class='card-body'>

            <form method="post" action="ExecuteSearchIngredienteServlet" >

                    <div class="form-group col-md-6">
                        <label>Descrizione</label>
                        <input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione" >
                    </div>

                    <div class="form-group col-md-6">
                        <label>Prezzo</label>
                        <input type="text" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo" >
                    </div>

                    <div class="form-group col-md-6">
                        <label>Codice</label>
                        <input type="text" class="form-control" name="codice" id="codice" placeholder="Inserire il codice" >
                    </div>

                <button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
                <input class="btn btn-outline-warning" type="reset" value="Ripulisci">


                <a class="btn btn-outline-primary ml-2" href="PrepareInsertIngredienteServlet">Add New</a>

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