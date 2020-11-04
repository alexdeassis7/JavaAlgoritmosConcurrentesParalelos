package com.siglo21.lectoresEscritores;

import java.util.Random;

public class Lector extends Thread {
	
	private static Random r = new Random();
	private GestorDB gestor;
	private int id;

	public Lector(GestorDB gestor, int id) {
		this.gestor = gestor;
		this.id = id;
	}
	
	public void run() {
		while(true) {
			try {
				gestor.openLector(id);
				//leyendo
				Thread.sleep(r.nextInt(2000));
				gestor.closeLector(id);
				Thread.sleep(r.nextInt(3000));
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
