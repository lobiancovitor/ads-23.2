package com.example.engdados.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String letra;

    private Date dataLancamento;

    private double duracao;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = true)
    @JoinColumn(name = "fk_categoria", nullable = true)
    private Categoria categoria;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "autor_musica",
            joinColumns = @JoinColumn(name = "fk_musica"),
            inverseJoinColumns = @JoinColumn(name = "fk_autor"))
    private List<Autor> autores = new ArrayList<>();

    public Musica(String titulo, String letra, Date dataLancamento, double duracao, Categoria categoria, List<Autor> autores) {
        this.titulo = titulo;
        this.letra = letra;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.categoria = categoria;
        this.autores = autores;
    }

    public Musica() { }

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

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
        autor.getMusicas().add(this);
    }

    public void removeAutor(Integer autorId) {
        Autor autor = this.autores.stream().filter(a -> a.getId() == autorId).findFirst().orElse(null);
        if (autor != null ){
            this.autores.remove(autor);
            autor.getMusicas().remove(this);
        }
    }
}
