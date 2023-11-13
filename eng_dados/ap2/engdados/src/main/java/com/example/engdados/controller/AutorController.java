package com.example.engdados.controller;

import com.example.engdados.model.Autor;
import com.example.engdados.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping
    public ResponseEntity getAllAutores() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existem autores.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(autores);
    }

    @GetMapping("{id}")
    public ResponseEntity getAutor(@PathVariable Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(autor.get());
    }

    @PostMapping
    public ResponseEntity<Autor> saveAutor(@RequestBody Autor autor) {
        var newAutor = autorRepository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAutor(@PathVariable Integer id){
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor não encontrado.");
        }
        autorRepository.delete(autor.get());
        return ResponseEntity.status(HttpStatus.OK).body("Autor deletado.");
    }

    @PutMapping("{id}")
    public ResponseEntity updateAutor(@PathVariable Integer id,
                                      @RequestBody  Autor autor) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        if(optionalAutor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor não encontrado.");
        }
        var updatedAutor = optionalAutor.get();
        updatedAutor.setCpf(autor.getCpf());
        updatedAutor.setNomeArtistico(autor.getNomeArtistico());
        updatedAutor.setNomeOriginal(autor.getNomeOriginal());

        autorRepository.save(updatedAutor);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAutor);
    }
}
