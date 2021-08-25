package br.com.zupacademy.vinicius.casadocodigo.form;

import br.com.zupacademy.vinicius.casadocodigo.model.Autor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotBlank
    private final String nome;

    @NotBlank
    private final String email;

    @NotBlank @Size(max = 400)
    private final String descricao;


    public AutorForm(@NotBlank String nome, @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converteParaAutor() {
        return new Autor(this.nome, this.email, this.descricao );
    }
}
