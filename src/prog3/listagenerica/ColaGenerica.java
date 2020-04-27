package prog3.listagenerica;

public class ColaGenerica<T> {
	ListaGenerica<T> datos = new ListaGenericaEnlazada<T>();

	public ColaGenerica() {
	}

	public void encolar(T elem) {
		datos.agregarFinal(elem);
	}

	public T desencolar() {
		T elem = datos.elemento(0);
		datos.eliminarEn(0);
		return elem;
	}

	public T tope() {
		return datos.elemento(0);
	}

	public boolean esVacia() {
		return datos.tamanio() == 0;
	}

}
