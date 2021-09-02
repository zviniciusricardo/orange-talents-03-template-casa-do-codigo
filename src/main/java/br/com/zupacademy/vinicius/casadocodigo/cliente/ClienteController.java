package br.com.zupacademy.vinicius.casadocodigo.cliente;

import br.com.zupacademy.vinicius.casadocodigo.estado.Estado;
import br.com.zupacademy.vinicius.casadocodigo.pais.Pais;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseBody
    @Transactional
    ResponseEntity<?> salvaCliente(@RequestBody @Valid ClienteForm form) {
        Pais pais = manager.find(Pais.class, form.getPaisId());
        Estado estado = manager.find(Estado.class, form.getEstadoId());
        Cliente cliente = new Cliente(form, pais, estado);
        manager.persist(cliente);
        return new ResponseEntity<>(new ClienteDto(cliente), HttpStatus.OK);
    }
}
