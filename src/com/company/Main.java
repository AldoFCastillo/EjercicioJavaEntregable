package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        DigitalHouseManager sede1 = new DigitalHouseManager();
        sede1.altaProfesorTitular("Antonio", "Rios", 3001, "Full Stack");
        sede1.altaProfesorTitular("Ozzy", "Osbourne", 3002, "Android");
        sede1.altaProfesorAdjunto("Leo", "Mattioli", 3003, 2);
        sede1.altaProfesorAdjunto("Lemmy", "Kilmister", 3004, 1);
        System.out.println("---------------------------------------------");

        sede1.altaCurso("Full Stack", 20001, 3);
        sede1.altaCurso("Android",20002,2);
        System.out.println("---------------------------------------------");

        sede1.asignarProfesores(20001,3001,3003);
        sede1.asignarProfesores(20002,3002,3004);
        System.out.println("---------------------------------------------");

        sede1.altaAlumno("Aldo","Castillo",1001);
        sede1.altaAlumno("David","Carradine",1002);
        sede1.altaAlumno("Bela","Lugosi",1003);
        System.out.println("---------------------------------------------");

        sede1.inscribirAlumno(1002,20001);
        sede1.inscribirAlumno(1003,20001);
        sede1.inscribirAlumno(1003,20002);
        sede1.inscribirAlumno(1002,20002);
        sede1.inscribirAlumno(1001,20002);
        System.out.println("---------------------------------------------");

        sede1.bajaProfesor(3003);
        System.out.println("---------------------------------------------");

        sede1.bajaCurso(20001);
    }
}
