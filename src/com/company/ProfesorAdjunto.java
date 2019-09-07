package com.company;

public class ProfesorAdjunto extends Profesor {

    private Integer cantHorasParaConsultas;


    public ProfesorAdjunto(String nombre, String apellido, Integer antiguedad, Integer codigoDeProfesor, Integer cantHorasParaConsultas) {
        super(nombre, apellido, antiguedad, codigoDeProfesor);
        this.cantHorasParaConsultas = cantHorasParaConsultas;
    }

    public Integer getCantHorasParaConsultas() {
        return cantHorasParaConsultas;
    }

    public void setCantHorasParaConsultas(Integer cantHorasParaConsultas) {
        this.cantHorasParaConsultas = cantHorasParaConsultas;
    }
}