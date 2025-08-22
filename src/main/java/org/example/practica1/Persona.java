package org.example.practica1;
import java.util.*;

public class Persona {
    String nombre;
    int  edad, altura;
    double peso, imc;

    String[] nombres = {
            "Tulio Mango", "Paco Culms", "Caco Tún",
            "Sosa Pisa", "Beto Meco", "Duro González",
            "Harry Poto", "Tomás Tulo", "Chico Tazo",
            "Aprieta Fuertes", "Mete Loro", "Roy Nalga",
            "Hugo Marto", "Iván Duro", "Benito Camelas",
    };

    int[] edades = {25, 31, 22, 38, 29, 43, 26, 35, 20, 33, 27, 41, 24, 37, 30};

    double[] pesos = {68.5, 74.2, 62.8, 81.3, 71.6, 89.7, 65.9, 77.4, 58.2, 83.1, 69.8, 92.5, 63.7, 79.4, 72.9};

    int[] alturas = {168, 175, 162, 182, 171, 189, 165, 178, 155, 185, 169, 192, 163, 180, 173};

    public Persona() {
        Random rand = new Random();
        this.nombre = nombres[rand.nextInt(nombres.length)];
        this.edad = edades[rand.nextInt(edades.length)];
        this.altura = alturas[rand.nextInt(alturas.length)];
        this.peso = pesos[rand.nextInt(pesos.length)];
        this.imc = calcularImc(this.peso,this.altura);
    }

    private double calcularImc(double peso, int altura) {
        double alturaMetros = altura / 100.0;
        return peso / (alturaMetros * alturaMetros);
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s Edad: %d Altura: %d Peso: %.2f IMC: %.1f",
                             this.nombre, this.edad, this.altura, this.peso, this.imc);
    }

    public String getNombre() {return nombre;}
    public int  getEdad() {return edad;}
    public int getAltura() {return altura;}
    public double getImc() {return imc;}
    public double  getPeso() {return peso;}
}

class OrdenarNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return Integer.compare(0, o1.getNombre().compareToIgnoreCase(o2.getNombre()));
    }
}

class OrdenarEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return Integer.compare(0, o1.getEdad() - o2.getEdad());
    }
}

class OrdenarAlturas implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        return Integer.compare(0, o1.getAltura() - o2.getAltura());
    }
}

class  OrdenarPeso implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1.getPeso() - o2.getPeso() < 0) {
            return 1;
        }
        if (o1.getPeso() - o2.getPeso() > 0) {
            return -1;
        }
        return 0;
    }
}

class OrdenarImc implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1.getImc() - o2.getImc() < 0) {
            return 1;
        }
        if (o1.getImc() - o2.getImc() > 0) {
            return -1;
        }
        return 0;
    }
}