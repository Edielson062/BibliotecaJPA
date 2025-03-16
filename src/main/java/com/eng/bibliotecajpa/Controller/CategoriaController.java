package com.eng.bibliotecajpa.Controller;

import com.eng.bibliotecajpa.Entidade.Categoria;
import com.eng.bibliotecajpa.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public Categoria salvar(Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    @PutMapping
    public Categoria update(Categoria categoria) {
        return categoriaService.update(categoria);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id) {
        this.categoriaService.excluir(id);
    }
}
