import java.util.ArrayList;
import java.util.List;

public class BarcoCarga extends Embarcacion {
    private List<Contenedor> contenedores = new ArrayList<>();

    public BarcoCarga(String nombre, double capacidadToneladas) {
        super(nombre, capacidadToneladas);
    }

    public void agregarContenedor(Contenedor c) {
        contenedores.add(c);
    }

    public double calcularPesoTotal() {
        double total = 0;
        for (Contenedor c : contenedores) {
            total += c.getPeso();
        }
        return total;
    }

    @Override
    public double calcularCostoAtraque() {
        return capacidadToneladas * 5;
    }
}
