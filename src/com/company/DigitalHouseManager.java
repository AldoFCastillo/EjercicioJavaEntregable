package com.company;

import java.util.ArrayList;
import java.util.List;

public class DigitalHouseManager {

    private List<Alumno> listaDeAlumnos;
    private List<Profesor> listaDeProfesores;
    private List<Curso> listaDeCursos;
    private List<Inscripcion> listaDeInscripciones;

    public DigitalHouseManager() {
        this.listaDeAlumnos = new ArrayList<>();
        this.listaDeProfesores = new ArrayList<>();
        this.listaDeCursos = new ArrayList<>();
        this.listaDeInscripciones = new ArrayList<>();
    }

    public List<Alumno> getListaDeAlumnos() {
        return listaDeAlumnos;
    }

    public void setListaDeAlumnos(List<Alumno> listaDeAlumnos) {
        this.listaDeAlumnos = listaDeAlumnos;
    }

    public List<Profesor> getListaDeProfesores() {
        return listaDeProfesores;
    }

    public void setListaDeProfesores(List<Profesor> listaDeProfesores) {
        this.listaDeProfesores = listaDeProfesores;
    }

    public List<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public List<Inscripcion> getListaDeInscripciones() {
        return listaDeInscripciones;
    }

    public void setListaDeInscripciones(List<Inscripcion> listaDeInscripciones) {
        this.listaDeInscripciones = listaDeInscripciones;
    }
}
