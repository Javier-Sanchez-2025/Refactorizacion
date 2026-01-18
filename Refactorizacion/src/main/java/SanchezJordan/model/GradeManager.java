package SanchezJordan.model;

public class GradeManager implements ICalculable {

    @Override
    public double calcularPromedio(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3.0;
    }

    @Override
    public String determinarEstado(double promedio) {
        return promedio >= 14.0 ? "Aprobado" : "Reprobado";
    }
    public boolean validarNotas(double n1, double n2, double n3) {
        return (n1 >= 0 && n1 <= 20) &&
                (n2 >= 0 && n2 <= 20) &&
                (n3 >= 0 && n3 <= 20);
    }
    public boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}