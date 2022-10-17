package br.edu.femass.GUI;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimos;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GuiDevolver {
    private JPanel jPanel;
    private JComboBox cboEmprestimos;
    private JTextField txtData;
    private JButton btnDevolver;
    private JList lstEmprestimos;

    public GuiDevolver() {
        updateList();
        try{
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.install((JFormattedTextField) txtData);
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Emprestimos emprestimos = new Emprestimos(lstEmprestimos.getSelectedValuesList(),txtData.getText());
                    try {
                        new DaoEmprestimo().updateDao(emprestimos);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } catch (Exception exls){
                    throw new RuntimeException(exls);
                }
            }
        });
    }
    private void updateList(){
        try{
            List<Emprestimos> emprestimos = new DaoEmprestimo().getAll();
            lstEmprestimos.setListData(emprestimos.toArray());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
