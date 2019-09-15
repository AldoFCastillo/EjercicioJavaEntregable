package guia;

public class GuiaPractica extends Guia {
    private Integer cantidadDeEjercicios;

    public GuiaPractica(Integer codigo, Integer cantidadDePaginas, Double costo, String titulo, Integer cantidadDeEjercicios) {
        super(codigo, cantidadDePaginas, costo, titulo);
        this.cantidadDeEjercicios = cantidadDeEjercicios;
    }

    public Integer getCantidadDeEjercicios() {
        return cantidadDeEjercicios;
    }

    public void setCantidadDeEjercicios(Integer cantidadDeEjercicios) {
        this.cantidadDeEjercicios = cantidadDeEjercicios;
    }
}
