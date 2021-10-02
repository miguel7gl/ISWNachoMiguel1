import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Graphics;
import java.awt.Toolkit;

public class InicioRegistro extends JPanel implements ActionListener, WindowListener
{
    JButton JbtnInicio = new JButton("INICIAR SESION");
    JButton JbtnRegistrarse = new JButton("REGISTRARSE");

    Image fondo;
    Registro JVentanaApp;

    public InicioRegistro(JVentanaApp JVentana)
    {
        fondo = Toolkit.getDefaultToolkit().getImage("./././src/TheGame.jpg");
        fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);

        JbtnInicio.addActionListener(this);

        JbtnInicio.setBounds(290,210,225,30);
        JbtnRegistrarse.setBounds(290,170,225,30);
        JVentana.add(JbtnInicio);
        JVentana.add(JbtnRegistrarse);
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

