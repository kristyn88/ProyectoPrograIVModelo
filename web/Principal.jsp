<%@page import="modelo.Puesto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/estiloBienvenida.css" rel="stylesheet" type="text/css"/>
        <title>Página Principal</title>
    </head>
    <body>
        <div id="wrapper">
            <header>
            </header>
            <div id="header" style="overflow: hidden;">
                <jsp:directive.include file="headerNavegacion.jsp"/>
            </div>
            <div id="contents">
                <br/>
                <br/>
                <h1 class="titulo">Bienvenidos al Banco de Empleo</h1>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
