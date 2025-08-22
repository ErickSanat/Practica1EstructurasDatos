package org.example.practica1;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.sort();
        Application.launch(HelloApplication.class, args);
    }
}
