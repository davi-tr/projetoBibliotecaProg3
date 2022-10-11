package br.edu.femass.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GuiInicial {
    private JComboBox cboUser;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private JPanel jPanel;
    Object Atendente = "Atendente";
    Object Bibliotecario = "Bibliotecario";
    private Object usuario;

    public GuiInicial() {
        cboUser.addItem(Bibliotecario);
        cboUser.addItem(Atendente);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] input = txtSenha.getPassword();
                char[] senhaBibl = {'1','2','3','4','5','6'};
                char[] senhaAt = {'1','2','3','4'};
                Object Username = cboUser.getSelectedItem();
                if(Username.equals(Bibliotecario) && Arrays.equals(input,senhaBibl)){
                    JOptionPane.showMessageDialog(null,"Senha Correta");
                    System.exit(0);
                }else if (Username.equals(Atendente) && Arrays.equals(input,senhaAt)){
                    JOptionPane.showMessageDialog(null,"Senha Correta");
                    System.exit(0);
                }else{
                    JOptionPane.showMessageDialog(null,"Senha ou Usuario Incorreto");
                }
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
