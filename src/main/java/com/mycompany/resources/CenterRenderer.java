package com.mycompany.resources;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class CenterRenderer extends DefaultTableCellRenderer {

    public CenterRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setHorizontalAlignment(JLabel.CENTER);
        return c;
    }
}
