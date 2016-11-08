package eu.linqed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Contact> contacts;

	public Company(String companyName, String... contactNames) {
		
		this.name = companyName;
		this.contacts = new ArrayList<Contact>();

		for (String name : contactNames) {
			this.contacts.add(new Contact(name));
		}

	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public String getName() {
		return name;
	}

}
