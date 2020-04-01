package imc;

import java.util.HashMap;

import spark.ModelAndView;
// Spark imports
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class IMCController {

    static public Route calculateBMI = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/home.vtl");
        try{
            double weight = Double.parseDouble(request.queryParams("peso"));
            double height = Double.parseDouble(request.queryParams("altura"));

            if (height > 3.0){
                height /= 100;
            }

            IMC imc = new IMC(weight, height);

            model.put("message", imc.calculateIMC());
            model.put("imc", imc.getImc());
        } catch (NumberFormatException | NullPointerException e){
            model.put("message", "Parametros invalidos");
        }
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

}