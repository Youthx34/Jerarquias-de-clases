public class Contenedor {
    private double peso;
    private String tipo;

    public Contenedor(double peso, String tipo) {
        this.peso = peso;
        this.tipo = tipo;
    }

    public double getPeso() { return peso; }

    public String getTipo() {
        return tipo;
    }

    public boolean esSobrepeso() {
        return peso > 28000;
    }

    public double calcularCostoTransporte() {
        return peso * 0.08;
    }
}
