package com.example.engdados.controller;

import com.example.engdados.exception.RecordNotFoundException;
import com.example.engdados.model.Autor;
import com.example.engdados.model.Musica;
import com.example.engdados.repository.AutorRepository;
import com.example.engdados.repository.MusicaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class AutorController {

    private final AutorRepository autorRepository;
    private final MusicaRepository musicaRepository;

    public AutorController(AutorRepository autorRepository,
                           MusicaRepository musicaRepository) {
        this.autorRepository = autorRepository;
        this.musicaRepository = musicaRepository;
    }

    @GetMapping("/autores")
    public ResponseEntity<List<Autor>> getAllAutores() {
        List<Autor> autores = new ArrayList<>();
        autorRepository.findAll().forEach(autores::add);

        if (autores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/autores/{musicaId}/musicas")
    public ResponseEntity<List<Autor>> getAllAutoresByMusicaId(@PathVariable("musicaId") Integer musicaId) {
        if (!musicaRepository.existsById(musicaId)) {
            throw new RecordNotFoundException(musicaId);
        }
        List<Autor> autores = autorRepository.findAutoresByMusicasId(musicaId);

        if (autores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/autores/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable("id") Integer id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PutMapping("/autores/{autorId}/{musicaId}")
    public ResponseEntity<Autor> addAutor(@PathVariable("musicaId") Integer musicaId,
                                          @PathVariable("autorId") Integer autorId) {
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(() -> new RecordNotFoundException(autorId));

        Musica musica = musicaRepository.findById(musicaId)
                .orElseThrow(() -> new RecordNotFoundException(musicaId));

        musica.addAutor(autor);

        return new ResponseEntity<>(autorRepository.save(autor), HttpStatus.OK);
    }

    @PostMapping("/autores")
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        Autor _autor = autorRepository.save(
                new Autor(
                        autor.getCpf(),
                        autor.getNomeOriginal(),
                        autor.getNomeArtistico(),
                        autor.getMusicas()
                )
        );

        return new ResponseEntity<>(_autor, HttpStatus.CREATED);
    }

    @PutMapping("/autores/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Integer id,
                                      @RequestBody  Autor autorRequest) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        autor.setCpf(autorRequest.getCpf());
        autor.setNomeOriginal(autorRequest.getNomeOriginal());
        autor.setNomeArtistico(autorRequest.getNomeArtistico());
        autor.setMusicas(autorRequest.getMusicas());

        return new ResponseEntity<>(autorRepository.save(autor), HttpStatus.OK);
    }

    @DeleteMapping("/autores/{id}")
    public ResponseEntity<HttpStatus> deleteAutor(@PathVariable Integer id){
        autorRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
