package br.com.zupacademy.vinicius.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @ResponseBody
    @Transactional
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid PaisForm form) {
        Pais pais = new Pais(form);
        repository.save(pais);
        return new ResponseEntity<>(new PaisDto(pais), HttpStatus.OK);
    }
}
