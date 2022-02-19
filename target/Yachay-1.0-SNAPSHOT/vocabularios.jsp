<%@page import="java.util.ArrayList"%>
<%@page import="com.yachay.model.Vocabulario"%>
<%@page import="com.yachay.dao.DaoVocabulario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abecedario</title>
    </head>
    <body>
        <div class="container">
            <%
                DaoVocabulario dv = new DaoVocabulario();
                ArrayList<Vocabulario> vocabularios = new ArrayList<>(dv.obtenerVocabularios("0"));
                for (Vocabulario v : vocabularios) {
                    int idProducto = v.getIdVocabulario();
                    
                    out.print(v.getDescripcion()+"<br>");
                }
            %>
        </div>
    </body>
</html>
