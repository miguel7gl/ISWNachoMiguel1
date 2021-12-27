package code;

import javax.swing.*;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import main.isw.domain.Plan;

public class DisplayPlans extends JPanel implements ActionListener, WindowListener,MouseListener// Este JPanel va a mostrar todos los planes
{

    Image fondo;
    JVentanaApp ventana;
    JButton volver;
    public static ArrayList<Plan> listaPlans; //lista que va a recoger todos los planes que se den en la base de datos
    public static JTable tablaPlanes; //tabla que va a representar todos los planes de la lista
    String [] nombresColumna={"Nombre","Creador","Fecha","Lugar","Hora","Capacidad","Privacidad","IdPlan","Descripcion","Unirse","Abandonar"};//cabecera de la tabla
    public static DefaultTableModel tablaPlanes_model;


    public DisplayPlans(JVentanaApp ventana)
    {
        super();
        this.ventana=ventana;
        ventana.setLayout(new BorderLayout());
        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);
        tablaPlanes_model=new DefaultTableModel(nombresColumna,0); //Establecemos el formato default de la tabla

        for (Plan plan : listaPlans){   //Establecemos los datos que tendrá la tabla
            tablaPlanes_model.addRow(new Object[]{plan.getNombre(),plan.getCreador(),plan.getFecha(),plan.getLugar(),plan.getHora(),plan.getCapacidad(),plan.getPrivacidad(),plan.getIdPlan(),plan.getDescripcion(),"Unirse","Abandonar"});
        }
        tablaPlanes=new JTable((tablaPlanes_model)){ //Creamos tabla
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int col) {
                if (col == 8|| col==9 ||col==10) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        tablaPlanes.getTableHeader().setReorderingAllowed(false); //Impedimos al usuario que sea capaz de cambiar las columnas de sitio
                                                                  //Pero podrá ajustar el ancho de las columnas simplemente con el ratón
        tablaPlanes.getColumnModel().getColumn(7).setPreferredWidth(50);
        tablaPlanes.getColumnModel().getColumn(8).setPreferredWidth(140);
        tablaPlanes.getColumnModel().getColumn(9).setPreferredWidth(100);
        tablaPlanes.getColumnModel().getColumn(10).setPreferredWidth(120);
        tablaPlanes.setEnabled(true);
        TableCellRenderer buttonRenderer = new RenderBotones(); //asignamos a la tabla los botones y su lógica en las columnas designadas de unirse,abandonar y descripcion


        tablaPlanes.getColumn("Descripcion").setCellRenderer(buttonRenderer);
        tablaPlanes.getColumn("Descripcion").setCellEditor(new ControlBotones(new JCheckBox()));
        tablaPlanes.getColumn("Unirse").setCellRenderer(buttonRenderer);
        tablaPlanes.getColumn("Unirse").setCellEditor(new ControlBotones(new JCheckBox()));
        tablaPlanes.getColumn("Abandonar").setCellRenderer(buttonRenderer);
        tablaPlanes.getColumn("Abandonar").setCellEditor(new ControlBotones(new JCheckBox()));

        JScrollPane scrollTabla = new JScrollPane(tablaPlanes);

        tablaPlanes.setOpaque(false);
        scrollTabla.setOpaque(false);

    //Añadimos botón de vuelta atrás al menu
        volver= new JButton("VolverMenú");
        volver.addActionListener(this);

        ventana.add(volver,BorderLayout.SOUTH);

        ventana.add(scrollTabla, BorderLayout.CENTER);
        ventana.add(tablaPlanes.getTableHeader(), BorderLayout.NORTH);

        ventana.setVisible(true);


    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo,0,0,this); //Fondo
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.volver) {
            ventana.setVisible(false);
            JVentanaApp ventanaMenu=new JVentanaApp();
            MenuPlanes menuPlan = new MenuPlanes(ventanaMenu);
            ventanaMenu.add(menuPlan);
            ventanaMenu.setVisible(true);

        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
    }


    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {

        JVentanaApp ventana= new JVentanaApp();
        DisplayPlans display= new DisplayPlans(ventana);
        ventana.add(display);
        ventana.setVisible(true);
    }


}


