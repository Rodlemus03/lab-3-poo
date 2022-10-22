import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.Position;
public class Menu{
    public static void main(String[] args) {
        //Objetos
        Comun usuario1=new Comun("julio", "12345");
        Scanner teclado=new Scanner(System.in);
        ArrayList<Publicacion> publicaciones=new ArrayList<Publicacion>();
        ArrayList<Comun> usuarios=new ArrayList<Comun>();
        Comun usuarioContexto=new Comun(null, null);
        usuarios.add(usuario1);
        ArrayList<String>nombresUsuarios=new ArrayList<String>();
        ArrayList<String>Contras=new ArrayList<String>();
        ArrayList<Publicacion>guardados=new ArrayList<Publicacion>();
        nombresUsuarios.add(usuario1.getNombre());
        Contras.add(usuario1.getPassword());
        //Menu-->login
            //USUARIO DEFAULT julio CONTRASEÑA DEFAULT 12345
        int seleccionLogin=0;
        boolean banderaLogin=false;
        while(banderaLogin==false){
            System.out.println("1. Ingresar");
            System.out.println("2. Crear cuenta");
            seleccionLogin=teclado.nextInt();
            if(seleccionLogin==1){
                String nombre,pass;
                System.out.println("Ingresa tu nombre de usuario ");
                nombre=teclado.next();
                System.out.println("Ingresa tu contraseña ");
                pass=teclado.next();
                for(int i=0;i<nombresUsuarios.size();i++){
                    if(nombresUsuarios.get(i).equalsIgnoreCase(nombre) && Contras.get(i).equalsIgnoreCase(pass)){
                        banderaLogin=true;
                        usuarioContexto=usuarios.get(i);
                    }
                }
            }else if(seleccionLogin==2){
                String nombreNuevo,passNueva,passNueva2;
                System.out.println("Ingresa tu nombre de usuario");
                nombreNuevo=teclado.next();
                System.out.println("Ingresa tu contraseña");
                passNueva=teclado.next();
                System.out.println("Confirma tu contraseña");
                passNueva2=teclado.next();
                if(passNueva.equalsIgnoreCase(passNueva2)){
                    Comun nuevo=new Comun(nombreNuevo, passNueva);
                    usuarios.add(nuevo);
                    nombresUsuarios.add(nuevo.getNombre());
                    Contras.add(nuevo.getPassword());
                    System.out.println("Usuario creado, intenta entrar");
                }else{
                    System.out.println("Las contraseñas no son iguales");
                }
            }else{
                System.out.println("Ingresa una opcion correcta porfavor");
            }
            if(banderaLogin==true){
                int eleccion=0;
                ArrayList<Publicacion>publicacionesContexto=new ArrayList<Publicacion>();
                while(eleccion!=7){
                    System.out.println("1. Crear publicacion ");
                    System.out.println("2. Eliminar publicacion");
                    System.out.println("3. Ver publicaciones (dar enter para pasar a la siguiente)");
                    System.out.println("4. Buscar por fecha");
                    System.out.println("5. Buscar por hashtag");
                    System.out.println("6. Ver guardar");
                    System.out.println("7. Salir");
                    eleccion=teclado.nextInt();
                    if(eleccion==1){
                        String contenido,multimedia,hashtag;
                        System.out.println("Ingresa tu mensaje (maximo 20 caracteres)");
                        contenido=teclado.next();
                        System.out.println("Ingresa el contenido multimedia con peso (imagen.jpg 20mb) ");
                        multimedia=teclado.next();
                        System.out.println("Ingresa tu hashtag o presiona enter para no ingresar ");
                        hashtag=teclado.next();
                        Publicacion publi=new Publicacion(contenido, multimedia, usuarioContexto, hashtag);
                        publicaciones.add(publi);
                        System.out.println("Publicacion creada! ");
                    }else if(eleccion==2){
                        for(int i=0;i<publicaciones.size();i++){
                            if(publicaciones.get(i).getUsuario().equals(usuarioContexto)){
                                publicacionesContexto.add(publicaciones.get(i));
                            }
                        }

                        int posicion=0;
                        for(int i=0;i<publicacionesContexto.size();i++){
                            System.out.println("#####################################################################");
                            System.out.println(i+1);
                            System.out.println("______________");
                            System.out.println(publicacionesContexto.get(i).getUsuario().getNombre());
                            System.out.println("______________");
                            System.out.println(publicacionesContexto.get(i).getFecha());
                            System.out.println("______________");
                            System.out.println("Likes: "+publicacionesContexto.get(i).getLikes());
                            System.out.println("______________");
                            System.out.println(publicacionesContexto.get(i).getHashtag());
                            System.out.println("______________");
                            System.out.println(publicacionesContexto.get(i).getContenido());
                            System.out.println("______________");
                            System.out.println(publicacionesContexto.get(i).getContenidoMultimedia());
                            System.out.println("#####################################################################");
                        }
                        System.out.println("Ingresa el numero de publicacion para borrar ");
                        posicion=teclado.nextInt();
                        ArrayList<Publicacion> auxiliar=new ArrayList<Publicacion>();
                        for(int i=0;i<publicacionesContexto.size();i++){
                            if(i!=posicion-1){
                                auxiliar.add(publicacionesContexto.get(i));
                            }
                        }
                        publicacionesContexto=auxiliar;
                        System.out.println("Publicacion eliminada");
                        
                    }else if(eleccion==3){
                        String like="",com="",comentario="",guardado="";
                        for(int i=0;i<publicaciones.size();i++){
                            publicaciones.get(i).toString();
                            System.out.println("Deseas darle like y/n ?");
                            like=teclado.next();
                            if(like.equalsIgnoreCase("y")){
                                publicaciones.get(i).setLikes(publicaciones.get(i).getLikes()+1);
                            }
                            System.out.println("Deseas comentar algo? y/n ?");
                            com=teclado.next();
                            if(com.equalsIgnoreCase("y")){
                                System.out.println("Ingresa tu comentario");
                                comentario=teclado.next();
                                publicaciones.get(i).comentarios.add(comentario);
                            }
                            System.out.println("Deseas guardarlo? y/n ?");
                            guardado=teclado.next();
                            if(guardado.equalsIgnoreCase("y")){
                                guardados.add(publicaciones.get(i));
                            }


                            
                        }

                    }else if(eleccion==4){
                        String fecha;
                        System.out.println("Ingresa la fecha en formato dd-MM-yyyy");
                        fecha=teclado.next();
                        ArrayList<Publicacion>porFechas=new ArrayList<Publicacion>();
                        for(int i=0;i<publicaciones.size();i++){
                            if(fecha.equalsIgnoreCase(publicaciones.get(i).getFecha())){
                                porFechas.add(publicaciones.get(i));
                            }
                        }
                        for(int i=0;i<porFechas.size();i++){
                            porFechas.get(i).toString();
                        }
                    }else if(eleccion==5){
                        String hashtag;
                        System.out.println("Ingresa elhashtag");
                        hashtag=teclado.next();
                        ArrayList<Publicacion>porHashtag=new ArrayList<Publicacion>();
                        for(int i=0;i<publicaciones.size();i++){
                            if(hashtag.equalsIgnoreCase(publicaciones.get(i).getHashtag())){
                                porHashtag.add(publicaciones.get(i));
                            }
                        }
                        for(int i=0;i<porHashtag.size();i++){
                            porHashtag.get(i).toString();
                        }
                    }else if(eleccion==6){
                        for(int i=0;i<guardados.size();i++){
                            guardados.get(i).toString();
                        }
                    }else if(eleccion==7){
                        System.out.println("Gracias por usar QueOndaMano");
                    }else{
                        System.out.println("Ingresa una opcion correcta");
                    }
                }
            }else{
                System.out.println("----------------------------------------------------------------------------------------------------");
            }
        }
        
    }
}