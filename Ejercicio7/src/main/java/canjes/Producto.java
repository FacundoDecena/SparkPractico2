package canjes;

import lombok.Data;

@Data
public class Producto {
    private String nombre;
    private int valor;
    public Producto(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }
}
