package guia;

public class Guia {
    private Integer codigo;
    private Integer cantidadDePaginas;
    private Double costo;
    private String titulo;

    public Guia(Integer codigo, Integer cantidadDePaginas, Double costo, String titulo) {
        this.codigo = codigo;
        this.cantidadDePaginas = cantidadDePaginas;
        this.costo = costo;
        this.titulo = titulo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public Double getCosto() {
        return costo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
