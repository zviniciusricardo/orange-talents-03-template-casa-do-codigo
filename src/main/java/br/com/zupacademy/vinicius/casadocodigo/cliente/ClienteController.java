package br.com.zupacademy.vinicius.casadocodigo.cliente;

import br.com.zupacademy.vinicius.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.vinicius.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<?> salvaCliente(@RequestBody @Valid ClienteForm form) {
        Cliente cliente = clienteRepository.save(form.toModel(paisRepository, estadoRepository));
        return ResponseEntity.ok().body(new ClienteDto(cliente));
    }
}
