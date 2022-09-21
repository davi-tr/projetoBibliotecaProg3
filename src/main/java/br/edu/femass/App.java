package br.edu.femass;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import java.util.List;

public class App {
    public static void main(String[] args) {
        lerAutor();

    }

    private static void lerAutor() {
        Dao<Autor> dao = new DaoAutor();

        try {
            List<Autor> autores2 = new DaoAutor().getAll();
            for (Autor autor: autores2){
                System.out.println(autor);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void gerarAutores() {
        Autor davi = new Autor("Davi","Trajano","Brazil");
        DaoAutor dao = new DaoAutor();
        try {
            dao.save(davi);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Autor luis = new Autor("Luis", "Teste","Australia");
        try {
            dao.save(luis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }

    }
