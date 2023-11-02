package org.ejercicio2;

import java.util.Random;

public class Filosofo implements Runnable{
    Cubiertos palillos;
    int posPalilloIzq,posPalilloDer;
    String nombre;
    public Filosofo(Cubiertos g, int pIzq, int pDer){
        this.palillos=g;
        this.posPalilloDer=pDer;
        this.posPalilloIzq=pIzq;
    }
    public void run() {
        while (true){
            boolean palillosCogidos;
            palillosCogidos=
                    this.palillos.intentarCogerCubiertos(
                            posPalilloIzq, posPalilloDer);
            if (palillosCogidos){
                comer();
                this.palillos.liberarCubiertos(
                        posPalilloIzq,
                        posPalilloDer);
                pensar();
            }
        }
    }

    private void comer() {
        System.out.println("Filosofo "+
                Thread.currentThread().getName()+
                " comiendo");
        esperarTiempoAzar();
    }
    private void esperarTiempoAzar() {
        Random generador=new Random();
        int msAzar=generador.nextInt(4000)+1000;
        try {
            Thread.sleep(msAzar);
        } catch (InterruptedException ex) {
            System.out.println("Fallo la espera");
        }
    }
    private void pensar(){
        System.out.println("Filosofo "+
                Thread.currentThread().getName()+
                " pensando");
        esperarTiempoAzar();
    }
}
