public abstract class Embarcacion {
    protected String nombre;
    protected double capacidadToneladas;

    public Embarcacion(String nombre, double capacidadToneladas) {
        this.nombre = nombre;
        this.capacidadToneladas = capacidadToneladas;
    }

    public String getNombre() { return nombre; }

    public double calcularConsumoCombustible() {
        return capacidadToneladas * 0.5;
    }

    public abstract double calcularCostoAtraque();
}
