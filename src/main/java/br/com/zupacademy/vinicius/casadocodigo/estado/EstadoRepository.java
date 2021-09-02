package br.com.zupacademy.vinicius.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, String> {

    Optional<Estado>findByNomeAndPaisId(String nome, Long idPais);

    List<Estado> findAllByPaisId(Long idPais);
}
