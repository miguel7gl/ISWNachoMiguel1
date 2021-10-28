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
    JTextField password = new JTextField("",4);
    JLabel LabelNombre = new JLabel("Nombre:");
    JLabel LabelPassword = new JLabel("Contraseña:");

    String nombreTxt;
    String passwordTxt;


    Image fondo;
    JVentanaApp ventana;
    public static Boolean salida;


    public InicioSesion(JVentanaApp ventana)
    {
        super();
        this.ventana=ventana;

        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800,500,java.awt.Image.SCALE_SMOOTH);

        JbtnInicio.addActionListener(this);

        JbtnInicio.setBounds(290,210,225,30);
        nombre.setBounds(385,130,130,30);
        password.setBounds(385,170,130,30);
        LabelNombre.setBounds(307,130,130,30);
        LabelPassword.setBounds(296,170,130,30);
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
    public void actionPerformed(ActionEvent e) {
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
                JVentanaApp ventanaPlan = new JVentanaApp();
                MenuPlanes inicioMenu = new MenuPlanes(ventanaPlan);
                ventanaPlan.add(inicioMenu);
                ventanaPlan.setVisible(true);
            }else if (salida.equals(false)){
                JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrectos");
            }else{
                System.out.println("No queremos esto");
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
