package br.edu.femass.model;

import java.util.Objects;

public class Professor extends Leitor{
    protected String disciplina;
    public Professor(){

    }

    public Professor(String nome, String endereco, String telefone, String disciplina){
        this.nome=nome;
        this.endereco=endereco;
        this.telefone=telefone;
        this.disciplina=disciplina;
        this.codigo = proximoNumero++;
        this.prazoMaximoDevolucao = 30;
    }

    public void atualizarID() {
        super.atualizarID();
    }

    public String toString() {

        return  (this.codigo+" "+this.nome+" "+this.endereco+" "+this.telefone+" "+this.disciplina);
    }

    public String getDisciplina() {
        return disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(disciplina, professor.disciplina);
    }

}
