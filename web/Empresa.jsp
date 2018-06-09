<%-- 
    Document   : Empresa
    Created on : 14-abr-2018, 0:53:45
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Empresa (Pagina Principal)</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/estiloBienvenida.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="header" style="overflow: hidden;">
                <nav> <!-- Aqui estamos iniciando la nueva etiqueta nav -->
                    <ul class="nav">
                        <li><a href="Principal.jsp">Inicio</a></li>
                        <li><a href="loginEmpresa.jsp">Empresa</a></li>
                        <li><a href="loginOferente.jsp">Oferente</a></li>
                        <li><a href="loginAdministrador.jsp">Administracion</a></li>
                        <li><a href="prueba.jsp">Registros</a></li>
                    </ul>
                </nav><!-- Aqui estamos cerrando la nueva etiqueta nav -->
            </div>
            <div id="contents">
                <br/><br/>
                <section class="section">
                    <center>
                        <h1><span>Bienvenida Empresa!</span></h1>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td>
                                    <a href="AgregarPuestos.jsp"><button class="submit">Publicar Puesto</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="prueba.jsp"><button class="submit">Buscar Candidatos</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="prueba.jsp"><button class="submit">Editar Puesto</button></a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="prueba.jsp"><button class="submit">Puestos Registrados</button></a>
                                </td>
                            </tr>
                        </table>
                    </center>
                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
