package br.com.zupacademy.vinicius.casadocodigo.categoria;

public class CategoriaDto {

    private Long id;
    private String nome;

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "CategoriaDto: " +
                "\n\tid= " +id+
                "\n\tnome= " +nome;
    }
}
