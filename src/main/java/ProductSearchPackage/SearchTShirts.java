package ProductSearchPackage;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SearchTShirts {
	
	List<Tshirt> available_tshirts = new ArrayList<>();
	Configuration cfg;
	SessionFactory factory;
	Session session;
	
	public SearchTShirts() {
		this.cfg = new Configuration();
		this.cfg.configure("hibernate.cfg.xml");
        this.factory = cfg.buildSessionFactory();
    	this.session = factory.openSession();
	}
	
	// Method to search all the available t-shirts in all the csv files
	public void search(UserInput inputs) {
		
		// Updating the database
    	AddDataToDatabase.add(session);
    	
    	// Fetching data from the database
    	List t_shirts = session.createQuery("from Tshirt").list();
    	
    	// Checking for available t-shirt on the basis of given inputs
		for (int i = 0; i < t_shirts.size(); i++) {
			Tshirt t_shirt = (Tshirt) t_shirts.get(i);
			if(Character.toLowerCase(t_shirt.getAvailability()) == 'y' && t_shirt.getColour().toLowerCase().equals(inputs.color) && Character.toLowerCase(t_shirt.getGender()) == inputs.gender.charAt(0) && t_shirt.getSize().toLowerCase().equals(inputs.size)) {
	    		this.available_tshirts.add(t_shirt);
	    	}
		}
		
		
		// Calling the sort function to sort the available_t-shirt list on the basis of preference
		Sort sort = new Sort();
		sort.arrangeByPreference(this, inputs.preference);
		
	}
	
}
