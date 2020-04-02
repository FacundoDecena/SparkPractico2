package calculadora;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class CalculadoraController {

    public static Route home = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route sumar = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        Calculadora c = new Calculadora();
        try{
            double a = Double.parseDouble(request.queryParams("a"));
            double b = Double.parseDouble(request.queryParams("b"));
            model.put("a", a);
            model.put("b", b);
            model.put("resultado", c.sumar(a, b));

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route restar = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");

        Calculadora c = new Calculadora();
        try {
            double a = Double.parseDouble(request.queryParams("a"));
            double b = Double.parseDouble(request.queryParams("b"));
            model.put("a", a);
            model.put("b", b);
            model.put("resultado", c.restar(a, b));
        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route multiplicar = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");

        Calculadora c = new Calculadora();
        try {
            double a = Double.parseDouble(request.queryParams("a"));
            double b = Double.parseDouble(request.queryParams("b"));
            model.put("a", a);
            model.put("b", b);
            model.put("resultado", c.multiplicar(a, b));
        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route dividir = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");

        Calculadora c = new Calculadora();
        try {
            double a = Double.parseDouble(request.queryParams("a"));
            double b = Double.parseDouble(request.queryParams("b"));
            model.put("a", a);
            model.put("b", b);
            model.put("resultado", c.dividir(a, b));
        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
