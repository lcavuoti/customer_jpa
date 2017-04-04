package ch.schule.ecustomer.ejb.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import ch.schule.ecustomer.api.CustomerService;
import ch.schule.ecustomer.jpa.model.Customer;

@SuppressWarnings("serial")
@Stateless
public class CustomerServiceEjb implements CustomerService, Serializable {
	// authenticated
	Customer authenticatedCustomer;

	@PersistenceContext(unitName = "ecustomer_db2")
	EntityManager em;

	@Override
	// Security um Methoden aufzurufen
	public List<Customer> findAllCustomers() {
		return em.createNamedQuery("customer.findAll", Customer.class)
				.getResultList();
	}

	@Override
	public Customer findCustomerById(int id) {
		try {
			return em.find(Customer.class, id);
		} catch (EntityNotFoundException e) {
			return null;
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		em.persist(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {

		em.remove(em.getReference(customer.getClass(), customer.getId()));
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return em.merge(customer);
	}

}
