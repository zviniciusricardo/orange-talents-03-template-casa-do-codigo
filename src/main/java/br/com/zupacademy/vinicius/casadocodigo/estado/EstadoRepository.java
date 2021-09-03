package br.com.zupacademy.vinicius.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado>findByPaisId(Long idPais);

    Optional<List<Estado>> findAllByPaisId(Long idPais);
}
