package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void atualizarID() {
        Professor professor =  new Professor("Teste","Teste","22000001","Banco de dados");
        professor.atualizarID();
        Long maior = 0L;
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            for (Professor a : professores) {
                if (a.getCodigo() > maior) {
                    maior = a.getCodigo()+1;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(maior,professor.getCodigo());
    }
    @Test
    void testToString() {
        Professor professor =  new Professor("Teste","Teste","22000001","Banco de dados");
        String expected = "Teste Teste 22000001 Banco de dados";
        Assertions.assertEquals(expected,professor.toString());
    }

    @Test
    void testEquals() {
        Professor professor =  new Professor("Teste","Teste","22000001","Banco de dados");
        Professor professor2 =  new Professor("Teste","Teste","22000001","Banco de dados");
        Assertions.assertTrue(professor.equals(professor2));
    }
}