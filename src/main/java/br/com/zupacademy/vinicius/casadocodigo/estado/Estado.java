package br.com.zupacademy.vinicius.casadocodigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    public Estado(EstadoForm form) {
        this.nome = form.getNome();
    }

    @Deprecated
    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
