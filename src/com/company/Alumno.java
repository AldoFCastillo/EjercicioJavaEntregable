package com.company;

public class Alumno {

    private String nombre;
    private String apellido;
    private Integer codigoDeAlumno;

    /**
     * Constructor de Alumno
     * @param nombre
     * @param apellido
     * @param codigoDeAlumno
     */

    public Alumno(String nombre, String apellido, Integer codigoDeAlumno) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoDeAlumno = codigoDeAlumno;
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
}
