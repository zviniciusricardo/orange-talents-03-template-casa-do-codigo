package br.com.zupacademy.vinicius.casadocodigo.pais;

public class PaisDto {

    private final Long id;
    private final String nome;

    public PaisDto(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
