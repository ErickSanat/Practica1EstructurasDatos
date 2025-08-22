package org.example.practica1.Sorters;

import org.example.practica1.Persona;

public class BubbleSort {
    Persona A[];

    public BubbleSort(Persona[] A) {this.A = A;}

    public void bubbleSort() {
        int n = this.A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if(this.A[j - 1].getEdad() >  A[j].getEdad()) {
                    Persona aux = this.A[j - 1];
                    this.A[j - 1] = this.A[j];
                    this.A[j] = aux;
                }
            }
        }
    }
}
