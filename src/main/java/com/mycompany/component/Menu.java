package com.mycompany.component;

import com.mycompany.event.EventMenu;
import com.mycompany.swing.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    private EventMenu event;

    public Menu() {
        initComponents();
        setOpaque(false);
        setLayout(new MigLayout("wrap 2, inset 30", "[fill, 100]10[fill, 100]", "[]10[]"));
    }

    public void initMenu(EventMenu event) {
        this.event = event;
        addMenu(createImageIcon("/image/1.png"), "Dashboard", 0);
        addMenu(createImageIcon("/image/2.png"), "Pacientes", 1);
        addMenu(createImageIcon("/image/3.png"), "Treinos", 2);
        addMenu(createImageIcon("/image/4.png"), "Consultas", 3);
        addMenu(createImageIcon("/image/5.png"), "Relatórios", 4);
        addMenu(createImageIcon("/image/6.png"), "Configurações", 5);
    }

    private void addMenu(Icon icon, String name, int index) {
        Button menu = new Button();
        menu.setHorizontalTextPosition(SwingConstants.CENTER);
        menu.setVerticalTextPosition(SwingConstants.BOTTOM);
        menu.setText(name);
        menu.setIcon(icon);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(index);
            }
        });
        add(menu);
    }

    private ImageIcon createImageIcon(String path) {
        URL resource = getClass().getResource(path);
        if (resource != null) {
            return new ImageIcon(resource);
        } else {
            System.err.println("Recurso não encontrado: " + path);
            return null; 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
