package org.ejercicio2;

public class Main {
    public static void main(String[] args) {
        int numFilosofos=5;
        Filosofo filosofos[]=new Filosofo[numFilosofos];
        Cubiertos cubiertos;
        cubiertos=new Cubiertos(numFilosofos);
        Thread hilos[]=new Thread[numFilosofos];
        for (int i=1; i<numFilosofos; i++){
            filosofos[i]=new Filosofo(
                    cubiertos, i, i-1);
            hilos[i]=new Thread(filosofos[i]);
            hilos[i].start();
        }
        filosofos[0]=new Filosofo(
                cubiertos, 0, 4);
        hilos[0]=new Thread(filosofos[0]);
        hilos[0].start();
    }
}
