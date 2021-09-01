package br.com.zupacademy.vinicius.casadocodigo.pais;

import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisForm(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public PaisForm() {
    }

    public String getNome() {
        return nome;
    }
}
