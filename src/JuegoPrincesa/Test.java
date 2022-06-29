package JuegoPrincesa;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;

public class Test {
	public static void main(String[] args) {
		 Personaje p0 = new Personaje("Scooby", "Animal");
		 Personaje p1 = new Personaje("Cenicienta", "Princesa");
		 Personaje p2 = new Personaje("Rojo", "Dragon");
		 Personaje p3 = new Personaje("Pluto", "Animal");
		 Personaje p4 = new Personaje("Negro", "Dragon");
		 Personaje p5 = new Personaje("La Bella", "Princesa");
		 Personaje p6 = new Personaje("Tweety", "Animal");
		 Personaje p7 = new Personaje("Cid", "Animal");
		 Personaje p8 = new Personaje("Coyote", "Animal");
		 ArbolGeneral<Personaje> a1 = new ArbolGeneral<Personaje>(p0);
		 ArbolGeneral<Personaje> a21 = new ArbolGeneral<Personaje>(p1);
		 ArbolGeneral<Personaje> a22 = new ArbolGeneral<Personaje>(p2);
		 ArbolGeneral<Personaje> a23 = new ArbolGeneral<Personaje>(p3);
		 ListaGenerica<ArbolGeneral<Personaje>> hijosa2 = new ListaEnlazadaGenerica<ArbolGeneral<Personaje>>();
		 hijosa2.agregarFinal(a21);
		 hijosa2.agregarFinal(a22);
		 hijosa2.agregarFinal(a23);
		 ArbolGeneral<Personaje> a2 = new ArbolGeneral<Personaje>(p4, hijosa2);
		 
		 ListaGenerica<ArbolGeneral<Personaje>> hijosa3 = new ListaEnlazadaGenerica<ArbolGeneral<Personaje>>();
		 ArbolGeneral<Personaje> a31 = new ArbolGeneral<Personaje>(p5);
		 ArbolGeneral<Personaje> a32 = new ArbolGeneral<Personaje>(p6);		 
		 hijosa3.agregarFinal(a31);
		 hijosa3.agregarFinal(a32);
		 ArbolGeneral<Personaje> a3 = new ArbolGeneral<Personaje>(p7, hijosa3);
		 
		 
		 
		 ListaGenerica<ArbolGeneral<Personaje>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Personaje>>();
		 hijos.agregarFinal(a1);
		 hijos.agregarFinal(a2);
		 hijos.agregarFinal(a3);		 
		 ArbolGeneral<Personaje> a = new ArbolGeneral<Personaje>(p8, hijos);
		 
		 Juego juego = new Juego();
		 juego.encontrarPrincesa(a);
	}
}
