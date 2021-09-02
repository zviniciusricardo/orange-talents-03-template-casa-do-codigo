package br.com.zupacademy.vinicius.casadocodigo.estado;

import br.com.zupacademy.vinicius.casadocodigo.pais.Pais;
import br.com.zupacademy.vinicius.casadocodigo.validator.IfExists;

import javax.validation.constraints.NotBlank;

public class EstadoForm {

    @NotBlank
    private String nome;

    @IfExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public EstadoForm(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public EstadoForm() {
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
