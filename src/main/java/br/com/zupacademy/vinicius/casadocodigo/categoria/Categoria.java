package br.com.zupacademy.vinicius.casadocodigo.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Categoria \n" + "\tid=" +id+ "\n \tnome=" + nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}