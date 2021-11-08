package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

import main.isw.domain.Customer;
import main.isw.client.Client;
import main.isw.domain.Plan;

public class DisplayPlans extends JPanel implements ActionListener, WindowListener
{

    Image fondo;
    JVentanaApp ventana;
    public static ArrayList<Plan> listaPlans;


    public DisplayPlans(JVentanaApp ventana)
    {
        super();
        this.ventana=ventana;

        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo,0,0,this); //Fondo
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
