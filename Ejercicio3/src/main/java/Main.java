import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

import familia.FamiliaController;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api", FamiliaController.personas);
        get("/api/hijos", FamiliaController.hijos);
        get("/api/hermanos", FamiliaController.hermanos);
        get("/api/nietos", FamiliaController.nietos);
        get("/api/padres", FamiliaController.padres);
        get("/api/sobrinos", FamiliaController.sobrinos);
        get("/api/tios", FamiliaController.tios);
    }
}