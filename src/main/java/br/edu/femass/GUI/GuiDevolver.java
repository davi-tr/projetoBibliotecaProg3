package br.edu.femass.GUI;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class GuiDevolver {
    private JPanel jPanel;
    private JComboBox cboEmprestimos;
    private JTextField txtData;
    private JButton btnDevolver;

    public GuiDevolver() {
        updateCombo();
        cboEmprestimos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    private void updateCombo(){
        try {
            List<Emprestimos> emprestimos = new DaoEmprestimo().getAll();
            for (Emprestimos emprestimo : emprestimos) {
                cboEmprestimos.addItem(emprestimo.toString());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        GuiDevolver guiDevolver = new GuiDevolver();
        JFrame frame = new JFrame("Menu Bibliotecario");
        frame.setContentPane(guiDevolver.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
