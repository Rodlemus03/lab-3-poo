public class Administrador extends Usuario {
    private String tipo = "";

    public Administrador(String nombre, String password) {
        super(nombre, password);
    }

    public String getNombre() {
        return super.getNombre();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
