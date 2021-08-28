package br.com.zupacademy.vinicius.casadocodigo.autor;

import br.com.zupacademy.vinicius.casadocodigo.autor.Autor;
import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotBlank @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank @Size(max = 400)
    private String descricao;

    public AutorForm(@NotBlank String nome,
                     @NotBlank @Email String email,
                     @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao );
    }

    public String getEmail() {
        return email;
    }
}