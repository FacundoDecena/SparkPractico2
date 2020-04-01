package sorter;
// Spark imports
import spark.Request;
import spark.Response;
import spark.Route;
// Velocity imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class SorterController {
    static public Route home = (Request request, Response response) ->{
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/home.vtl");
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    static public Route sort = (Request request, Response response) ->{
        HashMap<String, Object> model = new HashMap<String, Object>();
        Map<String, Integer> numberMap = new HashMap<String, Integer>();
        List<String> sortedMap = new ArrayList<>();
        String s0, s1, s2, s3, s4, s5;
        int n0, n1, n2, n3, n4, n5;
        boolean sort;

        s0 =request.queryParams("n0");
        s1 = request.queryParams("n1");
        s2 = request.queryParams("n2");
        s3 = request.queryParams("n3");
        s4 = request.queryParams("n4");
        s5 = request.queryParams("n5");

        if (s0 != null){
            if (!s0.isEmpty()){
                try{n0 = Integer.parseInt(s0);
                    numberMap.put("Numero-0",n0);
                    sortedMap.add("Numero-0");sortedMap.add(s0);
                    model.put("n0", n0);
                }catch (NumberFormatException ignored){}
            }
        }
        if (s1 != null){
            if (!s1.isEmpty()){
                try{n1 = Integer.parseInt(s1);
                    numberMap.put("Numero-1", n1);
                    sortedMap.add("Numero-1");sortedMap.add(s1);
                    model.put("n1", n1);
                }catch (NumberFormatException ignored){}
            }
        }
        if (s2 != null){
            if (!s2.isEmpty()){
                try{n2 = Integer.parseInt(s2);
                    numberMap.put("Numero-2", n2);
                    sortedMap.add("Numero-2");sortedMap.add(s2);
                    model.put("n2", n2);
                }catch (NumberFormatException ignored){}
            }
        }
        if (s3 != null){
            if (!s3.isEmpty()){
                try{n3 = Integer.parseInt(s3);
                    numberMap.put("Numero-3", n3);
                    sortedMap.add("Numero-3");sortedMap.add(s3);
                    model.put("n3", n3);
                }catch (NumberFormatException ignored){}
            }
        }
        if (s4 != null){
            if (!s4.isEmpty()){
                try{n4 = Integer.parseInt(s4);
                    numberMap.put("Numero-4", n4);
                    sortedMap.add("Numero-4");sortedMap.add(s4);
                    model.put("n4", n4);
                }catch (NumberFormatException ignored){}
            }
        }
        if (s5 != null){
            if (!s5.isEmpty()){
                try{n5 = Integer.parseInt(s5);
                    numberMap.put("Numero-5", n5);;
                    sortedMap.add("Numero-5");sortedMap.add(s5);
                    model.put("n5", n5);
                }catch (NumberFormatException ignored){}
            }
        }

        sort = Boolean.parseBoolean(request.queryParams("sort"));
        if (sort)
            sortedMap = Sorter.sortList(numberMap);

        model.put("template", "templates/home.vtl");
        model.put("sort", sort);
        model.put("ListaDeNumeros", sortedMap);
        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
