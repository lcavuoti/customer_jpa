package ch.schule.ecustomer.api;

import java.util.List;

import ch.schule.ecustomer.jpa.model.Customer;

public interface CustomerService {
	public List<Customer> findAllCustomers();
	public Customer findCustomerById(int id);
	public void addCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
}
