package prog3.listaenteros.test;

import prog3.listaenteros.*;
import prog3.listagenerica.ListaDeEnterosEnlazada;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada listaEnlazada = new ListaDeEnterosEnlazada();
		listaEnlazada.agregarFinal(2);
		listaEnlazada.agregarFinal(4);
		listaEnlazada.agregarFinal(6);
		listaEnlazada.agregarFinal(22);
		listaEnlazada.agregarFinal(3);
		listaEnlazada.agregarFinal(1);
		listaEnlazada.agregarFinal(0);
		listaEnlazada.agregarFinal(12);
		System.out.println("Usando toString()");
		System.out.println(listaEnlazada);
		System.out.println("Usando métodos");
		listaEnlazada.comenzar();
		while(!listaEnlazada.fin())
			System.out.print(listaEnlazada.proximo() + " -> ");
		listaEnlazada.comenzar();
		System.out.println();
		System.out.println("Usando inverso");
		imprimirLista(listaEnlazada);
	}

	public static void imprimirLista(ListaDeEnteros l) {
		Integer proximo = l.proximo();
		l.eliminar(proximo);
		l.agregarInicio(proximo);
		if (l.fin())
			System.out.println(l);
		else
			imprimirLista(l);
	}
}
