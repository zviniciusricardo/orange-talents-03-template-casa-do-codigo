package br.com.zupacademy.vinicius.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String nome;
    private final String email;
    private final String descricao;
    private LocalDateTime dataCriacao;

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        criadoEm();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    private void criadoEm() {
        this.dataCriacao = LocalDateTime.now();
    }
}
