package com.example.engdados.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date dataCriacao;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "musica_playlist",
            joinColumns = @JoinColumn(name = "fk_playlist"),
            inverseJoinColumns = @JoinColumn(name = "fk_musica")
    )
    private ArrayList<Musica> musicas = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }
}
