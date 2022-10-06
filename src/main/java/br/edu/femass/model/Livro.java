package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    protected Long codigo;
    List<Autor> listaAutor = new ArrayList();
    protected String titulo;
    public Livro(){

    }

    public Livro(String titulo, List<Autor> autores ){
        this.titulo=titulo;
        listaAutor.addAll(autores);
    }
}
