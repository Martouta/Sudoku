package capaDomini;
 
import persistencia.CtrlUser;
 
import excepciones.excUsuario.*;
 
//LISTO PARA PROGRAMARLO
//fet, no provat
public class CtrlCasoUsoIniciarSesion {
        public void iniciarSesion(String nombreUsuario, String contrasena) throws ExcepcionUsuarioNoExiste, ExcepcionContrasenaIncorrecta{
        	    CtrlUser.init();
        	    
                if(CtrlUser.getUsuari(nombreUsuario) == null) throw new ExcepcionUsuarioNoExiste();
                if(!CtrlUser.comprovaPwd(nombreUsuario, contrasena)) throw new ExcepcionContrasenaIncorrecta();
               
                /*FALTA HACER ESTA FUNCION:
                Debe comprobar si el usuario "nombreUsuario" existe y si la contrasena "contrasena" es correcta,
                si es el caso, no hay que devolver nada ni hacer nada mas,
                pero si no es el caso, hay que activar la excepcion correspondiente,
                que puede ser "ExcepcionUsuarioNoExiste" o "ExcepcionContrasenaIncorrecta"
                */
        }
}