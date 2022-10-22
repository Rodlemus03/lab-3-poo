public class Comun extends Usuario {

    private String tipo="comun";
    public Comun(String nombre,String password){
        super(nombre, password);
    }
  


    //Gets,sets y toString
    public String getTipo() {
        return this.tipo;
    }
    public String getNombre(){
        return super.getNombre();
    }
    public String getPassword(){
        return super.getPassword();
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
