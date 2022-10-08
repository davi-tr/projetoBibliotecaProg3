package br.edu.femass.GUI;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Emprestimos;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanel;
    private JList lstExemplares;
    private JButton salvarButton;

    public GuiEmprestimo() {
        updateList();
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateList();
                    Emprestimos emprestimos = new Emprestimos(lstExemplares.getSelectedValuesList());
                    new DaoEmprestimo().save(emprestimos);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
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
