package com.example.engdados.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titulo;

    private String letra;

    private Date dataLancamento;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "autor_musica",
            joinColumns = @JoinColumn(name = "fk_musica"),
            inverseJoinColumns = @JoinColumn(name = "fk_autor")
    )
    private ArrayList<Autor> autores = new ArrayList<>();

    private float duracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
}
