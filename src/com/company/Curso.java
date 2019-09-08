package com.company;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nombre;
    private Integer codigoDeCurso;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private List<Alumno> alumnosInscriptos;

    private Integer cupoMaximoDealumnos;

    public Curso(String nombre, Integer codigoDeCurso) {
        this.nombre = nombre;
        this.codigoDeCurso = codigoDeCurso;
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

    public Integer getCantidadDeAlumnosPermitidos() {
        return cupoMaximoDealumnos;
    }

    public void setCantidadDeAlumnosPermitidos(Integer cantidadDeAlumnosPermitidos) {
        this.cupoMaximoDealumnos = cantidadDeAlumnosPermitidos;
    }

    public void setProfesorTitular(ProfesorTitular profesorTitular) {
        this.profesorTitular = profesorTitular;
        System.out.println("Profesor titular asignado al curso con exito");
    }

    public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto) {
        this.profesorAdjunto = profesorAdjunto;
        System.out.println("Profesor adjunto asignado al curso con exito");
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
        if (!(obj instanceof Curso)) {
            return false;
        }
        Curso unCurso = (Curso) obj;
        return unCurso.getCodigoDeCurso().equals(this.codigoDeCurso);
    }


    /**
     * Metodo para agregar alumnos al curso
     *
     * @param unAlumno
     * @return
     */
    public Boolean agregarUnAlumno(Alumno unAlumno) {

        if (!hayCupoDisponible() && !alumnoRepetido(unAlumno)) {
            System.out.println("No pudo realizarse la operacion");
            return false;
        }
        alumnosInscriptos.add(unAlumno);
        return true;
    }

    /**
     * Metodo para verificar cupo
     *
     * @return
     */

    public Boolean hayCupoDisponible() {
        Boolean hayCupo = true;
        if (!(cupoMaximoDealumnos > alumnosInscriptos.size())) {
            hayCupo = false;
            System.out.println("No hay cupo disponible");
        }
        return hayCupo;
    }

    /**
     * Metodo para verificar si el alumno esta repetido en este curso
     *
     * @param unAlumno
     * @return
     */

    public Boolean alumnoRepetido(Alumno unAlumno) {
        Boolean repetido = false;
        for (Alumno otroAlumno : alumnosInscriptos) {
            if (otroAlumno.equals(unAlumno)) {
                repetido = true;
                System.out.println("EL alumno ya fue inscripto previamente a este curso");
                break;
            }
        }
        return repetido;
    }

    /**
     * Metodo para eliminar alumnos del curso
     *
     * @param unAlumno
     */
    public void eliminarAlumno(Alumno unAlumno) {
        List<Alumno> alumnosAEliminar = new ArrayList<>();
        for (Alumno otroAlumno : alumnosInscriptos) {
            if (otroAlumno.equals(unAlumno)) {
                alumnosAEliminar.add(unAlumno);
            }
        }
        alumnosInscriptos.removeAll(alumnosAEliminar);
        System.out.println("El alumno se ha eliminado");
    }
}

