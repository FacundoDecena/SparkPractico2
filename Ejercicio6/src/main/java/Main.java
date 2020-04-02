import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

import calculadora.CalculadoraController;


public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api", CalculadoraController.home);
        get("/api/celcius", CalculadoraController.aCelcius);
        get("/api/fahrenheit", CalculadoraController.aFahrenheit);
        get("/api/kilogramo", CalculadoraController.aKilogramo);
        get("/api/kilometros", CalculadoraController.aKilometros);
        get("/api/libra", CalculadoraController.aLibra);
        get("/api/millas", CalculadoraController.aMillas);
    }
}