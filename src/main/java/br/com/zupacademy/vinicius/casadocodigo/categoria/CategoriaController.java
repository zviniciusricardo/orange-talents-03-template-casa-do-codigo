package br.com.zupacademy.vinicius.casadocodigo.categoria;

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
@RequestMapping("/categorias")
public class CategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvaCategoria(@RequestBody @Valid CategoriaForm categoriaForm) {
        Categoria categoria = categoriaForm.toModel();
        manager.persist(categoria);
        CategoriaDto dto = new CategoriaDto(categoria);
        return ResponseEntity.ok().body(dto);
    }
}
