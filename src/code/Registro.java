package code;

import main.isw.configuration.PropertiesISW;
import main.isw.dao.CustomerDAO;
import main.isw.controler.CustomerControler;
import main.isw.domain.Customer;
import main.isw.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.HashMap;

public class Registro extends JPanel implements ActionListener, WindowListener {
    JButton JbtnRegistrarse = new JButton("REGISTRARSE");
    JTextField nombre = new JTextField("", 4);
    JTextField apellido1 = new JTextField("", 4);
    JTextField password = new JTextField("", 4);
    JLabel LabelNombre = new JLabel("Nombre:");
    JLabel LabelApellido1 = new JLabel("Primer apellido:");
    JLabel LabelPassword = new JLabel("Contraseña:");

    String nombreTxt;
    String apellido1Txt;
    String passwordTxt;

    Customer usuario;
    Image fondo;

    public JVentanaApp ventana;

    public Registro(JVentanaApp ventana) {
        this.ventana=ventana;
        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);

        JbtnRegistrarse.addActionListener(this);

        JbtnRegistrarse.setBounds(290, 230, 225, 30);
        nombre.setBounds(385, 110, 130, 30);
        apellido1.setBounds(385, 150, 130, 30);
        password.setBounds(385, 190, 130, 30);
        LabelNombre.setBounds(307, 110, 130, 30);
        LabelApellido1.setBounds(290, 150, 130, 30);
        LabelPassword.setBounds(296, 190, 130, 30);
        ventana.add(JbtnRegistrarse);
        ventana.add(nombre);
        ventana.add(apellido1);
        ventana.add(password);
        ventana.add(LabelNombre);
        ventana.add(LabelApellido1);
        ventana.add(LabelPassword);
    }
    public Registro(){

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo, 0, 0, this); //Fondo
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JbtnRegistrarse) {
            System.out.println("Botón Registrarse pulsado");
            nombreTxt = nombre.getText();
            apellido1Txt = apellido1.getText();
            passwordTxt = password.getText();

           // usuario= new Customer(nombreTxt,apellido1Txt,passwordTxt);

            //Parte para actualizar la tabla con un nuevo usuario
            //Creacion de un hasmap para almacenar los datos y se envian al cliente
            HashMap<String,Object> session =new HashMap<String, Object>();
            session.put("Nombre", (Object)nombreTxt);
            session.put("Apellido",(Object)apellido1Txt);
            session.put("Password",(Object)passwordTxt);
            Client.enviarPeticion("/setCustomer",session);



            System.out.println("Registro - Nombre: "+nombreTxt + " " + apellido1Txt + " " + passwordTxt);
            ventana.setVisible(false);
            JVentanaApp ventanaLog = new JVentanaApp();
            InicioSesion inicioSesion = new InicioSesion(ventanaLog);
            ventanaLog.add(inicioSesion);
            ventanaLog.setVisible(true);
        }
    }
    public Customer getUsuario(){
        return this.usuario;
    }
    public String getNombre(){
        return this.nombreTxt;
    }
    public String getApellido(){
        return this.apellido1Txt;
    }
    public String getPassword(){
        return this.passwordTxt;
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
