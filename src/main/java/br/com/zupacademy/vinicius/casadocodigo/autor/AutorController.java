package br.com.zupacademy.vinicius.casadocodigo.autor;

import br.com.zupacademy.vinicius.casadocodigo.autor.AutorForm;
import br.com.zupacademy.vinicius.casadocodigo.autor.Autor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/autores")
    @Transactional
    public String salvaAutor(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.toModel();
        manager.persist(autor);
        return autor.toString();
    }
}
