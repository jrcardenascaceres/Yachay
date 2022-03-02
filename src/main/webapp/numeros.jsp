<%@page import="java.util.ArrayList"%>
<%@page import="com.yachay.model.Vocabulario"%>
<%@page import="com.yachay.dao.DaoVocabulario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Yachay: Aprendizaje inclusivo</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="estilos.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href=".">Yachay</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href=".">Abecedario</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="numeros.jsp">Números</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <%
                    DaoVocabulario dv = new DaoVocabulario();
                    ArrayList<Vocabulario> vocabularios = new ArrayList<>(dv.obtenerVocabularios("1"));
                    for (Vocabulario v : vocabularios) {
                        int idProducto = v.getIdVocabulario();
                        out.print("<div class='col-md-6 col-lg-4'>");
                        out.print("<div class='flip-card'>");
                        out.print("<div class='flip-card-inner'>");
                        out.print("<div class='flip-card-front'>");
                        out.print("<h1 class='align-middle'>" + v.getVocabulario() + "</h1>");
                        out.print("</div>");
                        out.print("<div class='flip-card-back'>");
                        out.print("<img src='assets/img/senias/" + v.getImgSenia() + "' alt='Avatar' style='border-radius:10px;'>");
                        out.print("</div>");
                        out.print("</div>");
                        out.print("</div>");
                        out.print("</div>");
                    }
                %>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>