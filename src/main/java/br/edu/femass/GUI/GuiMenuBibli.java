package br.edu.femass.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class GuiMenuBibli extends Frame {
    private JPanel jPanel;
    private JButton btnLivro;
    private JButton btnAutores;
    private JButton btnExemplar;
    private JButton listaDeEmprestimosAtrasadosButton;
    private JButton btnVoltar;

    public GuiMenuBibli() {
        btnLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLivro guiLivro = new GuiLivro();
                JFrame frame = new JFrame("Projeto");
                frame.setContentPane(guiLivro.jPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        btnAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIAutor guiAutor = new GUIAutor();
                JFrame frame = new JFrame("Projeto");
                frame.setContentPane(guiAutor.jPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        btnExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiExemplar guiExemplar = new GuiExemplar();
                JFrame frame = new JFrame("Projeto");
                frame.setContentPane(guiExemplar.jPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        listaDeEmprestimosAtrasadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAtrasado guiAtrasado = new GuiAtrasado();
                JFrame frame = new JFrame("Projeto");
                frame.setContentPane(guiAtrasado.jPanel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
