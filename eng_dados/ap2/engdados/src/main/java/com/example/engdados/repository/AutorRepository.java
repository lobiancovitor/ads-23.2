package com.example.engdados.repository;

import com.example.engdados.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    List<Autor> findAutoresByMusicasId(Integer id);
}
