package br.com.zupacademy.vinicius.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvaLivro(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toModel(manager);
        manager.persist(livro);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @GetMapping
    public List<LivroDto> listaLivros() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(livro ->
                new LivroDto(livro)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> detalhaLivro(@Valid @PathVariable Long id, UriComponentsBuilder builder) {
        Livro livro = manager.find( Livro.class, id);
        URI uri = builder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDetalhesView(new LivroDetalhesForm(livro)));
    }
}