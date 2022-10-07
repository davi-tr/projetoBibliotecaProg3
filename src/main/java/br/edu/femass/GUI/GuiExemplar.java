package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiExemplar {
    private JPanel jPanel;
    private JList lstLivros;
    private JButton btnSalvar;

    public GuiExemplar() {
        updateList();
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Exemplar exemplar = new Exemplar(lstLivros.getSelectedValuesList());
                    updateList();
                    new DaoExemplar().save(exemplar);
                    JOptionPane.showMessageDialog(null,"Exemplar Salvo");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });

        lstLivros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {lstLivros.getSelectedValue();
            }
        });
        }
    private void updateList() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            lstLivros.setListData(livros.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        GuiExemplar guiExemplar = new GuiExemplar();
        JFrame frame = new JFrame("Projeto");
        frame.setContentPane(guiExemplar.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
