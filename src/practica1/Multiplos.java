package practica1;

public class Multiplos {
	public static int[] mul(int n) {
		int [] v = new int [n];
		for (int i= 0; i<n; i++) {
			v[i]= n * (i+1);
		}
		return v;
	}
}
