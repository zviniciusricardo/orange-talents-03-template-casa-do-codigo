package br.com.zupacademy.vinicius.casadocodigo.pais;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface PaisRepository extends JpaRepository<Pais, String> {

    Optional<Pais> findByNome(String nome);
}
