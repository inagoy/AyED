package practica1;

public class ProcesarArreglo {
	private static Datos d;
	
	public static Datos calculoA(int [] v) {
		
		int min=9999; int max = -1;
		int suma = 0;
		for (int i=0; i<v.length;i++) {
			suma = suma + v[i];
			if (v[i]<min) min = v[i];
			if (v[i]>max) max = v[i];
		}
		double prom = suma / v.length;
		Datos dat = new Datos(min,max,prom);
		
		return dat;
	}
	public static void calculoB(int [] v, Datos dat) {

		int min=9999; int max = -1;
		int suma = 0;
		for (int i=0; i<v.length;i++) {
			suma = suma + v[i];
			if (v[i]<min) min = v[i];
			if (v[i]>max) max = v[i];
		}
		double prom = suma / v.length;
		dat.setMin(min);
		dat.setMax(max);
		dat.setProm(prom);
	}
	
	public static void calculoC(int [] v) {
		
		int min=9999; int max = -1;
		int suma = 0;
		for (int i=0; i<v.length;i++) {
			suma = suma + v[i];
			if (v[i]<min) min = v[i];
			if (v[i]>max) max = v[i];
		}
		double prom = suma / v.length;
		d.setMax(max);
		d.setMin(min);
		d.setProm(prom);
		
	}
	
}
