package org.example.practica1.Sorters;

import org.example.practica1.Persona;

public class QuickSort {
    Persona[] A;

    public QuickSort(Persona[] A) {this.A = A;}

    public void quickSort(int ini, int fin) {
        if (ini < fin) {
            int pivot = divide(ini, fin);
            quickSort(ini, pivot - 1);
            quickSort(pivot + 1, fin);
        }
    }

    int divide(int ini, int fin) {
        Persona p = this.A[ini];
        int izq = ini;
        int der = fin;
        Persona temp;
        while (izq < der) {
            while (this.A[der].getAltura() > p.getAltura()) {der--;}
            while (izq < der && this.A[izq].getAltura() <= p.getAltura()) {izq++;}

            if (izq < der) {
                temp = this.A[izq];
                this.A[izq] = this.A[der];
                this.A[der] = temp;
            }
        }
        temp = this.A[der];
        this.A[der] = this.A[ini];
        this.A[ini] = temp;
        return der;
    }
}
