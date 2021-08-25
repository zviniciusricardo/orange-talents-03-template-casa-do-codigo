package br.com.zupacademy.vinicius.casadocodigo.form;

import br.com.zupacademy.vinicius.casadocodigo.model.Autor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Valid
@NotBlank
public class AutorForm {

    private final String nome;
    private final String email;
    private final String descricao;


    @Valid
    public AutorForm(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
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
