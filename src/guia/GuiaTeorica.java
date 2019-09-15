package guia;

import java.util.List;

public class GuiaTeorica extends Guia {

    private List<String> listaDeLosTemas;


    public GuiaTeorica(Integer codigo, Integer cantidadDePaginas, Double costo, String titulo, List<String> listaDeLosTemas) {
        super(codigo, cantidadDePaginas, costo, titulo);
        this.listaDeLosTemas = listaDeLosTemas;
    }

    public List<String> getListaDeLosTemas() {
        return listaDeLosTemas;
    }

    public void setListaDeLosTemas(List<String> listaDeLosTemas) {
        this.listaDeLosTemas = listaDeLosTemas;
    }
}
