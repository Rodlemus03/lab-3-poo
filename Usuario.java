public class Usuario {
    private String nombre;
    private String password;
    //Constructor
    public Usuario(String nombre,String password){
        this.nombre=nombre;
        this.password=password;
    }


    //Gets, sets y toString

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}

