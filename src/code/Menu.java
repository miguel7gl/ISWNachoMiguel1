package code;

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
    public Image fondo;


    Menu(JVentanaApp ventana)
    {
        super();
        //cargar foto del fondo
        this.ventana=ventana;



        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
        registro=new JButton("REGISTRARSE");
        login=new JButton("LOG IN ");
        registro.setBounds(290, 210, 150, 30);
        login.setBounds(290, 170, 150, 30);

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
