package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAutor {
    protected JPanel jPanel;
    private JTextField TxtNome;
    private JTextField TxtSobrenome;
    private JTextField TxtNacionalidade;
    private JButton Salvar;

    public GUIAutor() {
        Salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Autor autor = new Autor(TxtNome.getText(),TxtSobrenome.getText(),TxtNacionalidade.getText());
                    new DaoAutor().save(autor);
                    JOptionPane.showMessageDialog(null, "Autor salvo\n"+TxtNome.getText()+" "
                            +TxtSobrenome.getText()+
                            "\n "
                            +TxtNacionalidade.getText());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        GUIAutor guiAutor = new GUIAutor();
        JFrame frame = new JFrame("Projeto");
        frame.setContentPane(guiAutor.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
