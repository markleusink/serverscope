package eu.linqed;

import java.io.Serializable;

public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public Contact(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
