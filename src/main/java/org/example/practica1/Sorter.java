package org.example.practica1;

import org.example.practica1.Sorters.BubbleSort;
import org.example.practica1.Sorters.InsertSort;
import org.example.practica1.Sorters.MergeSort;
import org.example.practica1.Sorters.QuickSort;

public class Sorter {
    public void sort () {
        Persona persona[] = new Persona[15];
        for (int i = 0; i < persona.length; i++) {
            persona[i] = new Persona();
        }
        InsertSort insertSort = new InsertSort(persona);
        BubbleSort bubbleSort = new BubbleSort(persona);
        QuickSort quickSort = new QuickSort(persona);
        MergeSort mergeSort = new MergeSort(persona);

        System.out.println("Datos sin Ordenar:");
        imprimir(persona);

        System.out.println("\nOrdenando nombre por InsertionSort:");
        insertSort.insertionSort();
        imprimir(persona);

        System.out.println("\nOrdenando edad por BubbleSort:");
        bubbleSort.bubbleSort();
        imprimir(persona);

        System.out.println("\nOrdenando altura por QuickSort:");
        quickSort.quickSort(0, persona.length - 1);
        imprimir(persona);

        System.out.println("\nOrdenando IMC por MergeSort:");
        mergeSort.mergeSort(0, persona.length - 1);
        imprimir(persona);
    }

    public void imprimir (Persona A[]) {
        int i = 0;
        for (Persona p : A) {
            System.out.println(p);
        }
    }
}
