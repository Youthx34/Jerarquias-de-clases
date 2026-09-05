public class Empleado extends Persona {
    protected double salario;

    public Empleado(String nombre, String dpi, int edad, double salario) {
        super(nombre, dpi, edad);
        this.salario = salario;
    }

    public double calcularSalarioMensual() {
        return salario + (salario * 0.10);
    }

    @Override
    public double calcularPuntuacion() {
        return salario / 1000.0;
    }
}
