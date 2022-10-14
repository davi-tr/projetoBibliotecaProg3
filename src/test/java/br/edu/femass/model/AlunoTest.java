package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void atualizarID() {
        Aluno aluno =  new Aluno("Teste","Teste","22000001");
        aluno.atualizarID();
        Long maior = 0L;
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            for (Aluno a : alunos) {
                if (a.getCodigo() > maior) {
                    maior = a.getCodigo()+1;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(maior,aluno.getCodigo());
    }

    @Test
    void testToString() {
        Aluno aluno =  new Aluno("Teste","Teste","22000001");
        String expected = "Teste Teste 22000001";
        Assertions.assertEquals(expected,aluno.toString());
    }

    @Test
    void testEquals() {
        Aluno aluno =  new Aluno("Teste","Teste","22000001");
        Aluno aluno2 =  new Aluno("Teste","Teste","22000001");
        Assertions.assertTrue(aluno.equals(aluno2));
    }
}