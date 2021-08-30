package br.com.zupacademy.vinicius.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;

interface LivroRepository extends JpaRepository<Livro, Long> {

}
