package br.com.zupacademy.vinicius.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class LivroDetalhesView {

    private final Long id;

    private final String titulo;

    private final String resumo;

    private final String sumario;

    private final Integer numeroPaginas;

    private final Long isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private final LocalDate dataPublicacao;

    private final String autorNome;

    private final String autorDescricao;

    private final Float precoEbook;

    private final Float precoImpresso;

    @NotNull
    private final Float precoEbookMaisImpresso;


    public LivroDetalhesView(LivroDetalhesForm form) {
        this.id = form.getId();
        this.titulo = form.getTitulo();
        this.resumo = form.getResumo();
        this.sumario = form.getSumario();
        this.numeroPaginas = form.getNumeroPaginas();
        this.isbn = form.getIsbn();
        this.dataPublicacao = form.getDataPublicacao();
        this.autorNome = form.getAutor().getNome();
        this.autorDescricao = form.getAutor().getDescricao();
        this.precoEbook = form.getPrecoEbook();
        this.precoImpresso = form.getPrecoImpresso();
        this.precoEbookMaisImpresso = form.getPrecoEbookMaisImpresso();
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

    public String getAutorNome() {
        return autorNome;
    }

    public String getAutorDescricao() {
        return autorDescricao;
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
}
