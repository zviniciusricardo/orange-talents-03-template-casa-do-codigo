package br.com.zupacademy.vinicius.casadocodigo.livro;

import java.time.LocalDate;

public class LivroDto {

    private String titulo;

    private String resumo;

    private String sumario;

    private Float preco;

    private Integer numeroPaginas;

    private Long isbn;

    private LocalDate dataPublicacao;


    public LivroDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Float getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public Long getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String toString() {
        return "LivroDto: " +
                "\n\ttitulo= " +titulo+
                "\n\tresumo= " +resumo+
                "\n\tsumario= " +sumario+
                "\n\tpreco= " +preco+
                "\n\tnumeroPaginas= " +numeroPaginas+
                "\n\tisbn= " +isbn+
                "\n\tdataPublicacao= " + dataPublicacao;
    }
}
