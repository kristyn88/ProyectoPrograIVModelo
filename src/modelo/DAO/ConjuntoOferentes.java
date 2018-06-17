package modelo.DAO;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Oferente;
import org.apache.commons.fileupload.FileItem;

public class ConjuntoOferentes implements Serializable {

    private ConjuntoOferentes() {
    }

    public static ConjuntoOferentes obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoOferentes();
        }
        return instancia;
    }

    public void agregar(Oferente nuevoOferente) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevoOferente.getId_oferente());
                stm.setString(2, nuevoOferente.getNombre_oferente());
                stm.setString(3, nuevoOferente.getPrimer_apellido());
                stm.setString(4, nuevoOferente.getNacionalidad());
                stm.setInt(5, nuevoOferente.getTelefono());
                stm.setString(6, nuevoOferente.getCorreo());
                stm.setString(7, nuevoOferente.getResidencia());
                stm.setInt(8, nuevoOferente.getEstado());
                stm.setString(9, nuevoOferente.getClave());
                stm.setInt(10, nuevoOferente.getUsuario());

                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de oferente: (%s)",
                            nuevoOferente));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }

    public List<Oferente> obtenerOferentes() {
        List<Oferente> oferentes = new ArrayList<>();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

                while (rs.next()) {
                    int id_oferente = rs.getInt("id_oferente");
                    String nombre = rs.getString("nombre_oferente");
                    String primerApellido = rs.getString("primer_apellido");
                    String nacionalidad = rs.getString("nacionalidad");
                    int telefono = rs.getInt("telefono");
                    String correo = rs.getString("correo");
                    String residencia = rs.getString("residencia");
                    int estado = rs.getInt("estado");
                    String clave = rs.getString("clave");
                    int usuario = rs.getInt("usuario");
                    oferentes.add(new Oferente(id_oferente, nombre, primerApellido, nacionalidad, telefono, correo, residencia, estado, clave, usuario));
                }
            }
            return oferentes;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return oferentes;
    }

    public List<Oferente> obtenerOferentesPendientes() {
        List<Oferente> oferentes = new ArrayList<>();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR_PENDIENTES)) {

                while (rs.next()) {
                    int id_oferente = rs.getInt("id_oferente");
                    String nombre = rs.getString("nombre_oferente");
                    String primerApellido = rs.getString("primer_apellido");
                    String nacionalidad = rs.getString("nacionalidad");
                    int telefono = rs.getInt("telefono");
                    String correo = rs.getString("correo");
                    String residencia = rs.getString("residencia");
                    int estado = rs.getInt("estado");
                    String clave = rs.getString("clave");
                    int usuario = rs.getInt("usuario");
                    oferentes.add(new Oferente(id_oferente, nombre, primerApellido, nacionalidad, telefono, correo, residencia, estado, clave, usuario));
                }
            }
            return oferentes;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return oferentes;
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table class=\"tabla\">");
        r.append("\n<thead><tr>");
        r.append(Oferente.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Oferente o : obtenerOferentes()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    o.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }

    public String toStringHTMLPendientes() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table class=\"tabla\">");
        r.append("\n<thead><tr>");
        r.append(Oferente.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Oferente o : obtenerOferentesPendientes()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    o.toStringHTML())
            );
        }
        if (obtenerOferentesPendientes().isEmpty()) {
            r.append("\n<tr>");
            r.append("\n<td>No hay Oferentes Pendientes</td>");
            r.append("\n</tr>");
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }

    public boolean autorizar(int id, int estado) {
        boolean exito = false;
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareStatement(CMD_ACTUALIZAR)) {
                stm.clearParameters();
                stm.setInt(1, estado);
                stm.setInt(2, id);

                int r = stm.executeUpdate();
                exito = (r == 1);
            }

        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return exito;
    }

    public boolean verificarOferente(String correo, String clave) {
        //Devuelve si existe o no el oferente solicitado
        boolean encontrado = false;
        try {
            Connection cnx
                    = GestorBD.obtenerInstancia().obtenerConexion();

            try (PreparedStatement stm = cnx.prepareStatement(CMD_VERIFICAR)) {
                stm.clearParameters();
                stm.setString(1, correo);
                stm.setString(2, clave);
                ResultSet rs = stm.executeQuery();
                encontrado = rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return encontrado;
    }

    public Oferente recuperar(int serie) {
        Oferente r = null;
        try {
            Connection cnx
                    = GestorBD.obtenerInstancia().obtenerConexion();

            try (PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR)) {
                stm.clearParameters();
                stm.setInt(1, serie);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = new Oferente(
                                rs.getInt("id_oferente"),
                                rs.getString("nombre_oferente"),
                                rs.getString("primer_apellido"),
                                rs.getString("nacionalidad"),
                                rs.getInt("telefono"),
                                rs.getString("correo"),
                                rs.getString("residencia"),
                                rs.getInt("estado"),
                                rs.getString("clave"),
                                rs.getInt("usuario")
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    public Oferente recuperarPorCorreo(String correo) {
        Oferente r = null;
        try {
            Connection cnx
                    = GestorBD.obtenerInstancia().obtenerConexion();

            try (PreparedStatement stm = cnx.prepareStatement(CMD_RECUPERAR_POR_CORREO)) {
                stm.clearParameters();
                stm.setString(1, correo);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        r = new Oferente(
                                rs.getInt("id_oferente"),
                                rs.getString("nombre_oferente"),
                                rs.getString("primer_apellido"),
                                rs.getString("nacionalidad"),
                                rs.getInt("telefono"),
                                rs.getString("correo"),
                                rs.getString("residencia"),
                                rs.getInt("estado"),
                                rs.getString("clave"),
                                rs.getInt("usuario")
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return r;
    }

    public boolean agregarCurriculum(byte[] bytes, String correo) {
        try {
            Connection cnx
                    = GestorBD.obtenerInstancia().obtenerConexion();

            try (PreparedStatement stm = cnx.prepareStatement(CMD_CURRICULUM)) {
                stm.clearParameters();
                stm.setBytes(1, bytes);
                stm.setString(2, correo);

                int resultado = stm.executeUpdate();
                if (resultado >= 1) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }
        return false;
    }

    public String toStringHTMLEspecifico(int id) {
        StringBuilder r = new StringBuilder();
        r.append("\n<table class=\"tabla\">");
        r.append("\n<thead><tr>");
        r.append(Oferente.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        r.append(String.format(
                "\n\t<tr>%s</tr>",
                recuperar(id).toStringHTML())
        );
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }

    private static final String CMD_CURRICULUM
            = "UPDATE oferente SET documento = ? WHERE  correo = ?;";

    private static final String CMD_LISTAR
            = "SELECT id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, estado,clave, usuario "
            + "FROM bancoempleo.oferente ORDER BY id_oferente DESC; ";

    private static final String CMD_LISTAR_PENDIENTES
            = "SELECT id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, estado, clave,usuario "
            + "FROM bancoempleo.oferente WHERE estado=0 ORDER BY id_oferente DESC; ";

    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.oferente "
            + "(id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, estado,clave,usuario) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?,?,?); ";

    private static final String CMD_ACTUALIZAR
            = "UPDATE oferente SET estado=? WHERE id_oferente=?;";

    private static final String CMD_VERIFICAR
            = "SELECT id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, estado, clave, usuario "
            + "FROM bancoempleo.oferente WHERE correo=? and clave=?; ";

    private static final String CMD_RECUPERAR_POR_CORREO
            = "SELECT id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, estado, clave, usuario "
            + "FROM bancoempleo.oferente WHERE correo=?; ";

    private static final String CMD_RECUPERAR
            = "SELECT id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, estado, clave, usuario "
            + "FROM bancoempleo.oferente WHERE id_oferente=?; ";

    private static ConjuntoOferentes instancia = null;
}
