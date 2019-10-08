import Classes.Controller;
import Classes.Estudiante;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        staticFiles.location("/public");

        ////////////////////////////////////////////////////////////////////////
        //                            GET                                    //
        ///////////////////////////////////////////////////////////////////////

        get("/", (request,response) -> {
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            Map<String,Object> attributes = new HashMap<>();

            attributes.put("estudiantes",estudiantes);

            return new FreeMarkerEngine().render(new ModelAndView(attributes,"datosEstudiante.ftl"));
        });

        get("/add/", (request, response) -> {
            return new FreeMarkerEngine().render(new ModelAndView(null,"nuevoEstudiante.ftl"));
        });

        get("/visualize/:matricula/", (request, response) -> {
            int matricula = Integer.parseInt(request.params("matricula"));
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            Estudiante estudianteActual = null;
            for(Estudiante estudiante: estudiantes) {
                if (estudiante.getMatricula() == matricula ){
                    estudianteActual = estudiante;
                }
            }
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante",estudianteActual);
            return new FreeMarkerEngine().render(new ModelAndView(attributes, "visualEstudiante.ftl"));
        });

        get("/update/:matricula/", (request, response) -> {
            int matricula = Integer.parseInt(request.params("matricula"));
            int index = 0,pos = 0;
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            Estudiante estudianteActual = null;
            for(Estudiante estudiante: estudiantes) {
                if (estudiante.getMatricula() == matricula ){
                    estudianteActual = estudiante;
                    pos = index;
                }
                index++;
            }
            Map<String,Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudianteActual);
            attributes.put("pos",pos);
            return new FreeMarkerEngine().render(new ModelAndView(attributes, "updateEstudiante.ftl"));
        });

        ////////////////////////////////////////////////////////////////////////
        //                          POST                                     //
        ///////////////////////////////////////////////////////////////////////
        post("/procesarEstudiante/", (request, response) -> {
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            int matricula = Integer.parseInt(request.queryParams("matricula"));

            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            Estudiante estudiante = new Estudiante(matricula,nombre,apellido,telefono);
            estudiantes.add(estudiante);
            Controller.getInstance().setEstudiantes(estudiantes);
            response.redirect("/");
            return "";
        });

        post("/updateEstudiante/",(request, response) -> {
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            int pos = Integer.parseInt(request.queryParams("pos"));

            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();

            Estudiante estudiante = estudiantes.get(pos);
            estudiante.setNombre(nombre);
            estudiante.setApellido(apellido);
            estudiante.setMatricula(matricula);
            estudiante.setTelefono(telefono);

            estudiantes.set(pos,estudiante);
            Controller.getInstance().setEstudiantes(estudiantes);

            response.redirect("/");
            return "";
        });

        post("/delete/", (request, response) -> {
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            int pos = Integer.parseInt(request.queryParams("pos"));
            estudiantes.remove(pos);
            Controller.getInstance().setEstudiantes(estudiantes);
            response.redirect("/");
            return "";
        });
    }
}
