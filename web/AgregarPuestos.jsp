<%-- 
    Document   : AgregarPuestos
    Created on : 14-abr-2018, 2:06:07
    Author     : krist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Pagina Agregar Puestos</title>
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
            <div class="section">
                <h1><span>Registrando Nuevo Puesto</span></h1>
                <form id="formulario" action="RegistroPuesto" method="GET">
                    <table width="65%" cellpadding="8">
                        <thead></thead>
                        <tbody>
                            <tr>
                                <td align="right">
                                    Nombre:&nbsp;
                                </td><td>
                                    <input name="nombreP" type="text"/><br/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    Descripcion:&nbsp;
                                </td>
                                <td>
                                    <textarea  name="descripcionP"
                                               cols="40" rows="8"></textarea>
                                </td>
                            </tr> 
                            <tr>
                                <td>
                                    Salario ofrecido:&nbsp;
                                </td>
                                <td>
                                    <input type="number" name="salarioP" required />
                                </td>
                            </tr>
                            
                            <tr>
                                <td>
                                    Tipo de Publicacion:&nbsp;
                                </td>
                                <td>
                                    <input type="radio" id="opcion_00" name="opcionP1" value="0" />
                                    <label for="opcion_00">Pública</label>
                                    <input type="radio" id="opcion_01" name="opcionP1" value="1" />
                                    <label for="opcion_01">Privada</label>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Estado de Puesto:
                                </td>
                                <td>
                                    <input type="radio" id="opcion_00" name="opcionP2" value="0" />
                                    <label for="opcion_00">Libre</label>
                                    <input type="radio" id="opcion_01" name="opcionP2" value="1" />
                                    <label for="opcion_01">Ocupado</label>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="reset" value="Borrar" class="submit"/>
                                    <input type="submit" value="Registrar" class="submit"/>
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
