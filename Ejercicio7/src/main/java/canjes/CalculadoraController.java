package canjes;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class CalculadoraController {

    public static Route home = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        ProductoDAO p = new ProductoDAO();
        model.put("productos", p.getProductos());
        model.put("template", "templates/home.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route verCanjes = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();
        model.put("template", "templates/home.vtl");
        try{
            int puntos = Integer.parseInt(request.queryParams("puntos"));
            ProductoDAO p = new ProductoDAO();
            model.put("productos", p.getCanjes(puntos));
            model.put("caros", p.getTooExpensive(puntos));
            model.put("puntos", puntos);
        } catch (NumberFormatException e){
            model.put("Error", "Parametro no valido");
        } catch(NullPointerException e){
            model.put("Error", "Parametro nulo");
        }

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
