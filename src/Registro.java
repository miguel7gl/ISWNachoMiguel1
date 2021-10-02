import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Graphics;
import java.awt.Toolkit;

public class Registro extends JPanel implements ActionListener, WindowListener
{
    JButton JbtnRegistrarse = new JButton("REGISTRARSE");
    JTextField nombre = new JTextField("",4);
    JTextField apellido1 = new JTextField("",4);
    JTextField password = new JTextField("",4);
    JLabel LabelNombre = new JLabel("Nombre:");
    JLabel LabelApellido1 = new JLabel("Primer apellido:");
    JLabel LabelPassword = new JLabel("Contraseña:");

    Image fondo;
    Registro JVentanaApp;

    public Registro(JVentanaApp JVentana)
    {
        fondo = Toolkit.getDefaultToolkit().getImage("./././src/TheGame.jpg");
        fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);

        JbtnRegistrarse.addActionListener(this);

        JbtnRegistrarse.setBounds(290,230,225,30);
        nombre.setBounds(385,110,130,30);
        apellido1.setBounds(385,150,130,30);
        password.setBounds(385,190,130,30);
        LabelNombre.setBounds(307,110,130,30);
        LabelApellido1.setBounds(290,150,130,30);
        LabelPassword.setBounds(296,190,130,30);
        JVentana.add(JbtnRegistrarse);
        JVentana.add(nombre);
        JVentana.add(apellido1);
        JVentana.add(password);
        JVentana.add(LabelNombre);
        JVentana.add(LabelApellido1);
        JVentana.add(LabelPassword);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo,0,0,this); //Fondo
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JbtnRegistrarse) {
            System.out.println("Botón Registrarse pulsado");
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
