package br.com.zupacademy.vinicius.casadocodigo.cliente;

import br.com.zupacademy.vinicius.casadocodigo.estado.Estado;
import br.com.zupacademy.vinicius.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nome;

    private String sobrenome;

    private String documento;

    private String endereco;

    private String complemento;

    private String cidade;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    private String telefone;

    private String cep;

    public Cliente( ClienteForm form, Pais pais, Estado estado) {
        this.email = form.getEmail();
        this.nome = form.getNome();
        this.sobrenome = form.getSobrenome();
        this.documento = form.getDocumento();
        this.endereco = form.getEndereco();
        this.complemento = form.getComplemento();
        this.cidade = form.getCidade();
        this.pais = pais;
        this.estado = estado;
        this.telefone = form.getTelefone();
        this.cep = form.getCep();
    }

    @Deprecated
    public Cliente() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
