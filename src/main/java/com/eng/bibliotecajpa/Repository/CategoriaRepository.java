package com.eng.bibliotecajpa.Repository;

import com.eng.bibliotecajpa.Entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
