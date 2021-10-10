package main.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.isw.domain.Customer;
import main.isw.domain.Plan;

public class CustomerDAO {



	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3)));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
	public static void setClientes(Customer customer) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		//try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios(nombre,apellido,password)values('Paco','González','44444')"))
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios (nombre,apellido,password)values('"+customer.getNombre()+"','"+customer.getApellido()+"','"+customer.getPassword()+"')"))
		{	pst.executeQuery();
			//try (PreparedStatement hst = con.prepareStatement("Select * from usuarios")){
			//	ResultSet	 rs = hst.executeQuery();

			//while (rs.next()) {
			//	lista.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3)));
			//}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void setPlan(Plan plan) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		//INSERT INTO planes (nombre,fecha,lugar,hora,capacidad,privacidad,descripcion)values('Futbol','2020-09-09','Madrid','16:00:00',8,'Publico','Hola')"))
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO planes (nombre,fecha,lugar,hora,capacidad,privacidad,descripcion)values('"+plan.getNombre()+"','"+plan.getFecha()+"','"+plan.getLugar()+"','"+plan.getHora()+"',"+plan.getCapacidad()+",'"+plan.getPrivacidad()+"','"+plan.getDescripcion()+"')"))
		{	pst.executeQuery();
			//try (PreparedStatement hst = con.prepareStatement("Select * from usuarios")){
			//	ResultSet	 rs = hst.executeQuery();

			//while (rs.next()) {
			//	lista.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3)));
			//}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/*public static void main(String[] args) {


		ArrayList<Customer> lista=new ArrayList<Customer>();
		CustomerDAO.setClientes(lista);


		 for (Customer customer : lista) {
			System.out.println("He leído el nombre: "+customer.getNombre()+" "+customer.getApellido()+" con contraseña: "+customer.getPassword());
		}*/

}
