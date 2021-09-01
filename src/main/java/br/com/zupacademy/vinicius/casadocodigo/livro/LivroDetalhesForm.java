package br.com.zupacademy.vinicius.casadocodigo.livro;

import br.com.zupacademy.vinicius.casadocodigo.autor.Autor;

import java.time.LocalDate;

public class LivroDetalhesForm {


    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private Integer numeroPaginas;

    private Long isbn;

    private LocalDate dataPublicacao;

    private Float precoEbook;

    private Float precoImpresso;

    private Float precoEbookMaisImpresso;

    private Autor autor;

    public LivroDetalhesForm(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = livro.getAutor();
        this.precoEbook = livro.getPreco();
        this.precoImpresso = calculaPrecoImpresso(1.8F);
        this.precoEbookMaisImpresso = calculaPrecoEbookMaisImpresso(.15F);
    }

    private Float calculaPrecoImpresso(Float addCustos) {
        return this.precoImpresso = this.precoEbook * addCustos;
    }

    private Float calculaPrecoEbookMaisImpresso(Float desconto) {
        float total = (this.precoEbook + this.precoImpresso);
        return this.precoEbookMaisImpresso = total - (total * desconto);
    }

    public Float getPrecoEbook() {
        return precoEbook;
    }

    public Float getPrecoImpresso() {
        return precoImpresso;
    }

    public Float getPrecoEbookMaisImpresso() {
        return precoEbookMaisImpresso;
    }

    public Long getId() {
        return id;
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

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public Long getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }
}
