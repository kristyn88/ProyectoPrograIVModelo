<%-- 
    Document   : CrearHabilidad
    Created on : 16-abr-2018, 21:03:40
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <header></header>
            <div id="placa">
                <form id="formulario" action="RegistroRequerimientos2" method="GET">
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Registro de nueva area de Categoria:</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="etiqueta">Nombre:</td>
                                <td class="campo">
                                    <input type="text" id="nombreS" name="nombreS" required />
                                </td>
                            </tr>
                            <tr>
                                <td class="etiqueta">Nivel de dominio:</td>
                                <td class="campo">
                                    <input type="text" id="dominioS" name="dominioS" required />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="Crear" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
