package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Emprestimos;
import br.edu.femass.model.Exemplar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanel;
    private JList lstExemplares;
    private JButton salvarButton;
    private JList lstLeitores;
    private JComboBox cboLeitores;

    public GuiEmprestimo() {
        updateList();
        updateCombo();
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateCombo();
                    updateList();
                    Emprestimos emprestimos = new Emprestimos();
                    try {
                        new DaoEmprestimo().save(emprestimos);
                    }catch (ParseException p){
                        throw new RuntimeException(p);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    private void updateCombo() {
        try {
            List<Aluno> aluno = new DaoAluno().getAll();
            lstLeitores.setListData(aluno.toArray());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    private void updateList() {
        try {
            List<Exemplar> exemplar = new DaoExemplar().getAll();
            lstExemplares.setListData(exemplar.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
        JFrame frame = new JFrame("Projeto");
        frame.setContentPane(guiEmprestimo.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
