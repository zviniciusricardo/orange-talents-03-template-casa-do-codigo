package br.com.zupacademy.vinicius.casadocodigo.autor;

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

    @Deprecated
    public AutorForm() {
    }

    public AutorForm(@NotBlank @Email String email,
                     @NotBlank String nome,
                     @NotBlank @Size(max = 400) String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Autor toAutor() {
        return new Autor(this.email, this.nome, this.descricao );
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}