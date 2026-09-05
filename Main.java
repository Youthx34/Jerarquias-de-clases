import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Puerto puerto = new Puerto();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA PUERTO BARRIOS ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar barco de carga");
            System.out.println("3. Registrar barco pesquero");
            System.out.println("4. Agregar contenedor a un barco de carga");
            System.out.println("5. Calcular ingreso total del puerto");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: registrarCliente(); break;
                case 2: registrarBarcoCarga(); break;
                case 3: registrarBarcoPesquero(); break;
                case 4: agregarContenedor(); break;
                case 5: System.out.printf("Ingreso total del puerto: Q%.2f%n", puerto.calcularIngresoTotal()); break;
                case 0: System.out.println("Adios!"); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
        sc.close();
    }

    static void registrarCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("DPI: ");
        String dpi = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        System.out.print("Total de compras del anio: ");
        double compras = sc.nextDouble();
        sc.nextLine();

        Cliente cliente = new Cliente(nombre, dpi, edad, compras);
        puerto.registrarCliente(cliente);

        System.out.println("DPI valido: " + cliente.validarDPI());
        System.out.printf("Descuento: Q%.2f%n", cliente.calcularDescuento());
    }

    static void registrarBarcoCarga() {
        System.out.print("Nombre del barco: ");
        String nombre = sc.nextLine();
        System.out.print("Capacidad en toneladas: ");
        double capacidad = sc.nextDouble();
        sc.nextLine();

        BarcoCarga barco = new BarcoCarga(nombre, capacidad);
        puerto.registrarEmbarcacion(barco);

        System.out.printf("Costo de atraque: Q%.2f%n", barco.calcularCostoAtraque());
    }

    static void registrarBarcoPesquero() {
        System.out.print("Nombre del barco: ");
        String nombre = sc.nextLine();
        System.out.print("Capacidad en toneladas: ");
        double capacidad = sc.nextDouble();
        System.out.print("Toneladas de pescado: ");
        double pescado = sc.nextDouble();
        sc.nextLine();

        BarcoPesquero barco = new BarcoPesquero(nombre, capacidad, pescado);
        puerto.registrarEmbarcacion(barco);

        System.out.printf("Costo de atraque: Q%.2f%n", barco.calcularCostoAtraque());
    }

    static void agregarContenedor() {
        System.out.print("Nombre del barco de carga: ");
        String buscado = sc.nextLine();

        BarcoCarga encontrado = null;
        for (Embarcacion e : puerto.getEmbarcaciones()) {
            if (e instanceof BarcoCarga && e.getNombre().equalsIgnoreCase(buscado)) {
                encontrado = (BarcoCarga) e;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ese barco.");
            return;
        }

        System.out.print("Peso del contenedor en kg: ");
        double peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Tipo de carga: ");
        String tipo = sc.nextLine();

        Contenedor c = new Contenedor(peso, tipo);
        encontrado.agregarContenedor(c);

        System.out.println("Sobrepeso: " + c.esSobrepeso());
        System.out.printf("Costo de transporte: Q%.2f%n", c.calcularCostoTransporte());
        System.out.printf("Peso total del barco: %.2f kg%n", encontrado.calcularPesoTotal());
    }
}
