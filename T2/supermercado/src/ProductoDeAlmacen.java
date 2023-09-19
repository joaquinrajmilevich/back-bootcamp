public class ProductoDeAlmacen extends Producto implements IImpuestos {
    String categoria;

    @Override
    public double calcularIva() {
        return precio / IVA;
    }

    public ProductoDeAlmacen(double precio, String nombre, String categoria) {
        super(precio, nombre);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nombre + ": $" + precio + " categoria: " + categoria;
    }
}
