package familia;

import lombok.Data;

import java.util.List;

@Data
class Persona{
    private String nombre;
    private List<String> hijos;
    private List<String> padres;
    private List<String> hermanos;

    Persona(String nombre, List<String> hijos, List<String> padres, List<String> hermanos){
        this.nombre = nombre;
        this.hijos = hijos;
        this.padres = padres;
        this.hermanos = hermanos;
    }

    public void addHijo(String h){
        this.hijos.add(h);
    }
    public void addPadre(String h){
        this.padres.add(h);
    }
    public void addHermano(String h){
        this.hermanos.add(h);
    }

}
