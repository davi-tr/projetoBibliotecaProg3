package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                Aluno aluno = new Aluno("TESTE", "DSA", "221111");
                aluno.atualizarID();
                new DaoAluno().save(aluno);
            }
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
        try{
            List<Aluno> alunos = new DaoAluno().getAll();
            for (Aluno a:alunos){
                System.out.println(a.getCodigo());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
