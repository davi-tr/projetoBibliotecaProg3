package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanel;
    private JList lstExemplares;
    private JButton salvarButton;
    private JList lstAlunos;
    private JList lstProfessores;
    private JComboBox cboLeitores;
    List<Leitor> leitor = new ArrayList();

    public GuiEmprestimo() {
        updateList();
        updateCombo();
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Emprestimos emprestimos = new Emprestimos(lstProfessores.getSelectedValuesList());
                    updateCombo();
                    updateList();
                    try {
                        new DaoEmprestimo().save(emprestimos);
                    }catch (ParseException p){
                        throw new RuntimeException(p);
                    }
                }catch (Exception ex){
                    //JOptionPane.showMessageDialog(null,ex.getMessage());
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
    

    private void updateCombo() {
        try {
            List<Aluno> aluno = new DaoAluno().getAll();
            lstAlunos.setListData(aluno.toArray());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    private void updateList() {
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            List<Professor> professores = new DaoProfessor().getAll();
            lstAlunos.setListData(alunos.toArray());
            lstProfessores.setListData(professores.toArray());
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            lstExemplares.setListData(exemplares.toArray());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanel() {
        return jPanel;
    }



}
