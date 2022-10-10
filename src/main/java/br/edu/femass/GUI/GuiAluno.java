package br.edu.femass.GUI;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAluno {
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JButton btnSalvar;
    private JPanel jPanel;

    public GuiAluno() {
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Aluno aluno = new Aluno(txtNome.getText(),txtEndereco.getText(),txtTelefone.getText());
                    aluno.atualizarID();
                    new DaoAluno().save(aluno);
                    JOptionPane.showMessageDialog(null, "Aluno salvo\n"+txtNome.getText()+" "
                            +txtTelefone.getText()+
                            "\n"
                            +txtEndereco.getText());

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        GuiAluno guiAluno = new GuiAluno();
        JFrame frame = new JFrame("Projeto");
        frame.setContentPane(guiAluno.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
