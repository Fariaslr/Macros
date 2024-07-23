package com.mycompany.resources;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import java.util.concurrent.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRender extends DefaultTableCellRenderer {

    private final ImageCache imageCache = new ImageCache();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setText(""); // Remover texto padrão
        label.setHorizontalAlignment(SwingConstants.CENTER);

        if (value != null) {
            String photoURL = value.toString();
            ImageIcon imageIcon = imageCache.getImage(photoURL);

            if (imageIcon != null) {
                label.setIcon(imageIcon);
            } else {
                label.setText("Imagem inválida");
                label.setIcon(null);
            }
        } else {
            label.setText("Imagem inválida");
            label.setIcon(null);
        }

        return label;
    }

}
