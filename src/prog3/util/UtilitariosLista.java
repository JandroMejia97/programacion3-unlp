package prog3.util;

import prog3.listagenerica.ListaDeEnterosEnlazada;

public class UtilitariosLista {
	
	public static ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada l1) {
		if (l1.tamanio() == 1)
			return l1;
		int q = l1.tamanio()/2;
		ListaDeEnterosEnlazada left = new ListaDeEnterosEnlazada(); 
		ListaDeEnterosEnlazada right = new ListaDeEnterosEnlazada();
		l1.comenzar();
		for (int i=0;i < l1.tamanio(); i++)
			if(i < q)
				left.agregarFinal(l1.proximo());
			else
				right.agregarFinal(l1.proximo());
		return merge(mergeSort(left), mergeSort(right));			
	}

	public static ListaDeEnterosEnlazada merge(ListaDeEnterosEnlazada left, ListaDeEnterosEnlazada right) {
		ListaDeEnterosEnlazada aux = new ListaDeEnterosEnlazada();
		left.comenzar();
		right.comenzar();
		while(!left.fin() && !right.fin()) {
			int a = left.proximo();
			int b = right.proximo();
			if (a <= b)
				aux.agregarFinal(a);
			else 
				aux.agregarFinal(b);
		}
		while(!left.fin())
			aux.agregarFinal(left.proximo());
		while(!right.fin())
			aux.agregarFinal(right.proximo());

		return aux;
	}
}
