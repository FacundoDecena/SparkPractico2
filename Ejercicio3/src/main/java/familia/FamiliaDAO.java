package familia;

import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO {
    private List<Persona> personas;
    private List<String> nombres;

    public void init(){
        personas = new ArrayList<Persona>();
        nombres = new ArrayList<String>();
        
        Persona jose = new Persona("Jose", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        Persona pedro = new Persona("Pedro", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        Persona juan = new Persona("Juan", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        Persona esteban = new Persona("Esteban", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        Persona sofia = new Persona("Sofia", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        Persona margarita = new Persona("Margarita", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        Persona josefina = new Persona("Josefina", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        
        // Josefina Un padre, sin hermanos, sin hijos
        josefina.addPadre(jose.getNombre());
        // Margarita Un padre, sin hermanos, sin hijos
        margarita.addPadre(juan.getNombre());
        // Esteban, sin padres, una hermana, sin hijos
        esteban.addHermano(sofia.getNombre());
        // Pedro, sin padres, dos hijos, sin hermanos
        pedro.addHijo(jose.getNombre()); pedro.addHijo(juan.getNombre());
        // Sofia, sin padres, un hermano, mismos hijos que pedro
        sofia.addHermano(esteban.getNombre());
        sofia.addHijo(jose.getNombre());
        sofia.addHijo(juan.getNombre());
        // Jose, dos padres, un hermano, una hija
        jose.addHermano(juan.getNombre());
        jose.addHijo(josefina.getNombre());
        jose.addPadre(pedro.getNombre());jose.addPadre(sofia.getNombre());

        // Juan, dos padres, un hermano, una hija
        juan.addHermano(jose.getNombre());
        juan.addHijo(margarita.getNombre());
        juan.addPadre(pedro.getNombre());juan.addPadre(sofia.getNombre());

        personas.add(pedro);personas.add(sofia);personas.add(esteban);personas.add(jose);
        personas.add(juan);personas.add(josefina);personas.add(margarita);

        nombres.add(pedro.getNombre());nombres.add(sofia.getNombre());nombres.add(esteban.getNombre());nombres.add(jose.getNombre());
        nombres.add(juan.getNombre());nombres.add(josefina.getNombre());nombres.add(margarita.getNombre());
    }

    public List<String> personas(){
        init();
        return nombres;
    }

    public List<String> hijos(String nombre){
        init();
        Persona persona = getPersonaFromNombre(nombre);
        if (persona != null)
           return persona.getHijos();
        return null;
    }

    public List<String> hermanos(String nombre){
        init();
        Persona persona = getPersonaFromNombre(nombre);
        if (persona != null)
           return persona.getHermanos();
        return null;
    }

    public List<String> nietos(String nombre){
        init();
        Persona persona = getPersonaFromNombre(nombre);
        if (persona != null){
            List<String> nietos = new ArrayList<>();
            if (persona.getHijos() == null)
                return null;
            persona.getHijos().forEach(hijo->{
                List<String> n = getPersonaFromNombre(hijo).getHijos();
                if (n != null)
                    nietos.addAll(n);
            });
            return nietos;
        }
        return null;
    }

    public List<String> padres(String nombre){
        init();
        Persona persona = getPersonaFromNombre(nombre);
        if (persona != null)
           return persona.getPadres();
        return null;
    }

    public List<String> tios(String nombre){
        init();
        Persona persona = getPersonaFromNombre(nombre);
        if (persona == null) 
            return null;

        List<String> tios = new ArrayList<>();

        if (persona.getPadres() == null)
            return null;
        persona.getPadres().forEach(padre -> {
            List<String> t = getPersonaFromNombre(padre).getHermanos();
            if(t != null)
                tios.addAll(t);
        });
        return tios;
    }

    public List<String> sobrinos(String nombre){
        init();
        Persona persona = getPersonaFromNombre(nombre);
        if (persona == null) 
            return null;
        List<String> sobrinos = new ArrayList<>();
        if (persona.getHermanos() == null)
            return null;
        persona.getHermanos().forEach(hermano -> {
            List<String> s = getPersonaFromNombre(hermano).getHijos();
            if (s != null)
                sobrinos.addAll(s);
        });
        return sobrinos;
    }

    private Persona getPersonaFromNombre(String nombre){
        for (Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }

}