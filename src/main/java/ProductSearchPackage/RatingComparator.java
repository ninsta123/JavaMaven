package ProductSearchPackage;

import java.util.Comparator;
import org.apache.commons.csv.CSVRecord;


public class RatingComparator implements Comparator<Tshirt> {
	
	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		
		float rating1 = tshirt1.getRating();
		float rating2 = tshirt2.getRating();
		
		if(rating1 == rating2) {
			return 0;
		}
		else if(rating1 > rating2) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
}
