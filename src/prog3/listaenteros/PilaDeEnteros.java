package prog3.listaenteros;

import prog3.listagenerica.ListaDeEnterosEnlazada;

public class PilaDeEnteros {

	private ListaDeEnteros datos = new ListaDeEnterosEnlazada();

	public PilaDeEnteros() {
	}

	public void apilar(int elem) {
		datos.agregarEn(elem, 0);
	}

	public int desapilar() {
		int ele = datos.elemento(0);
		datos.eliminarEn(0);
		return ele;
	}

	public int tope() {
		return datos.elemento(0);
	}

	public boolean esVacia() {
		return datos.tamanio() == 0;
	}

}
