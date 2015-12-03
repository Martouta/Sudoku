package capaDomini;
 
import persistencia.CtrlUser;
 
import excepciones.excUsuario.*;
 
//LISTO PARA PROGRAMARLO
//fet, no provat
 
public class CtrlCasoUsoRegistrarse {
        public void registrarse(String nombreUsuario, String contrasena) throws ExcepcionUsuarioYaExiste {
        	    CtrlUser.init();
                User u = CtrlUser.getUsuari(nombreUsuario);
                if(u != null) throw new ExcepcionUsuarioYaExiste();
                else {
                        u=new User(nombreUsuario, contrasena);
                        CtrlUser.afegeixUsuari(u);
                        CtrlUser.end();
                }
               
                /*FALTA HACER ESTA FUNCION:
                Si el usuario "nombreUsuario" ya existe, activa la excepcion "ExcepcionUsuarioYaExiste",
                si no: da de alta el usuario "nombreUsuario" con la contrasena "contrasena"
                //me imagino que tendras que hacer algo del tipo contrasena.isEmpty() en algun lado pero no estoy segura
                */
        }
}