package com.example.engdados.controller;

import com.example.engdados.model.Categoria;
import com.example.engdados.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity getAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existem categorias.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @GetMapping("{id}")
    public ResponseEntity getCategoria(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoria.get());
    }

    @PostMapping
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
        var newCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoria(@PathVariable Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        categoriaRepository.delete(categoria.get());
        return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada.");
    }

    @PutMapping("{id}")
    public ResponseEntity updateCategoria(@PathVariable Integer id,
                                      @RequestBody  Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if(optionalCategoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada.");
        }
        var updatedCategoria = optionalCategoria.get();
        updatedCategoria.setNome(categoria.getNome());

        categoriaRepository.save(updatedCategoria);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategoria);
    }
}
