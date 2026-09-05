import java.util.ArrayList;
import java.util.List;

public class Puerto {
    private List<Embarcacion> embarcaciones = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void registrarEmbarcacion(Embarcacion e) { embarcaciones.add(e); }
    public void registrarCliente(Cliente c) { clientes.add(c); }

    public List<Embarcacion> getEmbarcaciones() { return embarcaciones; }

    public double calcularIngresoTotal() {
        double total = 0;
        for (Embarcacion e : embarcaciones) {
            total += e.calcularCostoAtraque();
        }
        return total;
    }
}
