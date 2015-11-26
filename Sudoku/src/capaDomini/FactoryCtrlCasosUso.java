package capaDomini;

public class FactoryCtrlCasosUso {
	CtrlCasoUsoIniciarSesion ctrlCUIniciarSesion;
	
	public void prueba() {
		System.out.println("prueba");
	}
	
	public CtrlCasoUsoIniciarSesion getCtrlCasoUsoIniciarSesion() {
		if (ctrlCUIniciarSesion == null) ctrlCUIniciarSesion = new CtrlCasoUsoIniciarSesion();
		return ctrlCUIniciarSesion;
	}
}
