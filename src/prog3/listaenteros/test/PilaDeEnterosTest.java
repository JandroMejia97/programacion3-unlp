package prog3.listaenteros.test;

import prog3.listaenteros.PilaDeEnteros;

public class PilaDeEnterosTest {

	public static void main(String[] args) {
		PilaDeEnteros pila = new PilaDeEnteros();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(5);
		for(int i=0;i<4;i++)
			System.out.println(pila.desapilar());
		System.out.println("Tope: " + pila.tope());

	}

}
