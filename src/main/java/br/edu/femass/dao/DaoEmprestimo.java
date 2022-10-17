package br.edu.femass.dao;

import br.edu.femass.model.Emprestimos;
import br.edu.femass.model.Exemplar;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DaoEmprestimo extends Persistencia<Emprestimos> implements Dao<Emprestimos> {
    private final static String NOMEARQUIVO = "emprestimos.json";

    public void save (Emprestimos emprestimos) throws Exception{
        List<Emprestimos> emprestados = getAll();
        emprestados.add(emprestimos);
        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(emprestados);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public void updateDao(Emprestimos emprestimoatualizado) throws Exception{
        List<Emprestimos> emprestados = getAll();
        List<Emprestimos> emprestimosAtualizado = new ArrayList<>();

        for(Emprestimos emprestimo : emprestados){
            if(emprestimo.getCodigo() == emprestimoatualizado.getCodigo()) {
                emprestimo.setDevolucao(emprestimoatualizado.getDevolucao());
            }
                emprestimosAtualizado.add(emprestimo);

        }

        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(emprestimosAtualizado);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Emprestimos> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Emprestimos> emprestados = getObjectmapper().readValue(json, new TypeReference<List<Emprestimos>>(){});
            return emprestados;
        } catch (FileNotFoundException f){
            return new ArrayList();
        }
    }
}
