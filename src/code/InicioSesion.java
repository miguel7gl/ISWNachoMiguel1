package code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.HashMap;

import main.isw.domain.Customer;
import main.isw.client.Client;

public class InicioSesion extends JPanel implements ActionListener, WindowListener
{
    JButton JbtnInicio = new JButton("INICIAR SESION");
    JTextField nombre = new JTextField("",4);
    JPasswordField password = new JPasswordField("",4);
    JLabel LabelNombre = new JLabel("Nombre:");
    JLabel LabelPassword = new JLabel("Contraseña:");

    public static String nombreTxt;
    static String passwordTxt;


    Image fondo;
    JVentanaApp ventana;
    public static Boolean salida;


    public InicioSesion(JVentanaApp ventana) //JPanel de inicio sesion
    {
        super();
        this.ventana=ventana;

        fondo = Toolkit.getDefaultToolkit().getImage("./iniciosesion.jpg"); //Establecemos fondo
        fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);

        JbtnInicio.addActionListener(this);

        JbtnInicio.setBounds(290,340,225,30);
        JbtnInicio.setBackground(new Color(250, 252, 250));

        nombre.setBounds(385,240,130,30);
        password.setBounds(385,290,130,30);
        password.setEchoChar('*');
        LabelNombre.setBounds(307,240,130,30);
        LabelPassword.setBounds(296,290,130,30);

        ventana.add(JbtnInicio);
        ventana.add(nombre);
        ventana.add(password);
        ventana.add(LabelNombre);
        ventana.add(LabelPassword);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo,0,0,this); //Fondo
        setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Implementamos logica de los botones del panel
        if (e.getSource() == JbtnInicio) {
            System.out.println("Botón Iniciar sesión pulsado");
            nombreTxt = nombre.getText();
            passwordTxt = password.getText();
            HashMap<String,Object> session =new HashMap<String, Object>();
            session.put("Nombre", (Object)nombreTxt);
            session.put("Password",(Object)passwordTxt);
            Client.enviarPeticion("/getCustomer",session);
            if (salida.equals(true))
            {
                System.out.println("Correcto");
                ventana.setVisible(false);
                nombreTxt=nombre.getText();
                JVentanaApp ventanaPlan = new JVentanaApp();
                MenuPlanes inicioMenu = new MenuPlanes(ventanaPlan);
                ventanaPlan.add(inicioMenu);
                ventanaPlan.setVisible(true);
            }else if (salida.equals(false)) {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos");
            }

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
