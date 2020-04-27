package prog3.listagenerica.test;

import prog3.listagenerica.ListaGenericaEnlazada;

public class Test {
	public static void main(String[] args) {
		ListaGenericaEnlazada<Integer> listaEnlazada = new ListaGenericaEnlazada<Integer>();
		listaEnlazada.agregarFinal(13);
		listaEnlazada.agregarFinal(4);
		listaEnlazada.agregarFinal(6);
		listaEnlazada.agregarFinal(1);
		listaEnlazada.agregarFinal(22);
		listaEnlazada.agregarFinal(0);
		listaEnlazada.agregarFinal(3);
		listaEnlazada.agregarFinal(12);
		System.out.println("Lista Original");
		System.out.println(listaEnlazada);
		System.out.println("Lista Invertida");
		System.out.println(listaEnlazada.invertir());
	}
}
