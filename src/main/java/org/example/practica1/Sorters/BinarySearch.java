package org.example.practica1.Sorters;

import org.example.practica1.Persona;

public class BinarySearch {
    Persona[] A;

    public BinarySearch(Persona[] A) {this.A = A;}

    public int binarySearch(int x) {
        int left = 0,  right = this.A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (this.A[mid].getEdad() == x)
                return mid;
            if (this.A[mid].getEdad() < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    @Override
    public String toString() {
        int index = binarySearch(30);
        if (index != -1) {
            return "La edad 30 se encuentra en la posicion: " + index;
        }
        return "La edad no existe";
    }
}
