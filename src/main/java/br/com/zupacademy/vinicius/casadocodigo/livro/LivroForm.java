package br.com.zupacademy.vinicius.casadocodigo.livro;

import br.com.zupacademy.vinicius.casadocodigo.autor.Autor;
import br.com.zupacademy.vinicius.casadocodigo.categoria.Categoria;
import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull @Digits(integer = 3, fraction = 2) @Min(20)
    private Float preco;

    @NotNull @Min(100)
    private Integer numeroPaginas;

    @NotNull @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private Long isbn;

    @NotNull @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;

    public LivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                     @NotNull @Digits(integer = 3, fraction = 2) @Min(20) Float preco,
                     @NotNull @Min(100) Integer numeroPaginas,
                     @NotNull Long isbn, @NotNull @Future LocalDate dataPublicacao,
                     @NotNull Long idCategoria, @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    @PersistenceContext
    public Livro toModel(EntityManager manager) {
        @NotNull Autor autor = manager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);

        return new Livro(titulo, resumo, preco, numeroPaginas, isbn,
                dataPublicacao, categoria, autor);
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
}
