import java.util.ArrayList;

public class Carrito {
    ArrayList<ProductoDeAlmacen> carritoCollection = new ArrayList<>();

    void agregarProducto(ProductoDeAlmacen nuevoProducto) {
        carritoCollection.add(nuevoProducto);
    }

    void eliminarProducto(ProductoDeAlmacen productoExistente) {
        carritoCollection.remove(productoExistente);
    }

    int cantidadProductos() {
        return carritoCollection.size();
    }

    double importeTotal() {
        double total = 0;
        for (ProductoDeAlmacen producto : carritoCollection) {
            total += producto.calcularIva();
        }
        return total;
    }

    void contenidoCarrito() {
        System.out.println("===================");
        System.out.println("Tiene " + cantidadProductos() + " productos en el carrito.");
        int index = 1;
        for (ProductoDeAlmacen producto : carritoCollection) {
            System.out.println(index + ". " + producto.toString());
            index++;
        }
    }
}
