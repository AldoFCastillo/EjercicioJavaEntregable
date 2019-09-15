package com.company;

import com.digitalhouse.DHException;
import com.digitalhouse.DigitalException;
import com.digitalhouse.OtherException;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, DHException, OtherException {
        // write your code here
        Impresora unaImpresora = new Impresora();


        DigitalHouseManager sede1 = new DigitalHouseManager();
        sede1.setUnaImpresora(unaImpresora);
        sede1.altaProfesorTitular("Lia", "Crucet", 3001, "Full Stack");
        sede1.altaProfesorTitular("Ozzy", "Osbourne", 3002, "Android");
        sede1.altaProfesorAdjunto("Leo", "Mattioli", 3003, 2);
        sede1.altaProfesorAdjunto("Lemmy", "Kilmister", 3004, 1);
        System.out.println("---------------------------------------------");

        sede1.altaCurso("Full Stack", 20001, 3);
        sede1.altaCurso("Android", 20002, 2);
        System.out.println("---------------------------------------------");

        sede1.asignarProfesores(20001, 3001, 3003);
        sede1.asignarProfesores(20002, 3002, 3004);
        System.out.println("---------------------------------------------");

        sede1.altaAlumno("Aldo", "Castillo", 1001, true);
        sede1.altaAlumno("David", "Carradine", 1002, false);
        sede1.altaAlumno("Tura", "Satana", 1003, true);

        System.out.println("---------------------------------------------");

        sede1.inscribirAlumno(1002, 20001);
        sede1.inscribirAlumno(1003, 20001);
        sede1.inscribirAlumno(1001, 20002);
        sede1.inscribirAlumno(1002, 20002);
        sede1.inscribirAlumno(1003, 20002);
        System.out.println("---------------------------------------------");

        sede1.bajaProfesor(3003);
        System.out.println("---------------------------------------------");

        sede1.bajaCurso(20001);


        /**
         * Parte K
         * ¿Cómo modificaría el diagrama de clases para que se le pueda consultar a un alumno a qué
         * cursos está inscripto?
         *
         * A la clase Alumno se le podría sumar como atributo una lista de cursosInscriptos.
         * Se podria agregar cursos a esta lista<Curso> mediante un metodo(en la clase Alumno) que reciba el objeto de tipo Curso
         * y lo agregue mediante un List<Curso>.add. Este metodo se podría llamar desde el constructor de la clase Inscripcion.
         * Mediante un metodo get se podria devolver esta lista<Curso>.
         */

        /**
         * Destacado opcion 1
         */
        System.out.println();
        System.out.println("//--------------------DESTACADO OPCION 1---------------------//");
        LectorDeArchivosCSV lectorcsv = new LectorDeArchivosCSV();
        sede1.altaCurso("Android Mobile", 20003, 30);
        sede1.asignarProfesores(20003, 3001, 3004);
        System.out.println();
        System.out.println("--------Creacion e inscripcion de listadoDeAlumnos.csv---------");
        for (Alumno unAlumno : lectorcsv.lector()) {
            sede1.altaAlumno(unAlumno.getNombre(), unAlumno.getApellido(), unAlumno.getCodigoDeAlumno());
            sede1.inscribirAlumno(unAlumno.getCodigoDeAlumno(), 20003);
        }

        /**
         * Destacado opcion 2
         */
        System.out.println();
        System.out.println("//--------------------DESTACADO OPCION 2---------------------//");
        System.out.println();


        for (Alumno unAlumno : sede1.getListaDeAlumnos()) {
            System.out.println(unAlumno);
            try {

                DigitalException.inscripcionDH(unAlumno);


            } catch (DHException e) {
                System.out.println("Venir al colearning.");
                //  e.printStackTrace();
            } catch (OtherException ee) {
                System.out.println("Hablar con alumnos.");
                //   ee.printStackTrace();
            } catch (NullPointerException eee) {
                System.out.println("Alumno/a sin referencias");
                //   eee.printStackTrace();
            }
        }

        /**
         * Destacado opcion 3
         *
         */

        System.out.println();
        System.out.println("//--------------------DESTACADO OPCION 3---------------------//");
        System.out.println();

        unaImpresora.altaDeGuia(12, 10, 10.0, "Teorico Android");
        unaImpresora.altaDeGuia(123, 20, 15.0, "Guia Practica Android", 120);
        unaImpresora.altaDeGuia(1234, 3, 5.0, "Practica Fulll Stack 1", 15);
        unaImpresora.altaDeGuia(12345, 30, 50.0, "Teoria Full Stack 1");
        unaImpresora.borrarGuiaPractica(1234);
        unaImpresora.borrarGuiaTeorica(12345);
        System.out.println("---------------------PRUEBA DE IMPRESION------------------------");

        for (Alumno unAlumno : sede1.getListaDeAlumnos()) {
            unAlumno.usarImpresora(unaImpresora, 12);
            unAlumno.usarImpresora(unaImpresora, 123);
            unAlumno.usarImpresora(unaImpresora, 1234);
            unAlumno.usarImpresora(unaImpresora, 12345);
        }

    }


}
