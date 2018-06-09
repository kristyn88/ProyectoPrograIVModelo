<%-- 
    Document   : loginEmpresa
    Created on : 03-jun-2018, 2:54:35
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <link href="css/estiloBienvenida.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
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
                <div class="section">
                    <h1><span>Login Administrador</span></h1>
                    <form name="loginForm" action="ServicioLogin" method="POST">
                        <%
                        modelo.Elementos.tipoLogin = 3 ;
                        %>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td align="right">
                                    Identificación:&nbsp;
                                </td><td>
                                    <input name="identificacionAdministrador" type="text"/><br/>
                                </td>
                            </tr><tr>
                                <td align="right">
                                    Clave:&nbsp;
                                </td><td>
                                    <input name="claveAdministrador" type="password"/><br/>
                                </td>
                            </tr><tr>
                                <td align="center" colspan="2">
                                    <input type="submit" value="Entrar" class="submit"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <%-- Va al servicio Verificar Admin--%>
                </div>
            <footer></footer>
        </div>
    </body>
</html>
