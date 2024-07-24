package com.mycompany.resources;

import java.awt.Component;
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
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centralizar horizontalmente

        if (value != null) {
            String photoURL = value.toString();
            ImageIcon imageIcon = imageCache.getImage(photoURL);

            if (imageIcon != null) {
                label.setIcon(imageIcon);
            } else {
                label.setIcon(null); // Limpar ícone enquanto a imagem é carregada
                imageCache.loadImage(photoURL, label);
            }
        } else {
            label.setText("Imagem inválida");
            label.setIcon(null);
        }

        return label;
    }
}
