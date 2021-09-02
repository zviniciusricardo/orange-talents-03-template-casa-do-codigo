package br.com.zupacademy.vinicius.casadocodigo.estado;

import br.com.zupacademy.vinicius.casadocodigo.pais.Pais;
import br.com.zupacademy.vinicius.casadocodigo.validator.IfExists;
import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @IfExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public EstadoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
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
