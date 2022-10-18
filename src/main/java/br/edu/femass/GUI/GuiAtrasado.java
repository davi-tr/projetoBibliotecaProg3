package br.edu.femass.GUI;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GuiAtrasado {
    protected Object teste = "teste";
    protected JPanel jPanel;
    private JComboBox cboAtrasados;

    public GuiAtrasado(){
        try {
            List<Emprestimos> emprestimosAtr = new DaoEmprestimo().getAll();
            for(Emprestimos em : emprestimosAtr){
                if(em.getDevolucao()==null){
                    cboAtrasados.addItem(em.toString());
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    }