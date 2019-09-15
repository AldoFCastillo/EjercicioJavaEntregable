package com.company;

import com.digitalhouse.Estudioso;
import guia.Guia;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Estudioso {

    private String nombre;
    private String apellido;
    private Integer codigoDeAlumno;
    private Boolean estudioso = null;
    private List<Guia> copiasDeGuiasDelAlumno;



    /**
     * Constructor de Alumno
     *
     * @param nombre
     * @param apellido
     * @param codigoDeAlumno
     */

    public Alumno(String nombre, String apellido, Integer codigoDeAlumno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoDeAlumno = codigoDeAlumno;
        this.copiasDeGuiasDelAlumno = new ArrayList<>();


    }

    /**
     * Constructor de Alumno con referencias
     * para Destacado opcion 2
     *
     * @param nombre
     * @param apellido
     * @param codigoDeAlumno
     * @param estudioso
     */
    public Alumno(String nombre, String apellido, Integer codigoDeAlumno, Boolean estudioso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoDeAlumno = codigoDeAlumno;
        this.estudioso = estudioso;
        this.copiasDeGuiasDelAlumno = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getCodigoDeAlumno() {
        return codigoDeAlumno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCodigoDeAlumno(Integer codigoDeAlumno) {
        this.codigoDeAlumno = codigoDeAlumno;
    }

    @Override
    public boolean equals(Object obj) {
        Alumno unAlumno = (Alumno) obj;
        return unAlumno.getCodigoDeAlumno().equals(this.codigoDeAlumno);
    }

    @Override
    public String toString() {
        return "Alumno/a: " + nombre + " " + apellido +
                " (codigo:" + codigoDeAlumno + ")";
    }

    @Override
    public Boolean esEstudioso() {
        while (estudioso != null) {
            if (estudioso) {
                return true;
            } else return false;
        }
        return null;
    }

    /**
     *metodo para que el alumno imprima en la impresora
     * @param unaImpresora
     * @param codigo
     */

    public void usarImpresora(Impresora unaImpresora, Integer codigo) {
        Boolean imprimio = unaImpresora.imprimir(codigo);

        if (imprimio) {
            for (Guia unaCopia : copiasDeGuiasDelAlumno) {
                if (unaCopia.getCodigo().equals(codigo)) {
                    copiasDeGuiasDelAlumno.add(unaCopia);
                }
            }
        }

    }


}
