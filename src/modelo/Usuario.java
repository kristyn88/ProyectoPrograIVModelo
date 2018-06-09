package modelo;

/**
 *
 * @author krist
 */

/*Esta clase va a dar el tipo de usuario cuando se haga una nueva empresa, oferente o administrador,
Administrador = 1, Empresa = 2, Oferente = 3*/

public class Usuario { 

    public Usuario(int id_usuario, int tipo_usuario) {
        this.id_usuario = id_usuario;
        this.tipo_usuario = tipo_usuario;
    }
    
    @Override
    public String toString() {
        return String.format("{Id: %d, Tipo de Usuario: %d}", id_usuario, tipo_usuario);
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th class=\"encabezado\">Id_Usuario</th>");
        r.append("<th class=\"encabezado\">Tipo Usuario</th>");
        return r.toString();
    }
    
    public String convertirUsuario(){
        switch (tipo_usuario) {
            case 1:
                return "Administrador";
            case 2:
                return "Empresa";
            default:
                return "Oferente";
        }
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td class=\"campo\">%d</td>", id_usuario));
        r.append(String.format("<td class=\"campo\">%s</td>", convertirUsuario()));
        return r.toString();
    }
    
    
    private int id_usuario;
    private int tipo_usuario;
}
