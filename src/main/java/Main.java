import Classes.Controller;
import Classes.Estudiante;

import java.util.ArrayList;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        get("/", (request,response) -> {
            ArrayList<Estudiante> estudiantes = Controller.getInstance().getEstudiantes();
            ArrayList<String> nombres = new ArrayList<>();
            for (Estudiante estudiante: estudiantes) {
                nombres.add(estudiante.getNombre());
            }
            return nombres;
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
