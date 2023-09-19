
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrito carrito = new Carrito();
        TreeMap<Integer, ProductoDeAlmacen> almacenTreeMap = new TreeMap<>();
        ProductoDeAlmacen lechuga = new ProductoDeAlmacen(100, "lechuga", "vegetales");
        almacenTreeMap.put(1, lechuga);
        ProductoDeAlmacen jamon = new ProductoDeAlmacen(200, "jamon", "embutidos");
        almacenTreeMap.put(2, jamon);
        ProductoDeAlmacen leche = new ProductoDeAlmacen(300, "leche", "lacteos");
        almacenTreeMap.put(3, leche);
        ProductoDeAlmacen gel = new ProductoDeAlmacen(400, "gel", "cuidado corporal");
        almacenTreeMap.put(4, gel);
        ProductoDeAlmacen queso = new ProductoDeAlmacen(500, "queso", "lacteos");
        almacenTreeMap.put(5, queso);
        int option;
        do {
            System.out.println("===================");
            System.out.println("Bienvenido");
            System.out.println("===================");
            System.out.println("1. Añadir Producto al Carrito");
            System.out.println("2. Eliminar Producto del Carrito");
            System.out.println("3. Ver Contenido del Carrito");
            System.out.println("4. Importe total");
            System.out.println("5. Salir");
            System.out.print("Introduzca una opción: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("1. " + lechuga);
                    System.out.println("2. " + jamon);
                    System.out.println("3. " + leche);
                    System.out.println("4. " + gel);
                    System.out.println("5. " + queso);
                    System.out.println("Elija un producto: ");
                    int optionCarrito = scanner.nextInt();
                    try {
                        carrito.agregarProducto(almacenTreeMap.get(optionCarrito));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    carrito.contenidoCarrito();
                    System.out.println("Que producto desea eliminar? ");
                    if (carrito.carritoCollection.isEmpty()) {
                        System.out.println("No hay productos en el carrito");
                        break;
                    }
                    int optionCarritoEliminar = scanner.nextInt();
                    if (optionCarritoEliminar > carrito.carritoCollection.size() || optionCarritoEliminar == 0) {
                        System.out.println("Producto incorrecto");
                        break;
                    }
                    System.out.println("===================");
                    try {
                        System.out.println("Se ha eliminado el producto: " + carrito.carritoCollection.get(optionCarritoEliminar - 1).nombre);
                        carrito.eliminarProducto(carrito.carritoCollection.get(optionCarritoEliminar - 1));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    continuar(scanner);
                    break;
                case 3:
                    try {
                        carrito.contenidoCarrito();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    continuar(scanner);
                    break;
                case 4:
                    try {
                        System.out.println("===================");
                        System.out.println("El valor total es de $" + String.format("%.2f", carrito.importeTotal()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    continuar(scanner);
                    break;
            }
        } while (option != 5);
    }

    public static void continuar(Scanner scanner) {
        System.out.println("===================");
        System.out.println("Pulse enter para continuar");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}