package modelo.DAO;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.SubCategoria;

/**
 *
 * @author krist
 */
public class ConjuntoSubCategorias implements Serializable{
    
    private ConjuntoSubCategorias() {
    }

    public static ConjuntoSubCategorias obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConjuntoSubCategorias();
        }    
        return instancia;
    }
    
    public void agregar(SubCategoria nuevaSubCategoria) {
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareCall(CMD_AGREGAR)) {
                stm.clearParameters();
                stm.setInt(1, nuevaSubCategoria.getId_subCategoria());
                stm.setString(2, nuevaSubCategoria.getNombre_subCategoria());
                stm.setInt(3, nuevaSubCategoria.getCategoria());
                
                if (stm.executeUpdate() != 1) {
                    throw new Exception(String.format(
                            "No puede agregar el resgistro de subCategoria: (%s)",
                            nuevaSubCategoria));
                }
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
    }
//    
//    public List<SubCategoria> obtenerSubCategorias(int cat){
//        List<SubCategoria> subCategorias = new ArrayList<>();
//        try{
//            try(Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
//                    Statement stm = cnx.createStatement();
//                    ResultSet rs = stm.executeQuery(CMD_LISTAR)){
//                
//                while(rs.next()){
//                    int id_subCategoria = rs.getInt("id_subCategoria");
//                    String nombre = rs.getString("nombre_subCategoria");
//                    int categoria = rs.getInt("categoria");
//                    
//                    subCategorias.add(new SubCategoria(id_subCategoria, nombre, categoria));
//                }
//            }
//            return subCategorias;
//        }catch (SQLException ex) {
//            System.err.printf("Excepción: '%s'\n", ex.getMessage());
//        }
//        return subCategorias;
//    }
    
    //Saca todas las subCategorias de una Categoria Especifica
    public List<SubCategoria> obtenerSubCategorias(int num) {
        List<SubCategoria> subCategorias = new ArrayList<>();
        try {
            try (Connection cnx = GestorBD.obtenerInstancia().obtenerConexion();
                    PreparedStatement stm = cnx.prepareStatement(CMD_LISTAR_POR_CATEGORIA)) {
                stm.clearParameters();
                stm.setInt(1, num);
                try (ResultSet rs = stm.executeQuery()) {

                    while (rs.next()) {
                        int id_subCategoria = rs.getInt("id_subCategoria");
                        String nombre = rs.getString("nombre_subCategoria");
                        int categoria = rs.getInt("categoria");
                    
                        subCategorias.add(new SubCategoria(id_subCategoria, nombre, categoria));
                    }
                }
            }
            return subCategorias;
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'\n", ex.getMessage());
        }
        return subCategorias;
    }
    
    
    
//    private static final String CMD_LISTAR
//            = "SELECT id_subCategoria, nombre_subCategoria, categoria "
//            + "FROM bancoempleo.subCategoria ORDER BY id_subCategoria ASC; ";
//    
    private static final String CMD_LISTAR_POR_CATEGORIA
            = "SELECT id_subCategoria, nombre_subCategoria, categoria "
            + "FROM bancoempleo.subCategoria " + " WHERE categoria=? "
            + "ORDER BY id_subCategoria ASC; ";
    
    private static final String CMD_AGREGAR
            = "INSERT INTO bancoempleo.subCategoria "
            + "(id_subCategoria, nombre_subCategoria, categoria) "
            + "VALUES(?, ?, ?); ";
    
    private static final String CMD_ULTIMO_ID
            = "SELECT id_subCategoria "
            + "FROM bancoempleo.subCategoria " + " where id_subCategoria = (select max(id_subCategoria) from subCategoria); ";
    
    private static ConjuntoSubCategorias instancia = null;
}
