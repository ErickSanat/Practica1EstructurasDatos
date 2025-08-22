package org.example.practica1.Sorters;

import org.example.practica1.Persona;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    Persona[] A;

    public MergeSort(Persona[] A) {
        this.A = A;
    }

    public void mergeSort(int min, int max) {
        if (min < max) {
            int mid = min + (max - min) / 2;
            mergeSort(min, mid);
            mergeSort(mid + 1, max);
            merge(min, mid, max);
        }
    }

    public void merge(int min, int mid, int max) {
        int n1 = mid - min + 1;
        int n2 = max - mid;

        Persona[] leftArray = new Persona[n1];
        Persona[] rightArray = new Persona[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = A[min + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = A[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = min;

        while (i < n1 && j < n2) {
            if (leftArray[i].getImc() <= rightArray[j].getImc()) {
                A[k] = leftArray[i];
                i++;
            } else {
                A[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = rightArray[j];
            j++;
            k++;
        }
    }
}