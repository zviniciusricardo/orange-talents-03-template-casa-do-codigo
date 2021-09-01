package br.com.zupacademy.vinicius.casadocodigo.estado;

import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class EstadoForm {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    public EstadoForm(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public EstadoForm() {
    }

    public String getNome() {
        return nome;
    }
}
