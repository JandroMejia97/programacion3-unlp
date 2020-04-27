package prog3.listagenerica.test;

import prog3.listagenerica.PilaGenerica;

public class PilaTest {

	public static void main(String[] args) {
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		pila.apilar('a');
		pila.apilar('b');
		pila.apilar('c');
		pila.apilar('d');
		pila.apilar('e');
		for(int i=0;i<4;i++)
			System.out.println(pila.desapilar());
		System.out.println("Tope: " + pila.tope());
	}

}
