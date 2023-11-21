package com.example.engdados.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Integer id) {
        super("Registro não encontrado com id: " + id);
    }
}
