package com.example.engdados.repository;

import com.example.engdados.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer> {
    List<Musica> findByCategoriaId(Integer id);

    List<Musica> findMusicasByAutoresId(Integer id);
}
