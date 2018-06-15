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
                <jsp:directive.include file="headerNavegacion.jsp"/>
            </div>
                <div class="section">
                    <h1><span>Login Oferente</span></h1>
                    <form name="loginForm" action="ServicioLogin" method="POST">
                        <%
                        modelo.Elementos.tipoLogin = 1 ;
                        %>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td align="right">
                                    Correo:&nbsp;
                                </td><td>
                                    <input name="correoOferente" type="email"/><br/>
                                </td>
                            </tr><tr>
                                <td align="right">
                                    Clave:&nbsp;
                                </td><td>
                                    <input name="claveOferente" type="password"/><br/>
                                </td>
                            </tr><tr>
                                <td align="center" colspan="2">
                                    <input type="submit" value="Entrar" class="submit"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <center>
                    <a href="registroOferente.jsp"><button class="submit">Registrarse</button></a>
                    </center>
                </div>
            <footer></footer>
        </div>
    </body>
</html>
