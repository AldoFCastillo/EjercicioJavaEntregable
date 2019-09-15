package com.company;

import profesor.ProfesorAdjunto;
import profesor.ProfesorTitular;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {

    private String nombre;
    private Integer codigoDeCurso;
    private ProfesorTitular profesorTitular;
    private ProfesorAdjunto profesorAdjunto;
    private List<Alumno> alumnosInscriptos;
    private Integer cupoMaximoDealumnos;
    private List<Integer> codigosDeGuiasPracticas;
    private List<Integer> codigosDeGuiasTeoricas;

    /**
     * Constructor de Curso
     *
     * @param nombre
     * @param codigoDeCurso
     */

    public Curso(String nombre, Integer codigoDeCurso) {

        this.nombre = nombre;
        this.codigoDeCurso = codigoDeCurso;
        this.alumnosInscriptos = new ArrayList<>();
        this.codigosDeGuiasTeoricas = new ArrayList<>();
        this.codigosDeGuiasPracticas = new ArrayList<>();


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

    public Integer getCupoMaximoDealumnos() {
        return cupoMaximoDealumnos;
    }

    public List<Integer> getCodigosDeGuiasPracticas() {
        return codigosDeGuiasPracticas;
    }

    public List<Integer> getCodigosDeGuiasTeoricas() {
        return codigosDeGuiasTeoricas;
    }

    public void setCantidadDeAlumnosPermitidos(Integer cantidadDeAlumnosPermitidos) {
        this.cupoMaximoDealumnos = cantidadDeAlumnosPermitidos;
    }

    public void setProfesorTitular(ProfesorTitular profesorTitular) {
        this.profesorTitular = profesorTitular;
        System.out.println("Profesor/a titular " + profesorTitular + " asignado/a al curso '" + nombre + "' con exito");
    }

    public void setProfesorAdjunto(ProfesorAdjunto profesorAdjunto) {
        this.profesorAdjunto = profesorAdjunto;
        System.out.println("Profesor/a adjunto " + profesorAdjunto + " asignado/a al curso '" + nombre + "' con exito");
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

    public void setCodigosDeGuiasPracticas(Integer codigo) {
        this.codigosDeGuiasPracticas.add(codigo);
    }

    public void setCodigosDeGuiasTeoricas(Integer codigo) {
        this.codigosDeGuiasTeoricas.add(codigo);
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

        if (!hayCupoDisponible() || alumnoRepetido(unAlumno)) {
            return false;
        } else {
            alumnosInscriptos.add(unAlumno);
            return true;
        }
    }

    /**
     * Metodo para verificar cupo
     *
     * @return
     */
    private Boolean hayCupoDisponible() {
        Boolean hayCupo = true;
        if (!(alumnosInscriptos.size() < cupoMaximoDealumnos)) {
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
    private Boolean alumnoRepetido(Alumno unAlumno) {
        Boolean repetido = false;
        for (Alumno otroAlumno : alumnosInscriptos) {
            if (otroAlumno.equals(unAlumno)) {
                repetido = true;
                System.out.println("EL/la alumno/a ya fue inscripto/a previamente a este curso");
                break;
            }
        }
        return repetido;
    }

    /**
     * Metodo para eliminar alumnos del curso
     * no fue pedido en el enunciado
     *
     * @param unAlumno
     */
    public void eliminarAlumno(Alumno unAlumno) {
        if (alumnoRepetido(unAlumno)) {
            alumnosInscriptos.remove(unAlumno);
            System.out.println("El/la alumno/a " + unAlumno + " se ha eliminado");
        } else {
            System.out.println("No pudo realizarse la operacion");
        }
    }

    @Override
    public String toString() {
        return "'" + nombre + "'" + " (codigo de curso:" + codigoDeCurso + ")";
    }

    /**
     * metodos para ingresar y eliminar odigos de guias en una lista
     *
     * @param codigo
     */
    public void ingresarCodigosDeGuiaPractica(Integer codigo) {
        Boolean masCodigos = true;
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        System.out.println("A continuacion ingrese un codigo de guia practica que se utilizara en el curso");
        while (masCodigos) {
            codigo = teclado.nextInt();
            if (!buscadorDeRepetidosPracticas(codigo)) {
                codigosDeGuiasPracticas.add(codigo);
                System.out.println("Codigo de guia practica ingresado correctamente");
                System.out.println("Desea ingresar otro codigo? (pulse cualquier tecla en caso afirmativo o 'N' para finalizar");
                respuesta = teclado.nextLine();
                if (respuesta.equals("N") || respuesta.equals("n")) {
                    masCodigos = false;
                }
            } else {
                System.out.println("Error en el codigo ingresado (repetido o inexistente");
                System.out.println("Desea ingresar otro codigo? (pulse cualquier tecla en caso afirmativo o 'N' para finalizar");
                respuesta = teclado.nextLine();
                if (respuesta.equals("N") || respuesta.equals("n")) {
                    masCodigos = false;
                }
            }
        }
    }


    public void ingresarCodigosDeGuiaTeorica(Integer codigo) {
        Boolean masCodigos = true;
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        System.out.println("A continuacion ingrese un codigo de guia teorica que se utilizara en el curso");
        while (masCodigos) {
            codigo = teclado.nextInt();

            if (!buscadorDeRepetidosTeoricas(codigo)) {
                codigosDeGuiasTeoricas.add(codigo);
                System.out.println("Codigo de guia teorica ingresado correctamente");
                System.out.println("Desea ingresar otro codigo? (pulse cualquier tecla en caso afirmativo o 'N' para finalizar");
                respuesta = teclado.nextLine();
                if (respuesta.equals("N") || respuesta.equals("n")) {
                    masCodigos = false;
                }
            } else {
                System.out.println("Error en el codigo ingresado (repetido o inexistente");
                System.out.println("Desea ingresar otro codigo? (pulse cualquier tecla en caso afirmativo o 'N' para finalizar");
                respuesta = teclado.nextLine();
                if (respuesta.equals("N") || respuesta.equals("n")) {
                    masCodigos = false;
                }
            }

        }
    }


    public void eliminarCodigoDeGuiaPractica(Integer codigo) {
        if (buscadorDeRepetidosPracticas(codigo)) {
            codigosDeGuiasPracticas.remove(codigo);
        } else System.out.println("No se encontro el codigo");
    }

    public void eliminarCodigoDeGuiaTeorica(Integer codigo) {
        if (buscadorDeRepetidosTeoricas(codigo)) {
            codigosDeGuiasTeoricas.remove(codigo);
        } else System.out.println("No se encontro el codigo");
    }


    public Boolean buscadorDeRepetidosPracticas(Integer codigo) {
        Boolean repetido = false;
        for (Integer unCodigo : codigosDeGuiasPracticas) {
            if (codigo.equals(unCodigo)) {
                repetido = true;
                break;
            }
        }
        return repetido;
    }

    public Boolean buscadorDeRepetidosTeoricas(Integer codigo) {
        Boolean repetido = false;
        for (Integer unCodigo : codigosDeGuiasTeoricas) {
            if (codigo.equals(unCodigo)) {
                repetido = true;
                break;
            }
        }
        return repetido;
    }
}

