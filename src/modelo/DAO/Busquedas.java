
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Busquedas {

    public static JSONArray busqueda(String criterio) {
        JSONArray arr = new JSONArray();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion()) {
                PreparedStatement stm;
                if (isInteger(criterio)) {
                    stm = cnx.prepareStatement(CMD_BUSCAR_INT);
                    stm.clearParameters();
                    stm.setInt(1, Integer.parseInt(criterio));
                } else {
                    stm = cnx.prepareStatement(CMD_BUSCAR_STRING);
                    stm.clearParameters();
                    stm.setString(1, "%" + criterio + "%");
                    stm.setString(2, "%" + criterio + "%");
                    stm.setString(3, "%" + criterio + "%");
                    stm.setString(4, "%" + criterio + "%");
                }
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        JSONObject obj = new JSONObject();
                        obj.put("nombre_puesto", rs.getString("nombre_puesto"));
                        obj.put("descripcion", rs.getString("descripcion"));
                        obj.put("salario", rs.getInt("salario_ofrecido"));
                        obj.put("nombre_empresa", rs.getString("nombre_empresa"));
                        obj.put("telefono", rs.getInt("telefono"));
                        arr.put(obj);
                    }
                }
                stm.close();
            }
            return arr;
        } catch (NumberFormatException | SQLException | JSONException ex) {
            System.out.printf("Error al acceder: %s\n", ex.getMessage());
        }
        return arr;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    private static final String CMD_BUSCAR_STRING = "SELECT DISTINCT puesto.nombre_puesto, puesto.descripcion, "
            + "puesto.salario_ofrecido, empresa.nombre_empresa, empresa.telefono "
            + "FROM empresa, puesto, requerimientos, subcategoria, categoria "
            + "WHERE empresa.id_empresa = puesto.empresa "
            + "AND puesto.id_puesto = requerimientos.puesto "
            + "AND requerimientos.subcategoria = subcategoria.id_subcategoria "
            + "AND subcategoria.categoria = categoria.id_categoria "
            + "AND (puesto.nombre_puesto LIKE ? "
            + "OR empresa.nombre_empresa LIKE ? "
            + "OR categoria.nombre_categoria LIKE ? "
            + "OR subcategoria.nombre_subcategoria LIKE ?);";

    private static final String CMD_BUSCAR_INT = "SELECT DISTINCT puesto.nombre_puesto, puesto.descripcion, puesto.salario_ofrecido, "
            + "empresa.nombre_empresa, empresa.telefono "
            + "FROM puesto, empresa, requerimientos "
            + "WHERE requerimientos.puesto = puesto.id_puesto "
            + "AND puesto.empresa = empresa.id_empresa "
            + "AND requerimientos.nivel = ?; ";
}
