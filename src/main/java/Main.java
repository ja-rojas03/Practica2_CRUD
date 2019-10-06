import Classes.Controller;
import Classes.Estudiante;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        get("/", (request,response) -> {
            ArrayList<Estudiante> estudiantes = new ArrayList<>();
            estudiantes = Controller.getInstance().getEstudiantes();


            Map<String,Object> attributes = new HashMap<>();
            attributes.put("estudiantes",estudiantes);


            return new FreeMarkerEngine().render(new ModelAndView(attributes,"datosEstudiante.ftl"));
        });

        get("/add", (request, response) -> {
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            Estudiante estudiante = new Estudiante(2020,"Jose","martinez","809-987-1111");
            estudiantes.add(estudiante);
            Estudiante estudiante2 = new Estudiante(2021,"Daniel","martinez","809-987-1111");
            estudiantes.add(estudiante2);
            Controller.getInstance().setEstudiantes(estudiantes);
            response.redirect("/");
            return "";
        });

        get("/delete", (request, response) -> {
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            for (Estudiante estudiante: estudiantes) {
                if (estudiante.getMatricula() == 2020 ) {
                    estudiantes.remove(estudiante);
                }
            }
            Controller.getInstance().setEstudiantes(estudiantes);
            response.redirect("/");
            return "";
        });

        get("/update", (request, response) -> {
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            for(Estudiante estudiante: estudiantes) {
                if (estudiante.getMatricula() == 2020 ){
                    estudiante.setNombre("Enzo");
                }
            }
            Controller.getInstance().setEstudiantes(estudiantes);
            response.redirect("/");
            return "";
        });


    }
}
