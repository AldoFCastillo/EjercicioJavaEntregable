package com.company;

public class Curso {

    private String nombre;
    private Integer codigoDeCurso;

    public Curso(String nombre, Integer codigoDeCurso) {
        this.nombre = nombre;
        this.codigoDeCurso = codigoDeCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCodigoDeCurso() {
        return codigoDeCurso;
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
