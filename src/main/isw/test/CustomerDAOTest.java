package main.isw.test;

import main.isw.dao.CustomerDAO;
import main.isw.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {

    @BeforeEach
    void setUp() {


    }
    @Test
    void getClientes() {
        ArrayList<Customer> lista=new ArrayList<Customer>();
        CustomerDAO.getClientes(lista);

    }

    @Test
    void setClientes() {
    }

    @Test
    void setPlan() {
    }

    @Test
    void getCliente() {
    }

    @Test
    void getPlans() {
    }
}