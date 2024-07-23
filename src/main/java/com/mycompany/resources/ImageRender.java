package com.mycompany.resources;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRender extends DefaultTableCellRenderer {

    private final ImageCache imageCache = new ImageCache();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String photoURL = value.toString();
        ImageIcon imageIcon = imageCache.getImage(photoURL);

        if (imageIcon != null) {
            Image image = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING);
            return new JLabel(new ImageIcon(image));
        } else {
            return new JLabel(" Imagem inválida");
        }
    }
}
