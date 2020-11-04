package com.siglo21.lectoresEscritores;

import java.sql.Timestamp;

public class GestorDB {
	private int numeroDeLectores = 0;
	private boolean hayEscritor = false;
	private int numeroEscritores = 0;

	public synchronized void openLector(int id) throws InterruptedException {
		while (hayEscritor || numeroEscritores > 0) {
			wait();
		}
		numeroDeLectores++;
		System.out.println(new Timestamp(System.currentTimeMillis())+"  Lector " + id + " entra en la DB" );
	}

	public synchronized void closeLector(int id) {
		System.out.println(new Timestamp(System.currentTimeMillis())+"  Lector " + id + " sale de la DB" );
		numeroDeLectores--;
		if (numeroDeLectores == 0) {
			notifyAll();
		}
	}

	public synchronized void openEscritor(int id) throws InterruptedException {
		numeroEscritores++;
		while (hayEscritor  || numeroDeLectores > 0) {
			wait();
		}
		hayEscritor = true;
		System.out.println(new Timestamp(System.currentTimeMillis())+"  Escritor " + id + " entra en la DB");

	}

	public synchronized void closeEscritor(int id) {
		numeroEscritores--;
		System.out.println(new Timestamp(System.currentTimeMillis())+"  Escritor " + id + " sale de la DB");
		hayEscritor = false;
		notifyAll();
	}

}
