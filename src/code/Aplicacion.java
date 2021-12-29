package code;
import ui.JVentanaApp;

public class Aplicacion { //Clase a ejecutar tras hacer el run del SocketServer

    public static void main(String[] args) {

        JVentanaApp ventana= new JVentanaApp();
        Menu menu= new Menu(ventana);
        ventana.add(menu);
        ventana.setVisible(true);
    }
}