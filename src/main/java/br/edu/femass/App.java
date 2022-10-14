package br.edu.femass;

import br.edu.femass.GUI.GuiInicial;
import br.edu.femass.GUI.GuiMenuBibli;
import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import java.util.List;

public class App {
    public static void main(String[] args) {

        GuiInicial guiInicial = new GuiInicial();
        JFrame frame = new JFrame("Sistema Bibliotecario");
        frame.setContentPane(guiInicial.getjPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        if(guiInicial.getDispo() == true){
            GuiMenuBibli guiMenuBibli = new GuiMenuBibli();
            JFrame framebibi = new JFrame("Menu Bibliotecario");
            frame.setContentPane(guiMenuBibli.getjPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

    }
}

