package br.edu.femass.model;

import br.edu.femass.dao.DaoExemplar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Exemplar {

    protected Long codigo;

    protected LocalDateTime dataAq;
    protected static Long proximoNumero = 1l;

    public List<Livro> getListaLivro() {
        return listaLivro;
    }

    protected Integer quantidade;


    protected Boolean disponivel;

    List<Livro> listaLivro = new ArrayList();


    public Exemplar(){
    }

    public Exemplar(List<Livro> livros, Integer quantidade){
        listaLivro.addAll(livros);
        this.quantidade=quantidade;
        if(quantidade>1){
            this.disponivel=true;
        }else {
            this.disponivel=false;
        }
        this.codigo = proximoNumero++;
        atualizarID();
        this.dataAq = LocalDateTime.now();
    }


    public LocalDateTime getDataAq() {
        return dataAq;
    }


    public Boolean getDisponivel() {
        return disponivel;
    }

    public Integer getQuantidade() {
        return quantidade;
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
        return (this.codigo+" "+this.listaLivro.toString());
    }
}
