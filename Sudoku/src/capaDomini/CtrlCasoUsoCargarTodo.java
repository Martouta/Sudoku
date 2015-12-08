package capaDomini;

import persistencia.CtrlUser;
import persistencia.CtrlJocSudoku;
import persistencia.CtrlPartida;

public class CtrlCasoUsoCargarTodo {
	public CtrlCasoUsoCargarTodo() {
		CtrlUser.init();
		CtrlJocSudoku.init();
		CtrlPartida.init();
	}
}
