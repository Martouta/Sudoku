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
}