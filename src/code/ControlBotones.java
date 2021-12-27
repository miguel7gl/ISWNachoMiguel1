package code;

import main.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class ControlBotones extends DefaultCellEditor { //Esta clase se encarga de llevar la lógica de los botones asociados a la tabla de DisplayPlans

    protected JButton boton;
    private String label;
    private boolean isPushed;


    public ControlBotones(JCheckBox checkBox) {
        super(checkBox);
        boton = new JButton();
        boton.setOpaque(true);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (isSelected) {
            boton.setForeground(table.getSelectionForeground());
            boton.setBackground(table.getSelectionBackground());

        } else {
            boton.setForeground(table.getForeground());
            boton.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        boton.setText(label);
        isPushed = true;
        return boton;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            int fila = DisplayPlans.tablaPlanes.getSelectedRow(); //Obtenemos el valor de la fila que se ha seleccionado para poder identificar que plan se ha seleccionado
            int columna = DisplayPlans.tablaPlanes.getSelectedColumn();


            if (columna == 8) { //Columna descripción
                JOptionPane.showMessageDialog(boton, DisplayPlans.tablaPlanes.getValueAt(fila, columna).toString());
            } else if (columna == 9) {//Columna unirse
                JOptionPane.showMessageDialog(boton, label + "Pulsado sobre el plan situado en la fila: " + fila);
                System.out.println("Usuario:"+InicioSesion.nombreTxt);
                Integer idPlan=Integer.parseInt(DisplayPlans.tablaPlanes.getValueAt(fila,7).toString()); //valor idPlan
                //Enviamos petición de actualización de la tabla participantes
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("idPlan", (Object) idPlan );
                session.put("usuario", (Object) InicioSesion.nombreTxt);
                Client.enviarPeticion("/updateParticipantes", session);

            } else if (columna == 10) {//Columna abandonar
                JOptionPane.showMessageDialog(boton, label + "Pulsado sobre el plan situado en la fila: " + fila);
                Integer idPlan=Integer.parseInt(DisplayPlans.tablaPlanes.getValueAt(fila,7).toString()); //valor idPlan
                //Enviamos petición de actualización de la tabla participantes
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("idPlan", (Object) idPlan );
                session.put("usuario", (Object) InicioSesion.nombreTxt);
                Client.enviarPeticion("/borrarParticipantes", session);
            }
        }
            isPushed = false;
            return label;
        }


    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
