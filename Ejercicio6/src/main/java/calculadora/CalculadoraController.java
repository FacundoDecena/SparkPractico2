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

    public static Route aKilogramo = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        Calculadora c = new Calculadora();
        try{
            double cantidad = Double.parseDouble(request.queryParams("cantidad"));
            model.put("cantidad", cantidad);
            model.put("unidad", "kilogramos");
            model.put("resultado", c.aKilogramo(cantidad));

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route aLibra = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        Calculadora c = new Calculadora();
        try{
            double cantidad = Double.parseDouble(request.queryParams("cantidad"));
            model.put("cantidad", cantidad);
            model.put("unidad", "libras");
            model.put("resultado", c.aLibra(cantidad));

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route aKilometros = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        Calculadora c = new Calculadora();
        try{
            double cantidad = Double.parseDouble(request.queryParams("cantidad"));
            model.put("cantidad", cantidad);
            model.put("unidad", "kilometros");
            model.put("resultado", c.aKilometros(cantidad));

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route aMillas = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        Calculadora c = new Calculadora();
        try{
            double cantidad = Double.parseDouble(request.queryParams("cantidad"));
            model.put("cantidad", cantidad);
            model.put("unidad", "millas");
            model.put("resultado", c.aMillas(cantidad));

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route aCelcius = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        Calculadora c = new Calculadora();
        try{
            double cantidad = Double.parseDouble(request.queryParams("cantidad"));
            model.put("cantidad", cantidad);
            model.put("unidad", "°C");
            model.put("resultado", c.aCelcius(cantidad));

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route aFahrenheit = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        Calculadora c = new Calculadora();
        try{
            double cantidad = Double.parseDouble(request.queryParams("cantidad"));
            model.put("cantidad", cantidad);
            model.put("unidad", "°F");
            model.put("resultado", c.aFahrenheit(cantidad));

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
