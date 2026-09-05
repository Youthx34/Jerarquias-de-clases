public class BarcoPesquero extends Embarcacion {
    private double toneladasPescado;

    public BarcoPesquero(String nombre, double capacidadToneladas, double toneladasPescado) {
        super(nombre, capacidadToneladas);
        this.toneladasPescado = toneladasPescado;
    }

    public double calcularGananciaPesca(double precioPorTonelada) {
        return toneladasPescado * precioPorTonelada;
    }

    @Override
    public double calcularCostoAtraque() {
        return capacidadToneladas * 3;
    }
}
