package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AutorTest {

    @Test
    void getNome() {
        Autor autor = new Autor("Davi","Trajano","Brazil");
        String esperado = "Davi";
        Assertions.assertEquals(esperado, autor.getNome());
    }

    @Test
    void setNome() {
        Autor autor = new Autor("Davi","Trajano","Brazil");
        String esperado = "Luis";
        autor.setNome("Luis");
        Assertions.assertEquals(esperado, autor.getNome());
    }

    @Test
    void getSobreNome() {
        Autor autor = new Autor("Davi","Trajano","Brazil");
        String esperado = "Trajano";
        Assertions.assertEquals(esperado, autor.getSobrenome());
    }

    @Test
    void setSobreNome() {
        Autor autor = new Autor("Davi","Trajano","Brazil");
        String esperado = "França";
        autor.setSobreNome("França");
        Assertions.assertEquals(esperado, autor.getSobrenome());
    }

    @Test
    void getNacionalidade() {
        Autor autor = new Autor("Davi","Trajano","Brazil");
        String esperado = "Brazil";
        Assertions.assertEquals(esperado, autor.getNacionalidade());
    }

    @Test
    void setNacionalidade() {
        Autor autor = new Autor("Davi","Trajano","Brazil");
        String esperado = "China";
        autor.setNacionalidade("China");
        Assertions.assertEquals(esperado, autor.getNacionalidade());
    }

    @Test
    void testEquals() {
        Autor Davi = new Autor("Davi","Trajano","Brazil");
        Autor Davi2 = new Autor("Davi","Trajano","Brazil");
        Assertions.assertTrue(Davi.equals(Davi2));
    }
}