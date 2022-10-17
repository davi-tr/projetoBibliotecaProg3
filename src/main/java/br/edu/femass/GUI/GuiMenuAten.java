package br.edu.femass.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenuAten {
    private JPanel jPanel;
    private JButton realizarEmprestimoButton;
    private JButton devolverEmprestimoButton;
    private JButton voltarButton;

    public GuiMenuAten() {
        devolverEmprestimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDevolver guiDevolver = new GuiDevolver();
                JFrame frame = new JFrame("Menu Bibliotecario");
                frame.setContentPane(guiDevolver.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        realizarEmprestimoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
                JFrame frame = new JFrame("Realizar Emprestimo");
                frame.setContentPane(guiEmprestimo.getjPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }

    public Container getjPanel() {
        return jPanel;
    }
}
