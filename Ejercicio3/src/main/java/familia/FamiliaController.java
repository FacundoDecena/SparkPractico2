package familia;

import java.util.HashMap;
import java.util.List;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

public class FamiliaController {
    public static Route personas = (Request request, Response response) -> {
        FamiliaDAO fDAO = new FamiliaDAO();
        HashMap<String, Object> model = new HashMap<>();

        List<String> p = fDAO.personas();

        model.put("template", "templates/home.vtl");
        model.put("personas", p);
        model.put("opt", "Todos");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route hijos = (Request request, Response response) -> {
        FamiliaDAO fDAO = new FamiliaDAO();
        HashMap<String, Object> model = new HashMap<>();

        String nombre = request.queryParams("nombre");
        List<String> p = fDAO.hijos(nombre);

        model.put("template", "templates/home.vtl");
        model.put("personas", p);
        model.put("opt", "Hijos");
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route hermanos = (Request request, Response response) -> {
        FamiliaDAO fDAO = new FamiliaDAO();
        HashMap<String, Object> model = new HashMap<>();

        String nombre = request.queryParams("nombre");
        List<String> p = fDAO.hermanos(nombre);

        model.put("template", "templates/home.vtl");
        model.put("personas", p);
        model.put("opt", "Hermanos");
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route nietos = (Request request, Response response) -> {
        FamiliaDAO fDAO = new FamiliaDAO();
        HashMap<String, Object> model = new HashMap<>();

        String nombre = request.queryParams("nombre");
        List<String> p = fDAO.nietos(nombre);

        model.put("template", "templates/home.vtl");
        model.put("personas", p);
        model.put("opt", "Nietos");
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route padres = (Request request, Response response) -> {
        FamiliaDAO fDAO = new FamiliaDAO();
        HashMap<String, Object> model = new HashMap<>();

        String nombre = request.queryParams("nombre");
        List<String> p = fDAO.padres(nombre);

        model.put("template", "templates/home.vtl");
        model.put("personas", p);
        model.put("opt", "Padres");
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route sobrinos = (Request request, Response response) -> {
        FamiliaDAO fDAO = new FamiliaDAO();
        HashMap<String, Object> model = new HashMap<>();

        String nombre = request.queryParams("nombre");
        List<String> p = fDAO.sobrinos(nombre);

        model.put("template", "templates/home.vtl");
        model.put("personas", p);
        model.put("opt", "Sobrinos");
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route tios = (Request request, Response response) -> {
        FamiliaDAO fDAO = new FamiliaDAO();
        HashMap<String, Object> model = new HashMap<>();

        String nombre = request.queryParams("nombre");
        List<String> p = fDAO.tios(nombre);
        model.put("template", "templates/home.vtl");
        model.put("personas", p);
        model.put("opt", "Tios");
        model.put("nombre", nombre);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
