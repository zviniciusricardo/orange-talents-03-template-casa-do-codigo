package br.com.zupacademy.vinicius.casadocodigo.pais;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    Optional<Pais> findByNome(String nome);
}
