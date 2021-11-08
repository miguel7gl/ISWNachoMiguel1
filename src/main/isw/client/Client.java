package main.isw.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import code.DisplayPlans;
import code.MenuPlanes;
import org.apache.log4j.Logger;

import main.isw.configuration.PropertiesISW;
import main.isw.domain.Customer;
import main.isw.message.Message;
import main.isw.domain.Plan;
import code.InicioSesion;


public class Client {
	private String host;
	private int port;
	final static Logger logger = Logger.getLogger(Client.class);

	public static void enviarPeticion(String peticion,HashMap<String,Object> session) {
		//Configure connections
		String host = PropertiesISW.getInstance().getProperty("host");
		int port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		Logger.getRootLogger().info("Host: "+host+" port"+port);
		//Create a cliente class
		Client cliente=new Client(host, port);
		

		//session.put("/getCustomer","");
		
		Message mensajeEnvio=new Message();
		Message mensajeVuelta=new Message();
		//mensajeEnvio.setContext("/getCustomer");
		mensajeEnvio.setContext(peticion);
		mensajeEnvio.setSession(session);
		cliente.sent(mensajeEnvio,mensajeVuelta);
		
		
		switch (mensajeVuelta.getContext()) {
			case "/getCustomersResponse":
				ArrayList<Customer> customerList=(ArrayList<Customer>)(mensajeVuelta.getSession().get("Customer"));
				 for (Customer customer : customerList) {
					 System.out.println("He leído el nombre: "+customer.getNombre()+" "+customer.getApellido()+" con contraseña: "+customer.getPassword());
					} 
				break;
			case "/setCustomerResponse":
				 System.out.println("Se ha actualizado la base de datos de usuarios");
				break;
			case "/setPlanResponse":
				System.out.println("Se ha actualizado la base de datos de planes");
				break;
			case "/getCustomerResponse":
				Boolean salida= (boolean)(mensajeVuelta.getSession().get("Salida"));
				if (salida==true)
				{
					InicioSesion.salida=salida;
					System.out.println("Se ha realizado la busqueda del cliente con éxito");
				}else{
					InicioSesion.salida=salida;
					System.out.println("El cliente inroducido no figura en la base de datos");
				}
				break;
			case "/getPlansResponse":
				ArrayList<Plan> listaPlans=(ArrayList<Plan>)(mensajeVuelta.getSession().get("Plans"));
				DisplayPlans.listaPlans=listaPlans;
				for (Plan plan : listaPlans) {
					System.out.println("Nombre_Plan: "+plan.getNombre()+" Lugar: "+plan.getLugar()+" Hora: con contraseña: "+plan.getHora()+" Capacidad: "+plan.getCapacidad()+" Privacidad: "+plan.getPrivacidad()+" Descripcion: "+plan.getDescripcion());
				}
				break;
			default:
				Logger.getRootLogger().info("Option not found");
				System.out.println("\nError a la vuelta");
				break;

		}
		//System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
	}
	
	public Client(String host, int port) {
		this.host=host;
		this.port=port;
	}


	public void sent(Message messageOut, Message messageIn) {
		try {

			System.out.println("Connecting to host " + host + " on port " + port + ".");

			Socket echoSocket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				echoSocket = new Socket(host, port);
				in = echoSocket.getInputStream();
				out = echoSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
				
				//Create the objetct to send
				objectOutputStream.writeObject(messageOut);
				
				// create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(in);
		        Message msg=(Message)objectInputStream.readObject();
		        messageIn.setContext(msg.getContext());
		        messageIn.setSession(msg.getSession());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/
				
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Unable to get streams from server");
				System.exit(1);
			}		

			/** Closing all the resources */
			out.close();
			in.close();			
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}