package prog3.listagenerica;

public class PilaGenerica<T> {
	ListaGenerica<T> datos = new ListaGenericaEnlazada<T>();

	public PilaGenerica() {
	}

	public void apilar(T elem) {
		datos.agregarEn(elem, 0);
	}

	public T desapilar() {
		T ele = datos.elemento(0);
		datos.eliminarEn(0);
		return ele;
	}

	public T tope() {
		return datos.elemento(0);
	}

	public boolean esVacia() {
		return datos.tamanio() == 0;
	}
}
