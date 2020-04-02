import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

import calculadora.CalculadoraController;


public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api", CalculadoraController.home);
        get("/api/suma", CalculadoraController.sumar);
        get("/api/resta", CalculadoraController.restar);
        get("/api/multiplicar", CalculadoraController.multiplicar);
        get("/api/dividir", CalculadoraController.dividir);
    }
}