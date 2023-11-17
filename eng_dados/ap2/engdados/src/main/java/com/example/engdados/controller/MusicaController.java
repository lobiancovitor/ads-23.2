package com.example.engdados.controller;

import com.example.engdados.exception.ResourceNotFoundException;
import com.example.engdados.model.Musica;
import com.example.engdados.repository.CategoriaRepository;
import com.example.engdados.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MusicaController {

    @Autowired
    MusicaRepository musicaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/musicas")
    public ResponseEntity<List<Musica>> getAllMusicas() {
        List<Musica> musicas = new ArrayList<Musica>();
        musicaRepository.findAll().forEach(musicas::add);

        if (musicas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(musicas, HttpStatus.OK);
    }

    @GetMapping("/musicas/{id}")
    public ResponseEntity<Musica> getMusicaById(@PathVariable("id") Integer id) {
        Musica musica = musicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada de id = " + id));

        return new ResponseEntity<>(musica, HttpStatus.OK);
    }

    @GetMapping("/categorias/{categoriaId}/musicas")
    public ResponseEntity<List<Musica>> getAllMusicasByCategoriaId(
            @PathVariable(value = "fk_categoria") Integer categoriaId) {
        if (!categoriaRepository.existsById(categoriaId)) {
            throw new ResourceNotFoundException("Categoria não encontrada de id = " + categoriaId);
        }
        List<Musica> musicas = musicaRepository.findByCategoriaId(categoriaId);
        return new ResponseEntity<>(musicas, HttpStatus.OK);
    }

    @GetMapping("/categorias/musicas/{id}")
    public ResponseEntity<Musica> getMusicaByCategoriaId(@PathVariable("id") Integer id) {
        Musica musica = musicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Música não encontrada de id = " + id));

        return new ResponseEntity<>(musica, HttpStatus.OK);
    }

    @PostMapping("categorias/{categoriaId}/musicas")
    public ResponseEntity<Musica> createMusica(@PathVariable("id") Integer categoriaId,
                                               @RequestBody Musica musica) {
        Musica _musica = categoriaRepository.findById(categoriaId).map(categoria -> {
            musica.setCategoria(categoria);
            return musicaRepository.save(musica);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Categoria não encontrada de id = " + categoriaId)
        );
        return new ResponseEntity<>(_musica, HttpStatus.CREATED);
    }

    @PutMapping("/musicas/{id}")
    public ResponseEntity<Musica> updateMusica(@PathVariable("id") Integer id,
                                       @RequestBody Musica musica) {
        Musica _musica  = musicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Música não encontrada de id = " + id
                ));

        _musica.setTitulo(musica.getTitulo());
        _musica.setLetra(musica.getLetra());
        _musica.setDataLancamento(musica.getDataLancamento());
        _musica.setDuracao(musica.getDuracao());
        _musica.setCategoria(musica.getCategoria());
        _musica.setAutores(musica.getAutores());

        return new ResponseEntity<>(musicaRepository.save(_musica), HttpStatus.OK);
    }

    @DeleteMapping("/musicas/{id}")
    public ResponseEntity<HttpStatus> deleteMusica(@PathVariable("id") Integer id){
        musicaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
