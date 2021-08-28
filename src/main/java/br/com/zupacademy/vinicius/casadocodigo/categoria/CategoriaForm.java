package br.com.zupacademy.vinicius.casadocodigo.categoria;

import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;
import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public CategoriaForm() {
    }

    public CategoriaForm(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
