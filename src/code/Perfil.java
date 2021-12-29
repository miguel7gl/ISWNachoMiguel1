package code;
import ui.JVentanaApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Perfil extends JPanel implements ActionListener, WindowListener,MouseListener {
    Image fondo;
    JVentanaApp ventana;
    JButton modificar;
    JButton volver;
    JLabel correoL;
    JLabel nombreL;
    JLabel passwordL;

    public Perfil(JVentanaApp ventana)
    {
        super();
        this.ventana=ventana;

        //Obtenemos los datos del cliente


        correoL=new JLabel("Correo: "+InicioSesion.correo);
        nombreL=new JLabel("Nombre: "+InicioSesion.nombreTxt);
        passwordL=new JLabel("Password: "+InicioSesion.password);

        passwordL.setBackground(Color.WHITE);
        correoL.setBackground(Color.WHITE);
        nombreL.setBackground(Color.WHITE);

        passwordL.setOpaque(true);
        correoL.setOpaque(true);
        nombreL.setOpaque(true);

        modificar=new JButton("modificar perfil");
        volver= new JButton("VolverMenú");

        fondo = Toolkit.getDefaultToolkit().getImage("./resources/crearplanes.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);

        modificar.setBounds(330, 350, 150, 30);
        volver.setBounds(0, 433, 800, 30);
        correoL.setBounds(305,200,200,30);
        nombreL.setBounds(305,150,200,30);
        passwordL.setBounds(305,250,200,30);


        modificar.addActionListener(this);
        volver.addActionListener(this);

        ventana.add(correoL);
        ventana.add(nombreL);
        ventana.add(passwordL);
        ventana.add(modificar);
        ventana.add(volver);


        this.setVisible(true);
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

        }else if (e.getSource()== this.modificar){
            ventana.setVisible(false);
            JVentanaApp ventanaMod=new JVentanaApp();
            ModificarPerfil modificarPerfil=new ModificarPerfil(ventanaMod);
            ventanaMod.add(modificarPerfil);
            ventanaMod.setVisible(true);
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
        Perfil perfil= new Perfil(ventana);
        ventana.add(perfil);
        ventana.setVisible(true);
    }
}
