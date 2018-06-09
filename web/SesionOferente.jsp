<%-- 
    Document   : SesionOferente
    Created on : 16-abr-2018, 20:38:36
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
            <div id="contents">
                <h1>Bienvenido Oferente</h1>
                <form i="FormularioOferente" action="RegistroHabilidades" method="GET">
                    <table id="tablaFormulario">
                        <thead>
                            <tr>
                                <th colspan="2">Transacciones Posibles</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="campo">
                                    <input type="radio" id="opcion_00" name="opcionO" value="1" />
                                    <label for="opcion_00">Registrar habilidad</label><br />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="controles">
                                    <input type="reset" value="Borrar" />
                                    <input type="submit" value="Enviar" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <p>
                Su sesion es:
                <%
                    out.print(modelo.Elementos.id_Oferente_Requerido);
                %>
            </p>
            <footer></footer>
        </div>
    </body>
</html>
