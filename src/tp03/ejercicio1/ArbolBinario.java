package tp03.ejercicio1;
import tp02.ejercicio3.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	
	public int contarHojas() {
		int cont = 0;
		if (!this.esVacio()) {
			if (this.esHoja())
				cont++;
			else {
				if (this.tieneHijoIzquierdo())
					cont= cont + this.getHijoIzquierdo().contarHojas();
				if(this.tieneHijoDerecho())
					cont= cont + this.getHijoDerecho().contarHojas();
			}
		}
		return cont;
	}
	
		
    public ArbolBinario<T> espejo() {
    	ArbolBinario<T> nuevo = new ArbolBinario<T>(this.getDato());
    	if (!this.esVacio()) {
			if (!this.esHoja()) {
				if (this.tieneHijoDerecho()) 
					nuevo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
				if (this.tieneHijoIzquierdo())
					nuevo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());;
		    }
	    }
    	return nuevo;
    }

    
    public void inOrder() {
    	if (this.tieneHijoIzquierdo())
    		this.getHijoIzquierdo().inOrder();
    	
    	System.out.print(this.getDato() + " - ");
    	
    	if (this.tieneHijoDerecho()) 
    		this.getHijoDerecho().inOrder();
    }
    
    
	public void entreNiveles(int n, int m){
		ArbolBinario<T> v;
		ColaGenerica<ArbolBinario<T>>  cola = new ColaGenerica<ArbolBinario<T>>();
		
		cola.encolar(this);
		cola.encolar(null);
		int nivel= 0;
		
		while (!cola.esVacia() && nivel<= m) {
			v = cola.desencolar();
			if (v!=null) {
				if (nivel>= n) 
					System.out.print(v.getDato() + " - ");
				
			    if (v.tieneHijoIzquierdo())
			    	cola.encolar(v.getHijoIzquierdo());
				if (v.tieneHijoDerecho())
					cola.encolar(v.getHijoDerecho());
			} else if (!cola.esVacia()){
				cola.encolar(null);
				nivel ++;
				System.out.println();
				System.out.println("Nivel " + nivel + ": ");
			}
		}
	}
	public int altura() {
		int altura = -1;
		if (!this.esVacio()) {
			if (!this.esHoja()) {
				if (this.tieneHijoIzquierdo())
					altura = Math.max( altura, this.getHijoIzquierdo().altura());
				if (this.tieneHijoDerecho())
					altura = Math.max( altura, this.getHijoDerecho().altura());
			}
			return altura +1;
		}
		return altura;
	}
	

}
