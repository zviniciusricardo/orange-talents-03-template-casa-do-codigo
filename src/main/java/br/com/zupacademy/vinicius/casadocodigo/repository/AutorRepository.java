package br.com.zupacademy.vinicius.casadocodigo.repository;

import br.com.zupacademy.vinicius.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
