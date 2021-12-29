package code;
import main.isw.client.Client;
import main.isw.domain.Plan;
import ui.JVentanaApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

public class MenuPlanes extends JPanel implements ActionListener {
    private JVentanaApp ventana;
    public JButton crear;
    public JButton buscar;
    public Image fondo;
    public JButton perfil;
    public static ArrayList<Plan> listaPlans;

    public static void main(String[] args) {

        JVentanaApp ventana1 = new JVentanaApp();
        MenuPlanes crear1 = new MenuPlanes(ventana1);
        ventana1.add(crear1);
        ventana1.setVisible(true);
    }
    public MenuPlanes(JVentanaApp ventana)
    {
        super();
        this.ventana=ventana;

        crear=new JButton("Crear Plan");
        buscar=new JButton("Buscar Plan");
        perfil=new JButton();

        fondo = Toolkit.getDefaultToolkit().getImage("./resources/plantastic.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
        //posicion de los botones
        crear.setBounds(315, 300, 150, 30);
        buscar.setBounds(315, 250, 150, 30);
        perfil.setBounds(650,10,128,128);

        crear.setBackground(new Color(228, 255, 222));
        buscar.setBackground(new Color(228, 255, 222));

        //Añadir imagen al boton del perfil
        Image fotoperfil = Toolkit.getDefaultToolkit().getImage("./resources/perfil.png");//Establecer icono de ventana
        fotoperfil = fotoperfil.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon=new ImageIcon(fotoperfil);
        perfil.setIcon(icon);

        perfil.addActionListener(this);
        crear.addActionListener(this);
        buscar.addActionListener(this);

        ventana.add(crear);
        ventana.add(buscar);
        ventana.add(perfil);

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
        if (e.getSource() == this.crear) {
            HashMap<String,Object> session =new HashMap<String, Object>();
            Client.enviarPeticion("/getMaxIdPlan",session);
            ventana.setVisible(false);
            JVentanaApp ventanaCrear=new JVentanaApp();
            CrearPlan crearPlan = new CrearPlan(ventanaCrear);
            ventanaCrear.add(crearPlan);
            ventanaCrear.setVisible(true);

        }
        else if (e.getSource() == this.buscar) {
            ;
            HashMap<String, Object> session = new HashMap<String, Object>();
            Client.enviarPeticion("/getPlans", session);
            ventana.setVisible(false);
            JVentanaApp ventanaDisplay = new JVentanaApp();
            DisplayPlans display = new DisplayPlans(ventanaDisplay);
            ventanaDisplay.add(display);
            ventanaDisplay.setVisible(true);
        }
        else if (e.getSource() == this.perfil) {
                ventana.setVisible(false);
                HashMap<String, Object> session = new HashMap<String, Object>();
                session.put("nombre", (Object) InicioSesion.nombreTxt);
                Client.enviarPeticion("/getCorreoCliente", session);
                Client.enviarPeticion("/getPasswordCliente", session);
                JVentanaApp ventanaPerfil=new JVentanaApp();
                Perfil perfil = new Perfil(ventanaPerfil);
                ventanaPerfil.add(perfil);
                ventanaPerfil.setVisible(true);
            }

        }
    }

