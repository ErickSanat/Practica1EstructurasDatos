package org.example.practica1.Sorters;

import org.example.practica1.Persona;

public class InsertSort {
    Persona A[];

    public InsertSort(Persona[] personas) {
        this.A = personas;
    }

    public void insertionSort() {
        int n = this.A.length;
        for (int i = 1; i < n; i++) {
            Persona p = this.A[i];
            int j = i - 1;
            while (j >= 0 && this.A[j].getNombre().compareToIgnoreCase(p.getNombre()) > 0) {
                this.A[j + 1] = this.A[j];
                j--;
            }
            this.A[j + 1] = p;
        }
    }
}
