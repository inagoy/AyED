package tp06.ejercicio5;
import tp06.ejercicio3.*;
import tp02.ejercicio2.*;

public class Mapa {
	
	private Grafo <String> mapaCiudades;
	
	public Mapa(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
	public Grafo<String> getMapaCiudades(){
		return this.mapaCiudades;
	}
	
	private Vertice<String> buscarVerticeCiudad(String ciudad) {
		ListaGenerica<Vertice<String>> listaV = this.getMapaCiudades().listaDeVertices();
		Vertice<String> v = null;
		listaV.comenzar();
		boolean encontre = false;
		while (!listaV.fin() && !encontre) {
			v = listaV.proximo();
			if (v.dato().equals(ciudad))
				encontre = true;
		}
		return v;
	}
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		
		ListaGenerica<String> res = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean [this.getMapaCiudades().listaDeVertices().tamanio()+1];
		Vertice<String> v = this.buscarVerticeCiudad(ciudad1);
		marca[v.getPosicion()] = true;
		caminoAct.agregarFinal(v.dato());
		devolverCaminoDfs(v,marca, res, caminoAct, ciudad2);
		return res;
	}
	
	private void  devolverCaminoDfs (Vertice<String> v, boolean[] marca, 
			ListaGenerica<String> res, ListaGenerica<String> caminoAct,  String ciudad2) {
		
		ListaGenerica<Arista<String>> ady = this.getMapaCiudades().listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin() && res.esVacia()) {
			Vertice<String> aux = ady.proximo().verticeDestino();
			if (!marca[aux.getPosicion()]){
				marca[aux.getPosicion()] = true;
				caminoAct.agregarFinal(aux.dato());
				if (aux.dato().equals(ciudad2)) {
					caminoAct.comenzar();
					while (!caminoAct.fin())
						res.agregarFinal(caminoAct.proximo());
				} else
					devolverCaminoDfs(aux,marca, res, caminoAct, ciudad2);
				caminoAct.eliminarEn(caminoAct.tamanio());
			}
		}
	}
	
	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
		ListaGenerica<String> ciudades){
		
		ListaGenerica<String> res = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean [this.getMapaCiudades().listaDeVertices().tamanio()+1];
		Vertice<String> v = this.buscarVerticeCiudad(ciudad1);
		marca[v.getPosicion()] = true;
		ciudades.comenzar();
		caminoAct.agregarFinal(v.dato());
		devolverCaminoExceptuandoDfs (v,marca, res, caminoAct, ciudad2,ciudades);
		return res;
	}
	private void  devolverCaminoExceptuandoDfs (Vertice<String> v, boolean[] marca, 
		ListaGenerica<String> res, ListaGenerica<String> caminoAct,  
		String ciudad2, ListaGenerica<String> ciudades) {
	
		ListaGenerica<Arista<String>> ady = this.getMapaCiudades().listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin() && res.esVacia()) {
			Vertice<String> aux = ady.proximo().verticeDestino();
			if (!marca[aux.getPosicion()] && !ciudades.incluye(aux.dato())){
				marca[aux.getPosicion()] = true;
				caminoAct.agregarFinal(aux.dato());
				if (aux.dato().equals(ciudad2)) {
					caminoAct.comenzar();
					while (!caminoAct.fin())
						res.agregarFinal(caminoAct.proximo());
				} else
					devolverCaminoDfs(aux,marca, res, caminoAct, ciudad2);
				caminoAct.eliminarEn(caminoAct.tamanio());
			}
		}
	}
	
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
		ListaGenerica<String> res = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean [this.getMapaCiudades().listaDeVertices().tamanio()+1];
		Vertice<String> v = this.buscarVerticeCiudad(ciudad1);
		caminoAct.agregarFinal(v.dato());
		Minimo min = new Minimo(99999);
		int distancia = 0;
		caminoMasCortoDfs(res,caminoAct,ciudad2, marca,v, min, distancia);
		return res;
	}

	private void caminoMasCortoDfs(ListaGenerica<String> res, ListaGenerica<String> caminoAct, 
			String ciudad2, boolean[] marca, Vertice<String> v, Minimo min, int distancia) {
		
		
		marca[v.getPosicion()] = true;
		ListaGenerica<Arista<String>> ady = this.getMapaCiudades().listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()) {
			Arista<String> a = ady.proximo();
			int posV = a.verticeDestino().getPosicion();
			String ciudad = a.verticeDestino().dato();
			if ((!marca[posV]) && (distancia+a.peso()<min.getMinimo())) {
				distancia+=a.peso();
				caminoAct.agregarFinal(ciudad);
				if (ciudad.equals(ciudad2)) {
					min.setMinimo(distancia);
					res.comenzar();
					while(!res.fin())
						res.eliminar(res.proximo());
					caminoAct.comenzar();
					while (!caminoAct.fin())
						res.agregarFinal(caminoAct.proximo());
				} else {
					caminoMasCortoDfs(res,caminoAct,ciudad2, 
							marca,a.verticeDestino(), min, distancia);
				}
				marca[posV] = false;
				distancia-= a.peso();
				caminoAct.eliminarEn(caminoAct.tamanio());
			}
		}
	}
	
	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1,
			String ciudad2, int tanqueAuto){
		ListaGenerica<String> res = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> caminoAct = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean [this.getMapaCiudades().listaDeVertices().tamanio()+1];
		Vertice<String> v = this.buscarVerticeCiudad(ciudad1);
		caminoAct.agregarFinal(v.dato());
		caminoSinCargarCombustible(res,caminoAct,ciudad2, tanqueAuto, marca,v);
		return res;		
	}
	private void caminoSinCargarCombustible(ListaGenerica<String> res, ListaGenerica<String> caminoAct, 
			String ciudad2, int tanqueAuto, boolean[] marca, Vertice<String> v) {
		
		marca[v.getPosicion()] = true;
		ListaGenerica<Arista<String>> ady = this.getMapaCiudades().listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin() && res.esVacia()) {
			Arista<String> a = ady.proximo();
			int posV = a.verticeDestino().getPosicion();
			String ciudad = a.verticeDestino().dato();
			if ((!marca[posV]) && (tanqueAuto-a.peso()> 0)) {
				tanqueAuto-=a.peso();
				caminoAct.agregarFinal(ciudad);
				if (ciudad.equals(ciudad2)) {
					caminoAct.comenzar();
					while (!caminoAct.fin())
						res.agregarFinal(caminoAct.proximo());
				} else
					caminoSinCargarCombustible(res,caminoAct,ciudad2, 
							tanqueAuto, marca,a.verticeDestino());
				marca[posV] = false;
				tanqueAuto+= a.peso();
				caminoAct.eliminarEn(caminoAct.tamanio());
			}
		}
	}
		
	
}
