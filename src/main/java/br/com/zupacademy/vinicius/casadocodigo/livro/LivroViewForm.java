package br.com.zupacademy.vinicius.casadocodigo.livro;

import javax.persistence.EntityNotFoundException;

public class LivroViewForm {

    private Livro livro;

    public LivroViewForm(long id, LivroRepository repository) {
        this.livro = repository.findById(id).
                orElseThrow(EntityNotFoundException::new);
    }

    public Livro getLivro() {
        return this.livro;
    }
}
