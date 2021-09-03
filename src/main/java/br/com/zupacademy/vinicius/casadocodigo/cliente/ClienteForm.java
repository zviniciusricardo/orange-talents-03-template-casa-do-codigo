package br.com.zupacademy.vinicius.casadocodigo.cliente;

import br.com.zupacademy.vinicius.casadocodigo.estado.Estado;
import br.com.zupacademy.vinicius.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.vinicius.casadocodigo.pais.Pais;
import br.com.zupacademy.vinicius.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.vinicius.casadocodigo.validator.CPForCNPJ;
import br.com.zupacademy.vinicius.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteForm {

    @NotBlank @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank @CPForCNPJ
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
                       @NotBlank String documento, @NotBlank String endereco,
                       @NotBlank String complemento, @NotBlank String cidade, @NotBlank Long paisId,
                       Long estadoId, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {

        Optional<Pais> pais = paisRepository.findById(paisId);
        Optional<Estado> estado = estadoRepository.findById(estadoId);

        if (pais.isEmpty() || estado.isEmpty()) throw new IllegalArgumentException();

        return new Cliente(this.email, this.nome, this.sobrenome, this.documento,
                 this.endereco, this.complemento, this.cidade, pais.get(), estado.get(), this.telefone, this.cep);

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

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
