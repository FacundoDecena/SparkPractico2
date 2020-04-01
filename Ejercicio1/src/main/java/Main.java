import sorter.SorterController;
import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/api/sort", SorterController.sort);
        get("/api", SorterController.home);
    }
}
