package ProductSearchPackage;

import java.util.Comparator;


public class PriceAndRatingComparator implements Comparator<Tshirt> {
	
	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		
		Double price1 = tshirt1.getPrice();
		Double price2 = tshirt2.getPrice();
		float rating1 = tshirt1.getRating();
		float rating2 = tshirt2.getRating();
		
		if(price1 == price2 && rating1 == rating2) {
			return 0;
		}
		else if(price1 > price2 || (price1 == price2 && rating1 > rating2)) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
}
