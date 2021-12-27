package code;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class RenderBotones extends JButton implements TableCellRenderer { //Esta clase procede a renderizar los botones en la tabla(Descripción ,Unirse y Abandonar)

    public RenderBotones() {
        setOpaque(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());

        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : table.getColumnName(column));// Esta linea indica que dependiendo de la columna en la que se muestre el botón se pondrá el nombre perteneciente al header
        return this;

    }
}