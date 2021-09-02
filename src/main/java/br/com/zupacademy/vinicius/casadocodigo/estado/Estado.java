package br.com.zupacademy.vinicius.casadocodigo.estado;

import br.com.zupacademy.vinicius.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Pais pais;

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

    public Pais getPais() {
        return pais;
    }
}
