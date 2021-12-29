package main.isw.controler;

import java.util.ArrayList;

import main.isw.dao.CustomerDAO;
import main.isw.domain.Customer;
import main.isw.domain.Plan;

public class CustomerControler {

	public void getCustomers(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}

	public boolean setCustomer(Customer customer) {
		boolean salida;
		salida=CustomerDAO.setClientes(customer);
		return salida;
	}
	public void setPlan(Plan plan) {
		CustomerDAO.setPlan(plan);
	}

	public boolean getCustomer(Customer  customer) {// Utilizado para el inicio de sesión
		boolean salida;
		salida=CustomerDAO.getCliente(customer);
		return salida;
	}

	public void getPlans(ArrayList<Plan> lista){
		CustomerDAO.getPlans(lista);
	}

	public Integer getMaxIdPlan(){
		 Integer idPlan=CustomerDAO.getMaxIdPlan();
		 return idPlan;
	}

	public void updateParticipantes(Integer idPlan,String usuario){CustomerDAO.updateParticipantes(idPlan,usuario);}//Añadir participantes

	public void borrarParticipantes(Integer idPlan,String usuario){CustomerDAO.borrarParticipantes(idPlan,usuario);}//Borrar participantes

	public String getCorreoCliente(String usuario){//Obtener correo cliente
		String correo=CustomerDAO.getCorreoCliente(usuario);
		return correo;
	}

	public String getPasswordCliente(String usuario){//Obtener password cliente
		String password=CustomerDAO.getPasswordCliente(usuario);
		return password;
	}
	public void updateCliente(String usuario,String correo,String password){CustomerDAO.updateCliente(usuario,correo,password);}

}
