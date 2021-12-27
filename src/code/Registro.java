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
    JTextField correo = new JTextField("", 4);
    JTextField password = new JTextField("", 4);
    JLabel LabelNombre = new JLabel("Nombre:");
    JLabel LabelCorreo = new JLabel("Correo:");
    JLabel LabelPassword = new JLabel("Contraseña:");

    String nombreTxt;
    String correoTxt;
    String passwordTxt;

    Customer usuario;
    Image fondo;

    public JVentanaApp ventana;
    public static Boolean salida;

    public Registro(JVentanaApp ventana) {
        this.ventana=ventana;
        fondo = Toolkit.getDefaultToolkit().getImage("./iniciosesion.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);

        JbtnRegistrarse.addActionListener(this);

        JbtnRegistrarse.setBounds(290, 350, 225, 30);
        JbtnRegistrarse.setBackground(new Color(250, 252, 250));

        nombre.setBounds(385, 230, 130, 30);
        correo.setBounds(385, 270, 130, 30);
        password.setBounds(385, 310, 130, 30);
        LabelNombre.setBounds(307, 230, 130, 30);
        LabelCorreo.setBounds(307, 270, 130, 30);
        LabelPassword.setBounds(296, 310, 130, 30);

        ventana.add(JbtnRegistrarse);
        ventana.add(nombre);
        ventana.add(correo);
        ventana.add(password);
        ventana.add(LabelNombre);
        ventana.add(LabelCorreo);
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
            correoTxt = correo.getText();
            passwordTxt = password.getText();

           // usuario= new Customer(nombreTxt,correoTxt,passwordTxt);

            //Parte para actualizar la tabla con un nuevo usuario
            //Creacion de un hasmap para almacenar los datos y se envian al cliente
            HashMap<String,Object> session =new HashMap<String, Object>();
            session.put("Nombre", (Object)nombreTxt);
            session.put("Correo",(Object)correoTxt);
            session.put("Password",(Object)passwordTxt);
            Client.enviarPeticion("/setCustomer",session);
            if (salida.equals(true))
            {
                System.out.println("Correcto");
                ventana.setVisible(false);
                JVentanaApp ventanaLog = new JVentanaApp();
                InicioSesion inicioSesion = new InicioSesion(ventanaLog);
                ventanaLog.add(inicioSesion);
                ventanaLog.setVisible(true);

            }else if (salida.equals(false)){
                JOptionPane.showMessageDialog(null,"Usuario y/o correo ya se encuentran registrados");
            }

        }
    }
    public Customer getUsuario(){
        return this.usuario;
    }
    public String getNombre(){
        return this.nombreTxt;
    }
    public String getCorreoTxt(){
        return this.correoTxt;
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
