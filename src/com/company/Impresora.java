package com.company;

import guia.Guia;
import guia.GuiaPractica;
import guia.GuiaTeorica;

import java.util.*;

public class Impresora {

    private Map<Integer, Guia> mapaDeGuias;
    private List<String> listaDeTemas;

    public Impresora() {
        this.mapaDeGuias = new HashMap<>();
        this.listaDeTemas = new ArrayList<>();
    }

    public Map<Integer, Guia> getMapaDeGuias() {
        return mapaDeGuias;
    }

    public List<String> getListaDeTemas() {
        return listaDeTemas;
    }

    /**
     * metodos para dar el alta a las guias
     * @param codigo
     * @param cantidadDePaginas
     * @param costo
     * @param titulo
     */

    public void altaDeGuia(Integer codigo, Integer cantidadDePaginas, Double costo, String titulo) {
        List<String> temario= ingresoTemario();
        GuiaTeorica unaGuia = new GuiaTeorica(codigo, cantidadDePaginas, costo, titulo, temario);
        if (mapaDeGuias.containsKey(codigo)) {
            System.out.println("Error. El codigo ya fue ingresado previamente");
        } else {
            mapaDeGuias.put(codigo, unaGuia);
            System.out.println("Guia teorica ingresada con exito");

        }

    }

    public void altaDeGuia(Integer codigo, Integer cantidadDePaginas, Double costo, String titulo, Integer cantidadDeEjercicios) {
        GuiaPractica unaGuia = new GuiaPractica(codigo, cantidadDePaginas, costo, titulo, cantidadDeEjercicios);

        if (mapaDeGuias.containsKey(codigo)) {
            System.out.println("Error. El codigo ya fue ingresado previamente");
        } else {
            mapaDeGuias.put(codigo, unaGuia);
            System.out.println("Guia practica ingresada con exito");

        }

    }

    /**
     * metodo para ingresar temas al temario de la guia teorica
     * @return
     */

    private List<String> ingresoTemario() {
        Boolean continuar = true;
        Scanner teclado = new Scanner(System.in);
        while (continuar) {
            System.out.println("Ingrese un tema para el temario de la guia teorica");
            listaDeTemas.add(teclado.next());
            System.out.println("Desea ingresar otro tema? (pulse cualquier tecla en caso afirmativo o 'N' para finalizar");
            String respuesta = teclado.next();
            if (respuesta.equals("N") || respuesta.equals("n")) {
                continuar = false;
            }
        }
        return listaDeTemas;
    }

    /**
     * metodos para borrar guias
     * @param codigo
     */

    public void borrarGuiaTeorica(Integer codigo) {
        if (!mapaDeGuias.containsKey(codigo)) {
            System.out.println("Codigo incorrecto");
        } else {
            mapaDeGuias.remove(codigo);
            System.out.println("La guia se ha borrado con exito");
        }
    }

    public void borrarGuiaPractica(Integer codigo) {
        if (!mapaDeGuias.containsKey(codigo)) {
            System.out.println("Codigo incorrecto");
        } else {
            mapaDeGuias.remove(codigo);
            System.out.println("La guia se ha borrado con exito");
        }
    }


    /**
     * metodo para imprimir
     * @param codigo
     * @return
     */
    public Boolean imprimir(Integer codigo) {
        Boolean seImprime = false;

        if (mapaDeGuias.containsKey(codigo)) {
            System.out.println("Se imprime guia " + mapaDeGuias.get(codigo).getTitulo());
            seImprime = true;
        } else System.out.println("No se pudo imprimir");

        return seImprime;
    }


}
