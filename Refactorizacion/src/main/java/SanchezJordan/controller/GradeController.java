package SanchezJordan.controller;

import SanchezJordan.model.GradeManager;
import SanchezJordan.view.gui.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeController implements ActionListener {
    private final GradeManager model;
    private final MainFrame view;

    public GradeController(GradeManager model, MainFrame view) {
        this.model = model;
        this.view = view;

        view.getBtnCalcular().addActionListener(this);
        view.getBtnLimpiar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == view.getBtnCalcular()) {
            calcularPromedio();
        } else if (source == view.getBtnLimpiar()) {
            limpiarTodo();
        }
    }

    private void calcularPromedio() {
        try {
            String nombre = view.getNombre();
            if (!model.validarNombre(nombre)) {
                view.mostrarAdvertencia("Por favor ingrese el nombre del estudiante");
                return;
            }

            double nota1 = Double.parseDouble(view.getNota1());
            double nota2 = Double.parseDouble(view.getNota2());
            double nota3 = Double.parseDouble(view.getNota3());

            if (!model.validarNotas(nota1, nota2, nota3)) {
                view.mostrarError("Las notas deben estar entre 0 y 20");
                return;
            }

            double promedio = model.calcularPromedio(nota1, nota2, nota3);
            String estado = model.determinarEstado(promedio);

            view.setResultado(nombre, promedio, estado);

        } catch (NumberFormatException ex) {
            view.mostrarError("Por favor ingrese valores numéricos válidos para todas las notas");
        } catch (Exception ex) {
            view.mostrarError("Error inesperado: " + ex.getMessage());
        }
    }

    private void limpiarTodo() {
        view.limpiarCampos();
        view.limpiarResultado();
    }
}