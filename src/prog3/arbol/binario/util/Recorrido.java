package prog3.arbol.binario.util;

import prog3.arbol.binario.ArbolBinario;

public class Recorrido<T> {

	public void imprimirPreOrden(ArbolBinario<T> aBinario) {
		System.out.println(aBinario.getDatoRaiz());
		if(!aBinario.getHijoIzquierdo().esVacio())
			imprimirPreOrden(aBinario.getHijoIzquierdo());
		if(!aBinario.getHijoDerecho().esVacio())
			imprimirPreOrden(aBinario.getHijoDerecho());
	}

	public void imprimirInOrden(ArbolBinario<T> aBinario) {
		if(!aBinario.getHijoIzquierdo().esVacio())
			imprimirPreOrden(aBinario.getHijoIzquierdo());
		System.out.println(aBinario.getDatoRaiz());
		if(!aBinario.getHijoDerecho().esVacio())
			imprimirPreOrden(aBinario.getHijoDerecho());
	}

	public void imprimirPostOrden(ArbolBinario<T> aBinario) {
		if(!aBinario.getHijoIzquierdo().esVacio())
			imprimirPreOrden(aBinario.getHijoIzquierdo());
		if(!aBinario.getHijoDerecho().esVacio())
			imprimirPreOrden(aBinario.getHijoDerecho());
		System.out.println(aBinario.getDatoRaiz());
	}
	
	
	public static void main(String[] args){
		ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);		
		ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));		
		ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));		
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
		
		Recorrido<Integer> recorrido= new Recorrido<Integer>();
		recorrido.imprimirPreOrden(arbolBinarioB);
		recorrido.imprimirInOrden(arbolBinarioB);
		recorrido.imprimirPostOrden(arbolBinarioB);
		System.out.println("SUMA VERTICAL: " + Utiles.sumaMaximaVertical(arbolBinarioB));
		System.out.println("SUMA HORIZONTAL: " + Utiles.sumaMaximaHorizontal(arbolBinarioB));
		System.out.println("TRAYECTORIA PESADA: " + Utiles.trayectoriaPesada(arbolBinarioB));
		
		ArbolBinario<String> abPreg = new ArbolBinario<String>("¿Tiene 4 patas?");
		ArbolBinario<String> hijoIzqP = new ArbolBinario<String>("¿Se mueve?");
		ArbolBinario<String> hijoDerP = new ArbolBinario<String>("¿Tiene alguna pata?");
		hijoIzqP.agregarHijoIzquierdo(new ArbolBinario<String>("¿Ladra?"));
		hijoIzqP.agregarHijoDerecho(new ArbolBinario<String>("Mesa"));
		hijoIzqP.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<String>("Perro"));
		abPreg.agregarHijoIzquierdo(hijoIzqP);
		abPreg.agregarHijoDerecho(hijoDerP);
		Adivinanza a = new Adivinanza();
		System.out.println("Adivinanza: " + a.secuenciaConMasPreguntas(abPreg));
	}
}
