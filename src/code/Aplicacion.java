package code;
import main.isw.client.Client;
import main.isw.configuration.PropertiesISW;

public class Aplicacion {
    String host;
    int port;
    public static void main(String[] args) {

        JVentanaApp ventana= new JVentanaApp();
        Menu menu= new Menu(ventana);
        ventana.add(menu);
        ventana.setVisible(true);
    }
}