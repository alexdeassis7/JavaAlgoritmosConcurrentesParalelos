package com.siglo21.lectoresEscritores;

public class ProgramaPrincipal {
	public static void main(String[] args) {
		GestorDB gestor = new GestorDB();
		
		Escritor[] escritor = new Escritor[2];
		Lector[] lector = new Lector[10];
		
		for (int i = 0; i < escritor.length; i++) {
			escritor[i] =  new  Escritor(gestor, i);
		}
		
		for (int i = 0; i < lector.length; i++) {
			lector[i] =  new  Lector(gestor, i);
		}
		
		for (int i = 0; i < escritor.length; i++) {
			escritor[i].start();
		}
		
		for (int i = 0; i < lector.length; i++) {
			lector[i].start();
		}
	}
}
