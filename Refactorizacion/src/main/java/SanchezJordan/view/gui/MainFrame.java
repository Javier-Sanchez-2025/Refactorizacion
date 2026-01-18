package SanchezJordan.view.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTextField txtNombre;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;
    private JLabel lblResultado;

    private JButton btnCalcular;
    private JButton btnLimpiar;

    public MainFrame() {
        inicializarVista();
    }

    private void inicializarVista() {
        setTitle("Calculadora de Promedio Académico - MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel titulo = new JLabel("Sistema de Cálculo de Promedios", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(titulo, gbc);

        gbc.gridwidth = 1;

        gbc.gridy = 1;
        gbc.gridx = 0;
        panelPrincipal.add(new JLabel("Nombre del Estudiante:"), gbc);
        gbc.gridx = 1;
        txtNombre = new JTextField(20);
        panelPrincipal.add(txtNombre, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panelPrincipal.add(new JLabel("Nota Parcial 1:"), gbc);
        gbc.gridx = 1;
        txtNota1 = new JTextField(20);
        panelPrincipal.add(txtNota1, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panelPrincipal.add(new JLabel("Nota Parcial 2:"), gbc);
        gbc.gridx = 1;
        txtNota2 = new JTextField(20);
        panelPrincipal.add(txtNota2, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        panelPrincipal.add(new JLabel("Nota Parcial 3:"), gbc);
        gbc.gridx = 1;
        txtNota3 = new JTextField(20);
        panelPrincipal.add(txtNota3, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnCalcular = new JButton("Calcular");
        btnLimpiar = new JButton("Limpiar");
        panelBotones.add(btnCalcular);
        panelBotones.add(btnLimpiar);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(panelBotones, gbc);

        gbc.gridy = 6;
        lblResultado = new JLabel("Resultado: ", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.PLAIN, 12));
        lblResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        lblResultado.setPreferredSize(new Dimension(350, 80));
        panelPrincipal.add(lblResultado, gbc);

        add(panelPrincipal);
    }

    public String getNombre() {
        return txtNombre.getText().trim();
    }

    public String getNota1() {
        return txtNota1.getText().trim();
    }

    public String getNota2() {
        return txtNota2.getText().trim();
    }

    public String getNota3() {
        return txtNota3.getText().trim();
    }

    public void setResultado(String nombre, double promedio, String estado) {
        String textoResultado = String.format("<html><center><b>%s</b><br>Promedio: %.2f<br>Estado: %s</center></html>",
                nombre, promedio, estado);
        lblResultado.setText(textoResultado);

        if (estado.equals("Aprobado")) {
            lblResultado.setForeground(new Color(0, 100, 0)); // Verde oscuro
            lblResultado.setBackground(new Color(220, 255, 220)); // Verde claro
        } else {
            lblResultado.setForeground(Color.RED);
            lblResultado.setBackground(new Color(255, 220, 220)); // Rojo claro
        }
        lblResultado.setOpaque(true);
    }

    public void limpiarResultado() {
        lblResultado.setText("Resultado: ");
        lblResultado.setForeground(Color.BLACK);
        lblResultado.setBackground(null);
        lblResultado.setOpaque(false);
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
        txtNombre.requestFocus();
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}