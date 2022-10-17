package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanel;
    private JList lstExemplares;
    private JButton salvarButton;
    private JList lstAlunos;
    private JList lstProfessores;
    private JComboBox cboExemplares;
    private JComboBox cboSeletor;
    private JLabel txtTitulo;
    private JList lstExemplar;
    private JComboBox cboLeitores;
    private Object professor = "Professor";
    private Object aluno = "Aluno";
    List<Leitor> leitor = new ArrayList();

    public GuiEmprestimo() {
        updateList();
        valores();
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Emprestimos emprestimos = new Emprestimos(lstExemplar.getSelectedValuesList(),lstAlunos.getSelectedValuesList());
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
        cboSeletor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cboSeletor.getSelectedItem()== aluno){
                    try {
                        txtTitulo.setText("Aluno");
                        List<Aluno> alunos = new DaoAluno().getAll();
                        List<Professor> professores = new DaoProfessor().getAll();
                        lstAlunos.setListData(alunos.toArray());

                    } catch (Exception es) {
                        throw new RuntimeException(es);
                    }
                } else{
                    try {
                        txtTitulo.setText("Professor");
                        List<Aluno> alunos = new DaoAluno().getAll();
                        List<Professor> professores = new DaoProfessor().getAll();
                        lstAlunos.setListData(professores.toArray());

                    } catch (Exception es) {
                        throw new RuntimeException(es);
                    }
                }
            }
        });
    }

private void valores(){
        cboSeletor.addItem(aluno);
        cboSeletor.addItem(professor);
}
    private void updateList() {
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            List<Professor> professores = new DaoProfessor().getAll();
            lstAlunos.setListData(alunos.toArray());
            List<Exemplar> exemplar = new DaoExemplar().getAll();
            lstExemplar.setListData(exemplar.toArray());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanel() {
        return jPanel;
    }



}
