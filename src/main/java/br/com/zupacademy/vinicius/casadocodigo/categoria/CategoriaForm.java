package br.com.zupacademy.vinicius.casadocodigo.categoria;

import br.com.zupacademy.vinicius.casadocodigo.autor.Autor;
import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "nome")
    public String nome;

    public CategoriaForm(@NotBlank String nome) {
        this.nome = nome;
    }

    private Categoria toModel(String nome) {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "CategoriaForm{" +
                "nome='" + nome + '\'' +
                '}';
    }


}
