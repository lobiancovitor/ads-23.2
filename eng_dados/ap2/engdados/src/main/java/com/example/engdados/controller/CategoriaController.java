package com.example.engdados.controller;

import com.example.engdados.exception.ResourceNotFoundException;
import com.example.engdados.model.Categoria;
import com.example.engdados.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        categoriaRepository.findAll().forEach(categorias::add);
        if (categorias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada de id = " + id));

        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria _categoria = categoriaRepository.save(
                new Categoria(categoria.getNome())
        );
        return new ResponseEntity<>(_categoria, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable("id") Integer id,
                                      @RequestBody  Categoria categoria) {
        Categoria _categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada de id = " + id));

        _categoria.setNome(categoria.getNome());

        return new ResponseEntity<>(categoriaRepository.save(_categoria), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable("id") Integer id){
        categoriaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
