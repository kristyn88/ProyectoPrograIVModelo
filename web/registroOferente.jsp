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
        <title>Registro Oferente</title>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="header" style="overflow: hidden;">
                <jsp:directive.include file="headerNavegacion.jsp"/>
            </div>
                <div class="section">
                    <h1><span>Registro Oferente</span></h1>
                    <form name="loginForm" action="Registro1" method="POST">
                        <%
                        modelo.Elementos.tipoLogin = 1 ;
                        %>
                        <table width="65%" cellpadding="8">
                            <tr>
                                <td align="right">
                                    Identificación:&nbsp;
                                </td><td>
                                    <input name="identificacion" type="text"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    Nombre:&nbsp;
                                </td><td>
                                    <input name="nombre" type="text"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    Apellido:&nbsp;
                                </td><td>
                                    <input name="apellido" type="text"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    Nacionalidad:&nbsp;
                                </td><td>
                                    <input name="nacionalidad" type="text"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    Telefono:&nbsp;
                                </td><td>
                                    <input name="telefono" type="number"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    Correo:&nbsp;
                                </td><td>
                                    <input name="correo" type="email"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    Residencia:&nbsp;
                                </td><td>
                                    <input name="residencia" type="text"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="2">
                                    <input type="submit" value="Registrarse" class="submit"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            <footer></footer>
        </div>
    </body>
</html>
