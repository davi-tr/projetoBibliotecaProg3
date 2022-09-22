package br.edu.femass.model;

import java.util.List;

public class Leitor {
    private Long codigo;
    private String nome;
    private String endereco;
    private String telefone;

    private List<Emprestimos> emprestimos;
    private Integer prazoMaximoDevolucao;

    private static Long proximoNumero = 1l;

    public Leitor(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigo = proximoNumero;
        proximoNumero++;
    }

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

    @Override
    calculartempo(){
        
    }


}
