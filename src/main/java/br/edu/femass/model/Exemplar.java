package br.edu.femass.model;

import br.edu.femass.dao.DaoExemplar;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Exemplar {

    protected Long codigo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDateTime dataAq;
    protected static Long proximoNumero = 1l;

    public List<Livro> getListaLivro() {
        return listaLivro;
    }

    List<Livro> listaLivro = new ArrayList();


    public Exemplar(){
    }

    public Exemplar(List<Livro> livros){
        listaLivro.addAll(livros);
        this.codigo = proximoNumero++;
        atualizarID();
        this.dataAq = LocalDateTime.now();
    }

    public LocalDateTime getDataAq() {
        return dataAq;
    }

    public void atualizarID() {
        Long maior = 0L;
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            for (Exemplar e : exemplares) {
                if (e.getCodigo() > maior) {
                    maior = e.getCodigo();
                    setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public static Long getProximoNumero() {
        return proximoNumero;
    }

    public static void setProximoNumero(Long proximoNumero) {
        Exemplar.proximoNumero = proximoNumero;
    }

    @Override
    public String toString() {
        return (this.codigo+" "+this.listaLivro);
    }
}
