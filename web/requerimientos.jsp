<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Requerimientos</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
        <link href="css/estiloBienvenida.css" rel="stylesheet" type="text/css"/>
        <script src="js/loadJSON.js" type="text/javascript"></script>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="init()">
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
            <div id="section">
                <h1><span>Bienvenido a la página de integración de requerimientos....!</span></h1>
                <form id="formulario1" action="#" method="GET">
                    <section id="section">
                        <p name="ultimoPuesto">
                            Puesto Agregado:
                        </p>
                        <p name="nombrePuesto">
                            <span id="error" style="color: Red; font-weight: bold;"></span>
                        </p>
                    </section>
                    
                    <section>
                        <table id="tablaRequerimientos">
                            <thead></thead>
                            <th>Area</th>
                            <th>Nombre</th>
                            <th>Nivel Deseado</th>
                            <tbody id="datosRequerimientos">
                            </tbody>
                        </table>
                    </section>
                    
                    <section>
                        <table>
                            <tbody>
                                <tr>
                                    <td>
                                        Area:&n&nbsp;
                                    </td>
                                    <td>
                                        <select id="categorias"></select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </section>
                </form>
                <section>
                    <a href="prueba.jsp">Regresar</a>

                    <% int variable = modelo.DAO.ConjuntoPuestos.obtenerInstancia().obtenerMayorId();%>
                    <p>
                        Me han pasado el valor <%= variable%>!
                    </p>

                </section>
            </div>
            <footer></footer>
        </div>
    </body>
</html>
