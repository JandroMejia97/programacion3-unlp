package prog3.arbol.binario;

import prog3.listagenerica.ColaGenerica;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;
	
	public ArbolBinario(){		
		this.raiz = null;
	}
	
	public ArbolBinario(T dato){		
		this.raiz = new NodoBinario<T>(dato);
	}	
	
	private ArbolBinario(NodoBinario<T> nodo){		
		this.raiz = nodo;
	}
	
	private NodoBinario<T> getRaiz(){		
		return raiz;
	}
	
	public T getDatoRaiz(){
		if (this.getRaiz() != null){
			return this.getRaiz().getDato();
		}else{
			return null;
		}
	}
	
	public ArbolBinario<T> getHijoIzquierdo(){		
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}
	
	public ArbolBinario<T> getHijoDerecho(){		
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}	
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo){		
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo){		
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}	
	
	public void eliminarHijoIzquierdo(){		
		this.raiz.setHijoIzquierdo(new NodoBinario<T>(null));
	}
	
	public void eliminarHijoDerecho(){		
		this.raiz.setHijoDerecho(new NodoBinario<T>(null));
	}	
	
	public boolean esVacio(){
		return this.raiz==null;
	}
	
	public boolean esHoja(){
		return this.getDatoRaiz()!=null && this.getHijoIzquierdo().esVacio() && this.getHijoDerecho().esVacio();
	}
	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		preordenFrontera(l, this);
		return l;
	}

	private void preordenFrontera(ListaGenerica<T> l, ArbolBinario<T> ab) {
		if(ab.esHoja())
			l.agregarFinal(ab.getDatoRaiz());
		if(!ab.getHijoIzquierdo().esVacio())
			ab.getHijoIzquierdo().preordenFrontera(l, ab.getHijoIzquierdo());
		if(!ab.getHijoDerecho().esVacio())
			ab.getHijoDerecho().preordenFrontera(l, ab.getHijoDerecho());
	}
	

	public boolean lleno() {
		ArbolBinario<T> ab = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		boolean lleno = true;
		cola.encolar(this);
		int cantNodos = 0;
		cola.encolar(null);
		int nivel = 0;
		while(!cola.esVacia() && lleno) {
			ab = cola.desencolar();
			if(ab != null) {
				System.out.println(ab.getDatoRaiz());
				if(!ab.getHijoIzquierdo().esVacio()) {
					cola.encolar(ab.getHijoIzquierdo());
					cantNodos++;
				}
				if(!ab.getHijoDerecho().esVacio()) {
					cola.encolar(ab.getHijoDerecho());
					cantNodos++;
				}
			} else if(!cola.esVacia()) {
				if(cantNodos == Math.pow(2, ++nivel)) {
					cola.encolar(null);
					cantNodos = 0;
					System.out.println();
				} else
					lleno=false;
			}
		}
		return lleno;
	}
	
	public boolean completo() {
		ArbolBinario<T> ab = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		boolean completo = true;
		cola.encolar(this);
		int cantNodos = 0;
		cola.encolar(null);
		int nivel = 0;
		while(!cola.esVacia() && completo) {
			ab = cola.desencolar();
			if(ab != null) {
				System.out.println(ab.getDatoRaiz());
				if(!ab.getHijoIzquierdo().esVacio()) {
					cola.encolar(ab.getHijoIzquierdo());
					cantNodos++;
				}
				if(!ab.getHijoDerecho().esVacio()) {
					cola.encolar(ab.getHijoDerecho());
					cantNodos++;
				}
				if(ab.getHijoIzquierdo().esVacio() && !ab.getHijoDerecho().esVacio())
					completo = false;
			} else if(!cola.esVacia()) {
				if(cantNodos >= Math.pow(2, ++nivel) && cantNodos <= (Math.pow(2, nivel + 1) - 1)) {
					cola.encolar(null);
					System.out.println();
				} else
					completo = false;
			}
		}
		return completo;

	}
	
	
}