package br.com.zupacademy.vinicius.casadocodigo.controller;

import br.com.zupacademy.vinicius.casadocodigo.form.AutorForm;
import br.com.zupacademy.vinicius.casadocodigo.model.Autor;
import br.com.zupacademy.vinicius.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public String salvaAutor(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.converteParaAutor();
        autorRepository.save(autor);
        return autor.toString();

    }
}
