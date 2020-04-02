import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

import canjes.CalculadoraController;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api", CalculadoraController.home);
        get("/api/canjearPuntos", CalculadoraController.verCanjes);
    }
}