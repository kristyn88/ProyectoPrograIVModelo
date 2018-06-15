package modelo;

public class Administrador {

    public Administrador(int id_administrador, String nombre_administrador, String clave, int usuario) {
        this.id_administrador = id_administrador;
        this.nombre_administrador = nombre_administrador;
        this.clave = clave;
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        return String.format("{%d, %s, %s, %d}", id_administrador, nombre_administrador, clave,  usuario);
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre_administrador() {
        return nombre_administrador;
    }

    public void setNombre_administrador(String nombre_administrador) {
        this.nombre_administrador = nombre_administrador;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    public String convertirUsuario(){
        if(usuario==1){
            return "Administrador";
        }else{
            return "Desconocido";
        }
    }
    
    public static String encabezadosHTML() {
        StringBuilder r = new StringBuilder();
        r.append("<th class=\"encabezado\">Id Administrador</th>");
        r.append("<th class=\"encabezado\">Nombre Administrador</th>");
        r.append("<th class=\"encabezado\">Clave</th>");
        r.append("<th class=\"encabezado\">Tipo Usuario</th>");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append(String.format("<td class=\"campo\">%d</td>", id_administrador));
        r.append(String.format("<td class=\"campo\">%s</td>", nombre_administrador));
        r.append(String.format("<td class=\"campo\">%s</td>", clave));
        r.append(String.format("<td class=\"campo\">%s</td>", convertirUsuario()));
        return r.toString();
    }
    
    private int id_administrador;
    private String nombre_administrador;
    private String clave;
    private int usuario;
}