package br.com.zupacademy.vinicius.casadocodigo.livro;

public class LivroDto {

    final Long id;

    final String titulo;


    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
