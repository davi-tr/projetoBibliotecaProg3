package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {

    private JPanel jPanel;
    private JTextField txtNome;
    private JList lstAutores;
    private JButton btnSalvar;
    public GuiLivro() {
        updateList();
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(txtNome.getText(), lstAutores.getSelectedValuesList());
                    updateList();
                    new DaoLivro().save(livro);
                    JOptionPane.showMessageDialog(null, "Livro Salvo\n" + txtNome.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        lstAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {lstAutores.getSelectedValue();
            }
        });
    }
    private void updateList() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            lstAutores.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
        public static void main(String[] args) {
            GuiLivro guiLivro = new GuiLivro();
            JFrame frame = new JFrame("Projeto");
            frame.setContentPane(guiLivro.jPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    }
