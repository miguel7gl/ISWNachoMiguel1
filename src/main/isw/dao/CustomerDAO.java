package main.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.isw.domain.Customer;
import main.isw.domain.Plan;

public class CustomerDAO {



	public static void getClientes(ArrayList<Customer> lista) { // obtener listado de clientes
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
	public static boolean setClientes(Customer customer) { //añadir clientes a la tabla
		boolean salidaRegistro;
		Connection con=ConnectionDAO.getInstance().getConnection();
		//try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios(nombre,apellido,password)values('Paco','González','44444')"))
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios (nombre,correo,password)values('"+customer.getNombre()+"','"+customer.getCorreo()+"','"+customer.getPassword()+"')");
		ResultSet rs=pst.executeQuery()){
			if (rs.next()) {
				System.out.println("El usuario y contraseña coinciden con la base de datos");
				//lista.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3)));
				salidaRegistro=true;
			}else{
				System.out.println("El usuario y/o la contraseña son incorrectos");
				salidaRegistro=false;

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			salidaRegistro =false;
		}
		return salidaRegistro;
	}
	public static void setPlan(Plan plan) { //Crear plan
		Connection con=ConnectionDAO.getInstance().getConnection();
		//INSERT INTO planes (nombre,fecha,lugar,hora,capacidad,privacidad,descripcion)values('Futbol','2020-09-09','Madrid','16:00:00',8,'Publico','Hola')"))
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO planes (nombre,fecha,lugar,hora,capacidad,privacidad,descripcion,creador,idplan)values('"+plan.getNombre()+"','"+plan.getFecha()+"','"+plan.getLugar()+"','"+plan.getHora()+"',"+plan.getCapacidad()+",'"+plan.getPrivacidad()+"','"+plan.getDescripcion()+"','"+plan.getCreador()+"','"+plan.getIdPlan()+"')"))
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
	public static Boolean getCliente(Customer customer) { //obtener cliente para el inicio de sesión
		boolean salidaInicioSesion;
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE nombre='"+customer.getNombre()+"' AND  password='"+ customer.getPassword()+"'");
			 ResultSet rs = pst.executeQuery()) {

			if (rs.next()) {
				System.out.println("El usuario y contraseña coinciden con la base de datos");
				//lista.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3)));
				 salidaInicioSesion =true;
			}else{
				System.out.println("El usuario y/o la contraseña son incorrectos");
				salidaInicioSesion =false;

			}
		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			salidaInicioSesion =false;
		}
		return salidaInicioSesion;
	}
	public static void getPlans(ArrayList<Plan> lista) { //Busqueda de todos los planes
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM planes");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Plan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}
	public static void updateParticipantes(Integer idPlan,String usuario) { //Añadir participante a un plan
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO participantes (id_plan,usuario) values("+idPlan+",'"+ usuario +"');");
				 ResultSet rs = pst.executeQuery()) {

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
			}
		}
	public static void borrarParticipantes(Integer idPlan,String usuario) { //Añadir participante a un plan
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("Delete from participantes where id_plan="+idPlan+"and usuario='"+ usuario +"';");
			 ResultSet rs = pst.executeQuery()) {

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static Integer getMaxIdPlan(){ //Obtener ultimo Id del plan
		Connection con=ConnectionDAO.getInstance().getConnection();
		Integer idPlan=0;
		try (PreparedStatement pst = con.prepareStatement("Select max(idplan) as idplan from planes;");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()){
				idPlan=rs.getInt(1);
				System.out.println(idPlan);
			}
		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			idPlan=0;
		}
		return idPlan;
	}

	}

	/*public static void main(String[] args) {


		ArrayList<Customer> lista=new ArrayList<Customer>();
		CustomerDAO.setClientes(lista);


		 for (Customer customer : lista) {
			System.out.println("He leído el nombre: "+customer.getNombre()+" "+customer.getApellido()+" con contraseña: "+customer.getPassword());
		}*/


