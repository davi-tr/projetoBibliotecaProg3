package br.edu.femass.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiInicial {
    private JComboBox cboUser;
    private JPasswordField passwordField1;
    private JButton btnLogin;
    private JPanel jPanel;
    Object Atendente = "Atendente";
    Object Bibliotecario = "Bibliotecario";

    public GuiInicial() {
        cboUser.addItem(Bibliotecario);
        cboUser.addItem(Atendente);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        GuiInicial guiInicial = new GuiInicial();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(guiInicial.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
