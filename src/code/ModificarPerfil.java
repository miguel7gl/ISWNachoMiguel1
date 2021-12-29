package code;

import main.isw.client.Client;
import ui.JVentanaApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class ModificarPerfil extends JPanel implements ActionListener, WindowListener {

    private JVentanaApp ventana;
    public JButton volver;
    public JButton guardar;
    public JTextField nuevaPassword, nuevoCorreo;
    public JLabel labelCorreo, labelPassword;
    public Image fondo;

    String nCorreo;
    String nPassword;

    public static void main(String[] args) {

        JVentanaApp ventana1 = new JVentanaApp();
        ModificarPerfil modificar = new ModificarPerfil(ventana1);
        ventana1.add(modificar);
        ventana1.setVisible(true);
    }

    public ModificarPerfil(JVentanaApp ventana)
    {
        super();
        this.ventana = ventana;

        fondo = Toolkit.getDefaultToolkit().getImage("./resources/crearplanes.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);

        volver = new JButton("Volver");
        volver.addActionListener(this);
        guardar = new JButton("Guardar cambios");
        guardar.addActionListener(this);

        nuevoCorreo = new JTextField();
        nuevaPassword = new JTextField();

        //labels
        labelCorreo = new JLabel("Nuevo correo:");
        labelPassword = new JLabel("Nueva contraseña:");

        volver.setBounds(225, 375, 150, 50);
        volver.setBackground(new Color(250, 252, 250));

        guardar.setBounds(425, 375, 150, 50);
        guardar.setBackground(new Color(250, 252, 250));

        labelCorreo.setBounds(240, 200, 130, 30);
        labelPassword.setBounds(230, 250, 130, 30);

        ventana.add(volver);
        ventana.add(guardar);
        ventana.add(labelCorreo);
        ventana.add(labelPassword);

        //JTextfields
        nuevoCorreo.setBounds(375, 200, 200, 30);
        nuevaPassword.setBounds(375, 250, 200, 30);

        ventana.add(nuevoCorreo);
        ventana.add(nuevaPassword);

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
        try {
            if (e.getSource() == this.guardar) {
                System.out.println("Boton crear pulsado");
                nCorreo = nuevoCorreo.getText();
                nPassword = nuevaPassword.getText();

                JOptionPane.showMessageDialog(null, "Datos modificados");
                System.out.println(InicioSesion.nombreTxt + "\n" + nCorreo + "\n" + nPassword);

                //Parte para actualizar la tabla con un nuevo usuario
                //Creacion de un hasmap para almacenar los datos y se envian al cliente
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("usuario", (Object) InicioSesion.nombreTxt);
                session.put("correo", (Object) nCorreo);
                session.put("password", (Object) nPassword);

                Client.enviarPeticion("/updateCliente", session);
                ventana.setVisible(false);
                JVentanaApp ventanaPlan = new JVentanaApp();
                MenuPlanes inicioMenu = new MenuPlanes(ventanaPlan);
                ventanaPlan.add(inicioMenu);
                ventanaPlan.setVisible(true);
            }
            else if (e.getSource() == this.volver) {
                ventana.setVisible(false);
                JVentanaApp ventanaPlan = new JVentanaApp();
                MenuPlanes inicioMenu = new MenuPlanes(ventanaPlan);
                ventanaPlan.add(inicioMenu);
                ventanaPlan.setVisible(true);
            }
        }catch(NullPointerException exception)
        {
            System.out.print("NullPointerException caught");
            JOptionPane.showMessageDialog(null, "Faltan parámetros por modificar en el perfil");
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