package main.isw.controler;

import java.util.ArrayList;

import main.isw.dao.CustomerDAO;
import main.isw.domain.Customer;
import main.isw.domain.Plan;
public class CustomerControler {

	public void getCustomers(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}

	public void setCustomer(Customer customer) {
		CustomerDAO.setClientes(customer);
	}
	public void setPlan(Plan plan) {
		CustomerDAO.setPlan(plan);
	}

	public boolean getCustomer(Customer  customer) {// utilizado para el inicio de sesión
		boolean salida;
		salida=CustomerDAO.getCliente(customer);
		return salida;
	}

	public void getPlans(ArrayList<Plan> lista){
		CustomerDAO.getPlans(lista);
	}

}
