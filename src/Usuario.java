public class Usuario {

    String nombre;
    String apellido1;
    int password;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido1, int password) {
        this.nombre=nombre;
        this. apellido1=apellido1;
        this.password=password;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido1(){
        return this.apellido1;
    }

    public int getPassword(){
        return this.password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    //public int setID(){

    //}
}
