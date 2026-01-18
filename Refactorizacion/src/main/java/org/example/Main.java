package org.example;

import SanchezJordan.controller.GradeController;
import SanchezJordan.model.GradeManager;
import SanchezJordan.view.gui.MainFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GradeManager model = new GradeManager();

            MainFrame view = new MainFrame();

            new GradeController(model, view);

            view.setVisible(true);
        });
    }
}