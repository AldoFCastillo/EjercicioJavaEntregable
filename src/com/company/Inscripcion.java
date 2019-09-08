package com.company;

import java.util.Date;

public class Inscripcion {

    private Alumno alumno;
    private Curso curso;
    private Date fechaDelDia;

    public Inscripcion(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.fechaDelDia = new Date();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public Date getFechaDelDia() {
        return fechaDelDia;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setFechaDelDia(Date fechaDelDia) {
        this.fechaDelDia = fechaDelDia;
    }
}
