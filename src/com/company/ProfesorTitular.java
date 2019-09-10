package com.company;

public class ProfesorTitular extends Profesor {

    private String especialidad;

    /**
     * Constructor de ProfesorTitular
     * @param nombre
     * @param apellido
     * @param antiguedad
     * @param codigoDeProfesor
     * @param especialidad
     */

    public ProfesorTitular(String nombre, String apellido, Integer antiguedad, Integer codigoDeProfesor, String especialidad) {
        super(nombre, apellido, antiguedad, codigoDeProfesor);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
