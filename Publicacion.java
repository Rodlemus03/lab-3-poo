import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Publicacion {
    private Date fecha1=new Date();
    private String fecha=new SimpleDateFormat("dd-MM-yyyy").format(fecha1);;
    private String contenido;
    private String contenidoMultimedia="";
    private Comun usuario;
    private String hashtag;
    private int likes;
    ArrayList<String> comentarios=new ArrayList<String>();
    
    //Constructor
    public Publicacion(String contenido, String contenidoMultimedia,Comun usuario,String hashtag){
        this.contenido=contenido;
        this.contenidoMultimedia=contenidoMultimedia;
        this.usuario=usuario;
        this.hashtag=hashtag;
        this.likes=0;
    }
    //Gets,Sets y toString

    public void comentarios(){
        for(int i=0;i<comentarios.size();i++){
            System.out.println((i+1)+comentarios.get(i));
        }
    }

    public String getFecha() {
        return this.fecha;
    }



    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getContenidoMultimedia() {
        return this.contenidoMultimedia;
    }

    public void setContenidoMultimedia(String contenidoMultimedia) {
        this.contenidoMultimedia = contenidoMultimedia;
    }

    public Comun getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Comun usuario) {
        this.usuario = usuario;
    }

    public String getHashtag() {
        return this.hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


    @Override
    public String toString() {
        String cadena="";
        for(int i=0;i<comentarios.size();i++){
            cadena+="--"+comentarios.get(i)+"\n";
        }
        return "{" +
            " fecha='" + getFecha() + "'" +
            ", contenido='" + getContenido() + "'" +
            ", contenidoMultimedia='" + getContenidoMultimedia() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", hashtag='" + getHashtag() + "'" +
            ", likes='" + getLikes() + "'" +
            ", comentarios=";

            
    }



}
