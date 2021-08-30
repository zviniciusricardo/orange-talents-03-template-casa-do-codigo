package br.com.zupacademy.vinicius.casadocodigo.autor;

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

    private String email;

    private String nome;

    private String descricao;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public String toString() {
        return "Autor\n" +
                "\n\tid=" +id+
                "\n\temail=" +email+
                "\n\tnome=" +nome+
                "\n\tdescricao=" +descricao+
                "\n\tdataCriacao=" +dataCriacao;
    }
}
