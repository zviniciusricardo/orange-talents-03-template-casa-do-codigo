package br.com.zupacademy.vinicius.casadocodigo.form;

import br.com.zupacademy.vinicius.casadocodigo.model.Autor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {

    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty
    private String email;

    @NotNull @NotEmpty @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor converteParaAutor(String nome, String email, String descricao) {
        return new Autor(nome, email, descricao);
    }
}
