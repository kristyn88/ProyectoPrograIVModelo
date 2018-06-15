package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Habilidades;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author krist
 */
public class ConjuntoHabilidades implements Serializable {

    private ConjuntoHabilidades() {
    }

    public static ConjuntoHabilidades obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoHabilidades();
        }
        return instancia;
    }

    public void agregar(Habilidades nuevasHabilidades) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevasHabilidades.getOferente());
                stm.setInt(2, nuevasHabilidades.getSubCategoria());
                stm.setInt(3, nuevasHabilidades.getNivel());

                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de las habilidades: (%s)",
                            nuevasHabilidades));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }

    public List<Habilidades> obtenerHabilidades() {
        List<Habilidades> habilidades = new ArrayList<>();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LISTAR)) {

                while (rs.next()) {
                    int oferente = rs.getInt("oferente");
                    int subCategoria = rs.getInt("subCategoria");
                    int nivel = rs.getInt("nivel");
                    habilidades.add(new Habilidades(oferente, subCategoria, nivel));
                }
            }
            return habilidades;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return habilidades;
    }
    
    public JSONArray obtenerHabilidades(String correo) {
        int id = modelo.DAO.ConjuntoOferentes.obtenerInstancia().recuperarPorCorreo(correo).getId_oferente();
        JSONArray arr = new JSONArray();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_HABILIDADES)) {
                stm.clearParameters();
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {

                    while (rs.next()) {
                        String categoria = rs.getString("nombre_categoria");
                        String subcategoria = rs.getString("nombre_subCategoria");
                        int nivel = rs.getInt("nivel");
                        JSONObject obj = new JSONObject();
                        obj.put("categoria", categoria);
                        obj.put("subcategoria", subcategoria);
                        obj.put("nivel", nivel);
                        arr.put(obj);
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return arr;
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\n<table class=\"tabla\">");
        r.append("\n<thead><tr>");
        r.append(Habilidades.encabezadosHTML());
        r.append("\n</tr></thead>");
        r.append("\n<tbody>");
        for (Habilidades a : obtenerHabilidades()) {
            r.append(String.format(
                    "\n\t<tr>%s</tr>",
                    a.toStringHTML())
            );
        }
        r.append("\n</tbody>");
        r.append("\n</table>");
        return r.toString();
    }

    private static final String CMD_LISTAR
            = "SELECT oferente, subCategoria, nivel "
            + "FROM bancoempleo.habilidades ORDER BY oferente ASC; ";

    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.habilidades "
            + "(oferente, subCategoria, nivel) "
            + "VALUES(?, ?, ?); ";

    private static final String CMD_LISTAR_HABILIDADES
            = "SELECT nombre_categoria, nombre_subCategoria, nivel "
            + "FROM habilidades, subcategoria, categoria "
            + "WHERE habilidades.oferente = ? "
            + "AND habilidades.subcategoria = subcategoria.id_subcategoria "
            + "AND subcategoria.categoria = categoria.id_categoria;";

    private static ConjuntoHabilidades instancia = null;
}
