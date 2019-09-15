package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class LectorDeArchivosCSV {
    private String separador = ",";

    /**
     * Metodo para convertir listadoDeAlumnos.csv en una Lista de Alumnos
     * para Destacado 1
     * @return
     * @throws IOException
     */
    public List<Alumno> lector() throws IOException {
        List<Alumno> listadoDeAlumnos = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("listadoDeAlumnos.csv"));
            String line = br.readLine();
            line = br.readLine();
            while (null != line) {
                String[] fields = line.split(separador);
                int numEntero = Integer.parseInt(fields[0]);
                Alumno unAlumno = new Alumno(fields[1], fields[2], numEntero);
                listadoDeAlumnos.add(unAlumno);
                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo: ");
            e.printStackTrace();

        } finally {
            if (null != br) {
                br.close();
            }
        }
        return listadoDeAlumnos;

    }


}