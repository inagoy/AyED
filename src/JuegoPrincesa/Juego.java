package JuegoPrincesa;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;

public class Juego {
	public void encontrarPrincesa(ArbolGeneral<Personaje> arbol) {
		ListaGenerica<Personaje> lista = new ListaEnlazadaGenerica<Personaje>();
		lista.agregarInicio(arbol.getDato());
		ListaGenerica<Personaje> camino = new ListaEnlazadaGenerica<Personaje>();
		encontrarPrincesa(arbol, lista, camino);
		System.out.print("Se encontró a la Princesa en el camino: " + camino);
		}
	private void encontrarPrincesa(ArbolGeneral<Personaje> arbol, ListaGenerica<Personaje> lista,
		ListaGenerica<Personaje> camino) {
		
		Personaje p = arbol.getDato();
		if (p.esPrincesa()) {
		 clonar(lista, camino);
		}
		else {
			ListaGenerica<ArbolGeneral<Personaje>> lHijos = arbol.getHijos();
			lHijos.comenzar();
			while (!lHijos.fin() && camino.esVacia()) {
				ArbolGeneral<Personaje> aux = lHijos.proximo();
				if (!aux.getDato().esDragon()) {
					lista.agregarFinal(aux.getDato());
					encontrarPrincesa(aux, lista, camino);
					lista.eliminarEn(lista.tamanio());
				}
			}
		}
	}
	private void clonar(ListaGenerica<Personaje>from, ListaGenerica<Personaje>to) {
		from.comenzar();
		while(!from.fin())
			to.agregarFinal(from.proximo());
	}
}
