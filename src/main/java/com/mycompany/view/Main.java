package com.mycompany.view;

import com.mycompany.component.Menu;
import com.mycompany.component.SubForm;
import com.mycompany.event.EventMenu;
import java.awt.Color;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        getContentPane().setBackground(new Color(236, 236, 236));
        MainProgram.getInstance().setSlideShow(slideshow);
        EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                slideshow.slideTo(index + 1);
            }
        };
        Menu menu = new Menu();
        menu.initMenu(event);
        slideshow.initSlideshow(menu, new SubForm("Dashboard"), new SubForm("Gerenciamento Pacientes"), new SubForm("Treinos"), new SubForm("Consultas"), new SubForm("Relatórios"),new SubForm("Configurações"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox1 = new com.mycompany.swing.PictureBox();
        slideshow = new com.mycompany.swing.slideshow.Slideshow();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pictureBox1.setImage(new javax.swing.ImageIcon("C:\\Users\\Lucas\\OneDrive\\Documentos\\NetBeansProjects\\Macros\\src\\main\\resources\\image\\background.jpg")); // NOI18N

        pictureBox1.setLayer(slideshow, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pictureBox1Layout = new javax.swing.GroupLayout(pictureBox1);
        pictureBox1.setLayout(pictureBox1Layout);
        pictureBox1Layout.setHorizontalGroup(
            pictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pictureBox1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(slideshow, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pictureBox1Layout.setVerticalGroup(
            pictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pictureBox1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(slideshow, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.swing.PictureBox pictureBox1;
    private com.mycompany.swing.slideshow.Slideshow slideshow;
    // End of variables declaration//GEN-END:variables
}
