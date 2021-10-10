package code;
import main.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class CrearPlan extends JPanel implements ActionListener,WindowListener {
    private JVentanaApp ventana;
    public JButton crear;
    public JTextField nombrePlan, fecha, hora, lugar, capacidad;
    public JTextArea descripcion;
    public JRadioButton publico, privado;
    public JLabel labelNombre, labelFecha, labelHora, labelLugar, labelCapacidad, labelDescripcion;
    public Image fondo;
    public ButtonGroup bg;
    JScrollPane scroll;

    String nombrePlanTxt;
    String fechaTxt;
    String horaTxt;
    String lugarTxt;
    String capacidadTxt;
    String descripcionTxt;
    String privacidadTxt;



    public static void main(String[] args) {

        JVentanaApp ventana1 = new JVentanaApp();
        CrearPlan crear1 = new CrearPlan(ventana1);
        ventana1.add(crear1);
        ventana1.setVisible(true);
    }

    public CrearPlan(JVentanaApp ventana)
    {
        super();
        this.ventana = ventana;

        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);

        crear = new JButton("CREAR");
        crear.addActionListener(this);

        nombrePlan = new JTextField();
        fecha = new JTextField("Año-Mes-Dia");
        hora = new JTextField("Hora:Min:Seg");
        capacidad = new JTextField();
        descripcion = new JTextArea(100,50);
        scroll = new JScrollPane(descripcion);
        lugar = new JTextField();
        privado = new JRadioButton("Privado");
        publico = new JRadioButton("Publico");
        //Botones de privacidad para que solo se rellene una casilla
        bg=new ButtonGroup();
        bg.add(privado);
        bg.add(publico);
        //labels
        labelNombre = new JLabel("Nombre:");
        labelFecha = new JLabel("Fecha:");
        labelHora = new JLabel("Hora:");
        labelLugar = new JLabel("Lugar:");
        labelCapacidad = new JLabel("NºIntegrantes:");
        labelDescripcion = new JLabel("Descripcion:");
        labelNombre.setForeground(Color.YELLOW);
        labelFecha.setForeground(Color.YELLOW);
        labelHora.setForeground(Color.YELLOW);
        labelLugar.setForeground(Color.YELLOW);
        labelCapacidad.setForeground(Color.YELLOW);
        labelDescripcion.setForeground(Color.YELLOW);


        crear.setBounds(550, 130, 100, 50);
        labelNombre.setBounds(290, 50, 130, 30);
        labelFecha.setBounds(290, 90, 130, 30);
        labelLugar.setBounds(290, 130, 130, 30);
        labelHora.setBounds(290, 170, 130, 30);
        labelCapacidad.setBounds(290, 210, 130, 30);
        labelDescripcion.setBounds(360, 290, 130, 30);
        ventana.add(crear);
        ventana.add(labelNombre);
        ventana.add(labelFecha);
        ventana.add(labelLugar);
        ventana.add(labelHora);
        ventana.add(labelCapacidad);
        ventana.add(labelDescripcion);
        //JRadioButtons
        publico.setBounds(300,250,80,30);
        privado.setBounds(420,250,80,30);
        publico.setOpaque(false);
        privado.setOpaque(false);
        privado.setForeground(Color.YELLOW);
        publico.setForeground(Color.YELLOW);

        //Para detectar lo que se ha seleccionado
        publico.setActionCommand("publico");
        privado.setActionCommand("privado");

        ventana.add(publico);
        ventana.add(privado);
        //JTextfields
        nombrePlan.setBounds(385, 50, 130, 30);
        fecha.setBounds(385, 90, 130, 30);
        lugar.setBounds(385, 130, 130, 30);
        hora.setBounds(385, 170, 130, 30);
        capacidad.setBounds(385, 210, 130, 30);
        scroll.setBounds(215, 340, 375, 100);


        ventana.add(nombrePlan);
        ventana.add(fecha);
        ventana.add(lugar);
        ventana.add(hora);
        ventana.add(capacidad);
        ventana.add(labelDescripcion);
        ventana.add(scroll);

        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Pintar fondo

        g.drawImage(fondo, 0, 0, this);
        setOpaque(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.crear) {
            System.out.println("Boton crear pulsado");
            JOptionPane.showMessageDialog(null,"Plan creado");

            //f(privado)

            nombrePlanTxt = nombrePlan.getText();
            fechaTxt = fecha.getText();
            lugarTxt = lugar.getText();
            horaTxt = hora.getText();
            capacidadTxt = capacidad.getText();
            privacidadTxt = bg.getSelection().getActionCommand();
            descripcionTxt = descripcion.getText();
            System.out.println(nombrePlanTxt+"\n"+fechaTxt+"\n"+lugarTxt+"\n"+horaTxt+"\n"+capacidadTxt+"\n"+privacidadTxt+"\n"+descripcionTxt);

            //Parte para actualizar la tabla con un nuevo usuario
            //Creacion de un hasmap para almacenar los datos y se envian al cliente
            HashMap<String,Object> session =new HashMap<String, Object>();
            session.put("nombre", (Object)nombrePlanTxt);
            session.put("fecha",(Object)fechaTxt);
            session.put("lugar",(Object)lugarTxt);
            session.put("hora",(Object)horaTxt);
            session.put("capacidad",(Object)capacidadTxt);
            session.put("privacidad",(Object)privacidadTxt);
            session.put("descripcion",(Object)descripcionTxt);

            Client.enviarPeticion("/setPlan",session);
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
}



