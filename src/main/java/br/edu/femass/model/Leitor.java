package br.edu.femass.model;

import java.util.List;

public class Leitor {
    protected Long codigo;
    protected String nome;
    protected String endereco;
    protected String telefone;

    protected List<Emprestimos> emprestimos;
    protected Integer prazoMaximoDevolucao;

    protected static Long proximoNumero = 1l;


    public Long getCodigo() {
        return codigo;
    }


    public String getNome() {
        return nome;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }



}
