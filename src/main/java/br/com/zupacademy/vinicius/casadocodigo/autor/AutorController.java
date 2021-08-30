package br.com.zupacademy.vinicius.casadocodigo.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> salvar(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.toAutor();
        manager.persist(autor);
        AutorDto dto = new AutorDto(autor);
        return ResponseEntity.ok().body(dto.toString());
    }
}
