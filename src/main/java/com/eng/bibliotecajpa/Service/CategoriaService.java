package com.eng.bibliotecajpa.Service;

import com.eng.bibliotecajpa.Entidade.Categoria;
import com.eng.bibliotecajpa.Repository.CategoriaRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada"));
    }

    public Categoria salvar(Categoria categoria) {
       return this.categoriaRepository.save(categoria);
    }

    public void excluir(Integer id) {
        this.categoriaRepository.deleteById(id);
    }

    public Categoria update(Categoria categoria) {
        return this.salvar(categoria);
    }
}
