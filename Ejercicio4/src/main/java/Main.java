import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

import circunferencia.CircunferenciaController;


public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api", CircunferenciaController.perimetroyarea);
        get("/api/perimetro", CircunferenciaController.perimetro);
        get("/api/area", CircunferenciaController.area);
    }
}