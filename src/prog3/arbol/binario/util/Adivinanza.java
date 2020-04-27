package prog3.arbol.binario.util;

import prog3.arbol.binario.ArbolBinario;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Adivinanza {
	public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> ab) {
			ListaGenericaEnlazada<String> lI = new ListaGenericaEnlazada<String>();
			ListaGenericaEnlazada<String> lD = new ListaGenericaEnlazada<String>();
			if (!ab.getHijoIzquierdo().esVacio()) {
				lI = secuenciaConMasPreguntas(ab.getHijoIzquierdo());
				lI.agregarInicio("SI");
			}
			if (!ab.getHijoDerecho().esVacio()) {
				lD = secuenciaConMasPreguntas(ab.getHijoDerecho());
				lD.agregarInicio("NO");
			}
			lI.agregarInicio(ab.getDatoRaiz());
			lD.agregarInicio(ab.getDatoRaiz());
		return lI.tamanio() > lD.tamanio() ? lI : lD;
	}

	public ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntasVersion2 (ArbolBinario<String> ab) {
		ListaGenericaEnlazada<ListaGenericaEnlazada<String>> result = new ListaGenericaEnlazada<ListaGenericaEnlazada<String>>();
		ListaGenericaEnlazada<String> lI = new ListaGenericaEnlazada<String>();
		ListaGenericaEnlazada<String> lD = new ListaGenericaEnlazada<String>();
		if (!ab.getHijoIzquierdo().esVacio()) {
			lI = secuenciaConMasPreguntas(ab.getHijoIzquierdo());
			lI.agregarInicio("SI");
		}
		if (!ab.getHijoDerecho().esVacio()) {
			lD = secuenciaConMasPreguntas(ab.getHijoDerecho());
			lD.agregarInicio("NO");
		}
		lI.agregarInicio(ab.getDatoRaiz());
		lD.agregarInicio(ab.getDatoRaiz());
		if (lI.tamanio() == lD.tamanio()) {
			result.agregarFinal(lI);
			result.agregarFinal(lD);
		}
		return null;
	}

}
