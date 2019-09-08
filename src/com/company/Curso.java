package com.company;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nombre;
    private Integer codigoDeCurso;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private List<Alumno> alumnosInscriptos;

    public Curso(String nombre, Integer codigoDeCurso, ProfesorTitular profesorTitular, ProfesorAdjunto profesorAdjunto) {
        this.nombre = nombre;
        this.codigoDeCurso = codigoDeCurso;
        this.profesorTitular = profesorTitular;
        this.profesorAdjunto = profesorAdjunto;
        this.alumnosInscriptos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigoDeCurso() {
        return codigoDeCurso;
    }

    public ProfesorTitular getProfesorTitular() {
        return profesorTitular;
    }

    public ProfesorAdjunto getProfesorAdjunto() {
        return profesorAdjunto;
    }

    public List<Alumno> getAlumnosInscriptos() {
        return alumnosInscriptos;
    }

    public void setProfesorTitular(ProfesorTitular profesorTitular) {
        this.profesorTitular = profesorTitular;
    }

    public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto) {
        this.profesorAdjunto = profesorAdjunto;
    }


    public void setAlumnosInscriptos(List<Alumno> alumnosInscriptos) {
        this.alumnosInscriptos = alumnosInscriptos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoDeCurso(Integer codigoDeCurso) {
        this.codigoDeCurso = codigoDeCurso;
    }

    @Override
    public boolean equals(Object obj) {
        Curso unCurso = (Curso) obj;
        return unCurso.getCodigoDeCurso().equals(this.codigoDeCurso);
    }
}
