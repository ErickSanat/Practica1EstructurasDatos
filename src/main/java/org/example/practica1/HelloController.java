package org.example.practica1;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    ObservableList<Persona> lista;

    @FXML
    RadioButton nombreButton, edadButton, alturaButton, pesoButton, imcButton, ascButton, descButton;

    ToggleGroup ordenamiento, orden;

    @FXML
    TableColumn<Persona, String> nombreColumn, edadColumn, alturaColumn, pesoColumn, imcColumn;

    @FXML
    TableView<Persona> table;

    @FXML
    TextField cuantos;

    @FXML
    private void exitApp() {
        System.exit(0);
    }

    @FXML
    private void initialize() {
        ordenamiento = new ToggleGroup();
        orden = new ToggleGroup();

        nombreButton.setToggleGroup(ordenamiento);
        nombreButton.setSelected(true);

        edadButton.setToggleGroup(ordenamiento);
        alturaButton.setToggleGroup(ordenamiento);
        pesoButton.setToggleGroup(ordenamiento);
        imcButton.setToggleGroup(ordenamiento);

        ascButton.setToggleGroup(orden);
        ascButton.setSelected(true);
        descButton.setToggleGroup(orden);

        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        edadColumn.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        alturaColumn.setCellValueFactory(new PropertyValueFactory<>("Altura"));
        pesoColumn.setCellValueFactory(new PropertyValueFactory<>("Peso"));
        imcColumn.setCellValueFactory(cellData -> {
            double imcValue = cellData.getValue().getImc();
            return new SimpleStringProperty(String.format("%.2f", imcValue));
        });
        lista = FXCollections.observableArrayList();
    }

    @FXML
    private void generarPersona() {
        if (!cuantos.getText().isEmpty()) {
            int cantidad = Integer.parseInt(cuantos.getText());
            lista = FXCollections.observableArrayList();
            for (int i = 0; i < cantidad; i++) {
                lista.add(new Persona());
            }
            table.setItems(lista);
        }
    }

    @FXML
    private void ordenar() {
        ordenarNombre();
        ordenarEdad();
        ordenarAltura();
        ordenarPeso();
        ordenarImc();
    }

    @FXML
    private void ordenarNombre() {
        if (nombreButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarNombre());
            } else {
                lista.sort(new OrdenarNombre().reversed());
            }
        }
    }

    @FXML
    private void ordenarEdad() {
        if (edadButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarEdad());
            } else {
                lista.sort(new OrdenarEdad().reversed());
            }
        }
    }

    @FXML
    private void ordenarAltura() {
        if (alturaButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarAlturas());
            } else {
                lista.sort(new OrdenarAlturas().reversed());
            }
        }
    }

    @FXML
    private void ordenarPeso() {
        if (pesoButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarPeso());
            } else {
                lista.sort(new OrdenarPeso().reversed());
            }
        }
    }

    @FXML
    private void ordenarImc() {
        if (imcButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarImc());
            } else {
                lista.sort(new OrdenarImc().reversed());
            }
        }
    }
}