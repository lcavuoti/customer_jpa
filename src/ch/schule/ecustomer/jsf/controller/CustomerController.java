package ch.schule.ecustomer.jsf.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ch.schule.ecustomer.api.CustomerService;
import ch.schule.ecustomer.jpa.model.Customer;
import ch.schule.ecustomer.presentation.Outcome;

/**
 * 
 * The customer controller provides access to the underlying business layer. It
 * does also support customer form handling.
 * 
 * @author clip interactive GmbH
 */
@SuppressWarnings("serial")
//@ManagedBean
//@SessionScoped
@Named
@SessionScoped
public class CustomerController implements Serializable {

	private static Logger logger = Logger.getLogger("CustomerController");

	@EJB
	// stateless session bean injection
	private CustomerService customerService;

	private List<Customer> allCustomers;
	
	private Customer current;
	
	/**
	 * Temporäre Variable, die indiziert ob das showEditCustomer Formular einen neuen Customer hinzuf�gen
	 * oder einen bestehenden bearbeiten soll.
	 **/
	private boolean createNew;

	public void setCurrent(Customer current) {
		this.current = current;
	}

	public Customer getCurrent() {
		return current;
	}

	public String addCustomer() {

		customerService.addCustomer(current);
		return "showAllCustomer";
	}

	public String showEditCustomer(Customer aCustomer) {

		current = aCustomer;
		createNew = false;
		return "showEditCustomer";
	}

	public String showCustomer(Customer customer) {

		this.current = customer;
		return "showCustomer";
	}

	public String updateCustomer() {

		customerService.updateCustomer(current);
		logger.info("updateCustomer - Methode called!!!!");
		return "showAllCustomer";
	}
	
	public String showNewCustomer() {
		current = new Customer();
		createNew = true;
		logger.info("showNewCustomer - Methode !!!!");
		return "showEditCustomer";
	}

	public Outcome showDeleteConfirmation(Customer aCustomer) {

		current = aCustomer;
		return Outcome.SUCCESS;
	}

	public void showDeleteConfirmation() {

		// return Outcome.SUCCESS;
	}

	public void deleteCustomer(Customer customer) {

		customerService.deleteCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		allCustomers = customerService.findAllCustomers();
		return allCustomers;
	}

	public String editCustomer() {
		if ( createNew )
			return addCustomer();
		else
			return updateCustomer();
	}
}
