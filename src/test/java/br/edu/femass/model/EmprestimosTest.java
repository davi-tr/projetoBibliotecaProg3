package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimosTest {

    @Test
    void calculartempo() {
        Emprestimos emprestimos = new Emprestimos();
        String dataInicio = "22/07/2022";
        String dataFim = "02/08/2022";
        String valor = emprestimos.calculartempo("22/07/2022","02/08/2022");
        String expected = "Esta atrasado em 30 dias";
        Assertions.assertEquals(expected,emprestimos.calculartempo("22/07/2022","02/08/2022"));
    }

    @Test
    void testToString() {
    }
}