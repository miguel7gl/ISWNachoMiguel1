package code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Graphics;
import java.awt.Toolkit;

public class InicioSesion extends JPanel implements ActionListener, WindowListener
{
    JButton JbtnInicio = new JButton("INICIAR SESION");
    JTextField nombre = new JTextField("",4);
    JTextField password = new JTextField("",4);
    JLabel LabelNombre = new JLabel("Nombre:");
    JLabel LabelPassword = new JLabel("Contraseña:");

    Image fondo;
    JVentanaApp ventana;

    public InicioSesion(JVentanaApp ventana)
    {
        super();
        this.ventana=ventana;

        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);

        JbtnInicio.addActionListener(this);

        JbtnInicio.setBounds(290,210,225,30);
        nombre.setBounds(385,130,130,30);
        password.setBounds(385,170,130,30);
        LabelNombre.setBounds(307,130,130,30);
        LabelPassword.setBounds(296,170,130,30);
        ventana.add(JbtnInicio);
        ventana.add(nombre);
        ventana.add(password);
        ventana.add(LabelNombre);
        ventana.add(LabelPassword);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo,0,0,this); //Fondo
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JbtnInicio) {
            System.out.println("Botón Iniciar sesión pulsado");
            ventana.setVisible(false);
            JVentanaApp ventanaPlan = new JVentanaApp();
            MenuPlanes inicioMenu = new MenuPlanes(ventanaPlan);
            ventanaPlan.add(inicioMenu);
            ventanaPlan.setVisible(true);
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
