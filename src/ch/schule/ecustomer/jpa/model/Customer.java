package ch.schule.ecustomer.jpa.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "customer")
@Table(name = "tbl_customer")
@NamedQueries({ @NamedQuery(name = "customer.findAll", query = "select c from customer c") })
public class Customer {

	@Id
	@GeneratedValue
	long id; 

	@Column(name = "s_firstname")
	String firstname;

	@Column(name = "s_lastname")
	String lastname;

	@Column(name = "s_email")
	String email;

	public Customer() {
		this.firstname = "";
		this.lastname = "";
		this.email = "";

	}

	public Customer(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
