package com.example.engdados.controller;

import com.example.engdados.model.Autor;
import com.example.engdados.model.Categoria;
import com.example.engdados.model.Musica;
import com.example.engdados.repository.MusicaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    MusicaRepository musicaRepository;

    @GetMapping
    public ResponseEntity getAllMusicas() {
        List<Musica> musicas = musicaRepository.findAll();
        if (musicas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existem músicas.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(musicas);
    }

    @GetMapping("{id}")
    public ResponseEntity getMusica(@PathVariable Integer id) {
        Optional<Musica> musica = musicaRepository.findById(id);
        if (musica.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Música não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(musica.get());
    }

    @PostMapping
    public ResponseEntity<Musica> saveMusica(@RequestBody Musica musica) {
        var newMusica = musicaRepository.save(musica);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMusica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMusica(@PathVariable Integer id){
        Optional<Musica> musica = musicaRepository.findById(id);
        if(musica.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Música não encontrada.");
        }
        musicaRepository.delete(musica.get());
        return ResponseEntity.status(HttpStatus.OK).body("Música deletada.");
    }

    @PutMapping("{id}")
    public ResponseEntity updateMusica(@PathVariable Integer id,
                                      @RequestBody Musica musica) {
        Optional<Musica> optionalMusica = musicaRepository.findById(id);
        if(optionalMusica.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Música não encontrada.");
        }
        var updatedMusica = optionalMusica.get();
        updatedMusica.setTitulo(musica.getTitulo());
        updatedMusica.setLetra(musica.getLetra());
        updatedMusica.setDataLancamento(musica.getDataLancamento());
        updatedMusica.setDuracao(musica.getDuracao());
        updatedMusica.setCategoria(musica.getCategoria());
        updatedMusica.setAutores(musica.getAutores());

        musicaRepository.save(updatedMusica);
        return ResponseEntity.status(HttpStatus.OK).body(updatedMusica);
    }

}
