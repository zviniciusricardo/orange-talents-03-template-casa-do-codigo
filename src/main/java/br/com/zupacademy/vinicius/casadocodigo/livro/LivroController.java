package br.com.zupacademy.vinicius.casadocodigo.livro;

import br.com.zupacademy.vinicius.casadocodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> salvaLivro(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toModel(manager);
        manager.persist(livro);
        return ResponseEntity.ok().body(new LivroDto(livro).toString());
    }

    @GetMapping
    public List<LivroDto> listaLivros() {
        List<Livro>livros = livroRepository.findAll();
        return livros.stream().map(livro ->
                new LivroDto(livro)).collect(Collectors.toList());
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<?> detalhaLivro(@PathVariable long id, LivroRepository repository) {

        LivroViewForm viewForm = new LivroViewForm(id, repository);
        return new ResponseEntity<>(
                new LivroDetalhesDto(viewForm), HttpStatus.OK);
    }
}