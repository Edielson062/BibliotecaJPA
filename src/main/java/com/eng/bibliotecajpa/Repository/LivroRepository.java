package com.eng.bibliotecajpa.Repository;

import com.eng.bibliotecajpa.Entidade.Categoria;
import com.eng.bibliotecajpa.Entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    // Consulta JPQL
    @Query("SELECT li FROM Livro li WHERE li.titulo LIKE CONCAT('%', :nomeTitulo, '%')")
    List<Livro> buscartitulo(@Param("nomeTitulo") String nomeTitulo);

    @Query("SELECT li FROM Livro li WHERE li.autor LIKE CONCAT('%', :nomeAutor, '%')")
    List<Livro> buscarAutor(@Param("nomeAutor") String nomeAutor);

    @Query("SELECT li FROM Livro li WHERE li.categoria.nome LIKE CONCAT('%', :nomeCategoria, '%')")
    List<Livro> buscarCategoria(@Param("nomeCategoria") String nomeCategoria);

    @Query("SELECT li FROM Livro li WHERE li.quantidadeDisponivel > 0 ")
    List<Livro> buscarDisponivel();
}
