package capaDomini;

public class FactoryCtrlCasosUso {
	CtrlCasoUsoIniciarSesion ctrlCUIniciarSesion;
	
	public CtrlCasoUsoIniciarSesion getCtrlCasoUsoIniciarSesion() {
		if (ctrlCUIniciarSesion == null) ctrlCUIniciarSesion = new CtrlCasoUsoIniciarSesion();
		return ctrlCUIniciarSesion;
	}
}
