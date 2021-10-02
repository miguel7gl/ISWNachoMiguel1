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
    Registro JVentanaApp;

    public InicioSesion(JVentanaApp JVentana)
    {
        //fondo = Toolkit.getDefaultToolkit().getImage("./././src/TheGame.jpg");
        //fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);

        JbtnInicio.addActionListener(this);

        JbtnInicio.setBounds(290,210,225,30);
        nombre.setBounds(385,130,130,30);
        password.setBounds(385,170,130,30);
        LabelNombre.setBounds(307,130,130,30);
        LabelPassword.setBounds(296,170,130,30);
        JVentana.add(JbtnInicio);
        JVentana.add(nombre);
        JVentana.add(password);
        JVentana.add(LabelNombre);
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
        if (e.getSource() == JbtnInicio) {
            System.out.println("Botón Iniciar sesión pulsado");
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
