package ProductSearchPackage;

import java.util.Comparator;

public class PriceComparator implements Comparator<Tshirt> {
	
	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		
		Double price1 = tshirt1.getPrice();
		Double price2 = tshirt2.getPrice();
		
		if(price1 == price2) {
			return 0;
		}
		else if(price1 > price2) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
}
