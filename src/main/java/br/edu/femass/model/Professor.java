package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;

import java.util.List;
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
        atualizarID();
    }

    public void atualizarID() {
        Long maior = 0L;
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            for (Professor a : professores) {
                if (a.getCodigo() > maior) {
                    maior = a.getCodigo();
                    setCodigo(maior + 1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
