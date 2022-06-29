package practica1;

public class Enteros {
	public static void conFor(int a, int b) {
		for (int i=a; i<=b; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void conWhile(int a, int b) {
		while (a<=b) {
			System.out.print(a + " ");
			a++;
		}
		System.out.println();
	}
	public static void sinIterar(int a, int b) {
		if (a<=b) {
			System.out.print(a + " ");
			sinIterar(a+1,b);
		}
	}	
}
