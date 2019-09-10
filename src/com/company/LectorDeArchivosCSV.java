package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Metodo para convertir listadoDeAlumnos.csv en una Lista de Alumnos
 */

public class LectorDeArchivosCSV {
    public static final String SEPARATOR = ",";
    public static final String QUOTE = "\"";

    public List<Alumno> lector() throws IOException {
        List<Alumno> listadoDeAlumnos = new ArrayList<>();
        BufferedReader br = null;


        try {

            br = new BufferedReader(new FileReader("listadoDeAlumnos.csv"));
            String line = br.readLine();

            while (null != line) {
                line = br.readLine();
                String[] fields = line.split(SEPARATOR);
                int numEntero = Integer.parseInt(fields[0]);
                Alumno unAlumno = new Alumno(fields[1], fields[2], numEntero);
                listadoDeAlumnos.add(unAlumno);
                line = br.readLine();
            }

        } catch (Exception e) {

        } finally {
            if (null != br) {
                br.close();
            }
        }
        return listadoDeAlumnos;

    }


}