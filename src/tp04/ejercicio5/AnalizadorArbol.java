package tp04.ejercicio5;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import tp02.ejercicio3.*;

public class AnalizadorArbol {
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol) {
		int prom, promMax = 0, suma = 0, cont = 0;
		
		if (arbol!= null && !arbol.esVacio()) {
			ColaGenerica<ArbolGeneral<AreaEmpresa>> cola;
			cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
			ArbolGeneral<AreaEmpresa> aux;
			int tardanza;
			ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos;
			
			cola.encolar(arbol);
			cola.encolar(null);
			
			while (!cola.esVacia()) {
				aux = cola.desencolar();
				if (aux != null) {
					tardanza = aux.getDato().getTardanza();
					suma = suma + tardanza;
					cont++;
					if (aux.tieneHijos()){
						hijos = aux.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) 
							cola.encolar(hijos.proximo());
					}
				
				} else if(!cola.esVacia()){
					prom = suma/cont;
					if (prom > promMax)
						promMax = prom;
					cola.encolar(null);
				}
			}
			
		}
		return promMax;
	}
}
