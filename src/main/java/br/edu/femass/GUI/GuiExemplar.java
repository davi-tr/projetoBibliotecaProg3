package br.edu.femass.GUI;

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
import java.util.ArrayList;
import java.util.List;

public class GuiExemplar {
    protected JPanel jPanel;
    private JList lstLivros;
    private JButton btnSalvar;
    private JSpinner spQuantidade;
    private JScrollPane scrollPane;
    private JTextField sobreNome;
    private JTextField nacionalidade;
    private JTextField nomeAutor;

    public GuiExemplar() {
        updateList();
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    spQuantidade.commitEdit();
                } catch ( java.text.ParseException l ) {
                    
                }
                int value = (Integer) spQuantidade.getValue();
                try{
                    Exemplar exemplar = new Exemplar(lstLivros.getSelectedValuesList(),value);
                    updateList();
                    new DaoExemplar().save(exemplar);
                    JOptionPane.showMessageDialog(null,"Exemplar Salvo");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        
    }
    private void updateList() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            lstLivros.setListData(livros.toArray());
            scrollPane.setViewportView(lstLivros);
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
