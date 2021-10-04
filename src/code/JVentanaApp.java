package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JVentanaApp extends JFrame implements WindowListener
{
    Registro Registro;
    InicioSesion InicioSesion;

    public JVentanaApp()
    {
        super("Planaria");

       /* //INICIO SESIÓN
        InicioSesion = new InicioSesion(this);
        this.add(InicioSesion, BorderLayout.CENTER);

        /*
        Registro = new Registro(this);
        this.add(Registro, BorderLayout.CENTER);
         */

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(new Dimension(800,500));
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addWindowListener(this);
        this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
        System.exit(0);
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
