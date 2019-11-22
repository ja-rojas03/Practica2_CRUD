package edu.pucmm.practica.Classes;

import java.util.ArrayList;

public class Controller {
    private static Controller instance;
    private ArrayList<Estudiante> estudiantes;

    private Controller(){
        super();
        this.estudiantes = new ArrayList<>();
    }

    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
