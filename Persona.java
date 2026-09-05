public abstract class Persona {
    protected String nombre;
    protected String dpi;
    protected int edad;

    public Persona(String nombre, String dpi, int edad) {
        this.nombre = nombre;
        this.dpi = dpi;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }

    public boolean validarDPI() {
        return dpi != null && dpi.length() == 13;
    }

    public abstract double calcularPuntuacion();
}
