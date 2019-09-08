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


    /**
     * Metodos para verificar que el codigo no haya sido ingresado antes
     *
     * @param codigo
     * @return
     */
    public Boolean cursoRepetido(Integer codigo) {
        if (!buscadorDeCursos(codigo).isEmpty()) {
            System.out.println("El curso ya fue ingresado previamente");
            return true;
        } else return false;
    }

    public Boolean profesorRepetido(Integer codigo) {
        if (!buscadorDeProfesores(codigo).isEmpty()) {
            System.out.println("El/La profesor/a ya fue ingresado previamente");
            return true;
        } else return false;
    }

    public Boolean alumnoRepetido(Integer codigo) {
        if (!buscadorDeAlumnos(codigo).isEmpty()) {
            System.out.println("El/La alumno/a ya fue ingresado previamente");
            return true;
        } else return false;
    }

    //TODO
    public Boolean inscripcionRepetida(Integer codigo) {
        if (!buscadorDeAlumnos(codigo).isEmpty()) {
            System.out.println("El/La alumno/a ya fue ingresado previamente");
            return true;
        } else return false;
    }

    /**
     * Metodos para buscar cursos, profesores y alumnos
     *
     * @param codigo
     * @return
     */
    public List<Curso> buscadorDeCursos(Integer codigo) {
        List<Curso> cursoEncontrado = new ArrayList<>();
        for (Curso unCurso : listaDeCursos) {
            if (unCurso.getCodigoDeCurso().equals(codigo)) {
                cursoEncontrado.add(unCurso);
                break;
            } else System.out.println("No se pudo hallar el curso");
        }
        return cursoEncontrado;
    }

    public List<Profesor> buscadorDeProfesores(Integer codigo) {
        List<Profesor> profesorEncontrado = new ArrayList<>();
        for (Profesor unProfesor : listaDeProfesores) {
            if (unProfesor.getCodigoDeProfesor().equals(codigo)) {
                profesorEncontrado.add(unProfesor);
                break;
            } else System.out.println("No se pudo hallar el/la profesor/a");
        }
        return profesorEncontrado;
    }

    public List<Alumno> buscadorDeAlumnos(Integer codigo) {
        List<Alumno> alumnoEncontrado = new ArrayList<>();
        for (Alumno unAlumno : listaDeAlumnos) {
            if (unAlumno.getCodigoDeAlumno().equals(codigo)) {
                alumnoEncontrado.add(unAlumno);
                break;
            } else System.out.println("No se pudo hallar el/la alumno/a");
        }
        return alumnoEncontrado;
    }

    /**
     * Metodo para dar alta a un nuevo curso
     *
     * @param nombre
     * @param codigoCurso
     * @param cupoMaximoDealumnos
     */
    public void altaCurso(String nombre, Integer codigoCurso, Integer cupoMaximoDealumnos) {
        if (!cursoRepetido(codigoCurso)) {
            Curso unCurso = new Curso(nombre, codigoCurso);
            unCurso.setCantidadDeAlumnosPermitidos(cupoMaximoDealumnos);
            listaDeCursos.add(unCurso);
            System.out.println("Curso ingresado correctamente");
        } else System.out.println("No se pudo realizar la operacion");
    }

    /**
     * Metodo para dar la baja a un curso
     *
     * @param codigoCurso
     */

    public void bajaCurso(Integer codigoCurso) {
        if (buscadorDeCursos(codigoCurso).isEmpty()) {
            System.out.println("No se pudo realizar la operacion");
        } else {
            listaDeCursos.remove(buscadorDeCursos(codigoCurso).get(0));
            System.out.println("Curso eliminado");
        }
    }

    /**
     * Metodo para dar alta a un nuevo profesor adjunto
     *
     * @param nombre
     * @param apellido
     * @param codigoProfesor
     * @param cantidadDeHoras
     */
    public void altaProfesorAdjunto(String nombre, String apellido, Integer codigoProfesor, Integer cantidadDeHoras) {
        if (!profesorRepetido(codigoProfesor)) {
            Profesor unProfesor = new ProfesorAdjunto(nombre, apellido, 0, codigoProfesor, cantidadDeHoras);
            listaDeProfesores.add(unProfesor);
            System.out.println("Profesor/a ingresado correctamente");
        } else System.out.println("No se pudo realizar la operacion");

    }

    /**
     * Metodo para dar el alta a un profesor titular
     *
     * @param nombre
     * @param apellido
     * @param codigoProfesor
     * @param especialidad
     */
    public void altaProfesorTitular(String nombre, String apellido, Integer codigoProfesor, String especialidad) {
        if (!profesorRepetido(codigoProfesor)) {
            Profesor unProfesor = new ProfesorTitular(nombre, apellido, 0, codigoProfesor, especialidad);
            listaDeProfesores.add(unProfesor);
            System.out.println("Profesor/a ingresado correctamente");
        } else System.out.println("No se pudo realizar la operacion");
    }

    /**
     * Metodo para dar la baja a un profesor
     *
     * @param codigoProfesor
     */
    public void bajaProfesor(Integer codigoProfesor) {
        if (buscadorDeProfesores(codigoProfesor).isEmpty()) {
            System.out.println("No se pudo realizar la operacion");
        } else {
            listaDeProfesores.remove(buscadorDeProfesores(codigoProfesor).get(0));
            System.out.println("Profesor/a eliminado/a");
        }
    }

    /**
     * Metodo para dar el alta a un/a alumno/a
     *
     * @param nombre
     * @param apellido
     * @param codigoAlumno
     */
    public void altaAlumno(String nombre, String apellido, Integer codigoAlumno) {
        if (!alumnoRepetido(codigoAlumno)) {
            Alumno unAlumno = new Alumno(nombre, apellido, codigoAlumno);
            listaDeAlumnos.add(unAlumno);
            System.out.println("Alumnor/a ingresado/a correctamente");
        } else System.out.println("No se pudo realizar la operacion");
    }

    /**
     * Metodo para dar la baja a un/a alumno/a
     *
     * @param codigoAlumno
     */
    public void bajaAlumno(Integer codigoAlumno) {
        if (buscadorDeAlumnos(codigoAlumno).isEmpty()) {
            System.out.println("No se pudo realizar la operacion");
        } else {
            listaDeAlumnos.remove(buscadorDeAlumnos(codigoAlumno).get(0));
            System.out.println("Alumno/a eliminado/a");
        }
    }

    /**
     * Metodo para realizar una nueva inscripcion
     *
     * @param codigoAlumno
     * @param codigoCurso
     */
    public void inscribirAlumno(Integer codigoAlumno, Integer codigoCurso) {
        if (buscadorDeCursos(codigoCurso).get(0).agregarUnAlumno(buscadorDeAlumnos(codigoAlumno).get(0))) {
            Inscripcion nuevaInscripcion = new Inscripcion(buscadorDeAlumnos(codigoAlumno).get(0), buscadorDeCursos(codigoCurso).get(0));
            listaDeInscripciones.add(nuevaInscripcion);
            System.out.println("Alumno/a " + buscadorDeAlumnos(codigoAlumno).get(0) + " fue inscripto/a en el curso " + buscadorDeCursos(codigoCurso).get(0));
        }
    }

    /**
     * Metodo para asignar profesores a un curso
     *
     * @param codigoCurso
     * @param codigoProfesorTitular
     * @param codigoProfesorAdjunto
     */
    public void asignarProfesores(Integer codigoCurso, Integer codigoProfesorTitular, Integer codigoProfesorAdjunto) {
        if (!(buscadorDeCursos(codigoCurso).isEmpty()) && !(buscadorDeProfesores(codigoProfesorTitular).isEmpty())) {
            buscadorDeCursos(codigoCurso).get(0).setProfesorTitular((ProfesorTitular) buscadorDeProfesores(codigoProfesorTitular));
        } else System.out.println("No se pudo asignar");
        if (!(buscadorDeCursos(codigoCurso).isEmpty()) && !(buscadorDeProfesores(codigoProfesorAdjunto).isEmpty())) {
            buscadorDeCursos(codigoCurso).get(0).setProfesorAdjunto((ProfesorAdjunto) buscadorDeProfesores(codigoProfesorAdjunto));
        } else System.out.println("No se pudo asignar");
    }

}
