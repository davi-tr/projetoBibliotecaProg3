package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProfessor {
    private JPanel jPanel;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtTelefone;
    private JTextField txtDisciplina;
    private JButton BtnSalvar;
    private JTextField txtEndereco;


    public GuiProfessor() {
        BtnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Professor professor = new Professor(txtNome.getText(),txtEndereco.getText(),txtTelefone.getText(),txtDisciplina.getText());
                    new DaoProfessor().save(professor);
                    JOptionPane.showMessageDialog(null, "Professor salvo\n"+txtNome.getText()+" "+
                            " "+txtSobrenome.getText()+" "
                            +txtTelefone.getText()+
                            "\n"
                            +txtDisciplina.getText());

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
    public static void main(String[] args) {
        GuiProfessor guiProfessor = new GuiProfessor();
        JFrame frame = new JFrame("Projeto");
        frame.setContentPane(guiProfessor.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
