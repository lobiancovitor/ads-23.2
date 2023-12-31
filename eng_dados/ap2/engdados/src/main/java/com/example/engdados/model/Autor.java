package com.example.engdados.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpf;

    private String nomeOriginal;

    private String nomeArtistico;

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private List<Musica> musicas = new ArrayList<>();

    public Autor(String cpf, String nomeOriginal, String nomeArtistico, List<Musica> musicas) {
        this.cpf = cpf;
        this.nomeOriginal = nomeOriginal;
        this.nomeArtistico = nomeArtistico;
        this.musicas = musicas;
    }

    public Autor() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
