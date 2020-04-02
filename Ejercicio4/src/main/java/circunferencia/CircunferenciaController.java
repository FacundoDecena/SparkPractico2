package circunferencia;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class CircunferenciaController {
    public static Route perimetro = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        try {
            double radio = Double.parseDouble(request.queryParams("radio"));
            Circunferencia c = new Circunferencia();
            model.put("perimetro", c.perimetro(radio));
            model.put("radio", radio);

        } catch (NumberFormatException | NullPointerException Ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route area = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");

        try {
            double radio = Double.parseDouble(request.queryParams("radio"));
            Circunferencia c = new Circunferencia();
            model.put("area", c.area(radio));
            model.put("radio", radio);

        } catch (NumberFormatException | NullPointerException ignored){}

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route perimetroyarea = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        
        try{
            double radio = Double.parseDouble(request.queryParams("radio"));
            Circunferencia c = new Circunferencia();
            model.put("area", c.area(radio));
            model.put("perimetro", c.perimetro(radio));
            model.put("radio", radio);

        } catch (NumberFormatException | NullPointerException ignored){
        }

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
