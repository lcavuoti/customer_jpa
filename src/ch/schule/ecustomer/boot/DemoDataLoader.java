package ch.schule.ecustomer.boot;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.schule.ecustomer.jpa.model.Customer;

/**
 * 
 * A singleton EJB that reloads our test data upon application start.
 * 
 * @author clip interactive GmbH
 */
@Singleton
@Startup
public class DemoDataLoader {

	private static Logger logger = Logger.getLogger("DemoDataLoader");

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() throws Exception {

		// DEBUG:INFO
		logger.info("DemoDataLoader::init");
         
		
		// persist some customer
		em.persist(new Customer("Hank", "Google", "hank.google@google.ch"));
		em.persist(new Customer("Martina", "Meier", "martina.meier@google.ch"));
		em.persist(new Customer("Detlef", "Berger", "db@google.ch"));
		em.persist(new Customer("Sabine", "Kalubers", "sabineK@google.ch"));
		em.persist(new Customer("Sabine", "Twitter", "sabineK@google.ch"));
		
		// Customer persisted
		logger.info("Customer persisted in DemoDataLoader");

	}
}
