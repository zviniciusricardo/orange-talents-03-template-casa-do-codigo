package br.com.zupacademy.vinicius.casadocodigo.estado;

import br.com.zupacademy.vinicius.casadocodigo.pais.Pais;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {


    @PersistenceContext
    private EntityManager manager;


    @PostMapping
    @Transactional
    public ResponseEntity<?> salva(@RequestBody @Valid EstadoForm form ) {
        Pais pais = manager.find(Pais.class, form.getPaisId());
        Estado estado = new Estado(form, pais);
        manager.persist(estado);
        return new ResponseEntity<>(new EstadoDto(estado), HttpStatus.OK);
    }

}
