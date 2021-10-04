import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MenuPlanes extends JPanel implements ActionListener {
    private JVentanaApp ventana;
    public JButton crear;
    public JButton buscar;
    public Image fondo;
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

        fondo = Toolkit.getDefaultToolkit().getImage("./fotofondo.jpg");
        fondo = fondo.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);

        crear.setBounds(295,150,225,30);
        buscar.setBounds(295,190,225,30);

        crear.addActionListener(this);
        buscar.addActionListener(this);

        ventana.add(crear);
        ventana.add(buscar);

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
            ventana.setVisible(false);
            JVentanaApp ventanaCrear=new JVentanaApp();
            CrearPlan crearPlan = new CrearPlan(ventanaCrear);
            ventanaCrear.add(crearPlan);
            ventanaCrear.setVisible(true);

        }
        else if (e.getSource() == this.buscar) {
            System.out.println("Funcionalidad sin implementar aún");
        }
    }

}
