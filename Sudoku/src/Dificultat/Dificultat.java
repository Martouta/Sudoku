package Dificultat;

abstract public class Dificultat {
	private static final String[] d = {"4x4", "9x9", "16x16"};
	
	public static boolean esValida(String s) {
		for (int i=0; i<d.length; ++i) {
			if (d[i].equals(s)) return true;
		}
		return false;
	}
	
	public static String[] getAll() {
		return d;
	}
	
	/* La dificultat d és valida */
	public static int toInt(String s) {
		int i = 0;
		boolean trobat = false;
		while (!trobat) {
			if (d[i].equals(s)) trobat = true;
			else ++i;
		}
		int val = Integer.parseInt(d[i].substring(0,1));
		if (val == 1) val = 16;
		return val;
	}
}