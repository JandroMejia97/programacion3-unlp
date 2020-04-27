package prog3.listaenteros.test;

import prog3.listagenerica.ListaDeEnterosEnlazada;
import prog3.util.UtilitariosLista;

public class TestOrdenamientos {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada listaEnlazada = new ListaDeEnterosEnlazada();
		listaEnlazada.agregarFinal(13);
		listaEnlazada.agregarFinal(4);
		listaEnlazada.agregarFinal(6);
		listaEnlazada.agregarFinal(1);
		listaEnlazada.agregarFinal(22);
		listaEnlazada.agregarFinal(0);
		listaEnlazada.agregarFinal(3);
		listaEnlazada.agregarFinal(12);
		ListaDeEnterosEnlazada listaEnlazada2 = new ListaDeEnterosEnlazada();
		listaEnlazada2.agregarFinal(17);
		listaEnlazada2.agregarFinal(5);
		listaEnlazada2.agregarFinal(28);
		listaEnlazada2.agregarFinal(14);
		listaEnlazada2.agregarFinal(2);
		listaEnlazada2.agregarFinal(11);
		listaEnlazada2.agregarFinal(34);
		listaEnlazada2.agregarFinal(10);
		ListaDeEnterosEnlazada lista3 = new ListaDeEnterosEnlazada();
		listaEnlazada.comenzar();
		while(!listaEnlazada.fin())
			lista3.agregarFinal(listaEnlazada.proximo());
		listaEnlazada2.comenzar();
		while(!listaEnlazada2.fin())
			lista3.agregarFinal(listaEnlazada2.proximo());
		System.out.println("Lista 1 original");
		System.out.println(listaEnlazada);
		System.out.println("Lista 2 original");
		System.out.println(listaEnlazada2);
		System.out.println("Lista 1 ordenada");
		listaEnlazada = listaEnlazada.ordenar();
		System.out.println(listaEnlazada);
		System.out.println("Lista 2 ordenada");
		listaEnlazada2 = listaEnlazada2.ordenar();
		System.out.println(listaEnlazada2);
		System.out.println("Lista 3 cominando 1 y 2");
		System.out.println(listaEnlazada.combinarOrdenado(listaEnlazada2));
		System.out.println("Lista 3 original");
		System.out.println(lista3);
		System.out.println("Lista 3 mergeSort");
		System.out.println(UtilitariosLista.mergeSort(lista3));
		
	}

}
