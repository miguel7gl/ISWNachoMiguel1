package main.isw.controler;

import java.util.ArrayList;

import main.isw.dao.CustomerDAO;
import main.isw.domain.Customer;

public class CustomerControler {


	public void getCustomer(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}

	public void setCustomer(Customer customer) {
		CustomerDAO.setClientes(customer);
	}
	//public void setPlan(ArrayList<Plan>)
}
