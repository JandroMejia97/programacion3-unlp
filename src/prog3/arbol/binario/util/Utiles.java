package prog3.arbol.binario.util;

import prog3.arbol.binario.ArbolBinario;
import prog3.listagenerica.ColaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Utiles {
	
	public static int sumaMaximaVertical(ArbolBinario<Integer> ab) {
		int sumaDerecha = (int) ab.getDatoRaiz();
		int sumaIzquierda = (int) ab.getDatoRaiz();
		if (!ab.getHijoIzquierdo().esVacio())
			sumaDerecha += sumaMaximaVertical(ab.getHijoIzquierdo());
		if (!ab.getHijoDerecho().esVacio())
			sumaIzquierda += sumaMaximaVertical(ab.getHijoDerecho());
		return sumaDerecha > sumaIzquierda ? sumaDerecha: sumaIzquierda;
	}

	public static int sumaMaximaHorizontal(ArbolBinario<Integer> ab) {
		int sumaActual = 0, aux = 0;
		ArbolBinario<Integer> actual = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(ab);
		cola.encolar(null);
		while(!cola.esVacia()) {
			actual = cola.desencolar();
			if(actual!=null) {
				sumaActual += (int) actual.getDatoRaiz();
				if(!actual.getHijoIzquierdo().esVacio())
					cola.encolar(actual.getHijoIzquierdo());
				if(!actual.getHijoDerecho().esVacio())
					cola.encolar(actual.getHijoDerecho());
			} else {
				if(!cola.esVacia())
					cola.encolar(null);
				if (sumaActual>aux)
					aux=sumaActual;
				sumaActual = 0;
			}
		}
		return aux;
	}
	
	public static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> ab) {
		int suma = 0, nivel = 0;
		ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
		obtenerPeso(ab, l, nivel, suma);
		return l;
	}

	private static void obtenerPeso(ArbolBinario<Integer> ab, ListaGenericaEnlazada<Integer> l, int nivel, int sumaParcial) {
		if(!ab.esVacio()) {
			if(ab.esHoja()) {
				l.agregarFinal(sumaParcial + ab.getDatoRaiz()*nivel);
			}else {
				if(!ab.getHijoIzquierdo().esVacio() )
					obtenerPeso(ab.getHijoIzquierdo(), l, nivel+1, sumaParcial + ab.getDatoRaiz()*nivel);
				if(!ab.getHijoDerecho().esVacio())
					obtenerPeso(ab.getHijoDerecho(), l, nivel+1, sumaParcial + ab.getDatoRaiz()*nivel);
			}
		}
	}
}
