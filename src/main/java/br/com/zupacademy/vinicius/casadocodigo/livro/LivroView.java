package br.com.zupacademy.vinicius.casadocodigo.livro;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class LivroView {

    private Long id;
    private String titulo;
    private String resumo;
    private Float eBook;
    private Float impresso;
    private Float ebookMaisImpresso;
    private String conteudo;
    private String sumario;
    private Integer numeroPaginas;
    private Long isbn;
    private LocalDate dataPublicacao;
    private String autorNome;


    public LivroView(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.eBook = livro.getPreco();
        this.impresso = calculaPrecoImpresso(.8F);
        this.ebookMaisImpresso = calculaPrecoEbookMaisImpresso(.15F);
        this.conteudo = livro.getSumario();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
    }

    public final void setAutorNome(EntityManager manager) {
        autorNome = manager.find(this.Autor, autorNome)
    }

    private Float calculaPrecoEbookMaisImpresso(Float desconto) {
        return (this.eBook + this.impresso) * desconto;
    }

    private Float calculaPrecoImpresso(Float acrescimo) {
        return this.eBook + (this.eBook * acrescimo);
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

    public Float geteBook() {
        return eBook;
    }

    public Float getImpresso() {
        return impresso;
    }

    public Float getEbookMaisImpresso() {
        return ebookMaisImpresso;
    }

    public String getConteudo() {
        return conteudo;
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
}
