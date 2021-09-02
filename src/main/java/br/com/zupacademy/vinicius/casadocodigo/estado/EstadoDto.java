package br.com.zupacademy.vinicius.casadocodigo.estado;

public class EstadoDto {

    private Long id;
    private String nome;
    private Long paisId;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.paisId = estado.getPais().getId();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
