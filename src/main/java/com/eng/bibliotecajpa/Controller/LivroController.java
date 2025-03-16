package com.eng.bibliotecajpa.Controller;

import com.eng.bibliotecajpa.Entidade.Livro;
import com.eng.bibliotecajpa.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAll() {
        return livroService.findAll();
    }

    @GetMapping("/id/{id}")
    public Livro getById(@PathVariable Integer id) {
        return livroService.findById(id);
    }

    @GetMapping("/titulo/{titulo}")
    public List<Livro> getByTitulo(@PathVariable String titulo) {
        return livroService.findByTitulo(titulo);
    }

    @GetMapping("/autor/{autor}")
    public List<Livro> getByAutor(@PathVariable String autor) {
        return livroService.findByAutor(autor);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Livro> getByCategoria(@PathVariable String categoria) {
        return livroService.findByCategoria(categoria);
    }

    @GetMapping("/Disponiveis")
    public List<Livro> findByDisponivel() {
        return livroService.findByDisponivel();
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @PutMapping
    public Livro update(@RequestBody Livro livro) {
        return livroService.update(livro);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        this.livroService.excluir(id);
    }
}
