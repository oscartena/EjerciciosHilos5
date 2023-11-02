package org.ejercicio2;

public class Cubiertos {
    boolean palilloLibre[];
    public Cubiertos(int numPalillos){
        palilloLibre=new boolean[numPalillos];
        for (int i=0; i<numPalillos; i++){
            palilloLibre[i]=true;
        }
    }
    public synchronized boolean intentarCogerCubiertos(int izquierda, int derecha) {
        boolean seConsigue=false;
        if (
                (palilloLibre[izquierda])
                        &&
                        (palilloLibre[derecha]) )
        {
            palilloLibre[izquierda]=false;
            palilloLibre[derecha]=false;
            seConsigue=true;
        }
        return seConsigue;
    }

    public void liberarCubiertos(int izquierda, int derecha){
        palilloLibre[izquierda]=true;
        palilloLibre[derecha]=true;
    }
}
