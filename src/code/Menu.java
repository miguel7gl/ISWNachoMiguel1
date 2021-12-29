package code;

import ui.JVentanaApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;


public class Menu extends JPanel  implements ActionListener{
    //fondo
    private JVentanaApp ventana ;
    //private Image fondo;
    public JButton registro;
    public JButton login;
    public JButton perfil;
    public Image fondo;


    Menu(JVentanaApp ventana)
    {
        super();
        //cargar foto del fondo
        this.ventana=ventana;



        fondo = Toolkit.getDefaultToolkit().getImage("./resources/plantastic.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
        //botones
        registro=new JButton("REGISTRARSE");
        login=new JButton("LOG IN ");

        //posición y tamaño
        registro.setBounds(315, 300, 150, 30);
        login.setBounds(315, 250, 150, 30);


        registro.setBackground(new Color(228, 255, 222));
        login.setBackground(new Color(228, 255, 222));


        registro.addActionListener(this);
        login.addActionListener(this);


        ventana.add(login);
        ventana.add(registro);


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
        if (e.getSource() == this.login) {
            ventana.setVisible(false);
            JVentanaApp ventanaLog=new JVentanaApp();
            InicioSesion inicioSesion = new InicioSesion(ventanaLog);
            ventanaLog.add(inicioSesion);
            ventanaLog.setVisible(true);

        }
        else if (e.getSource() == this.registro) {
            ventana.setVisible(false);
            JVentanaApp ventanaReg=new JVentanaApp();
            Registro registro = new Registro(ventanaReg);
            ventanaReg.add(registro);
            ventanaReg.setVisible(true);
        }
    }
}
