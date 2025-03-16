package com.eng.bibliotecajpa.Service;

import com.eng.bibliotecajpa.Entidade.Categoria;
import com.eng.bibliotecajpa.Entidade.Livro;
import com.eng.bibliotecajpa.Repository.CategoriaRepository;
import com.eng.bibliotecajpa.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Integer id) {
        return this.livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public List<Livro> findByTitulo(String titulo) {
        return this.livroRepository.buscartitulo(titulo);
    }

    public List<Livro> findByAutor(String autor) {
        return this.livroRepository.buscarAutor(autor);
    }

    public List<Livro> findByCategoria(String categoria) {
        return this.livroRepository.buscarCategoria(categoria);
    }

    public List<Livro> findByDisponivel() {
        return this.livroRepository.buscarDisponivel();
    }

    // Validação de Livro antes de salvar
    public Livro salvar(Livro livro) {

        // Verifica se a Categoria existe
        if (livro.getCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(livro.getCategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            livro.setCategoria(categoria);
        }

        return this.livroRepository.save(livro);
    }

    public void excluir(Integer id) {
        this.livroRepository.deleteById(id);
    }

    public Livro update(Livro livro) {
        return this.salvar(livro);
    }

}
