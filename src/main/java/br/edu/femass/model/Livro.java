package br.edu.femass.model;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.dao.DaoProfessor;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    protected Long codigo;
    protected static Long proximoNumero = 1l;
    List<Autor> listaAutor = new ArrayList();
    protected String titulo;
    public Livro(){

    }

    public Livro(String titulo, List<Autor> autores ){
        this.titulo=titulo;
        listaAutor.addAll(autores);
        atualizarID();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public static void setProximoNumero(Long proximoNumero) {
        Livro.proximoNumero = proximoNumero;
    }

    public void atualizarID() {
        Long maior = 0L;
        try {
            List<Livro> livros = new DaoLivro().getAll();
            for (Livro l : livros) {
                if (l.getCodigo() > maior) {
                    maior = l.getCodigo();
                    setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
