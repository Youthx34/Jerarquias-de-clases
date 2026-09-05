public class Cliente extends Persona {
    private double totalCompras;

    public Cliente(String nombre, String dpi, int edad, double totalCompras) {
        super(nombre, dpi, edad);
        this.totalCompras = totalCompras;
    }

    public double calcularDescuento() {
        return totalCompras > 20000 ? totalCompras * 0.05 : 0;
    }

    @Override
    public double calcularPuntuacion() {
        return totalCompras / 1000.0;
    }
}
