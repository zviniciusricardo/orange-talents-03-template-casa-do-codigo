package br.com.zupacademy.vinicius.casadocodigo.controller;

import br.com.zupacademy.vinicius.casadocodigo.form.AutorForm;
import br.com.zupacademy.vinicius.casadocodigo.model.Autor;
import br.com.zupacademy.vinicius.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/autores")
@Valid
public class AutorController {

    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public String salvaAutor(@RequestBody @Valid @NotBlank AutorForm autorForm) {
        Autor autor = autorForm.converteParaAutor();
        manager.persist(autor);
        return autor.toString();
    }
}
