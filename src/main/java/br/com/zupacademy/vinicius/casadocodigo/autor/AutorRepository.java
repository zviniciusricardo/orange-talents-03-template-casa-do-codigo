package br.com.zupacademy.vinicius.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {

    Optional<Autor> findByEmail(String email);
}
