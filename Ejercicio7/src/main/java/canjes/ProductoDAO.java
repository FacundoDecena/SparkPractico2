package canjes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductoDAO {
    private List<Producto> productos;

    public void init(){
        productos = new ArrayList<>();
        productos.add(new Producto("Palito Frutal x Uds", 420));
        productos.add(new Producto("Gigante 2 bochas", 1800));
        productos.add(new Producto("Capelina ", 2400));
        productos.add(new Producto("1/4 Kg", 3000));
        productos.add(new Producto("Capuccino", 3200));
        productos.add(new Producto("1/2 Kg", 6000));
        productos.add(new Producto("Crocantino", 6000));
        productos.add(new Producto("Bombón Suizo x 8 u.", 6000));
        productos.add(new Producto("Tentación 1 Lt.", 6000));
        productos.add(new Producto("Bombón Vainilla Split x 8 u.", 6000));
        productos.add(new Producto("Tentación Cadbury", 7000));
        productos.add(new Producto("Bombón Escocés x 8 u.", 7000));
        productos.add(new Producto("Torta", 11000));
    }

    public List<Producto> getProductos(){
        init();
        return productos;
    }

    public List<Producto> getCanjes(int puntos){
        init();
        List<Producto> disponibles = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getValor() <= puntos)
                disponibles.add(producto);
        }
        return disponibles;
    }

    public List<Producto> getTooExpensive(int puntos){
        init();
        List<Producto> caros = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getValor() > puntos)
                caros.add(producto);
        }
        return caros;
    }

}