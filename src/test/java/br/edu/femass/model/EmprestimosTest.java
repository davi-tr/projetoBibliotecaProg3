package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoExemplar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimosTest {

    @Test
    void calculartempo() {
        Emprestimos emprestimos = new Emprestimos();
        String dataInicio = "22-07-2022";
        String dataFim = "21-08-2022";
        emprestimos.calculartempo(dataInicio, dataFim);
        String expected = "Atrasado em 15 Dias";
        Assertions.assertEquals(expected, emprestimos.getMensagem());
    }

}