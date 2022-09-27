package br.edu.femass.model;

import java.util.Objects;

import java.util.Random;
public class Aluno extends Leitor{

    public Aluno(){

    }

    public Aluno(String nome, String endereco, String telefone){
        this.nome=nome;
        this.endereco=endereco;
        this.telefone=telefone;
        this.codigo = proximoNumero++;
        this.prazoMaximoDevolucao = 15;
    }

    @Override
    public void atualizarID() {
        super.atualizarID();
    }


    @Override
    public String toString() {

        return  (this.nome+" "+this.endereco+" "+this.telefone);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        if (!Objects.equals(nome, aluno.nome)) return false;
        if (!Objects.equals(endereco, aluno.endereco)) return false;
        return Objects.equals(telefone, aluno.telefone);
    }

}
