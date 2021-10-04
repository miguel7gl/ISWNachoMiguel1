public class Aplicacion {
    public static void main(String[] args) {
        JVentanaApp ventana= new JVentanaApp();
        Menu menu= new Menu(ventana);
        ventana.add(menu);
        ventana.setVisible(true);

    }
}