package prog3.listagenerica.test;

import prog3.listagenerica.ColaGenerica;

public class ColaTest {
	public static void main(String[] args) {
		ColaGenerica<Character> cola = new ColaGenerica<Character>();
		cola.encolar('a');
		cola.encolar('b');
		cola.encolar('c');
		cola.encolar('d');
		cola.encolar('e');
		for(int i=0;i<4;i++)
			System.out.println(cola.desencolar());
		System.out.println("Tope: " + cola.tope());
	}
}
