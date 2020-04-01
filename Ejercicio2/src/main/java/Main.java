import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

import imc.IMCController;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api", IMCController.calculateBMI);
    }
}