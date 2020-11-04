package com.siglo21.lectoresEscritores;

import java.util.Random;

public class Escritor extends Thread{
	
	private static Random r = new Random();
	private GestorDB gestor;
	private int id;

	public Escritor(GestorDB gestor, int id) {
		this.gestor = gestor;
		this.id = id;
	}
	
	public void run() {
		while(true) {
			try {
				gestor.openEscritor(id);
				//Escribiendo
				Thread.sleep(r.nextInt(2000));
				gestor.closeEscritor(id);
				Thread.sleep(r.nextInt(3000));
				
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		
		}
	}

}
