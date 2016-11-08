package eu.linqed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.xsp.extlib.util.ExtLibUtil;

public class ScopeTest {

	private static final String VAR_NAME = "myVar";

	public static void readScopeVar() {

		try {

			System.out.println(" ");
			System.out.println("reading scope var");

			Map serverScope = (Map) ExtLibUtil.resolveVariable("serverScope");
			Object data = serverScope.get(VAR_NAME);

			if (data == null) {
				
				System.out.println("not in scope");
				
			} else {
				
				System.out.println("data is of type " + data.getClass().getCanonicalName());

				// cast it to the correct type (still works...)
				List companies = (List) data;

				System.out.println("companies in list: " + companies.size());

				// loop over the entries
				for (Object company : companies) {
					System.out.println("- company of class: " + company.getClass().getCanonicalName());

					// the following line throws the ClassCastException:
					Company c = (Company) company;
					System.out.println("company name is " + c.getName());
					
					for (Contact contact : c.getContacts()) {
						System.out.println("- contact: " + contact.getName());
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clearScopeVar() {

		System.out.println(" ");
		System.out.println("clearing scope var");

		Map serverScope = (Map) ExtLibUtil.resolveVariable("serverScope");
		serverScope.remove(VAR_NAME);

	}

	public static void updateScopeVar() {

		System.out.println(" ");
		System.out.println("updating scope var");

		Map serverScope = (Map) ExtLibUtil.resolveVariable("serverScope");

		// create list of companies with contacts
		List<Company> companies = new ArrayList<Company>();
		companies.add(new Company("Microsoft", "Mark", "Mary"));
		companies.add(new Company("Apple", "Jack", "Pete"));

		serverScope.put(VAR_NAME, companies);

	}

}
